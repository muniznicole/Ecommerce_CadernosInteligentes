package br.unitins.hello.dto;

import br.unitins.hello.model.Cidade;

public record CidadeResponseDTO(
    String nomeCidade,
    String estadoabreviado
) {
    public static CidadeResponseDTO valueOf(Cidade cidade){

return new CidadeResponseDTO(
        cidade.getNomeCidade(),
        cidade.getEstadoCidade().getAbreviado());
    }
}
