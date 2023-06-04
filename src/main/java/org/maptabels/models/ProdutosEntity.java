package org.maptabels.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produtos")
public class ProdutosEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtosSeq")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "preco")
    private BigDecimal preco;
    @Basic
    @Column(name = "quantidade")
    private int quantidade;

    public ProdutosEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutosEntity(String nome, BigDecimal preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutosEntity that = (ProdutosEntity) o;
        return id == that.id && quantidade == that.quantidade && Objects.equals(nome, that.nome) && Objects.equals(preco, that.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, quantidade);
    }
}
