package br.unitins.hello.resource;

import org.jboss.logging.Logger;

import br.unitins.hello.dto.EnderecoDTO;
import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.service.EnderecoService;

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

@Path("/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {
    
    @Inject
    EnderecoService service;

    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);

    @POST
    @Transactional
    public Response insert(EnderecoDTO dto) {

        LOG.info("Criando um novo endereço...");  
        return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(EnderecoDTO dto, @PathParam("id") Long id) {
        
        service.update(dto, id);
        LOG.info("Atualizando endereço...");
        LOG.warn("Este endereço está sendo atualizado!");
        return Response.noContent().build();
    
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        service.delete(id);
        LOG.info("Deletando endereço...");
        LOG.warn("Este endereço está sendo deletado!");
        return Response.noContent().build();
    
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/cidade/{cidade}")
    public Response findByNome(@PathParam("cidade") String cidade) {
        return Response.ok(service.findByCidadeNome(cidade)).build();
    }

}
