package br.unitins.hello.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class DataCompra extends DefaultEntity {

    @Column
    private Date dataCompra;

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

}
