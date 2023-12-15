package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.ProdutoDTO;
import br.unitins.hello.dto.ProdutoResponseDTO;
import br.unitins.hello.dto.ProdutoResponseFindDTO;


public interface ProdutoService {
public ProdutoResponseFindDTO insert(ProdutoDTO dto);
    public ProdutoResponseDTO updateQuantidade(Long id,Integer novoQuantidade);
    public void delete(Long id);
    public List<ProdutoResponseFindDTO> findAll();
} 
