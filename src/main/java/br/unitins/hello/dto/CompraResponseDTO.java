package br.unitins.hello.dto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.hello.model.Compra;
import br.unitins.hello.model.Pagamento;
import br.unitins.hello.model.ProdutoCompra;
import br.unitins.hello.repository.ProdutoCompraRepository;

public record CompraResponseDTO(
LocalDate dataCompra,
List<ProdutoCompraResponseDTO> produtos,
Pagamento pagamentocompra
) {
    public static CompraResponseDTO valueOf(Compra compra){
        List<ProdutoCompraResponseDTO> produtosDTO = compra.getProduto().stream()
        .map(ProdutoCompraResponseDTO::valueOf)
        .collect(Collectors.toList());

return new CompraResponseDTO(
        compra.getDataCompra(),
        produtosDTO,
        compra.getPagamentoCompra()
);
    }}
    
    
