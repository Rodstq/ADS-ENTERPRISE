package data.tratamento.clients;
import java.util.List;

<<<<<<< HEAD
import controladores.ClienteCadastroDatabase;
import controladores.ClienteConsultaDatabase;
import controladores.ClienteConsultaPedidosDatabase;
import controladores.InterfaceClienteEstatic;
=======
import controladores.Cliente.ClienteCadastroDatabase;
import controladores.Cliente.ClienteConsultaDatabase;
import controladores.Cliente.ClienteConsultaPedidosDatabase;
import controladores.InterfaceCadastroClient;
>>>>>>> 8aa2ae468dd063d4a288b39e6f1b36c84f618b57
import controladores.InterfaceConsultaCliente;
import controladores.infoClienteException;

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
