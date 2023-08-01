package interfacesCliente;

import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;

	public interface InterfaceClienteUpdates {
		
		
	public void infoCliente(Clientes cliente) throws infoClienteException;
	
	public void enderecoCliente(Clientes cliente) throws infoClienteException;
		
	public boolean verificarCpfDb(Clientes verificarCpf) throws infoClienteException;


}
