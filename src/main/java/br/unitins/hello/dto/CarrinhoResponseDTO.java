package br.unitins.hello.dto;

import br.unitins.hello.model.Carrinho;

import br.unitins.hello.model.Item;
import br.unitins.hello.model.Usuario;

public record CarrinhoResponseDTO(
    Item item,
    Usuario usuario,
    Double preco

) {
    public static CarrinhoResponseDTO valueOf(Carrinho carrinho) {        
        return new CarrinhoResponseDTO(
           carrinho.getItem(),
           carrinho.getUsuario(),
           carrinho.getPrecoTotalCarrinho()
        );
    } 
}