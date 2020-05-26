package cars.use_cases;

import cars.decorators.HomePage;
import cars.entities.Manufacturer;
import cars.entities.Model;
import cars.persistence.ManufacturerDAO;
import cars.persistence.ModelDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@javax.enterprise.inject.Model
@RequestScoped
public class Models {

    @Inject
    private ManufacturerDAO manufacturerDAO;

    @Inject
    private ModelDAO modelDAO;

    @Getter
    @Setter
    private Model model = new Model();

    @Getter
    @Setter
    private Manufacturer manufacturer = new Manufacturer();

    @Getter
    private List<Model> modelsList;



    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer manufacturerId = Integer.parseInt(requestParameters.get("manufacturerId"));
        this.manufacturer = manufacturerDAO.findOne(manufacturerId);
        loadManufacturerModels(manufacturerId);
    }

    private void loadManufacturerModels(Integer manufacturerId) {
        this.modelsList = modelDAO.loadAll(manufacturerId);
    }

    @Transactional
    public String createModel() {
        model.setManufacturer(this.manufacturer);
        modelDAO.persist(model);
        return "Models?faces-redirect=true&manufacturerId=" + this.manufacturer.getId();
    }




}
