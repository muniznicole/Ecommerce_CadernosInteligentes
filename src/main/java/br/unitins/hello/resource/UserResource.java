package br.unitins.hello.resource;

import org.jboss.logging.Logger;

import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.service.UserService;
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

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"User", "Administrador"})
public class UserResource {
    
    @Inject
    UserService service;

    private static final Logger LOG = Logger.getLogger(UserResource.class);

    @POST
    @Transactional
    @RolesAllowed("Administrador")
    public Response insert(UserDTO dto) {

        LOG.info("Criando um novo usuário..."); 
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"User", "Administrador"})
    public Response update(UserDTO dto, @PathParam("id") Long id) {
    
        service.update(dto, id);
        LOG.info("Atualizando usuário...");
        LOG.warn("Este usuário está sendo atualizado!");
        return Response.noContent().build();
    
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"User", "Administrador"})
    public Response delete(@PathParam("id") Long id) {
        
        service.delete(id);
        LOG.info("Deletando usuário...");
        LOG.warn("Este usuário está sendo deletado!");
        return Response.noContent().build();
    
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"User", "Administrador"})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findbyid(id)).build();
    }
    
    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"User", "Administrador"})
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findbyNome(nome)).build();
    }

}
