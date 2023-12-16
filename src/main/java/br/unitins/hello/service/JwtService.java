package br.unitins.hello.service;

import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Usuario;

public interface JwtService {
    public String generateJwt(UserResponseDTO dto);
    public Usuario getJwt();
}
