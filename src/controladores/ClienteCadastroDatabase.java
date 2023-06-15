package controladores;

import java.sql.Statement;
import java.time.LocalDate;

import conexaoDb.Db;

public class ClienteCadastroDatabase {

	
	public  void cadastrarInfoCliente(String cpfCliente, String nomeCliente, LocalDate dataNascimentoCliente, 
			String telefoneCliente) {

	try {
		Statement stmt = Db.Connect().createStatement();

		String inserirCliente = "INSERT INTO clientes (cpf, nome, dataNascimento, telefone) VALUES ('" + cpfCliente + "', '" +
		nomeCliente + "', '" + dataNascimentoCliente + "', '" + telefoneCliente + "')";

		stmt.execute(inserirCliente);

		
	}catch(Exception e) {
		
		
		
	}
}
	
	public  void cadastrarEnderecoCliente(String estadoCliente, String cidadeCliente, String bairroCliente, 
			String cepCliente, String ruaCliente, String descricaoRuaCliente, String cpfCliente) {
		
		try {
			Statement stmt = Db.Connect().createStatement();

			String inserirEnderecoCliente = "INSERT INTO clientesEndereco (cep, estado, cidade, bairro, rua, cpf) VALUES ('" + cepCliente + "', '" + 
			estadoCliente + "', '" + cidadeCliente + "', '" + bairroCliente + "', '" + ruaCliente + "', '" + cpfCliente + "')";

			stmt.execute(inserirEnderecoCliente);

			
			
		}catch(Exception e) {
			
			
			
		}
	}
	
}
