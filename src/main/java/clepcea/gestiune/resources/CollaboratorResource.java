package clepcea.gestiune.resources;

import clepcea.gestiune.representations.Collaborator;
import clepcea.gestiune.representations.PriceCategory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/collaborator")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CollaboratorResource {

    @Path("{id}")
    @GET
    public Response getCollaborator(@PathParam("id") long id){

        Collaborator collaborator = new Collaborator("Test Collab",
                "France","EUR",
                "","",
                "office@testcollab.fr","",
                new PriceCategory("price 5",""));

        return Response.ok(collaborator).build();
    }
}
