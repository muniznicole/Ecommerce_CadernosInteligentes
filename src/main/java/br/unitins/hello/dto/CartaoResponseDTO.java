package br.unitins.hello.dto;

import br.unitins.hello.model.Cartao;

public record CartaoResponseDTO(
        String titularCartao,
        String tipoCartao

) {
    public static CartaoResponseDTO valueOf(Cartao cartao) {
        return new CartaoResponseDTO(
            cartao.getTitularCartao(),
            cartao.getTipoCartao().getDescricao());
    }
}
