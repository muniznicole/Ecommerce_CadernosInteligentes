package br.unitins.hello.dto;

import br.unitins.hello.model.Cidade;
import br.unitins.hello.model.Endereco;


public record EnderecoResponseDTO (

String quadra,
    String alameda,
    String complemento,
    Cidade cidadeEndereco
){
   public static EnderecoResponseDTO valueOf(Endereco endereco) {        
        return new EnderecoResponseDTO(
            endereco.getQuadra(),
            endereco.getAlameda(),
            endereco.getComplemento(),
            endereco.getCidadeEnderco()
        );
    } 
}


