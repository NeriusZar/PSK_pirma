package cars.use_cases;
import cars.entities.Manufacturer;
import cars.persistence.ManufacturerDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Manufacturers {

    @Inject
    private ManufacturerDAO manufacturerDAO;

    @Getter
    private List<Manufacturer> manufacturers;

    @Getter
    @Setter
    private Manufacturer manufacturerToCreate = new Manufacturer();

    @PostConstruct
    public void init(){
        laodAllManufacturers();
    }

    private void laodAllManufacturers(){
        this.manufacturers = manufacturerDAO.loadAll();
    }

    @Transactional
    public String addManufacturer(){
        manufacturerDAO.persist(manufacturerToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public Manufacturer findManufaturer(String id){
        return manufacturerDAO.findOne(Integer.parseInt(id));
    }
}
