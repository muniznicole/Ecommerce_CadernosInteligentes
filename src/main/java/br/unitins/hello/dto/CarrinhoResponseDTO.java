package br.unitins.hello.dto;

import br.unitins.hello.model.Carrinho;

public record CarrinhoResponseDTO(
    ItemResponseDTO item,
    UserResponseDTO usuario,
    Double preco

) {
    public CarrinhoResponseDTO(Carrinho carrinho) {
        this(
            new ItemResponseDTO(carrinho.getItem()),
            new UserResponseDTO(carrinho.getUsuario()),
            carrinho.getPrecoTotalCarrinho()
        );
    }
}