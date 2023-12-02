package br.unitins.hello.service;

import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Usuario;
import br.unitins.hello.repository.UserRepository;
import br.unitins.hello.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository repository;

    @Override
    public UserResponseDTO insert(UserDTO dto) {
        Usuario novUsuario = new Usuario();
        novUsuario.setNomeCompleto(dto.nomeCompleto());
        novUsuario.setLogin(dto.login());
        HashService service = new HashServiceImpl();
        novUsuario.setSenha(service.getHashSenha(dto.senha()));;
        novUsuario.setTelefone(dto.telefone());
        novUsuario.setCpf(dto.cpf());
        novUsuario.setPerfil(dto.perfil().fromId(0));
        repository.persist(novUsuario);

        return UserResponseDTO.valueOf(novUsuario);
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
             HashService service = new HashServiceImpl();
            usuario.setSenha(service.getHashSenha(dto.senha()));
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

        return  UserResponseDTO.valueOf(usuario);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserResponseDTO findbyid(Long id) {
        Usuario novoUser = new Usuario();
        novoUser = repository.findById(id);
        return UserResponseDTO.valueOf(novoUser);
    }

    @Override
    public List<UserResponseDTO> findbyNome(String nome) {
   return repository.findByNome(nome).stream().map(e -> UserResponseDTO.valueOf(e)).toList();
    }
    @Override
    public UserResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) 
            throw new ValidationException("login", "Login inválido");
        
        return UserResponseDTO.valueOf(usuario);
    }

    @Override
    public UserResponseDTO findByLogineSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null) 
            throw new ValidationException("login", "Login ou senha inválido");
        
        return UserResponseDTO.valueOf(usuario);
    }
}
