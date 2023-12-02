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
    
    public static ItemResponseDTO valueOf(Item item){
        return new ItemResponseDTO(
            item.getId(),
            item.getNomeItem(),
            item.getDescricaoItem(),
            item.getPrecoItem(),
            item.getTamanho_tipo(),
            item.getNomeImagemItem()
        );
    } 
}
