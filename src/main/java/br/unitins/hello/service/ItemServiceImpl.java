package br.unitins.hello.service;

import br.unitins.hello.model.Item;
import br.unitins.hello.model.TamanhoTipo;
import br.unitins.hello.repository.ItemRepository;
import br.unitins.hello.dto.ItemDTO;
import br.unitins.hello.dto.ItemResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ItemServiceImpl implements ItemService {

    @Inject
    ItemRepository itemRepository;

    @Override
    public ItemResponseDTO insert(ItemDTO dto) {

        Item novoItem = new Item();
        
        novoItem.setNomeItem(dto.nomeItem());
        novoItem.setDescricaoItem(dto.descricaoItem());
        novoItem.setPrecoItem(dto.precoItem());
        novoItem.setTamanho_tipo(dto.tamanho_tipo());
        novoItem.setImagemItem(dto.imagemItem());
        itemRepository.persist(novoItem);

        return new ItemResponseDTO(novoItem);

    }

    @Override
    public ItemResponseDTO update(ItemDTO dto, Long id) {

        Item item = itemRepository.findById(id);

        if(dto.nomeItem().equals("string")){
        } else {
            item.setNomeItem(dto.nomeItem());
        }

        if(dto.descricaoItem().equals("string")){
        } else {
            item.setDescricaoItem(dto.descricaoItem());
        }
        
        Double precoItem = dto.precoItem();
        if(precoItem != null && dto.precoItem() > 0.0){
        } else {
            item.setPrecoItem(dto.precoItem());
        }

        TamanhoTipo tamanho_tipo = dto.tamanho_tipo();
        if(tamanho_tipo != null){
        } else {
            item.setTamanho_tipo(dto.tamanho_tipo());
        }

        if(dto.imagemItem().equals("string")){
        } else {
            item.setImagemItem(dto.imagemItem());
        }

        return new ItemResponseDTO(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemResponseDTO findById(Long id) {
        Item novoItem = new Item();
        novoItem = itemRepository.findById(id);
        
        return new ItemResponseDTO((novoItem));
    }

    @Override
    public List<ItemResponseDTO> findByNome(String nomeItem) {
        List<Item> list = itemRepository.findByNome(nomeItem);
        if(list == null)
            throw new NullPointerException("nenhum item encontrado");

        return list.stream()
                .map(ItemResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemResponseDTO> findByAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponseDTO::new)
                .collect(Collectors.toList());
    }
    
}
