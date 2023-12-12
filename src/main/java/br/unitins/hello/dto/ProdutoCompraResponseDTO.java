package br.unitins.hello.dto;

import br.unitins.hello.model.Produto;
import br.unitins.hello.model.ProdutoCompra;

public record ProdutoCompraResponseDTO(
    Produto compra,
    Integer quantidade,
    Long id
) {
    public static ProdutoCompraResponseDTO valueOf(ProdutoCompra produtoCompra){

        return new ProdutoCompraResponseDTO (
            produtoCompra.getProdutoCompra(),
            produtoCompra.getQuantidade(),
            produtoCompra.getId());
    }
}
