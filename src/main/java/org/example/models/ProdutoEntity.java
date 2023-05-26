package org.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private double preco;

    public ProdutoEntity(){ }

    public int getId() {
        return id;
    }

    public ProdutoEntity(int id, String name, double preco) {
        this.id = id;
        this.name = name;
        this.preco = preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
