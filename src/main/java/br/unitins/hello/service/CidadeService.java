package br.unitins.hello.service;

import java.util.List;

import br.unitins.hello.dto.CidadeDTO;
import br.unitins.hello.dto.CidadeResponseDTO;

public interface CidadeService {
    public CidadeResponseDTO insertCidade(CidadeDTO cidade);
    public List<CidadeResponseDTO> findall();
}
