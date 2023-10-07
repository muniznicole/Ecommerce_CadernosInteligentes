package br.unitins.hello.dto;

import java.util.List;
import br.unitins.hello.model.Estoque;

public record EstoqueResponseDTO(
    
    Long id,
    String descricaoEstoque,
    int quantidade,
    List<ItemResponseDTO> itemList

) {
    public static EstoqueResponseDTO valueOf(Estoque estoque){ 
    
        return new EstoqueResponseDTO(
            estoque.getId(),
            estoque.getDescricaoEstoque(),
            estoque.getQuantidade(),
            estoque.getItemList()
                .stream()
                .map(e -> ItemResponseDTO.valueOf(e)).toList()
        );
    
    }
}
