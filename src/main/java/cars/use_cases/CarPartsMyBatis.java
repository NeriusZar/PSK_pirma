package cars.use_cases;

import cars.mybatis.dao.CarPartMapper;
import cars.mybatis.dao.ModelCarPartMapper;
import cars.mybatis.model.CarPart;
import cars.mybatis.model.ModelCarPart;
import cars.persistence.CarPartDAO;
import cars.persistence.ModelDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
@RequestScoped
public class CarPartsMyBatis{

    @Inject
    private CarPartMapper carPartMapper;

    @Inject
    private ModelCarPartMapper modelCarpartMapper;

    @Getter
    @Setter
    private ModelCarPart modelCarpart = new ModelCarPart();

    @Getter
    @Setter
    private cars.entities.Model model= new cars.entities.Model();

    @Inject
    private ModelDAO modelDAO;

    @Getter @Setter
    private List<CarPart> allCarParts;

    @Getter @Setter
    private List<CarPart> selectedCarParts;

    @Getter @Setter
    private CarPart carPartToCreate = new CarPart();

    @Getter @Setter
    private CarPart carPart = new CarPart();

    @Inject
    private CarPartDAO carPartDAO;

    @PostConstruct
    public void init() {

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer modelId = Integer.parseInt(requestParameters.get("modelId"));
        this.model = modelDAO.findOne(modelId);
        this.loadAllCarParts();
        this.loadSelectedCarParts(modelId);
    }



    private void loadAllCarParts() {
        this.allCarParts = carPartMapper.selectAll();
    }

    private void loadSelectedCarParts(Integer modelId){
        this.selectedCarParts = carPartMapper.getSelectedCarParts(modelId);
    }

    @Transactional
    public String createCarPart() {
        carPartMapper.insert(carPartToCreate);

        return "CarParts?faces-redirect=true&modelId=" + this.model.getId();
    }

    @Transactional
    public String deleteCarPart() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer carPartId = Integer.parseInt(requestParameters.get("carPartId"));
        carPartMapper.deleteByPrimaryKey(carPartId);

        return "CarParts?faces-redirect=true&modelId=" + this.model.getId();
    }

    @Transactional
    public String addCarPart() {

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer carPartId = Integer.parseInt(requestParameters.get("carPartId"));

        modelCarpart.setModelsId(this.model.getId());
        modelCarpart.setCarPartsId(carPartId);
        modelCarpartMapper.insert(modelCarpart);
        return "CarParts?faces-redirect=true&modelId=" + this.model.getId();
    }

    @Transactional
    public String removeCarPart() {

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer carPartId = Integer.parseInt(requestParameters.get("carPartId"));

        System.out.println(carPartId);
        modelCarpart.setModelsId(this.model.getId());
        modelCarpart.setCarPartsId(carPartId);
        modelCarpartMapper.deleteCarPartFromModel(modelCarpart);
        return "CarParts?faces-redirect=true&modelId=" + this.model.getId();
    }

    @Override
    public String toString() {
        return "CarPartsMyBatis{" +
                "car part=" + carPart.getId() +" "+carPart.getName() +
                '}';
    }
}