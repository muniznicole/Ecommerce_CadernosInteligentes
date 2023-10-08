package br.unitins.hello.service;

import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Usuario;
import br.unitins.hello.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository repository;

    @Override
    public UserResponseDTO insert(UserDTO dto) {
        Usuario novUsuario = new Usuario();
        novUsuario.setNomeCompleto(dto.nomeCompleto());
        novUsuario.setLogin(dto.login());
        novUsuario.setSenha(dto.senha());
        novUsuario.setTelefone(dto.telefone());
        novUsuario.setCpf(dto.cpf());
        novUsuario.setPerfil(dto.perfil().fromId(0));
        repository.persist(novUsuario);

        return new UserResponseDTO(novUsuario);
    }

    @Override
    public UserResponseDTO update(UserDTO dto, Long id) {
        Usuario usuario = repository.findById(id);
        if (dto.login().equals("string")) {
        } else {
            usuario.setLogin(dto.login());
        }
        if (dto.nomeCompleto().equals("string")) {

        } else {
            usuario.setNomeCompleto(dto.nomeCompleto());
        }
        if (dto.senha().equals("string")) {

        } else {
            usuario.setSenha(dto.senha());
        }
        if (dto.cpf().equals("string")) {
        } else {
            usuario.setCpf(dto.cpf());
        }
        if (dto.email().equals("string")) {
        } else {
            usuario.setEmail(dto.email());
        }
        if (dto.telefone().equals("string")) {
        } else {
            usuario.setTelefone(dto.telefone());
        }
        usuario.setPerfil(dto.perfil());

        return new UserResponseDTO(usuario);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserResponseDTO findbyid(Long id) {
        Usuario novoUser = new Usuario();
        novoUser = repository.findById(id);
        return new UserResponseDTO(novoUser);
    }

    @Override
    public List<UserResponseDTO> findbyNome(String nome) {
        List<Usuario> list = repository.findByNome(nome);
        if(list == null)
            throw new NullPointerException("Estoque não encontrado.");
        
        return list.stream()
                        .map(UserResponseDTO::new)
                        .collect(Collectors.toList());
    }

}
