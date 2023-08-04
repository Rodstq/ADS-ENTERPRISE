package interfaces.interfacesCliente;


import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;

public interface InterfaceClienteEstatic {

	public void infoCliente(Clientes cliente) throws infoClienteException;

	public void enderecoCliente(Clientes cliente)throws infoClienteException;


}
