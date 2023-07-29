package data.tratamento.clients;

import java.time.LocalDate;

import controladores.Cliente.ClienteCadastroDatabase;
import controladores.Cliente.ClienteConsultaDatabase;
import controladores.Cliente.ClienteDeleteDatabase;
<<<<<<< HEAD
import interfacesCliente.InterfaceClienteEstatic;
import interfacesCliente.interfaceClientePedido;
public class ClienteDeleteTratamento{
=======
import data.tratamento.clients.infoClienteException;

public class ClienteDeleteTratamento extends Clientes{
>>>>>>> 8a6ae09405037b49a33a26b985a9cdd4ae694462

	
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
