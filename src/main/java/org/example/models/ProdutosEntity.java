package org.example.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "produtos", schema = "public", catalog = "AdsEnterpriseDB")
@SequenceGenerator(name = "produtosSeq", sequenceName = "produtos_seq", allocationSize = 1)
public class ProdutosEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtosSeq")
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "Nome")
    private String nome;
    @Basic
    @Column(name = "Preco")
    private double preco;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutosEntity that = (ProdutosEntity) o;
        return id == that.id && Double.compare(that.preco, preco) == 0 && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }
}
