package data.tratamento.clients;
import java.time.LocalDate;

import controladores.ClienteCadastroDatabase;
import controladores.InterfaceCadastroClient;


public class ClienteCadastroTratamento{
	
	
//    private ClienteCadastroDatabase clienteDatabase;
    
    private InterfaceCadastroClient teste;
    
    public ClienteCadastroTratamento(InterfaceCadastroClient teste) {
    	
    	this.teste = teste;
    }
    
    public ClienteCadastroTratamento() {
    	
    	teste = new ClienteCadastroDatabase();
    	
    }
      
	    public void cadastrarClienteInfoTratamento(String cpfCliente, String nomeCliente, LocalDate dataNascimento, 
	            String telefoneCliente) {


	        Clientes info = new Clientes();
	        info.setCadastrarClienteInfo(cpfCliente, nomeCliente, dataNascimento, telefoneCliente);
	        teste.infoCliente(info);
	        
	    }
	       
	public void cadastrarEnderecoCliente( String cepCliente, String estadoCliente, String cidadeCliente, String bairroCliente, 
			String ruaCliente, String descricaoRuaCliente, String cpfCliente) {
		
		Clientes info = new Clientes();
		
						info.setCadastrarEnderecoCliente(cepCliente, estadoCliente, cidadeCliente, bairroCliente, ruaCliente, descricaoRuaCliente, cpfCliente);
		teste.enderecoCliente(info);
	}
    
}
	


