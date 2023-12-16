package br.unitins.hello.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import org.jboss.logging.Logger;

import com.arjuna.ats.arjuna.common.recoveryPropertyManager;

import br.unitins.hello.dto.CartaoDTO;
import br.unitins.hello.dto.CidadeDTO;
import br.unitins.hello.dto.CompraDTO;
import br.unitins.hello.repository.CidadeRepository;
import br.unitins.hello.service.CartaoService;
import br.unitins.hello.service.CidadeService;
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

@Path("/ClienteLogado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({ "Cliente"})
public class ClienteLogado {
    
    @Inject
    UserService service;
    
    @Inject
    ProdutoService produto;

    @Inject
    JwtService jwT;
       
    @Inject
    JsonWebToken jwt;
    
    @Inject
    CompraService compra;

    @Inject
    PagamentoService pagamento;

    @Inject
    EnderecoService endereco;
    
    @Inject
    CidadeService cidadeService;

    @Inject
    CartaoService cartaoService;
    
    private static final Logger LOG = Logger.getLogger(AuthFuncionarioResource.class);

    @POST
    @Path("/Realizar compra")
    @Transactional
    public Response Compra(CompraDTO insertcompra){
    
        LOG.info("Iniciando compra...");
        return Response.ok(compra.insert(insertcompra)).build();
    
    }

    @POST
    @Path("/Realizar cadastro de cidade")
    @Transactional
    public Response cadastrarCidade(CidadeDTO cidade){

        LOG.info("Iniciando cadastro de cidade...");    
        return Response.ok(cidadeService.insertCidade(cidade)).build();
    }

    @POST
    @Path("/Realizar cadastro de cartao")
    @Transactional
    public Response cadastrarCartao(CartaoDTO cartao){
        cartaoService.insert(cartao);
        LOG.info("Iniciando cadastro de cartão...");
        return Response.ok().build();
    }

    @GET
    @Path("/Login e Senha")
    public Response FindLoginSenha(){

        LOG.info("Buscando login e senha...");
        String login = jwt.getSubject();

        return Response.ok(service.findByLogin(login)).build();
    }


    @GET
    @Path("/Todos os Usuarios")
    public Response todosUsuarios(){
        
        LOG.info("Buscando todos os usuários...");
        return Response.ok(service.findall()).build();
    }

    @GET
    @Path("/Todas as cidades")
    public Response todasCidades(){
        
        LOG.info("Buscando todas as cidades...");
        return Response.ok(cidadeService.findall()).build();
    
    }

    @GET
    @Path("Todas as compras")
    public Response todasascompras(){
       
        return Response.ok(compra.findbyid(jwT.getJwt())).build();

    }

}
