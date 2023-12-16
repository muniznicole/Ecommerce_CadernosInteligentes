package br.unitins.hello.dto;

import br.unitins.hello.model.Produto;
import jakarta.validation.constraints.NotBlank;

public record ProdutoCompraDTO(

    @NotBlank(message = "Deve conter um Produto")
    Long produtoCompra,
    
    @NotBlank(message = "Deve conter a quantidade de produtos")
    Integer quantidadeProdutoCompra

) {} 
