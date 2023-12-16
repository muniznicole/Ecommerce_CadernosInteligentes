package br.unitins.hello.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.microprofile.jwt.JsonWebToken;



import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Usuario;
import br.unitins.hello.repository.UserRepository;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JwtServiceImpl implements JwtService{

    @Inject
    JsonWebToken jwt;

    @Inject
    UserRepository userRepository;

private static final Duration EXPIRATION_TIME = Duration.ofHours(24);
    @Override
    public String generateJwt(UserResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);
        Set<String> roles = new HashSet<String>();
        roles.add(dto.perfil());
        return Jwt.issuer("unitins-jwt").subject(dto.login())
        .groups(roles)
        .expiresAt(expiryDate)
        .sign();
    }
    @Override
    public Usuario getJwt() {
        Usuario user = new Usuario();
        for(Long i = userRepository.count();i>0;i--){
        if(jwt.getRawToken().equals(userRepository.findById(i).getSenha())){
            user = userRepository.findById(i);
        }
    }
    return user;
    }

    }



