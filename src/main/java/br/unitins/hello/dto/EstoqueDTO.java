package br.unitins.hello.dto;

import java.util.List;

public record EstoqueDTO(
    
    String descricaoEstoque,
    int quantidade,
    List<ItemResponseDTO> itemList

) {}