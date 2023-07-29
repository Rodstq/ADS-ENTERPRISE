package data.tratamento.clients;

import java.time.LocalDate;

import controladores.Cliente.ClienteCadastroDatabase;
import controladores.Cliente.ClienteConsultaDatabase;
import controladores.Cliente.ClienteDeleteDatabase;

import interfacesCliente.InterfaceClienteEstatic;
import interfacesCliente.interfaceClientePedido;



import data.tratamento.clients.infoClienteException;

public class ClienteDeleteTratamento extends Clientes{


	
	   private interfaceClientePedido datas;
	   private boolean flag =false;
	    	    
	    public ClienteDeleteTratamento(interfaceClientePedido datas){
	    	
	    	this.datas = datas;
	    }
	    
	    public ClienteDeleteTratamento() {
	    	
	    	datas = new ClienteDeleteDatabase();
	    	
	    }
		
	public void deleteClientePedido(String cpfCliente) throws infoClienteException {
			
			if(!cpfCliente.isBlank()) {		
				flag = true;		
			}
			
			if(cpfCliente.length() != 11  && flag ==true) {
	    		
	    		throw new infoClienteException("o cpf precisa ter 11 digitos");
	    		
	    	}

			Clientes info = new Clientes(); 
			info.setCpf(cpfCliente);
			datas.deletarClientePedido(info);
			
		}
	   
	public void deleteClienteCadastro(String cpfCliente) throws infoClienteException {
		
		if(cpfCliente.length() != 11  && flag !=true) {
    		
    		throw new infoClienteException("o cpf precisa ter 11 digitos");
    		
    	}

		
		Clientes info = new Clientes(); 
		info.setCpf(cpfCliente);
		datas.deletarClienteCadastro(info);
		
	}
	

	
	
	
}
