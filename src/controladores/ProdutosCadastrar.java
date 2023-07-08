package controladores;

import conexaoDb.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import classesProdutos.Produto;

public class ProdutosCadastrar extends Produto {

	
	public void cadastrarProdutos(Produto produto) {
		
		
		try (Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO produtos (id_produto, nome_produto, quantidade, valor, id_estoque) values (?,?,?,?,?)")){
		
		
				stmt.setString(1,produto.getId_produto());
				stmt.setString(2,produto.getNome_produto());
				stmt.setObject(3,produto.getQuantidade());
				stmt.setObject(4,produto.getValor());
				stmt.setString(5,produto.getId_estoque());
				
				 stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
