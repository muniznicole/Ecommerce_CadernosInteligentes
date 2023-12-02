package br.unitins.hello.dto;

import java.util.List;

import br.unitins.hello.model.Estoque;

public record EstoqueResponseDTO(
    
    Long id,
    String descricaoEstoque,
    int quantidade

) {
    public EstoqueResponseDTO (Estoque estoque){ 
    
        this(
            estoque.getId(),
            estoque.getDescricaoEstoque(),
            estoque.getQuantidade()
        );
    
    }
}
