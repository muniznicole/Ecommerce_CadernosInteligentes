package br.unitins.hello.service;



import java.util.List;

import br.unitins.hello.dto.ProdutoCompraDTO;
import br.unitins.hello.dto.ProdutoCompraResponseDTO;

public interface ProdutoCompraService {
    public ProdutoCompraResponseDTO insert(ProdutoCompraDTO dto);
    public ProdutoCompraResponseDTO update(ProdutoCompraDTO dto,Long id);
    public void delete(Long id);
    public List<ProdutoCompraResponseDTO> findall();
}
