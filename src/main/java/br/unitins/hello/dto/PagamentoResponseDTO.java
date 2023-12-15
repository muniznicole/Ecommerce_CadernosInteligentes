package br.unitins.hello.dto;
import br.unitins.hello.model.Cartao;
import br.unitins.hello.model.Pagamento;
import br.unitins.hello.model.PagamentoTipo;
public record PagamentoResponseDTO(

PagamentoTipo pagamentoTipo

) {
    public static PagamentoResponseDTO valueOf(Pagamento Pagamento) {        
        return new PagamentoResponseDTO(
        Pagamento.getPagamentoTipo()  
        );
    } 
}
