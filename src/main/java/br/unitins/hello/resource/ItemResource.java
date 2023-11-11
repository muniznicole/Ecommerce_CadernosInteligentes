package br.unitins.hello.resource;

import br.unitins.hello.dto.ItemDTO;
import br.unitins.hello.service.ItemService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/itens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

    @Inject
    ItemService itemService;

    @POST
    @Transactional
    public Response insert(ItemDTO dto) {
       return Response.status(Status.CREATED).entity(itemService.insert(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(ItemDTO dto, @PathParam("id") Long id) {
        itemService.update(dto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        itemService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(itemService.findById(id)).build();
    }
    
    @GET
    @Path("/search/nomeItem/{nomeItem}")
    public Response findByNome(@PathParam("nomeItem") String nomeItem) {
        return Response.ok(itemService.findByNome(nomeItem)).build();
    }

    @GET
    public Response findByAll() {
        return Response.ok(itemService.findByAll()).build();
    }

}