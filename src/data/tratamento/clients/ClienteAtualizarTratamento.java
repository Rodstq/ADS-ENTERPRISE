package data.tratamento.clients;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

import controladores.Cliente.ClienteAtualizarDatabase;
import controladores.Cliente.ClienteConsultaDatabase;
import interfaces.interfacesCliente.InterfaceClienteUpdates;

public class ClienteAtualizarTratamento {

	ClienteConsultaDatabase clienteConsulta = new ClienteConsultaDatabase();


    private ClienteAtualizarDatabase clienteDatabase;
    private LocalDate nascimento;

    private boolean allEmpty = false;
    private boolean flagNome= false;
    private boolean flagNascimento = false;
    private boolean flagTelefoneCliente = false;
    private boolean flagCepCliente = false;
    private boolean flagEstadoCliente =false;
    private boolean flagCidadeCliente =false;
    private boolean flagBairroCliente = false;
    private boolean flagRuaCliente =false;
    private boolean flagDescricao = false;

    public void nomeFlag(Boolean decisao) {
    	this.flagNome = decisao;
    }

    public void nascimentoFlag(Boolean decisao) {
    	this.flagNascimento = decisao;
    }

    public void telefonFlag(Boolean decisao) {
    	this.flagTelefoneCliente = decisao;
    }

    public void cepFlag(Boolean decisao) {
    	this.flagCepCliente = decisao;
    }

    public void estadoFlag(Boolean decisao) {
    	this.flagEstadoCliente = decisao;
    }

    public void cidadFlag(Boolean decisao) {
    	this.flagCidadeCliente = decisao;
    }

    public void bairrFlag(Boolean decisao) {
    	this.flagBairroCliente = decisao;
    }

    public void ruaFlag(Boolean decisao) {
    	this.flagRuaCliente = decisao;
    }

    public void descricaFlag(Boolean decisao) {
    	this.flagDescricao = decisao;
    }



    private InterfaceClienteUpdates datas;

    public ClienteAtualizarTratamento (InterfaceClienteUpdates cliente) {

    	this.datas = cliente;

    }

    public ClienteAtualizarTratamento() {
    	datas = new ClienteAtualizarDatabase();
    }


	public boolean verificarCpf(String cpfCliente)throws infoClienteException {

		if(cpfCliente.length() != 11) {

    		throw new infoClienteException("o cpf precisa ter 11 digitos");


    	}
    		Clientes info = new Clientes();
			info.setCpf(cpfCliente);
			datas.verificarCpfDb(info);

		boolean	resultado = datas.verificarCpfDb(info);

		return resultado;

	}



	public void clienteAtualizarCadastroCliente(String dataNascimento, String cpf, String nomeCliente, String telefoneCliente) throws infoClienteException, DataFormatException {


    		if(cpf.isBlank()) {

    		throw new infoClienteException("o cpf está em branco");

    		} else if(cpf.length() != 11  ) {

    		throw new infoClienteException("o cpf precisa ter 11 digitos");

    		}

   	 		if (flagNascimento && dataNascimento.isBlank()) {
	        throw new infoClienteException("Data de nascimento está em branco");
   	 		}else if(flagNascimento && dataNascimento.length() < 8) {

   	 			throw new infoClienteException("o formato da data está errado, precisa ser ddMMyyyy");
	 		}else if(flagNascimento) {

   	 		try {
   	 			nascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("ddMMyyyy"));

   	 			}catch (DateTimeException e1) {

   	 				throw new  infoClienteException("o formato correto é ddmmyyyy, voce deve ter preenchido errado");

   	 			}

	 		}


    	if(flagNome && nomeCliente.isEmpty()) {

    		throw new infoClienteException("o nome do cliente está em branco");
    	}

    	if(flagTelefoneCliente && telefoneCliente.isBlank()) {

    		throw new infoClienteException("o numero de telefone está em branco");
    	}else if(flagTelefoneCliente && telefoneCliente.length() != 11) {

    		throw new infoClienteException("o telefone precisa ter 11 digitos");

    	}

		if(nomeCliente.isBlank() && telefoneCliente.isBlank() && dataNascimento.isBlank()) {

		allEmpty = true;

		}

    	  Clientes info = new Clientes();
    	  info.setClienteInfo(cpf, nomeCliente, nascimento, telefoneCliente);
	       datas.infoCliente(info);



	}

	public void clienteAtualizarEnderecoCliente (String cpf, String cepCliente, String estadoCliente, String cidadeCliente, String bairroCliente,
			String ruaCliente, String descricaoRuaCliente) throws infoClienteException {


//    	if(cpf.isBlank()) {
//
//    		throw new infoClienteException("o cpf está em branco");
//
//    	} else if(cpf.length() != 11  ) {
//
//    		throw new infoClienteException("o cpf precisa ter 11 digitos");
//
//    	}

		if(flagEstadoCliente &&  estadoCliente.isBlank()) {
			throw new infoClienteException("o nome do estado está em branco");

		}

		if(flagCidadeCliente  && cidadeCliente.isBlank()) {

			throw new infoClienteException("o nome da cidade está em branco");
		}

		if(flagBairroCliente && bairroCliente.isBlank()) {
			throw new infoClienteException("o nome do bairro está em branco");

		}

		if(flagRuaCliente &&  ruaCliente.isBlank()) {

			throw new infoClienteException("nome da rua está em branco");
		}

		if(flagCepCliente &&  cepCliente.isBlank()) {
			throw new infoClienteException("o cep está em branco");
		}else if(flagCepCliente && cepCliente.length() != 8) {

			throw new infoClienteException("O cep precisa ter 8 digitos");
		}

		if(flagDescricao &&  descricaoRuaCliente.isBlank()) {

			throw new infoClienteException("a descrição do endereço está em branco");

		}

		if(estadoCliente.isBlank() && (cidadeCliente.isBlank() && bairroCliente.isBlank()) && ruaCliente.isBlank() &&
		descricaoRuaCliente.isBlank() && allEmpty) {

			throw new infoClienteException("você não preencheu nenhum campo");

		}


		Clientes info = new Clientes();
		info.setEnderecoCliente(cepCliente, estadoCliente, cidadeCliente, bairroCliente, ruaCliente, descricaoRuaCliente, cpf);
		datas.enderecoCliente(info);
	}


	}




