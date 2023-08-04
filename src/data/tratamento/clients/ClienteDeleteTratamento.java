package data.tratamento.clients;

import controladores.Cliente.ClienteDeleteDatabase;
import interfaces.interfacesCliente.interfaceClientePedido;

public class ClienteDeleteTratamento extends Clientes{


	   private interfaceClientePedido datas;

	   private boolean flag =false;
	   private boolean deleteUnico = false;
	   private boolean deleteAll = false;
	   private boolean deleteCadastro = false;
	   private boolean deleteId =false;

	   public void flagDeleteUnico(boolean decisao) {
		   this.deleteUnico =decisao;

	   }

	   public void flagDeleteAllPedidos(boolean decisao) {

		   this.deleteAll = decisao;
	   }


	   public void flagDeleteCadastro(boolean decisao) {

		   this.deleteCadastro = true;
	   }


	   public void flagDeleteId(boolean decisao) {

		   this.deleteId = decisao;

	   }

	    public ClienteDeleteTratamento(interfaceClientePedido datas){

	    	this.datas = datas;
	    }

	    public ClienteDeleteTratamento() {

	    	datas = new ClienteDeleteDatabase();

	    }


	public boolean verificarCpf(String cpfCliente)throws infoClienteException {

		if(cpfCliente.length() != 11  && deleteAll) {

    		throw new infoClienteException("o cpf precisa ter 11 digitos");


    	}
    		Clientes info = new Clientes();
			info.setCpf(cpfCliente);
			datas.verificarCpfDb(info);

		boolean	resultado = datas.verificarCpfDb(info);

		return resultado;

	}

	public boolean verificarPedido(int valor)throws infoClienteException {

			datas.verificarPedido(valor);

		boolean	resultado = datas.verificarPedido(valor);

		return resultado;

	}


	public void deleteAllPedidos(String cpfCliente) throws infoClienteException {

			if(cpfCliente.isBlank()) {

				throw new infoClienteException("o cpf está em branco");

			}	else if(cpfCliente.length() != 11  ) {

	    		throw new infoClienteException("o cpf precisa ter 11 digitos");


	    	}

	    		Clientes info = new Clientes();
				info.setCpf(cpfCliente);
				datas.deletarClientePedido(info);

		}


	public void deleteClienteCadastro(String cpfCliente) throws infoClienteException {



		if (cpfCliente.isBlank()) {

			throw new infoClienteException("o cpf está em branco");
		}else if(cpfCliente.length() != 11) {

	    		throw new infoClienteException("o cpf precisa ter 11 digitos");

	    }

    		Clientes info = new Clientes();
    		info.setCpf(cpfCliente);
    		datas.deletarClienteCadastro(info);


	}



	public void deleteUnicoPedido(String cpfCliente, int idPedido) throws infoClienteException {

		if(cpfCliente.isBlank()) {

    		throw new infoClienteException("o cpf está em branco");

    	} else if(cpfCliente.length() != 11) {

    		throw new infoClienteException("o cpf precisa ter 11 digitos");

    	}

		if(idPedido > 9999 || idPedido <=0) {

			throw new infoClienteException("o Id só pode ter no maximo 4 digitos e conter numeros");
		}



		Clientes info = new Clientes();
		info.setCpf(cpfCliente);
		datas.deletarUnicoPedido(info, idPedido);

	}


}
