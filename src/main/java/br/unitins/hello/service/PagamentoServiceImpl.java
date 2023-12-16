package br.unitins.hello.service;

import br.unitins.hello.dto.CartaoDTO;
import br.unitins.hello.dto.CartaoResponseDTO;
import br.unitins.hello.dto.PagamentoDTO;
import br.unitins.hello.dto.PagamentoResponseDTO;
import br.unitins.hello.model.Pagamento;
import br.unitins.hello.repository.CartaoRepository;
import br.unitins.hello.repository.PagamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    @Inject
    PagamentoRepository repository;
  
    @Inject
    CartaoService serviceCartao;
 
    @Inject
    CartaoRepository cartaoRepository;

    @Override
    public Pagamento insert(PagamentoDTO dto) {
        
        Pagamento novPagamento= new Pagamento();  

        novPagamento.setPagamentoTipo(dto.pagamentoTipo());
        CartaoDTO cartaoDTO = new CartaoDTO(cartaoRepository.findById(dto.cartaoId()).getTitularCartao(),
        cartaoRepository.findById(dto.cartaoId()).getTipoCartao(),
        cartaoRepository.findById(dto.cartaoId()).getNumeroCartao());
        novPagamento.setCartaoPagamento(cartaoRepository.findById(dto.cartaoId()));
        novPagamento.setStatusPagamento(dto.statusPagamento());

        try {

            repository.persist(novPagamento);

        } catch (Exception e) {

            e.getMessage();

        }

        return novPagamento;
    }

    @Override
    public PagamentoResponseDTO update(PagamentoDTO dto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public PagamentoResponseDTO findbyid(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findbyid'");
    }
    
}
