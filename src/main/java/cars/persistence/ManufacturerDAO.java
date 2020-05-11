package cars.persistence;

import cars.entities.Manufacturer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ManufacturerDAO {

    @Inject
    private EntityManager em;

    public List<Manufacturer> loadAll() {
        return em.createNamedQuery("Manufacturer.findAll", Manufacturer.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Manufacturer manufacturer){
        this.em.persist(manufacturer);
    }

    public Manufacturer findOne(Integer id) {
        return em.find(Manufacturer.class, id);
    }
}
