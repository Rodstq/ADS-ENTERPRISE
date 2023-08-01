package data.tratamento.clients;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

import controladores.Cliente.ClienteCadastroDatabase;
import interfacesCliente.InterfaceClienteEstatic;

import data.tratamento.clients.infoClienteException;



public class ClienteCadastroTratamento{
	

    private InterfaceClienteEstatic datas;
    
    private LocalDate nascimento;
    
    public ClienteCadastroTratamento(InterfaceClienteEstatic datas){
    	
    	this.datas = datas;
    }
    
    public ClienteCadastroTratamento() {
    	
    	datas = new ClienteCadastroDatabase();
    	
    }
    
      
	    public void cadastrarClienteInfoTratamento (String cpfCliente, String nomeCliente, String dataNascimento, 
	            String telefoneCliente)  throws infoClienteException, DataFormatException, SQLException{
	    	
	    	  	    	
	    	if(cpfCliente.isBlank() && nomeCliente.isBlank() && telefoneCliente.isBlank()) {
	    		
	    		throw new infoClienteException("preencha todos os campos");
	    		
	    	}
	    	if(nomeCliente.isBlank()) {
	    		
	    		throw new infoClienteException("o nome do cliente está em branco");
	    	}

	    	
	    	if(cpfCliente.isBlank()) {
	    		
	    		throw new infoClienteException("o cpf está em branco");    
	    		
	    	} else if(cpfCliente.length() != 11  ) {
	    		
	    		throw new infoClienteException("o cpf precisa ter 11 digitos");
	    		
	    	}

	    	

	    	 if (dataNascimento.isBlank()) {
	    	        throw new infoClienteException("Data de nascimento está em branco");
	    	 }else if(dataNascimento.length() < 8) {
	    		 
	    		 throw new infoClienteException("o formato da data está errado, precisa ser ddMMyyyy");
	    	 }
	    	 
	    	 try {
	    	 nascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("ddMMyyyy"));
	    	 
	    	 }catch (DateTimeException e2) {
	    		 
	    		throw new  infoClienteException("o formato correto é ddmmyyyy, voce deve ter preenchido errado");
	    		 
	    		
	    	 } 
	    	 
	    	
	    	if(telefoneCliente.isBlank()) {
	    		
	    		throw new infoClienteException("o numero de telefone está em branco");
	    	}else if(telefoneCliente.length() != 11) {
	    		
	    		throw new infoClienteException("o telefone precisa ter 11 digitos");
	    		
	    	}
	    		 
	    	Clientes info = new Clientes();      
	        info.setClienteInfo(cpfCliente, nomeCliente, nascimento, telefoneCliente);
	        datas.infoCliente(info);
	        

	    }
	       


	public void cadastrarEnderecoCliente( String cepCliente, String estadoCliente, String cidadeCliente, String bairroCliente, 
			String ruaCliente, String descricaoRuaCliente, String cpfCliente) throws infoClienteException {
		
		
		if(cepCliente.isBlank() && estadoCliente.isBlank() && (cidadeCliente.isBlank() && bairroCliente.isBlank()) && ruaCliente.isBlank() && 
		descricaoRuaCliente.isBlank()) {
			
			throw new infoClienteException("preencha todos os campos");
		}
		
		if(estadoCliente.isBlank()) {
			throw new infoClienteException("o nome do estado está em branco");
			
		}
		
		if(cidadeCliente.isBlank()) {
			
			throw new infoClienteException("o nome da cidade está em branco");
		}
		
		if(bairroCliente.isBlank()) {
			throw new infoClienteException("o nome do bairro está em branco");
			
		}
		
		if(ruaCliente.isBlank()) {
			
			throw new infoClienteException("nome da rua está em branco");
		}
		
		if(cepCliente.isBlank()) {
			throw new infoClienteException("o cep está em branco");
		}else if(cepCliente.length() != 8) {
			
			throw new infoClienteException("O cep precisa ter 8 digitos");
		}
				
		if(descricaoRuaCliente.isBlank()) {
			
			throw new infoClienteException("a descrição do endereço está em branco");
						
		}
		

		
		Clientes info = new Clientes();				info.setEnderecoCliente(cepCliente, estadoCliente, cidadeCliente, bairroCliente, ruaCliente, descricaoRuaCliente, cpfCliente);
		datas.enderecoCliente(info);
	}
    
}
	


