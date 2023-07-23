package data.tratamento.clients;

import java.time.LocalDate;

import controladores.Cliente.ClienteAtualizarDatabase;
import controladores.Cliente.ClienteConsultaDatabase;
import controladores.infoClienteException;

public class ClienteAtualizarTratamento extends Clientes{

	ClienteConsultaDatabase clienteConsulta = new ClienteConsultaDatabase();

	
    private ClienteAtualizarDatabase clienteDatabase;

    public ClienteAtualizarTratamento() {
    	
        this.clienteDatabase = new ClienteAtualizarDatabase();
    }
    
	public void clienteAtualizarCadastroCliente(LocalDate dataNascimento, String Cpf, String NomeCliente, String TelefoneCliente) throws infoClienteException {
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
    
    
    
