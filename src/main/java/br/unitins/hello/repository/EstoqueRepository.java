package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Estoque;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstoqueRepository implements PanacheRepository<Estoque>{

    public List<Estoque> findByNome(String descricaoEstoque) {
        return find("UPPER(descricaoEstoque) LIKE UPPER(?1) ", "%"+descricaoEstoque+"%").list();
    }

}