package br.unitins.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.hello.dto.CartaoResponseDTO;
import br.unitins.hello.dto.ProdutoCompraDTO;
import br.unitins.hello.dto.ProdutoCompraResponseDTO;
import br.unitins.hello.model.Cartao;
import br.unitins.hello.model.Produto;
import br.unitins.hello.model.ProdutoCompra;
import br.unitins.hello.repository.EnderecoRepository;
import br.unitins.hello.repository.ProdutoCompraRepository;
import br.unitins.hello.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProdutoCompraServiceImpl implements ProdutoCompraService {

    @Inject
    ProdutoCompraRepository repository;

    @Inject
    ProdutoRepository produtoRepository;

    @Override
    public ProdutoCompra insert(ProdutoCompraDTO dto) {
        ProdutoCompra novoProdutoCompra = new ProdutoCompra();
        Produto produto = new Produto();
        produto = produtoRepository.findById(dto.produtoCompra());
        novoProdutoCompra.setProdutoCompra(produto);
        novoProdutoCompra.setQuantidade(dto.quantidadeProdutoCompra());
       
            repository.persist(novoProdutoCompra); 

        return novoProdutoCompra;
    }

    @Override
    public ProdutoCompraResponseDTO update(ProdutoCompraDTO dto, Long id) {
        ProdutoCompra atualizaProdutoCompra = new ProdutoCompra();
         ProdutoCompra novoProdutoCompra = new ProdutoCompra();
        Produto produto = new Produto();
        atualizaProdutoCompra = repository.findById(id);
        atualizaProdutoCompra.setProdutoCompra(produto);
        atualizaProdutoCompra.setQuantidade(dto.quantidadeProdutoCompra());
        try {

            repository.persist(atualizaProdutoCompra);
        } catch (Exception e) {
            e.getMessage();

        }

        return ProdutoCompraResponseDTO.valueOf(atualizaProdutoCompra);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
/* 
    @Override
    public List<ProdutoCompraDTO> findall(List<Long> list) {
        
        for(int i = 0;i<= list.size();i++){

        }
        list.addAll(repository.listAll().size(), list);
        List<ProdutoCompraResponseDTO> listResponse = list.stream()
                .map(e -> ProdutoCompraResponseDTO.valueOf(e))
                .collect(Collectors.toList());
        return listResponse;
    }
*/
   

}
