package controladores;

import classesCliente.ClienteCadastroTratamento;
import data.tratamento.clients.Clientes;

public interface InterfaceCadastroClient {

	public void infoCliente(Clientes cliente);
	
	public void enderecoCliente(Clientes cliente);

    void setCadastrarInfoCliente(ClienteCadastroTratamento clienteCadastroTratamento);

	void cadastrarEnderecoCliente(ClienteCadastroTratamento clienteCadastroTratamento);
}
