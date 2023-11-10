package br.unitins.hello.service;

import br.unitins.hello.dto.UserResponseDTO;

public interface JwtService {
    public String generateJwt(UserResponseDTO dto);
}
