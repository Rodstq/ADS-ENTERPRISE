package interfacesCliente;

import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;

public interface interfaceClientePedido {

	public void deletarClienteCadastro(Clientes clienteDeleteCadastro)throws infoClienteException;
	
	public void deletarClientePedido(Clientes clienteDeletePedido)throws infoClienteException;
	
	public void deletarUnicoPedido(Clientes clienteDeletePedido, int idPedido)throws infoClienteException;
	
	
}
