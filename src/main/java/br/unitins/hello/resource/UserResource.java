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

public class UserResource {
    
    @Inject
    UserService service;

    private static final Logger LOG = Logger.getLogger(UserResource.class);

    @POST
    @Transactional
    public Response insert(UserDTO dto) {

        LOG.info("Criando um novo usuário..."); 
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    
    }

}
