package br.unitins.hello.dto;



public record EnderecoDTO (

    String quadra,
    String alameda,
    String complemento,
    Integer numero,
    String cep,
    Long id_cidadeEndereco
){
    
}
