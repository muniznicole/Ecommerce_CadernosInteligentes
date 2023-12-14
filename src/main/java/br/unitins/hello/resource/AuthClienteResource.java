package br.unitins.hello.resource;

import org.jboss.logging.Logger;

import br.unitins.hello.dto.LoginDTO;
import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Usuario;
import br.unitins.hello.service.HashService;
import br.unitins.hello.service.JwtService;
import br.unitins.hello.service.UserService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthClienteResource {

    @Inject
    UserService service;
    
    @Inject
    HashService hashService;
    
    @Inject
    JwtService jwtService;

    private static final Logger LOG = Logger.getLogger(AuthClienteResource.class);

    @POST
    public Response login (@Valid LoginDTO dto ){

        LOG.infof("Iniciando a autenticacao do %s", dto.login());

        String hashSenha = hashService.getHashSenha(dto.senha());

        LOG.info("Hash da senha gerado.");

        LOG.debug(hashSenha);

        UserResponseDTO result = service.findByLogineSenhaCliente(dto.login(), hashSenha);

        if (result != null)
            LOG.info("Login e senha corretos.");
        else
            LOG.info("Login e senha incorretos.");

        String token = jwtService.generateJwt(result);

        LOG.info("Finalizando o processo de login.");

        return Response.ok().header("Authorization", token).build();

    }
    
}