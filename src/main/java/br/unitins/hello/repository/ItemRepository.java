package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item>{
    public List<Item> findByNome(String nomeItem) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nomeItem + "%").list();
    }
}
