package br.unitins.hello.dto;

import br.unitins.hello.model.Produto;
import br.unitins.hello.model.ProdutoCompra;
import br.unitins.hello.repository.ProdutoRepository;

public record ProdutoCompraResponseDTO(
    Produto compra,
    Integer quantidade,
    Long id
) {
    public static ProdutoCompraResponseDTO valueOf(ProdutoCompra produtoCompra){
        ProdutoRepository produtoRepository = new ProdutoRepository();
        return new ProdutoCompraResponseDTO (
            produtoRepository.findById(produtoCompra.getProdutoCompra().getId()),
            produtoCompra.getQuantidade(),
            produtoCompra.getId()
            );
    }
}
