package br.unitins.hello.dto;

import br.unitins.hello.model.TamanhoTipo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
        @NotBlank(message = "Deve conter uma descrição do produto") 
        @Max(value = 5 ) 
        String descricao,
        @NotBlank(message = "Deve conter um valor") 
        @Max(value = (long) 100.00 ) 
        Double precoUnidade,
        @NotNull(message = "Deve ter o tamanho do produto")
        TamanhoTipo tamanho,
        @NotNull(message = "Tamanho da imagem não pode ultrapassar 10 mb")
        @Max(value = 1024*1024*10)
        String imagemProduto,
        @NotNull(message = "Deve ter a quantidade de produtos")
        Integer quantidade) 
        {
            
}
