package br.unitins.hello.service;

import br.unitins.hello.model.Pedido;
import br.unitins.hello.repository.PedidoRepository;
import br.unitins.hello.dto.PedidoDTO;
import br.unitins.hello.dto.PedidoResponseDTO;

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
public class PedidoServiceImpl implements PedidoService {
    
    @Inject
    PedidoRepository repository;

    @Inject
    ItemRepository itemRepository;

    @Inject
    UserRepository userRepository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto) {

        Pedido novoPedido = new Pedido();

        Item idDoItem = itemRepository.findById(dto.item());
        novoPedido.setItem(idDoItem);

        Usuario idDoUsuario = userRepository.findById(dto.usuario());
        novoPedido.setUsuario(idDoUsuario);

        novoPedido.setPrecoTotalPedido(dto.preco());

        repository.persist(novoPedido);

        return  PedidoResponseDTO.valueOf(novoPedido);
    }

    @Override
    @Transactional
    public PedidoResponseDTO update(PedidoDTO dto, Long id) {

        Pedido pedido = repository.findById(id);

        if(!dto.usuario().equals(pedido.getUsuario().getId())){
            pedido.getUsuario().setId(dto.usuario());
        }
        if(!dto.item().equals(pedido.getItem().getId())){
            pedido.getItem().setId(dto.item());
        }

        pedido.setPrecoTotalPedido(dto.preco());

        return  PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return  PedidoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return repository.findAll()
                        .stream()
                        .map(e -> PedidoResponseDTO.valueOf(e))
                        .collect(Collectors.toList());
    }
}
