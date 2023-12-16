package br.unitins.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.hello.dto.EnderecoDTO;
import br.unitins.hello.dto.EnderecoResponseDTO;
import br.unitins.hello.model.Cidade;
import br.unitins.hello.model.Endereco;

import br.unitins.hello.repository.CidadeRepository;
import br.unitins.hello.repository.EnderecoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {
    
    @Inject
    EnderecoRepository repository;
    @Inject
    CidadeRepository repositoryCidade;

    @Override
    public Endereco insert(EnderecoDTO dto) {
        Endereco novoEndereco = new Endereco();
        Cidade cidade = repositoryCidade.findById(dto.id_cidadeEndereco());
        novoEndereco.setCidadeEnderco(cidade);
        novoEndereco.setAlameda(dto.alameda());
        novoEndereco.setCep(dto.cep());
        novoEndereco.setNumero(dto.numero());
        novoEndereco.setQuadra(dto.quadra());
        novoEndereco.setComplemento(dto.complemento());
        repository.persist(novoEndereco);

        return novoEndereco;
    }

    @Override
    public EnderecoResponseDTO update(EnderecoDTO dto, Long id) {
        Endereco endereco = repository.findById(id);
        if (dto.id_cidadeEndereco() == endereco.getCidadeEnderco().getId() || dto.id_cidadeEndereco() == 0) {
        } else {
            Cidade cidade = repositoryCidade.findById(dto.id_cidadeEndereco());
            endereco.setCidadeEnderco(cidade);
        }
        if (dto.alameda().equals("string")) {

        } else {
            endereco.setAlameda(dto.alameda());
        }
        if (dto.cep().equals("string")) {

        } else {
            endereco.setCep(dto.cep());
        }
        if (dto.numero().equals("string")) {
        } else {
            endereco.setNumero(dto.numero());
        }
        if (dto.quadra().equals("string")) {
        } else {
            endereco.setQuadra(dto.quadra());
        }
        if (dto.complemento().equals("string")) {
        } else {
            endereco.setComplemento(dto.complemento());
        }

        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        Endereco endereco = new Endereco();
        endereco = repository.findById(id);
        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    public List<EnderecoResponseDTO> findByCidadeNome(String cidadenome) {
        List<Endereco> listendereco = new ArrayList();
        listendereco = repository.findByCidade(cidadenome);
        List<EnderecoResponseDTO> enderecoDTOList = listendereco.stream()
                .map(e -> EnderecoResponseDTO.valueOf(e))
                .collect(Collectors.toList());
        return enderecoDTOList;
    }

}
