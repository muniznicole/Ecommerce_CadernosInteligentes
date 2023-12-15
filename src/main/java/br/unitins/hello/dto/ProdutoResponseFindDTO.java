package br.unitins.hello.dto;

import br.unitins.hello.model.Produto;
import br.unitins.hello.model.TamanhoTipo;

public record ProdutoResponseFindDTO(

String descricao,
TamanhoTipo tamanho,
Long id,
Integer quantiade

) {
public static ProdutoResponseFindDTO valueOf(Produto produto){
    return new ProdutoResponseFindDTO(
    produto.getDescricao(),
    produto.getTamanhoProduto(),
    produto.getId(),
    produto.getQuantidade()
    );
    }    
}
