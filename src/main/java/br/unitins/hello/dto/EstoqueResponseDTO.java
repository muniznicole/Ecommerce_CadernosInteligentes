package br.unitins.hello.dto;

import br.unitins.hello.model.Estoque;

public record EstoqueResponseDTO(
    
    Long id,
    ItemResponseDTO item,
    String descricaoEstoque,
    int quantidade

) {
    public EstoqueResponseDTO (Estoque estoque){ 
    
        this(
            estoque.getId(),
            new ItemResponseDTO(estoque.getItem()),
            estoque.getDescricaoEstoque(),
            estoque.getQuantidade()
        );
    
    }
}
