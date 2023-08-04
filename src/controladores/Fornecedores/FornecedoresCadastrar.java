package controladores.Fornecedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoDb.Db;
import data.tratamento.produtos.CadastrarTratamento;
import models.classesFornecedores.Fornecedor;

public class FornecedoresCadastrar extends Fornecedor{

	private String erro;

	public void cadastrarFornecedor(Fornecedor fornecedor) throws Exception {

		try(Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO fornecedor (cnpj_fornecedor,nome_fornecedor) values (?,?);")){

			stmt.setString(1, fornecedor.getCnpj());
			stmt.setString(2, fornecedor.getNome());

			if(fornecedor.getCnpj().length() < 14) {
				throw new SQLException("Cnpj menor que 14");
			}

			stmt.executeUpdate();

		}catch(SQLException e){
			CadastrarTratamento verificar = new CadastrarTratamento();
			String erro = e.getMessage();
			verificar.verificaErro(erro);
			this.erro = verificar.verificaErro(erro);
			throw new SQLException();
		}
	}

	public String getErroMessage() {
		return this.erro;
	}

}
