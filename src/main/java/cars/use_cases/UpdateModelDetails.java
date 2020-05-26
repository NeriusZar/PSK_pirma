package cars.use_cases;

import cars.entities.Model;
import cars.interceptors.LoggedInvocation;
import cars.persistence.ModelDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateModelDetails implements Serializable {

    @Setter
    @Getter
    private Model model;

    @Inject
    private ModelDAO modelDAO;

    @PostConstruct
    private void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer modelId = Integer.parseInt(requestParameters.get("modelId"));

        this.model = modelDAO.findOne(modelId);
    }

    @Transactional
    @LoggedInvocation
    public String updateModel(){
        try {
            modelDAO.update(model);
        } catch (OptimisticLockException e) {
            return "/modelDetails.xhtml?faces-redirect=true&modelId=" + this.model.getId() + "&error=optimistic-lock-exception";
        }

        return "index.xhtml?&faces-redirect=true";
    }

}
