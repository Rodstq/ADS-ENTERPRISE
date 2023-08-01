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
	   
	   
	   private boolean deleteUnico = false;
	   private boolean deleteAll = false;
	   private boolean deleteCadastro = false;
	   private boolean deleteId =false;
	   
	   public void flagDeleteUnico(boolean decisao) {
		   this.deleteUnico =true;
		   
	   }
	   
	   public void flagDeleteAllPedidos(boolean decisao) {
		   
		   this.deleteAll = true;
	   }
	   
	   
	   public void flagDeleteCadastro(boolean decisao) {

		   this.deleteCadastro = true;
	   }
	    

	   public void flagDeleteId(boolean decisao) {
		   
		   this.deleteId = true;
		   
	   }
	   
	    public ClienteDeleteTratamento(interfaceClientePedido datas){
	    	
	    	this.datas = datas;
	    }
	    
	    public ClienteDeleteTratamento() {
	    	
	    	datas = new ClienteDeleteDatabase();
	    	
	    }
		
	    
	public void deleteAllPedidos(String cpfCliente) throws infoClienteException {
			
			
			if(cpfCliente.length() != 11  && deleteAll ==true) {
	    		
	    		throw new infoClienteException("o cpf precisa ter 11 digitos");
	    		
	    		
	    	}
			
	    		Clientes info = new Clientes(); 
				info.setCpf(cpfCliente);
				datas.deletarClientePedido(info);
	    	

		
			
		}
	   
	
	public void deleteClienteCadastro(String cpfCliente) throws infoClienteException {
		
		
		
		
		if(cpfCliente.length() != 11  && deleteCadastro ==true) {
    		
    		throw new infoClienteException("o cpf precisa ter 11 digitos");
    		
    	}
		
		if(cpfCliente.isBlank() && deleteCadastro==true) {
			
			throw new infoClienteException("o cpf está em branco");
		}

    		Clientes info = new Clientes(); 
    		info.setCpf(cpfCliente);
    		datas.deletarClienteCadastro(info);
    	
				
	}
	
	
	
	public void deleteUnicoPedido(String cpfCliente, int IdPedido) throws infoClienteException {

		if(cpfCliente.length() != 11  && deleteCadastro ==true) {
    		
    		throw new infoClienteException("o cpf precisa ter 11 digitos");
    		
    	}
		
		if(IdPedido > 9999  && deleteId ==true) {
			
			throw new infoClienteException("o Id só pode ter no maximo 4 digitos e conter numeros");
		}
    		
		
		
		Clientes info = new Clientes();
		info.setCpf(cpfCliente);
		datas.deletarUnicoPedido(info, IdPedido);		
    	
	}

}
