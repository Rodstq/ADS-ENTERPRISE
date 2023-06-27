package classesCliente;
import java.util.List;

import controladores.ClienteCadastroDatabase;
import controladores.ClienteConsultaDatabase;
import controladores.ClienteConsultaPedidosDatabase;

public class ClienteConsultaTratamento extends Clientes {

	ClienteConsultaDatabase clienteConsulta = new ClienteConsultaDatabase();
	
	private ClienteConsultaDatabase clienteDatabase;
		
    public ClienteConsultaTratamento() {
        this.clienteDatabase = new ClienteConsultaDatabase();
    }
	
	

	public  List<Object[]> retornoInfo(String nome, String cpf){
		 
		setCpf(cpf);
		setNomeCliente(nome);
		
		
		List<Object[]> resultadosCliente = clienteConsulta.consultaCliente(getNomeCliente(), getCpf());
		 
		 return resultadosCliente;

	 }
}
