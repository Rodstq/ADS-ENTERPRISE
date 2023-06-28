package classesCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controladores.ClienteAtualizarDatabase;
import controladores.ClienteCadastroDatabase;
import controladores.ClienteConsultaDatabase;

public class ClienteAtualizarTratamento  extends Clientes{

	ClienteConsultaDatabase clienteConsulta = new ClienteConsultaDatabase();

	
    private ClienteAtualizarDatabase clienteDatabase;

    public ClienteAtualizarTratamento() {
    	
        this.clienteDatabase = new ClienteAtualizarDatabase();
    }
    
	public void clienteAtualizarCadastroCliente(LocalDate dataNascimento, String Cpf, String NomeCliente, String TelefoneCliente) {
		setDataNascimentoCliente(dataNascimento);
		setCpf(Cpf);
		setNomeCliente(NomeCliente);
		setTelefoneCliente(TelefoneCliente);
		clienteDatabase.setAtualizarDadosCliente(this);
		
	}
    
	public void clienteAtualizarEnderecoCliente(String cepCliente, String estadoCliente, String cidadeCliente, String bairroCliente,
			String ruaCliente, String descricaoRuaCliente) {
			setCepCliente(cepCliente);
			setEstadoCliente(estadoCliente);
			setCidadeCliente(cidadeCliente);
			setBairroCliente(bairroCliente);
			setRuaCliente(ruaCliente);
			setDescricaoRuaCliente(descricaoRuaCliente);
			clienteDatabase.atualizarEnderecoCliente(this);
	}

	
	}
    
    
    

