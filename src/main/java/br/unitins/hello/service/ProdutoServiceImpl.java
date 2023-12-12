package br.unitins.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.hello.dto.ProdutoCompraResponseDTO;
import br.unitins.hello.dto.ProdutoDTO;
import br.unitins.hello.dto.ProdutoResponseDTO;
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
    public ProdutoResponseDTO insert(ProdutoDTO dto) {
       Produto novoProduto = new Produto();

       novoProduto.setDescricao(dto.descricao());
       novoProduto.setPrecoUnidade(dto.precoUnidade());
       novoProduto.setTamanhoProduto(dto.tamanho());
       novoProduto.setQuantidade(dto.quantidade());

       try {
    repository.persist(novoProduto);    
       } catch (Exception e) {
        e.getMessage();
       }
    return ProdutoResponseDTO.valueOf(novoProduto);
    }

    @Override
    public ProdutoResponseDTO update(ProdutoDTO dto, Long id) {
         Produto atualizaProduto = new Produto();

         atualizaProduto.setDescricao(dto.descricao());
       atualizaProduto.setPrecoUnidade(dto.precoUnidade());
       atualizaProduto.setTamanhoProduto(dto.tamanho());
       atualizaProduto.setQuantidade(dto.quantidade());
        try {

            repository.persist(atualizaProduto);
        } catch (Exception e) {
            e.getMessage();

        }

        return ProdutoResponseDTO.valueOf(atualizaProduto);
    }

    @Override
    public void delete(Long id) {
        
        repository.deleteById(id);
    }

   /* 
    @Override
    public ProdutoResponseDTO findbyid(Long id) {
        
    }
    */

    @Override
    public List<ProdutoResponseDTO> findAll() {
      List<Produto> listProduto = new ArrayList();
        listProduto.addAll(repository.listAll().size(), listProduto);
        List<ProdutoResponseDTO> listResponse = listProduto.stream()
                .map(e -> ProdutoResponseDTO.valueOf(e))
                .collect(Collectors.toList());
        return listResponse;
    }

  
    
}
