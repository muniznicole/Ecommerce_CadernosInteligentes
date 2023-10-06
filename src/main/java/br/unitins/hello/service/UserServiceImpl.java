package br.unitins.hello.service;

import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Usuario;
import br.unitins.hello.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository repository;
    @Override
    public UserResponseDTO insert(UserDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public UserResponseDTO update(UserDTO dto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public UserResponseDTO delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public UserResponseDTO findbyid(Long id) {
        Usuario novoUser = new Usuario();
    novoUser =  repository.findById(id);
        return UserResponseDTO.valueOf(novoUser);
    }

    @Override
    public List<UserResponseDTO> findbyNome(String nome) {
        List<Usuario> listuser = new ArrayList();
        listuser= repository.findByNome(nome);
List<UserResponseDTO> usuarioDTOList = listuser.stream()
    .map(e -> UserResponseDTO.valueOf(e))
    .collect(Collectors.toList());
return usuarioDTOList;
    }
    
}
