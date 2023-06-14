package classesCliente;
import java.util.List;

import classesPrincipais.clientes;
import controladores.clienteDataBase;
import controladores.consultaProdutos;

public class clienteConsultaTratamento extends clientes {

//	posso fazer o tratamento do que é escrito na interface de forma personalizada	
	public void consultaNomeCpf(String nome, String cpf) {
		
		setNomeCliente(nome);
		setCpf(cpf);
		
		
	}

	
	//posso fazer o tratamento do retorno do db	 e relacionar com o nome e cpf do cliente
	 public  List<Object[]> retornoInfo(){
		 
	List<Object[]> resultadosCliente = clienteDataBase.consultaCliente(getNomeCliente(), getCpf());
		 
		 return resultadosCliente;

	 }
}
