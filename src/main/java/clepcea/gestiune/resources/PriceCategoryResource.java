package clepcea.gestiune.resources;

import clepcea.gestiune.dao.PriceCategoryDAO;
import io.dropwizard.hibernate.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pricecategory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PriceCategoryResource {


    private PriceCategoryDAO priceCategoryDAO;

    public  PriceCategoryResource(PriceCategoryDAO priceCategoryDAO){
        this.priceCategoryDAO = priceCategoryDAO;
    }
    @GET
    @Path("{id}")
    public Response getPriceResource(@PathParam("id") long id){
        return Response.ok().build();
    }

    @GET
    @UnitOfWork
    public  Response getPricesResources(){
        return  Response.ok(priceCategoryDAO.findAll()).build();
    }
}
