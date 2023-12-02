package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.EnderecoDTO;
import br.unitins.hello.dto.EnderecoResponseDTO;

public interface EnderecoService {
    public EnderecoResponseDTO insert(EnderecoDTO dto);

    public EnderecoResponseDTO update(EnderecoDTO dto, Long id);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);

    public List<EnderecoResponseDTO> findByCidadeNome(String cidadenome);

}
