package classesCliente;
import java.time.LocalDate;

import classesPrincipais.Clientes;
import controladores.ClienteCadastroDatabase;


public class ClienteCadastroTratamento extends Clientes {
	
	
	ClienteCadastroDatabase cliente = new ClienteCadastroDatabase();
	
	public void cadastrarClienteInfo(String cpfCliente, String nomeCliente, LocalDate dataNascimento, 
			String telefoneCliente) {
		
		setNomeCliente(nomeCliente);
		setCpf(cpfCliente);
		setDataNascimentoCliente(dataNascimento);
		setTelefoneCliente(telefoneCliente);
		
				cliente.cadastrarInfoCliente(getCpf(), getNomeCliente(), getDataNascimentoCliente(), getTelefoneCliente());
		
	}
	
	public void cadastrarEnderecoCliente( String cepCliente, String estadoCliente, String cidadeCliente, String bairroCliente, 
			String ruaCliente, String descricaoRuaCliente, String cpfCliente) {
		
		setEstadoCliente(estadoCliente);
		setCidadeCliente(cidadeCliente);
		setBairroCliente(bairroCliente);
		setCepCliente(cepCliente);
		setRuaCliente(descricaoRuaCliente);
		setDescricaoRuaCliente(descricaoRuaCliente);
		setCpf(cpfCliente);
						cliente.cadastrarEnderecoCliente(getCepCliente(), getEstadoCliente(),getCidadeCliente(), getBairroCliente(),
			    getRuaCliente(), getDescricaoRuaCliente(), getCpf());
	   		    	
	}
    
}
	


