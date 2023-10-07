package br.unitins.hello.service;

import br.unitins.hello.model.Estoque;
import br.unitins.hello.repository.EstoqueRepository;
import br.unitins.hello.dto.EstoqueDTO;
import br.unitins.hello.dto.EstoqueResponseDTO;

import br.unitins.hello.model.Item;
import br.unitins.hello.model.TamanhoTipo;
import br.unitins.hello.model.Usuario;
import br.unitins.hello.repository.ItemRepository;
import br.unitins.hello.dto.ItemDTO;
import br.unitins.hello.dto.ItemResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstoqueServiceImpl implements EstoqueService {
    
    @Inject
    EstoqueRepository repository;

    @Override
    @Transactional
    public EstoqueResponseDTO insert(EstoqueDTO dto) {

        Estoque novoEstoque = new Estoque();
        novoEstoque.setDescricaoEstoque(dto.descricaoEstoque());
        novoEstoque.setQuantidade(dto.quantidade());
        
        if(dto.itemList() != null && !dto.itemList().isEmpty()){
            novoEstoque.setItemList(new ArrayList<Item>());
            for(ItemResponseDTO item: dto.itemList()){
                Item itemitem = new Item();
                itemitem.setNomeItem(item.nomeItem());
                itemitem.setDescricaoItem(item.descricaoItem());
                itemitem.setPrecoItem(item.precoItem());
                itemitem.setTamanho_tipo(item.tamanho_tipo());
                itemitem.setImagemItem(item.imagemItem());
                novoEstoque.getItemList().add(itemitem);
            }
        }

        repository.persist(novoEstoque);

        return EstoqueResponseDTO.valueOf(novoEstoque);
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

        if(dto.itemList() != null && !dto.itemList().isEmpty()){
            estoque.setItemList(new ArrayList<Item>());
            for(ItemResponseDTO item: dto.itemList()){
                Item itemitem = new Item();
                itemitem.setNomeItem(item.nomeItem());
                itemitem.setDescricaoItem(item.descricaoItem());
                itemitem.setPrecoItem(item.precoItem());
                itemitem.setTamanho_tipo(item.tamanho_tipo());
                itemitem.setImagemItem(item.imagemItem());
                estoque.getItemList().add(itemitem);
            }
        }        

        return EstoqueResponseDTO.valueOf(estoque);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EstoqueResponseDTO findById(Long id) {
        return EstoqueResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<EstoqueResponseDTO> findByNome(String descricaoEstoque) {
        return null;
    }

    @Override
    public List<EstoqueResponseDTO> findByAll() {
        return repository.listAll()
            .stream()
            .map(e -> EstoqueResponseDTO.valueOf(e)).toList();
    }
    
}
