package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.EstoqueDTO;
import br.unitins.hello.dto.EstoqueResponseDTO;

public interface EstoqueService {

    public EstoqueResponseDTO insert(EstoqueDTO dto);

    public EstoqueResponseDTO update(EstoqueDTO dto, Long id);

    public void delete(Long id);

    public EstoqueResponseDTO findById(Long id);

    public List<EstoqueResponseDTO> findByNome(String descricaoEstoque);

    public List<EstoqueResponseDTO> findByAll(); 
    
}
