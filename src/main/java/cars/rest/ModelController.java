package cars.rest;

import cars.entities.Manufacturer;
import cars.entities.Model;
import cars.interceptors.LoggedInvocation;
import cars.persistence.ManufacturerDAO;
import cars.persistence.ModelDAO;
import cars.rest.contracts.ModelDto;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@ApplicationScoped
@Path("/models")
public class ModelController {

    @Inject
    @Setter
    @Getter
    private ModelDAO modelsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @LoggedInvocation
    public Response getById(@PathParam("id") final Integer id) {
        System.out.println("Modelio id yra - "+id.toString());
        Model model = modelsDAO.findOne(id);
        if (model == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ModelDto modelDto = new ModelDto();
        modelDto.setName(model.getName());

        return Response.ok(modelDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @LoggedInvocation
    public Response update(@PathParam("id") final Integer id, ModelDto modelDto) {
        try {
            Model model = modelsDAO.findOne(id);
            if (model == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            model.setName(modelDto.getName());

            modelsDAO.update(model);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @LoggedInvocation
    public Response create(ModelDto modelDto) {
        try {
            Model model = new Model();
            model.setName(modelDto.getName());

            modelsDAO.persist(model);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

}
