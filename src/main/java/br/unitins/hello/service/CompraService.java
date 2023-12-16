package br.unitins.hello.service;

import br.unitins.hello.dto.CompraResponseDTO;
import br.unitins.hello.model.Usuario;

import java.util.List;

import br.unitins.hello.dto.CompraDTO;

public interface CompraService {
    
    public CompraResponseDTO insert(CompraDTO dto);

    public CompraResponseDTO update(CompraDTO dto, Long id);

    public void delete(Long id);

    public CompraResponseDTO findbyid(Long id);

    public List<CompraResponseDTO> Findbyuser(Usuario user);
}
