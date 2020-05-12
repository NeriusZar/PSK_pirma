package cars.persistence;

import cars.entities.CarPart;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CarPartDAO {

    @Inject
    private EntityManager em;

    public void persist(CarPart carPart){
        this.em.persist(carPart);
    }
    public List<CarPart> loadAll() {
        return em.createNamedQuery("CarPart.findAll", CarPart.class).getResultList();
    }

    public CarPart findOne(Integer id){
        return em.find(CarPart.class, id);
    }

    public CarPart update(CarPart carPart){
        return em.merge(carPart);
    }
}
