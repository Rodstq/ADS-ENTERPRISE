package classesCliente;

import controladores.ClienteConsultaDatabase;
import controladores.ClienteDeleteDatabase;
import classesPrincipais.Clientes;
public class ClienteDeleteTratamento extends Clientes{

	
	ClienteDeleteDatabase deleteCliente = new ClienteDeleteDatabase();
	
	public void deleteClienteCadastro(String cpfCliente) {
		setCpf(cpfCliente);
			
		deleteCliente.deletarClienteCadastro(getCpf());
		
	}
	
	
	public void deleteClientePedido(String cpfCliente) {
		setCpf(cpfCliente);
			
		deleteCliente.deletarClientePedido(getCpf());
		
	}
	
	
	
}
