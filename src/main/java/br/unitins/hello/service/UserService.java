package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Usuario;


public interface UserService {
    public UserResponseDTO insert(UserDTO dto);
    public UserResponseDTO update(UserDTO dto,Long id);
    public void delete(Long id);
    public UserResponseDTO findbyid(Long id);
    public List<UserResponseDTO> findbyNome(String nome);
    public UserResponseDTO findByLogin(String login);
    public UserResponseDTO findByLogineSenhaFuncionario(String login, String senha);
    public UserResponseDTO findByLogineSenhaCliente(String login, String senha);
    public UserResponseDTO findByUser();
    public List<UserResponseDTO> findall();
}
