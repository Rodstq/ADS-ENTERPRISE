package data.tratamento.clients;

import controladores.ClienteCadastroDatabase;
import controladores.ClienteConsultaDatabase;
import controladores.ClienteDeleteDatabase;
import controladores.infoClienteException;
public class ClienteDeleteTratamento extends Clientes{

	
    private ClienteDeleteDatabase clienteDatabase;

    public ClienteDeleteTratamento() {
        this.clienteDatabase = new ClienteDeleteDatabase();
    }
    
	public void deleteClienteCadastro(String cpfCliente) {
		setCpf(cpfCliente);
			
		clienteDatabase.deletarClienteCadastro(this);
		
	}
	
	
	public void deleteClientePedido(String cpfCliente) {
		setCpf(cpfCliente);
			
		clienteDatabase.deletarClientePedido(this);
		
	}
	
	
	
}
