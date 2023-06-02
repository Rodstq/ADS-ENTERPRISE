package org.example.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class ClientesEntity{

@Id
private int cpf;

@Column(name = "nome")
private String nome;

@Column(name = "telefone")
private int telefone;


//metodos
public void setCpf(int cpf){
    this.cpf = cpf;
}

public int getCpf(){
    return cpf;
}

public void setNomeCliente(String nome){
    this.nome = nome;
}

public String getNomeCliente(){
    return nome;
}

public void setTelefoneCliente(int telefone){
    this.telefone = telefone;
}

public int getTelefoneCliente(){
    return telefone;

}

//metodo para adicionar cliente
public ClientesEntity(int cpfCliente, String nomeCliente, int telefoneCliente ){
this.cpf =cpfCliente;
this.nome = nomeCliente;
this.telefone = telefoneCliente;

}

public ClientesEntity(){
    
}

}