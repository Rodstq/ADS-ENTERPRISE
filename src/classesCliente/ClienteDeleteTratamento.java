package classesCliente;

import controladores.Cliente.ClienteDeleteDatabase;
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
