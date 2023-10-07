package br.unitins.hello.dto;

import br.unitins.hello.model.Tipocartao;

public record CartaoDTO (
    String titularCartao,
    Tipocartao cartaoTipo,
    String numeroCartao
){
    
}
