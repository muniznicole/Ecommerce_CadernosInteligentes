package br.unitins.hello.repository;

import java.util.List;

import br.unitins.hello.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido>{

    public List<Pedido> findByNome(String descricaoPedido) {
        return find("UPPER(descricaoCarrinho) LIKE UPPER(?1) ", "%"+descricaoPedido+"%").list();
    }

}