package br.unitins.hello.resource;

import org.jboss.logging.Logger;

import java.io.IOException;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.hello.application.Error;
import br.unitins.hello.dto.ItemDTO;
import br.unitins.hello.form.ItemImageForm;
import br.unitins.hello.service.ItemService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/itens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"User", "Administrador"})
public class ItemResource {

    @Inject
    ItemService itemService;

    @Inject
    JsonWebToken jwt;

    private static final Logger LOG = Logger.getLogger(ItemResource.class);

    @POST
    @Transactional
    public Response insert(ItemDTO dto) {

        LOG.info("Criando um novo item..."); 
        return Response.status(Status.CREATED).entity(itemService.insert(dto)).build();
    
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(ItemDTO dto, @PathParam("id") Long id) {
        
        itemService.update(dto, id);
        LOG.info("Atualizando item...");
        LOG.warn("Este item está sendo atualizado!");
        return Response.noContent().build();
    
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        
        itemService.delete(id);
        LOG.info("Deletando item...");
        LOG.warn("Este item está sendo deletado!");
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

    @PATCH
    @Path("/upload/imagem")
    @RolesAllowed({"Administrador"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ItemImageForm form ){
        String nomeImagem;
        ItemImageForm formteste = new ItemImageForm();
        formteste = form;
        System.out.println(formteste.getNomeImagem());
        try{
            nomeImagem = itemService.upload(form.getNomeImagem(),form.getImagem());
        }
        catch(IOException e){
            e.printStackTrace();
            Error error = new Error("409", e.getMessage());
            return Response.status(Status.CONFLICT).entity(error).build();
        }
        return Response.ok().build();
    }

      @GET
    @Path("/download/imagem/{nomeImagem}")
    @RolesAllowed({ "Administrador"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(itemService.dowload(nomeImagem));
        response.header("Content-Disposition", "attachment;filename="+nomeImagem);
        return response.build();
    }
}