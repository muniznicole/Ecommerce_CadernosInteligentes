package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.CarrinhoDTO;
import br.unitins.hello.dto.CarrinhoResponseDTO;

public interface CarrinhoService {
    
    public CarrinhoResponseDTO insert(CarrinhoDTO dto);

    public CarrinhoResponseDTO update(CarrinhoDTO dto, Long id);

    public void delete(Long id);

    public CarrinhoResponseDTO findById(Long id);

    public List<CarrinhoResponseDTO> findByAll(); 

}