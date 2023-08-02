package controladores.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaoDb.Db;

public class ProdutosAtualizar {
	
	private String erro;
	private String query;
	
	
	public void atualizarProdutos() throws Exception{
		try {
			Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public String validarQuery(String nome, String valor,String quantidade,String cnpj) {
		
		if (!nome.isBlank()){
			
		}
		return query;
	}
	
}
