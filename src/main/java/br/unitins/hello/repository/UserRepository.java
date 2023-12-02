package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Item;
import br.unitins.hello.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class UserRepository implements PanacheRepository<Usuario> {
    
     public List<Usuario> findByNome(String nome) {
        return find("UPPER(nomeCompleto) LIKE UPPER(?1) ", "%"+nome+"%").list();

    }
    public Usuario findByLoginAndSenha(String login, String senha) {
        try {
            return find("login = ?1 AND senha = ?2 ", login, senha).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    public Usuario findByLogin(String login) {
        try {
            return find("login = ?1 ", login ).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
