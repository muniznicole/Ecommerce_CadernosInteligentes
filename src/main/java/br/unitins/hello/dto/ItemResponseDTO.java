package br.unitins.hello.dto;

import br.unitins.hello.model.Item;

public record ItemResponseDTO (
    Long id,
    String nomeItem,
    String descricaoItem,
    double precoItem,
    String imagemItem
) {     
    public static ItemResponseDTO valueOf(Item item) {        
        return new ItemResponseDTO (
            item.getId(),
            item.getNomeItem(),
            item.getDescricaoItem(),
            item.getPrecoItem(),
            item.getImagemItem()
        );
    }
}
