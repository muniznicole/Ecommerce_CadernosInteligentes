package br.unitins.hello.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.hello.dto.CompraDTO;
import br.unitins.hello.repository.CidadeRepository;
import br.unitins.hello.service.CompraService;
import br.unitins.hello.service.EnderecoService;
import br.unitins.hello.service.JwtService;
import br.unitins.hello.service.PagamentoService;
import br.unitins.hello.service.ProdutoService;
import br.unitins.hello.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/FuncionarioLogado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({ "Administrador"})
public class FuncionarioLogado {
    
    @Inject
    UserService service;
    
    @Inject
    ProdutoService produto;

    @Inject
      JsonWebToken jwt;
    
    @Inject
    CompraService compra;

    @Inject
    PagamentoService pagamento;

    @Inject
    EnderecoService endereco;

    @Inject
    CidadeRepository cidade;    

    @GET
    @Path("/Login e Senha")
    public Response FindLoginSenha(){
        String login = jwt.getSubject();

        return Response.ok(service.findByLogin(login)).build();
    }

    @POST
    @Path("/Realizar compra")
    @Transactional
    public Response Compra(CompraDTO insertcompra){
        
        return Response.ok(compra.insert(insertcompra)).build();
    }
}
