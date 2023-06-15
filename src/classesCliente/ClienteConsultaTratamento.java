package classesCliente;
import java.util.List;

import classesPrincipais.Clientes;
import controladores.ClienteConsultaDatabase;
import controladores.ConsultaProdutos;

public class ClienteConsultaTratamento extends Clientes {

	ClienteConsultaDatabase clienteConsulta = new ClienteConsultaDatabase();
		
//	posso fazer o tratamento do que é escrito na interface de forma personalizada	
	public void consultaNomeCpf(String nome, String cpf) {
		
		setNomeCliente(nome);
		setCpf(cpf);
		
		
	}

	
	//posso fazer o tratamento do retorno do db	 e relacionar com o nome e cpf do cliente
	 public  List<Object[]> retornoInfo(){
		 
	List<Object[]> resultadosCliente = clienteConsulta.consultaCliente(getNomeCliente(), getCpf());
		 
		 return resultadosCliente;

	 }
}
