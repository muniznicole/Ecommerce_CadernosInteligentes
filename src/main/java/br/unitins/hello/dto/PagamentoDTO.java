package br.unitins.hello.dto;

import br.unitins.hello.model.Cartao;
import br.unitins.hello.model.PagamentoTipo;
import jakarta.validation.constraints.NotBlank;

public record PagamentoDTO(
@NotBlank(message = "Deve conter o tipo de pagamento")
PagamentoTipo pagamentoTipo,

CartaoDTO cartao,
@NotBlank(message = "Deve conter o status do pagamento")
String statusPagamento

) {
    
}
