package br.unitins.hello.resource;

import org.jboss.logging.Logger;

import br.unitins.hello.dto.CartaoDTO;
import br.unitins.hello.service.CartaoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

@Path("/cartao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CartaoResource {

    @Inject
    CartaoService service;

    private static final Logger LOG = Logger.getLogger(CartaoResource.class);

    @POST
    @Transactional
    @RolesAllowed({"Cliente", "Administrador"})
    public Response insert(@Valid CartaoDTO dto) {
        
        LOG.info("Criando um novo cartão...");    
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();

    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Cliente", "Administrador"})
    public Response update(CartaoDTO dto, @PathParam("id") Long id) {
        
        service.update(dto, id);
        LOG.info("Fazendo update do cartão...");
        LOG.warn("Este cartão está sendo atualizado!");
        return Response.noContent().build();

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Cliente", "Administrador"})
    public Response delete(@PathParam("id") Long id) {
        
        service.delete(id);
        LOG.info("Deletando um cartão...");
        LOG.warn("Este cartão está sendo deletado");
        return Response.noContent().build();
        
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Administrador"})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/cartao/{Titularcartao}")
    @RolesAllowed({"Administrador"})
    public Response findByTitularCartao(@PathParam("Titularcartao") String titularCartao) {
        return Response.ok(service.findByTitularCartao(titularCartao)).build();
    }
}
