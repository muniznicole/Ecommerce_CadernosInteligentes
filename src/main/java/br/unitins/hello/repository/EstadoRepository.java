package br.unitins.hello.repository;

import br.unitins.hello.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado>{
    
}
