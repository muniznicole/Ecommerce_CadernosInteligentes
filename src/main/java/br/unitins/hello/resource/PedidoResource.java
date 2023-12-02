package br.unitins.hello.resource;

import org.jboss.logging.Logger;

import br.unitins.hello.dto.PedidoDTO;
import br.unitins.hello.service.PedidoService;
import jakarta.annotation.security.RolesAllowed;
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

@Path("/pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"User", "Administrador"})
public class PedidoResource {

    @Inject
    PedidoService pedidoService;

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @POST
    @Transactional
    public Response insert(PedidoDTO dto) {
        
        LOG.info("Criando um novo pedido..."); 
        return Response.status(Status.CREATED).entity(pedidoService.insert(dto)).build();
    
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(PedidoDTO dto, @PathParam("id") Long id) {
        
        pedidoService.update(dto, id);
        LOG.info("Atualizando pedido...");
        LOG.warn("Este pedido está sendo atualizado!");
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        
        pedidoService.delete(id);
        LOG.info("Deletando pedido...");
        LOG.warn("Este pedido está sendo deletado!");
        return Response.noContent().build();
    
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(pedidoService.findById(id)).build();
    }
    
    // @GET
    // @Path("/search/pedido/{pedido}")
    // public Response findByNome(@PathParam("pedido") String descricaoEstoque) {
    //    return Response.ok(pedidoService.findByNome(descricaoEstoque)).build();
    //}

}

