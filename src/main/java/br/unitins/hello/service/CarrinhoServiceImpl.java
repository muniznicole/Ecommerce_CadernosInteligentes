package br.unitins.hello.service;

import br.unitins.hello.model.Carrinho;
import br.unitins.hello.repository.CarrinhoRepository;
import br.unitins.hello.dto.CarrinhoDTO;
import br.unitins.hello.dto.CarrinhoResponseDTO;

import br.unitins.hello.model.Item;
import br.unitins.hello.repository.ItemRepository;

import br.unitins.hello.model.Usuario;
import br.unitins.hello.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CarrinhoServiceImpl implements CarrinhoService {
    
    @Inject
    CarrinhoRepository repository;

    @Inject
    ItemRepository itemRepository;

    @Inject
    UserRepository userRepository;

    @Override
    @Transactional
    public CarrinhoResponseDTO insert(CarrinhoDTO dto) {

        Carrinho novoCarrinho = new Carrinho();

        Item idDoItem = itemRepository.findById(dto.item());
        novoCarrinho.setItem(idDoItem);

        Usuario idDoUsuario = userRepository.findById(dto.usuario());
        novoCarrinho.setUsuario(idDoUsuario);

        novoCarrinho.setPrecoTotalCarrinho(dto.preco());

        repository.persist(novoCarrinho);

        return new CarrinhoResponseDTO(novoCarrinho);
    }

    @Override
    @Transactional
    public CarrinhoResponseDTO update(CarrinhoDTO dto, Long id) {

        Carrinho carrinho = repository.findById(id);

        if(!dto.usuario().equals(carrinho.getUsuario().getId())){
            carrinho.getUsuario().setId(dto.usuario());
        }
        if(!dto.item().equals(carrinho.getItem().getId())){
            carrinho.getItem().setId(dto.item());
        }

        carrinho.setPrecoTotalCarrinho(dto.preco());

        return new CarrinhoResponseDTO(carrinho);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CarrinhoResponseDTO findById(Long id) {
        return new CarrinhoResponseDTO(repository.findById(id));
    }

    @Override
    public List<CarrinhoResponseDTO> findByAll() {
        return repository.findAll()
                        .stream()
                        .map(CarrinhoResponseDTO::new)
                        .collect(Collectors.toList());
    }
}
