package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.ProdutoDTO;
import br.unitins.hello.dto.ProdutoResponseDTO;


public interface ProdutoService {
public ProdutoResponseDTO insert(ProdutoDTO dto);
    public ProdutoResponseDTO update(ProdutoDTO dto,Long id);
    public void delete(Long id);
    public List<ProdutoResponseDTO> findAll();
} 
