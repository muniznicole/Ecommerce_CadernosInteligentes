package br.unitins.hello.service;

import br.unitins.hello.model.Estoque;
import br.unitins.hello.repository.EstoqueRepository;
import br.unitins.hello.dto.EstoqueDTO;
import br.unitins.hello.dto.EstoqueResponseDTO;

import br.unitins.hello.model.Item;
import br.unitins.hello.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstoqueServiceImpl implements EstoqueService {
    
    @Inject
    EstoqueRepository repository;

    @Inject
    ItemRepository itemRepository;

    @Override
    @Transactional
    public EstoqueResponseDTO insert(EstoqueDTO dto) {

        Estoque novoEstoque = new Estoque();
        novoEstoque.setDescricaoEstoque(dto.descricaoEstoque());
        novoEstoque.setQuantidade(dto.quantidade());

        Item idDoItem = itemRepository.findById(dto.idItem());
        novoEstoque.setItem(idDoItem);

        repository.persist(novoEstoque);

        return new EstoqueResponseDTO(novoEstoque);
    }

    @Override
    @Transactional
    public EstoqueResponseDTO update(EstoqueDTO dto, Long id) {

        Estoque estoque = repository.findById(id);

        if(dto.descricaoEstoque().equals("string")){
        } else {
            estoque.setDescricaoEstoque(dto.descricaoEstoque());
        }

        estoque.setQuantidade(dto.quantidade());
        Item idDoItem = itemRepository.findById(dto.idItem());
        estoque.setItem(idDoItem);     

        return new EstoqueResponseDTO(estoque);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EstoqueResponseDTO findById(Long id) {
        return new EstoqueResponseDTO(repository.findById(id));
    }

    @Override
    public List<EstoqueResponseDTO> findByNome(String descricaoEstoque) {
        List<Estoque> list = repository.findByNome(descricaoEstoque);
        if(list == null)
            throw new NullPointerException("Estoque não encontrado.");
        
        return list.stream()
                        .map(EstoqueResponseDTO::new)
                        .collect(Collectors.toList());
    }

    @Override
    public List<EstoqueResponseDTO> findByAll() {
        return repository.findAll()
                        .stream()
                        .map(EstoqueResponseDTO::new)
                        .collect(Collectors.toList());
    }
    
}
