package controladores.Fornecedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classesFornecedores.Fornecedor;
import conexaoDb.Db;

public class FornecedoresCadastrar extends Fornecedor{
	
	public void cadastrarFornecedor(Fornecedor fornecedor) {
		
		try(Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO fornecedor (cnpj_fornecedor,nome_fornecedor) values (?,?);")){
			
			stmt.setString(1, fornecedor.getCnpj());
			stmt.setString(2, fornecedor.getNome());
			
			stmt.executeUpdate();
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
