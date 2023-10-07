package br.unitins.hello.dto;

import br.unitins.hello.model.TamanhoTipo;

public record ItemDTO(
    
    String nomeItem,
    String descricaoItem,
    double precoItem,
    TamanhoTipo tamanho_tipo,
    String imagemItem

) {}