package data.tratamento.clients;
import java.util.List;

import controladores.Cliente.ClienteCadastroDatabase;
import controladores.Cliente.ClienteConsultaDatabase;
import controladores.Cliente.ClienteConsultaPedidosDatabase;
<<<<<<< HEAD
import interfacesCliente.InterfaceClienteEstatic;
import interfacesCliente.InterfaceConsultaCliente;
=======
import interfacesCliente.InterfaceConsultaCliente;
import interfacesCliente.InterfaceClienteEstatic;
import data.tratamento.clients.infoClienteException;
>>>>>>> 8a6ae09405037b49a33a26b985a9cdd4ae694462

public class ClienteConsultaTratamento{
	
	 private InterfaceConsultaCliente datas;
 	 
	public ClienteConsultaTratamento(InterfaceConsultaCliente data) {
		this.datas = data;
		
	} 
	
	public ClienteConsultaTratamento() {
		
		datas = new ClienteConsultaDatabase();
	}

	
		
	public  List<Object[]> setConsultaNomeClienteEndereco(String nome) throws infoClienteException{
		 
		Clientes info = new Clientes();
		info.setNomeCliente(nome);
		
		
		List<Object[]> resultadosCliente = datas.infoCliente(info);;
			
		return  resultadosCliente;
		
	 }
	
	public  List<Object[]> setConsultaCpfClienteEndereco(String cpf) throws infoClienteException {
		
		if(cpf.length()  != 11) {
    		
    		throw new infoClienteException("o cpf precisa ter 11 digitos");
    		
    	}
		Clientes info = new Clientes();
		info.setCpf(cpf);
		
		List<Object[]> resultadosCliente = datas.infoClienteCpf(info);;
			
		return  resultadosCliente;

	 }	 

}
