package controladores.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexaoDb.Db;

public class ProdutosAtualizar {
	
	private String query;
	
	
	public void atualizarProdutos(String query) throws Exception{
		
		try {
			Connection connection = Db.Connect();
			
			PreparedStatement stmt1 = connection.prepareStatement(query);
			stmt1.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void execQuery(boolean nomeBoolean,boolean cnpjBoolean,boolean valorBoolean,boolean quantidadeBoolean,
		
		String id,String nome,String cnpj,String valor,String quantidade) throws Exception {
		
		Connection connection = Db.Connect();
		
		PreparedStatement stmt;
		
		
		try {
			
			if(!id.isBlank()) {
				
				query = "Select * from produto where id_produto = ?";
				stmt = connection.prepareStatement(query);
			
				stmt.setString(1,id);
				
				System.out.println(query);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					
				}else {
					throw new Exception("id informado não existe em sistema");
				}
			}
			
			if(nomeBoolean && !nome.isBlank()) {
			 query = "UPDATE produto set nome_produto = ? where id_produto = ?";
			stmt = connection.prepareStatement(query);
			
			stmt.setString(1, nome);
			stmt.setString(2,id);
			
			stmt.executeUpdate();
			}
			
			if(cnpjBoolean && !cnpj.isBlank()) {
				try {
				 query = "UPDATE produto set cnpj_fornecedor = ? where id_produto = ?";
				stmt = connection.prepareStatement(query);
				
				stmt.setString(1, cnpj);
				stmt.setString(2,id);
				
				stmt.executeUpdate();
				} catch (SQLException cnpjE) {
					throw new Exception ("Cnpj informado não é válido");
				}
				
			}
			
			if(valorBoolean && !valor.isBlank()) {
				 query = "UPDATE produto set valor_de_venda = ? where id_produto = ?";
				stmt = connection.prepareStatement(query);
				
				stmt.setString(1, valor);
				stmt.setString(2,id);
				
				stmt.executeUpdate();
				}
			
			if(quantidadeBoolean && !quantidade.isBlank()) {
							
				query = "UPDATE estoque set quantidade_produto = ? where id_estoque = ?";
				
				stmt = connection.prepareStatement(query);
				
				stmt.setString(1, quantidade);
				stmt.setString(2,id);
				
				stmt.executeUpdate();
			}
						
		} catch (SQLException e) {
			
		}
		
		
	}	
}
