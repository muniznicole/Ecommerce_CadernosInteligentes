package br.unitins.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.hello.dto.CartaoDTO;
import br.unitins.hello.dto.CartaoResponseDTO;
import br.unitins.hello.model.Cartao;
import br.unitins.hello.repository.CartaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class CartaoServiceImpl implements CartaoService{
 @Inject
    CartaoRepository repository;

    @Override
    public CartaoResponseDTO insert(CartaoDTO dto) {
       Cartao novoCartao = new Cartao();
       novoCartao.setNumeroCartao(dto.numeroCartao());
       novoCartao.setTipoCartao(dto.cartaoTipo());
       novoCartao.setTitularCartao(dto.titularCartao());

       repository.persist(novoCartao);

       return CartaoResponseDTO.valueOf(novoCartao);
    }

    @Override
    public CartaoResponseDTO update(CartaoDTO dto, Long id) {
        Cartao atualizaCartao = repository.findById(id);

        if (dto.numeroCartao().equals("string")) {
        } else {
            atualizaCartao.setNumeroCartao(dto.numeroCartao());;
        }
        if (dto.titularCartao().equals("string")) {

        } else {
            atualizaCartao.setTitularCartao(dto.titularCartao());
        }
        atualizaCartao.setTipoCartao(dto.cartaoTipo());

        return CartaoResponseDTO.valueOf(atualizaCartao);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CartaoResponseDTO findById(Long id) {
        Cartao cartao =repository.findById(id);
        return  CartaoResponseDTO.valueOf(cartao);
    }

    @Override
    public List<CartaoResponseDTO> findByTitularCartao(String titularCartao) {
     List<Cartao> listcartao = new ArrayList();
        listcartao = repository.findBytitularCartao(titularCartao);
        List<CartaoResponseDTO> cartaoDTOList = listcartao.stream()
                .map(e -> CartaoResponseDTO.valueOf(e))
                .collect(Collectors.toList());
        return cartaoDTOList;
    }
    
}
