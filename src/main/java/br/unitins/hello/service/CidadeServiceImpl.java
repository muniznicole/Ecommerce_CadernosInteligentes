package br.unitins.hello.service;

import java.util.ArrayList;
import java.util.List;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import br.unitins.hello.dto.CidadeDTO;
import br.unitins.hello.dto.CidadeResponseDTO;
import br.unitins.hello.model.Cidade;
import br.unitins.hello.repository.CidadeRepository;
import br.unitins.hello.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService{

    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    EstadoRepository estadoRepository;

    @Override
    public CidadeResponseDTO insertCidade(CidadeDTO cidade) {
        Cidade novaCidade = new Cidade();

        novaCidade.setNomeCidade(cidade.nomeCidade());
        novaCidade.setEstadoCidade(estadoRepository.findById(cidade.id()));
       cidadeRepository.persist(novaCidade);
        return CidadeResponseDTO.valueOf(novaCidade);
    }

    @Override
    public List<CidadeResponseDTO> findall() {
        List<CidadeResponseDTO> lCidadeResponseDTOs = new ArrayList<>();
       
        for(Long i = cidadeRepository.count();i>0;i--){
            lCidadeResponseDTOs.add(CidadeResponseDTO.valueOf(cidadeRepository.findById(i)));
        }

        return lCidadeResponseDTOs;
    }
    
}
