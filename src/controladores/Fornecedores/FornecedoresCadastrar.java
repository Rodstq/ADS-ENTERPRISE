package controladores.Fornecedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classesFornecedores.Fornecedor;
import conexaoDb.Db;
import data.tratamento.produtos.CadastrarTratamento;

public class FornecedoresCadastrar extends Fornecedor{
	
	private String erro;
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws Exception {
		
		try(Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO fornecedor (cnpj_fornecedor,nome_fornecedor) values (?,?);")){
			
			stmt.setString(1, fornecedor.getCnpj());
			stmt.setString(2, fornecedor.getNome());
			
			stmt.executeUpdate();
			
		}catch(SQLException e){
			CadastrarTratamento verificar = new CadastrarTratamento();
			e.printStackTrace();
			e.printStackTrace();
			String erro = e.getMessage();
			System.out.println(" ============" + erro);
			verificar.verificaErro(erro);
			this.erro = verificar.verificaErro(erro);
			throw new SQLException();	
//			verificar.lancarException(verificar, e.getMessage());
		}
	}
	
	public String getErroMessage() {
		return this.erro;
	}

}
 	