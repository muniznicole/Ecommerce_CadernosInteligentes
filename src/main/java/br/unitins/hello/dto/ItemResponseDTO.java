package br.unitins.hello.dto;

import br.unitins.hello.model.Item;
import br.unitins.hello.model.TamanhoTipo;

public record ItemResponseDTO (

    Long id,
    String nomeItem,
    String descricaoItem,
    Double precoItem,
    TamanhoTipo tamanho_tipo,
    String imagemItem
    
) {
    
    public ItemResponseDTO(Item item){
        this(
            item.getId(),
            item.getNomeItem(),
            item.getDescricaoItem(),
            item.getPrecoItem(),
            item.getTamanho_tipo(),
            item.getImagemItem()
        );
    } 
}
