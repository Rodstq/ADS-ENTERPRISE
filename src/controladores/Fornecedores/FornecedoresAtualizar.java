package controladores.Fornecedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexaoDb.Db;

public class FornecedoresAtualizar {
	String query;
	
public void atualizarFornecedor(String query) throws Exception{
		
		try {
			Connection connection = Db.Connect();
			
			PreparedStatement stmt1 = connection.prepareStatement(query);
			stmt1.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void execQuery(boolean nomeBoolean,
		
		String nome,String cnpj) throws Exception {
		
		Connection connection = Db.Connect();
		
		PreparedStatement stmt;
		
		
		try {
			
				if(!cnpj.isBlank()) {
				
				query = "select * from fornecedor where cnpj_fornecedor = ?";
				stmt = connection.prepareStatement(query);
				
				stmt.setString(1,cnpj);
				
				System.out.println(query);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					
				}else {
					throw new Exception("Cnpj informado não existe em sistema");
				}
			}
			
				
			if(nomeBoolean && !nome.isBlank()) {
				
				try {
					
				query = "UPDATE fornecedor set nome_fornecedor = ? where cnpj_fornecedor = ?";
				stmt = connection.prepareStatement(query);
				
				stmt.setString(1, nome);
				stmt.setString(2,cnpj);
				
				stmt.executeUpdate();
				} catch (SQLException cnpjE) {
					throw new Exception ("Cnpj informado não é válido");
				}
				
			}	
						
		} catch (SQLException e) {
			
		}
		
		
	}	

}
