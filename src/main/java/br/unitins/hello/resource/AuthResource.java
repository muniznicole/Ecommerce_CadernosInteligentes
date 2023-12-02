package br.unitins.hello.resource;

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
public class AuthResource {

    @Inject
    UserService service;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    @POST
    public Response login (@Valid LoginDTO dto ){
        String hashSenha = hashService.getHashSenha(dto.senha());
        UserResponseDTO result = service.findByLogineSenha(dto.login(), hashSenha);
        String token = jwtService.generateJwt(result);

        return Response.ok().header("Authorization", token).build();

    }
    
}
