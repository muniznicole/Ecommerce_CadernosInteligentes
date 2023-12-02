package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.PedidoDTO;
import br.unitins.hello.dto.PedidoResponseDTO;

public interface PedidoService {
    
    public PedidoResponseDTO insert(PedidoDTO dto);

    public PedidoResponseDTO update(PedidoDTO dto, Long id);

    public void delete(Long id);

    public PedidoResponseDTO findById(Long id);

    public List<PedidoResponseDTO> findByAll(); 

}