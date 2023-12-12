package br.unitins.hello.dto;

import br.unitins.hello.model.Produto;
import br.unitins.hello.model.TamanhoTipo;

public record ProdutoResponseDTO(

String descricao,
Double precoUnidade,
TamanhoTipo tamanho,
Integer quantidade

) {
public static ProdutoResponseDTO valueOf(Produto produto){
    return new ProdutoResponseDTO(
    produto.getDescricao(),
    produto.getPrecoUnidade(),
    produto.getTamanhoProduto(),
    produto.getQuantidade());

    }    
}
