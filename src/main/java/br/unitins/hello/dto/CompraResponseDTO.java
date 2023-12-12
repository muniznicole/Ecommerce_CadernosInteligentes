package br.unitins.hello.dto;
import java.time.LocalDate;
import java.util.List;

import br.unitins.hello.model.Compra;
import br.unitins.hello.model.Pagamento;
import br.unitins.hello.model.ProdutoCompra;

public record CompraResponseDTO(

LocalDate dataCompra,
List<ProdutoCompra> produtos,
Pagamento pagamentocompra
) {
    public static CompraResponseDTO valueOf(Compra compra){
    return new CompraResponseDTO(
    compra.getDataCompra(),
    compra.getProduto(),
    compra.getPagamentoCompra()
    );

    }    
}
