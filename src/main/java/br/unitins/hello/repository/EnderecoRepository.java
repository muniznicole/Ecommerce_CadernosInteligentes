package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Cartao;
import br.unitins.hello.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
     public List<Endereco> findByCidade(String cidade) {
        return find("UPPER(cidadeEndereco) LIKE UPPER(?1) ", "%" +cidade+ "%").list();
    }
}
