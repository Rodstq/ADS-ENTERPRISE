package org.maptabels.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class ClientesEntity{

@Id
private String cpfCliente;

@Column(name = "nomeCliente")
private String nomeCliente;

@Column(name = "dataNascimentoCliente")
private String dataNascimentoCliente;

@Column(name = "telefoneCliente")
private String  telefoneCliente;

@Column(name = "estadoCliente")
private String estadoCliente;

@Column(name = "cidadeCliente")
private String cidadeCliente;

@Column(name = "bairroCliente")
private String bairroCliente;

@Column(name = "cepCliente")
private String cepCliente;

@Column(name = "ruaCliente")
private String ruaCliente;

@Column(name = "descricacaoRuaCliente")
private String descricaoRuaCliente;


//metodos
public void setCpf(String cpfCliente){
    this.cpfCliente = cpfCliente;
}

public String getCpf(){
    return cpfCliente;
}

public void setNomeCliente(String nomeCliente){
    this.nomeCliente = nomeCliente;
}

public String getNomeCliente(){
    return nomeCliente;
}


public void setDataNascimentoCliente(String dataNascimentoCliente) {
	
	this.dataNascimentoCliente = dataNascimentoCliente;
}

public String getDataNascimentoCliente() {
		
	return this.dataNascimentoCliente;
}

public void setTelefoneCliente(String telefone){
    this.telefoneCliente = telefone;
}

public String getTelefoneCliente(){
    return telefoneCliente;

}


public void setEstadoCliente(String estadoCliente) {
	
	this.estadoCliente = estadoCliente;
}


public String getEstadoCliente(String estadoCliente) {
	return this.estadoCliente;
}

public void setCidadeCliente(String cidadeCliente) {
	this.cidadeCliente = cidadeCliente;
	
}

public String getCidadeCliente() {
	return this.cidadeCliente;
}


public void setBairroCliente(String bairroCliente) {
	this.bairroCliente = bairroCliente;
}


public String getBairroCliente() {
	return this.bairroCliente;
}
public void setCepCliente(String cepCliente) {
	this.cepCliente = cepCliente;
}


public String getCepCliente() {
	return cepCliente;
}

public void setRuaCliente(String ruaCliente) {
	this.ruaCliente = ruaCliente;
}

public String getRuaCliente() {
	return this.ruaCliente;
}

public void setDescricaoRuaCliente(String descricaoRuaCliente) {
	this.descricaoRuaCliente = descricaoRuaCliente;
	
}

public String getDescricacaoRuaCliente() {
	return this.descricaoRuaCliente;
}

//metodos para adicionar cliente
public ClientesEntity(String nomeCliente, String cpfCliente, String dataNascimentoCLiente, String telefoneCliente, String estadoCliente,
		String cidadeCliente, String bairroCliente, String cepCliente, String ruaCliente, String descricaoRuaCliente) {
	
this.nomeCliente = nomeCliente;
this.cpfCliente = cpfCliente;
this.dataNascimentoCliente = dataNascimentoCLiente;
this.telefoneCliente = telefoneCliente;
this.estadoCliente = estadoCliente;
this.cidadeCliente = cidadeCliente;
this.bairroCliente = bairroCliente;
this.ruaCliente = ruaCliente;
this.descricaoRuaCliente = descricaoRuaCliente;

	
}
public ClientesEntity() {
	
}


}