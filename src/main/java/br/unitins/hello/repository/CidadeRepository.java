package br.unitins.hello.repository;

import br.unitins.hello.model.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    
}
