package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.EnderecoDTO;
import br.unitins.hello.dto.EnderecoResponseDTO;
import br.unitins.hello.model.Endereco;

public interface EnderecoService {
    
    public Endereco insert(EnderecoDTO dto);

    public EnderecoResponseDTO update(EnderecoDTO dto, Long id);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);

    public List<EnderecoResponseDTO> findByCidadeNome(String cidadenome);

}
