package br.unitins.hello.service;

import br.unitins.hello.dto.ProdutoCompraDTO;

public interface PagamentoService {
     public PagamentoResponseDTO insert(PagamentoDTO dto);
    public PagamentoResponseDTO update(PagamentoDTO dto,Long id);
    public void delete(Long id);
    public PagamentoResponseDTO findbyid(Long id);
}
