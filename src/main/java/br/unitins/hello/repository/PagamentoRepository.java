package br.unitins.hello.repository;

import br.unitins.hello.model.Endereco;
import br.unitins.hello.model.Pagamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class PagamentoRepository implements PanacheRepository<Pagamento>{
    
}
