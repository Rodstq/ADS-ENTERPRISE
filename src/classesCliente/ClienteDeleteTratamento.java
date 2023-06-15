package classesCliente;

import controladores.ClienteConsultaDatabase;
import controladores.ClienteDeleteDatabase;
import classesPrincipais.Clientes;
public class ClienteDeleteTratamento extends Clientes{

	
	ClienteDeleteDatabase deleteCliente = new ClienteDeleteDatabase();
	
	public void deleteCliente(String cpfCliente, String nomeCliente) {
		setCpf(cpfCliente);
		setNomeCliente(nomeCliente);
		
		
		
		deleteCliente.deletarCliente(getCpf(), getNomeCliente());
		
	}
	
	
	
	
	
}
