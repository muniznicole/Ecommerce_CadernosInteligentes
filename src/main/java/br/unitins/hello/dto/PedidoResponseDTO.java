package br.unitins.hello.dto;

import br.unitins.hello.model.Pedido;

import br.unitins.hello.model.Item;
import br.unitins.hello.model.Usuario;

public record PedidoResponseDTO(
    Item item,
    Usuario usuario,
    Double preco

) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {        
        return new PedidoResponseDTO(
           pedido.getItem(),
           pedido.getUsuario(),
           pedido.getPrecoTotalPedido()
        );
    } 
}