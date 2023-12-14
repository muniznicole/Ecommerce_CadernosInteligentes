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
import br.unitins.hello.repository.PagamentoRepository;
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

    @Inject
    PagamentoRepository repositoryPagamento;
   
    @Inject
    PagamentoServiceImpl servicePagamento;

    public CompraResponseDTO insert(CompraDTO dto) {
        Compra compra = new Compra();
        compra.setDataCompra(LocalDate.now());

        List<ProdutoCompra> listProdutoCompra = new ArrayList<>();
        for(int i = 0;i<dto.produto().size();i++){
            
            listProdutoCompra.add( serviceProdutoCompra.insert( dto.produto().get(i)));  
            
        }
        compra.setProduto(listProdutoCompra);        
        compra.setPagamentoCompra(servicePagamento.insert( dto.pagamentoCompra()));
        repository.persist(compra);
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
