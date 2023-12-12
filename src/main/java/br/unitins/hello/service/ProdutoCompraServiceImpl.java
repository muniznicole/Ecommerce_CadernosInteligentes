package br.unitins.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.hello.dto.CartaoResponseDTO;
import br.unitins.hello.dto.ProdutoCompraDTO;
import br.unitins.hello.dto.ProdutoCompraResponseDTO;
import br.unitins.hello.model.Cartao;
import br.unitins.hello.model.ProdutoCompra;
import br.unitins.hello.repository.EnderecoRepository;
import br.unitins.hello.repository.ProdutoCompraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProdutoCompraServiceImpl implements ProdutoCompraService {

    @Inject
    ProdutoCompraRepository repository;

    @Override
    public ProdutoCompraResponseDTO insert(ProdutoCompraDTO dto) {
        ProdutoCompra novoProdutoCompra = new ProdutoCompra();

        novoProdutoCompra.setProdutoCompra(dto.produtoCompra());
        novoProdutoCompra.setQuantidade(dto.quantidadeProdutoCompra());
        try {

            repository.persist(novoProdutoCompra);
        } catch (Exception e) {
            e.getMessage();

        }

        return ProdutoCompraResponseDTO.valueOf(novoProdutoCompra);
    }

    @Override
    public ProdutoCompraResponseDTO update(ProdutoCompraDTO dto, Long id) {
        ProdutoCompra atualizaProdutoCompra = new ProdutoCompra();

        atualizaProdutoCompra = repository.findById(id);
        atualizaProdutoCompra.setProdutoCompra(dto.produtoCompra());
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

    @Override
    public List<ProdutoCompraResponseDTO> findall() {
         List<ProdutoCompra> listProdutoCompra = new ArrayList();
        listProdutoCompra.addAll(repository.listAll().size(), listProdutoCompra);
        List<ProdutoCompraResponseDTO> listResponse = listProdutoCompra.stream()
                .map(e -> ProdutoCompraResponseDTO.valueOf(e))
                .collect(Collectors.toList());
        return listResponse;
    }

   

}
