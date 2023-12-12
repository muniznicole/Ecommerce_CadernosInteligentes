package br.unitins.hello.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unitins.hello.dto.CompraDTO;
import br.unitins.hello.dto.CompraResponseDTO;
import br.unitins.hello.dto.ProdutoCompraDTO;
import br.unitins.hello.dto.ProdutoCompraResponseDTO;
import br.unitins.hello.model.Compra;
import br.unitins.hello.model.ProdutoCompra;
import br.unitins.hello.repository.CompraRepository;
import br.unitins.hello.repository.ProdutoCompraRepository;
import br.unitins.hello.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class CompraServiceImpl implements CompraService {

    @Inject
    CompraRepository repository;

    @Inject
    ProdutoRepository repositoryProduto;

    @Inject
    ProdutoCompraServiceImpl serviceProdutoCompra;

    @Inject
    ProdutoCompraRepository repositoryProdutoCompra;

    public CompraResponseDTO insert(CompraDTO dto) {
        Compra compra = new Compra();

        compra.setDataCompra(LocalDate.now());
        if (dto.produto() != null && !dto.produto().isEmpty()){

            compra.setProduto(new ArrayList<ProdutoCompra>());
            List<ProdutoCompra> list = new ArrayList<ProdutoCompra>();

            for (int i = dto.produto().size();i>=1;i--) {
                ProdutoCompraDTO dtoProdutoCompra = 
                new ProdutoCompraDTO(repositoryProduto.
                findById(dto.produto().get(i)), 0);
                ProdutoCompraResponseDTO compraResponseDTO = serviceProdutoCompra.insert(dtoProdutoCompra);
                list.add(repositoryProdutoCompra.findById(compraResponseDTO.id()));
            }
         
            compra.setProduto(list);
        compra.setPagamentoCompra(dto.pagamentoCompra());
    }
    return CompraResponseDTO.valueOf(compra);
    }
    @Override
    public CompraResponseDTO update(CompraDTO dto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CompraResponseDTO findbyid(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findbyid'");
    }
    
}
