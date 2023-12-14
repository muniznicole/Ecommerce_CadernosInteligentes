package br.unitins.hello.repository;

import br.unitins.hello.model.Compra;
import br.unitins.hello.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class CompraRepository implements PanacheRepository<Compra>{
    
}
