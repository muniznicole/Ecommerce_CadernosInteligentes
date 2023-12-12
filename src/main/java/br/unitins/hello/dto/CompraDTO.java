package br.unitins.hello.dto;
import java.time.LocalDate;
import java.util.List;

import br.unitins.hello.model.Pagamento;
import jakarta.validation.constraints.NotBlank;
public record CompraDTO(
@NotBlank(message = "Deve conter a data da compra")
LocalDate dataCompra,
@NotBlank(message = "Dever conter a lista de produtos comprados e suas quantidades")
List<Long> produto,
@NotBlank(message = "Deve conter a forma de pagamento e o status do pagamento   ")
Pagamento pagamentoCompra
) {
    
}
