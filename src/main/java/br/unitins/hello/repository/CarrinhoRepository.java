package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Carrinho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarrinhoRepository implements PanacheRepository<Carrinho>{

    public List<Carrinho> findByNome(String descricaoCarrinho) {
        return find("UPPER(descricaoCarrinho) LIKE UPPER(?1) ", "%"+descricaoCarrinho+"%").list();
    }

}