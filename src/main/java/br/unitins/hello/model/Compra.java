package br.unitins.hello.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.unitins.hello.dto.ProdutoCompraResponseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Compra extends DefaultEntity {
    
    @Column
    private LocalDate dataCompra;

    @OneToMany
    @JoinColumn(name = "id_ProdutoCompra")
    private List<ProdutoCompra> produto;

    @ManyToOne
    @JoinColumn(name = "id_PagamentoCompra")
    private Pagamento pagamentoCompra;

    @ManyToOne
    @JoinColumn(name = "id_enderecoentrega")
    private Endereco enderco;

    @ManyToOne
    @JoinColumn(name ="id_comprador")
    private Usuario user;

    public Endereco getEnderco() {
        return enderco;
    }

    public void setEnderco(Endereco enderco) {
        this.enderco = enderco;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Pagamento getPagamentoCompra() {
        return pagamentoCompra;
    }

    public void setPagamentoCompra(Pagamento pagamentoCompra) {
        this.pagamentoCompra = pagamentoCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<ProdutoCompra> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoCompra> produto) {
        this.produto = produto;
    }

    public Collection<ProdutoCompraResponseDTO> getProdutos() {
        return null;
    }

    

    
}
