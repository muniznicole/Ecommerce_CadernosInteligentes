package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Cartao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class CartaoRepository implements PanacheRepository<Cartao> {
   
    public List<Cartao> findBytitularCartao(String titularCartao) {
        return find("UPPER(titularCartao) LIKE UPPER(?1) ", "%" + titularCartao + "%").list();
    }
}
