package classesCliente;
import java.util.List;

import controladores.ClienteCadastroDatabase;
import controladores.ClienteConsultaDatabase;
import controladores.ClienteConsultaPedidosDatabase;

public class ClienteConsultaTratamento extends Clientes {

	ClienteConsultaDatabase clienteConsulta = new ClienteConsultaDatabase();
		
	public  List<Object[]> setConsultaNomeClienteEndereco(String nome){
		 
		setNomeCliente(nome);
		
	
		List<Object[]> resultadosCliente = clienteConsulta.consultaNomeClienteEndereco(getNomeCliente());
			
		return  resultadosCliente;
		
	 }
	
	public  List<Object[]> setConsultaCpfClienteEndereco(String cpf){
		 
		setCpf(cpf);

			
		List<Object[]> resultadosCliente = clienteConsulta.consultaCpfClienteEndereco(getCpf());
	
		 return resultadosCliente;

	 }	 
	
	
	
//public  List<Object[]> getConsultaNomeCliente(){
//	 
//
//
//	List<Object[]> resultadosCliente = clienteConsulta.consultaNomeOnlyCliente(getNomeCliente());
//		
//	return  resultadosCliente;
//	
// }

}
