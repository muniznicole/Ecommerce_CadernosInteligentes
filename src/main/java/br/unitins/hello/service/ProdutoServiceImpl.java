package br.unitins.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.hello.dto.ProdutoCompraResponseDTO;
import br.unitins.hello.dto.ProdutoDTO;
import br.unitins.hello.dto.ProdutoResponseDTO;
import br.unitins.hello.dto.ProdutoResponseFindDTO;
import br.unitins.hello.dto.UserDTO;
import br.unitins.hello.dto.UserResponseDTO;
import br.unitins.hello.model.Produto;
import br.unitins.hello.model.ProdutoCompra;
import br.unitins.hello.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;

    @Override
    public ProdutoResponseFindDTO insert(ProdutoDTO dto) {
       Produto novoProduto = new Produto();

       novoProduto.setDescricao(dto.descricao());
       novoProduto.setPrecoUnidade(dto.precoUnidade());
       novoProduto.setTamanhoProduto(dto.tamanho());
       novoProduto.setQuantidade(dto.quantidade());

       
    repository.persist(novoProduto);    
       
    return ProdutoResponseFindDTO.valueOf(novoProduto);
    }

    @Override
    public ProdutoResponseDTO updateQuantidade( Long id, Integer novaQuantidade) {
         Produto atualizaProduto = repository.findById(id);
        Integer quant = atualizaProduto.getQuantidade()-novaQuantidade;
         atualizaProduto.setQuantidade(quant);
        
        repository.persist(atualizaProduto);

        return ProdutoResponseDTO.valueOf(atualizaProduto);
    }

    @Override
    public void delete(Long id) {
        
        repository.deleteById(id);
    }


    @Override
    public List<ProdutoResponseFindDTO> findAll() {
        return repository.listAll().stream()
        .map(e -> ProdutoResponseFindDTO.valueOf(e)).toList();
    }
    
}
