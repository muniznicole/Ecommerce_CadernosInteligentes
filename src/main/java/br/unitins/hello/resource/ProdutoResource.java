package br.unitins.hello.resource;

import br.unitins.hello.dto.ProdutoDTO;
import br.unitins.hello.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/Cadernos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    @Inject
    ProdutoService produto;

    @GET
    @Path("/Todos os Produtos")
    public Response FindAll(){
        

        return Response.ok(produto.findAll()).build();

    }

    @POST
    @Path("/Inserir novo produto")
    @Transactional
    public Response insereProduto(ProdutoDTO produtoDTO){
        return Response.ok(produto.insert(produtoDTO)).build();
    }
}
