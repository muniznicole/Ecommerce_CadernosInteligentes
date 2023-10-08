package br.unitins.hello.resource;

import br.unitins.hello.dto.CarrinhoDTO;
import br.unitins.hello.service.CarrinhoService;

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

@Path("/carrinho")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoResource {

    @Inject
    CarrinhoService carrinhoService;

    @POST
    @Transactional
    public Response insert(CarrinhoDTO dto) {
       return Response.status(Status.CREATED).entity(carrinhoService.insert(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(CarrinhoDTO dto, @PathParam("id") Long id) {
        carrinhoService.update(dto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        carrinhoService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(carrinhoService.findById(id)).build();
    }
    
    // @GET
    // @Path("/search/carrinho/{carrinho}")
    // public Response findByNome(@PathParam("carrinho") String descricaoEstoque) {
    //    return Response.ok(carrinhoService.findByNome(descricaoEstoque)).build();
    //}

}

