package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.CartaoDTO;
import br.unitins.hello.dto.CartaoResponseDTO;


public interface CartaoService {
    public CartaoResponseDTO insert(CartaoDTO dto);

    public CartaoResponseDTO update(CartaoDTO dto, Long id);

    public void delete(Long id);

    public CartaoResponseDTO findById(Long id);

    public List<CartaoResponseDTO> findByTitularCartao(String titularCartao);

}
