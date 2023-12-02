package br.unitins.hello.resource;

import org.jboss.logging.Logger;

import br.unitins.hello.dto.EstoqueDTO;
import br.unitins.hello.service.EstoqueService;
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

@Path("/estoque")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"User", "Administrador"})
public class EstoqueResource {

    @Inject
    EstoqueService estoqueService;

    private static final Logger LOG = Logger.getLogger(EstoqueResource.class);

    @POST
    @Transactional
    public Response insert(EstoqueDTO dto) {
        
        LOG.info("Criando um novo estoque...");  
        return Response.status(Status.CREATED).entity(estoqueService.insert(dto)).build();
    
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(EstoqueDTO dto, @PathParam("id") Long id) {
        
        estoqueService.update(dto, id);
        LOG.info("Atualizando estoque...");
        LOG.warn("Este estoque está sendo atualizado!");
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        estoqueService.delete(id);
        LOG.info("Deletando estoque...");
        LOG.warn("Este estoque está sendo deletado!");
        return Response.noContent().build();
    
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(estoqueService.findById(id)).build();
    }
    
    @GET
    @Path("/search/descricaoEstoque/{descricaoEstoque}")
    public Response findByNome(@PathParam("descricaoEstoque") String descricaoEstoque) {
        return Response.ok(estoqueService.findByNome(descricaoEstoque)).build();
    }

}
