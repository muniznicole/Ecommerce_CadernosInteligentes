package br.unitins.hello.dto;

import br.unitins.hello.model.Endereco;

public record EnderecoDTO (

    String quadra,
    String alameda,
    String complemento,
    Integer numero,
    String cep,
    Long id_cidadeEndereco

) {}
