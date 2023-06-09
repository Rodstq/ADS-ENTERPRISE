package classesCliente;
import java.util.List;

import classesPrincipais.*;
import controladores.consultaCliente;
import controladores.consultaProdutos;

public class clienteConsultaTratamento extends clientes {

	
	private String nomeClienteDigitado;
	private String cpfClienteDigitado;
	
	
	
	
	public  void clienteInfo(String nome, String cpf) {
		
		
	//posso fazer o tratamento do que recebe para depois setar
		this.nomeClienteDigitado = nome;
		this.cpfClienteDigitado = cpf;		
		
	}
	
	
	 
	//posso fazer o tratamento do retorno do db	 
	 public  List<Object[]> retornoInfo(){
		 
	List<Object[]> resultadosCliente = consultaProdutos.consultaProdutos(nomeClienteDigitado, cpfClienteDigitado);
		 
		 return resultadosCliente;
		 
	 }
}
