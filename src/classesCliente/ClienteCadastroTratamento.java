package classesCliente;
import java.time.LocalDate;

import controladores.ClienteCadastroDatabase;


public class ClienteCadastroTratamento extends Clientes {
	
	
    private ClienteCadastroDatabase clienteDatabase;

    public ClienteCadastroTratamento() {
        this.clienteDatabase = new ClienteCadastroDatabase();
    }
    
	    public void cadastrarClienteInfoTratamento(String cpfCliente, String nomeCliente, LocalDate dataNascimento, 
	            String telefoneCliente) {

	     
	        setCpf(cpfCliente);
	        setNomeCliente(nomeCliente);
	        setDataNascimentoCliente(dataNascimento);
	        setTelefoneCliente(telefoneCliente);
	        clienteDatabase.setCadastrarInfoCliente(this);
	    }
	    
	   
	public void cadastrarEnderecoCliente( String cepCliente, String estadoCliente, String cidadeCliente, String bairroCliente, 
			String ruaCliente, String descricaoRuaCliente, String cpfCliente) {
		
		setCepCliente(cepCliente);
		setEstadoCliente(estadoCliente);
		setCidadeCliente(cidadeCliente);
		setBairroCliente(bairroCliente);	
		setRuaCliente(descricaoRuaCliente);
		setDescricaoRuaCliente(descricaoRuaCliente);
		setCpf(cpfCliente);
				        clienteDatabase.cadastrarEnderecoCliente(this);
	}
    
}
	


