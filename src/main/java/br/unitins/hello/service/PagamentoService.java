package br.unitins.hello.service;

import br.unitins.hello.dto.PagamentoDTO;
import br.unitins.hello.dto.PagamentoResponseDTO;
import br.unitins.hello.model.Pagamento;

public interface PagamentoService {
     public Pagamento insert(PagamentoDTO dto);
    public PagamentoResponseDTO update(PagamentoDTO dto,Long id);
    public void delete(Long id);
    public PagamentoResponseDTO findbyid(Long id);
}
