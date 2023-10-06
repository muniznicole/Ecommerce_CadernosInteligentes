package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Item;
import br.unitins.hello.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class UserRepository implements PanacheRepository<Usuario> {

    
     public List<Usuario> findByNome(String nome) {
        return find("UPPER(nomeCompleto) LIKE UPPER(?1) ", "%"+nome+"%").list();

    }
}
