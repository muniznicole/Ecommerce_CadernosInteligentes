package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.ProdutoCompraDTO;
import br.unitins.hello.dto.ProdutoCompraResponseDTO;
import br.unitins.hello.model.ProdutoCompra;

public interface ProdutoCompraService {

    public ProdutoCompra insert(ProdutoCompraDTO dto);
    public ProdutoCompraResponseDTO update(ProdutoCompraDTO dto,Long id);
    public void delete(Long id);
   /*  public List<ProdutoCompraDTO> findall(List<Long> list); */

}
