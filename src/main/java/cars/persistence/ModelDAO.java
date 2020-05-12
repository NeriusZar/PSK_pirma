package cars.persistence;


import cars.entities.Model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ModelDAO {

    @Inject
    private EntityManager em;

    public List<Model> loadAll(Integer manufacturerId) {
        return em.createNamedQuery("Model.findAll", Model.class).setParameter("manufacturerId", manufacturerId).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Model model) {
        this.em.persist(model);
    }

    public Model findOne(Integer id) {
        return em.find(Model.class, id);
    }
}