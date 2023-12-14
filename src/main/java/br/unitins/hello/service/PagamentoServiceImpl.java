package br.unitins.hello.service;

import br.unitins.hello.dto.PagamentoDTO;
import br.unitins.hello.dto.PagamentoResponseDTO;
import br.unitins.hello.model.Pagamento;
import br.unitins.hello.repository.PagamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    @Inject
    PagamentoRepository repository;
  
    @Inject
    CartaoService serviceCartao;

    @Override
    public Pagamento insert(PagamentoDTO dto) {
       Pagamento novPagamento= new Pagamento();  

        novPagamento.setPagamentoTipo(dto.pagamentoTipo());
        novPagamento.setCartaoPagamento(serviceCartao.insert( dto.cartao()));
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
