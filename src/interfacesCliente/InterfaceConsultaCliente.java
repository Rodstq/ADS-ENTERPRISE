package interfacesCliente;

import java.util.List;

import data.tratamento.clients.Clientes;

public interface InterfaceConsultaCliente {

	
	public List<Object[]> infoCliente(Clientes cliente);
	
	public List<Object[]> infoClienteCpf(Clientes cliente);
}
