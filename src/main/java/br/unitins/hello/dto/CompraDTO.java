package br.unitins.hello.dto;
import java.time.LocalDate;
import java.util.List;

import br.unitins.hello.model.Pagamento;
import br.unitins.hello.model.ProdutoCompra;
import jakarta.validation.constraints.NotBlank;
public record CompraDTO(
@NotBlank(message = "Dever conter a lista de produtos comprados e suas quantidades")
List<ProdutoCompraDTO> produto,
@NotBlank(message = "Deve conter a forma de pagamento e o status do pagamento   ")
PagamentoDTO pagamentoCompra,
@NotBlank(message = "Deve conter a forma de pagamento e o status do pagamento   ")
EnderecoDTO enderecoEntrega

) {
    
}
