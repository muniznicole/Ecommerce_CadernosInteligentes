package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.dto.UserResponseDTO;

public interface UserService {
    public UserResponseDTO insert(UserDTO dto);
    public UserResponseDTO update(UserDTO dto,Long id);
    public void delete(Long id);
    public UserResponseDTO findbyid(Long id);
    public List<UserResponseDTO> findbyNome(String nome);
    public UserResponseDTO findByLogin(String login);
    public UserResponseDTO findByLogineSenha(String login, String senha);
}
