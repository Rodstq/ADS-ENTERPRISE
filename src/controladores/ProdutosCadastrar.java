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
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (id_produto, nome_produto, valor_de_venda, id_estoque,cnpj_fornecedor) values (?,?,?,?,?)")){
		
		
				stmt.setInt(1,produto.getId_produto());
				stmt.setString(2,produto.getNome_produto());
				stmt.setObject(3,produto.getValorVenda());
				stmt.setInt(4,produto.getId_estoque());
				stmt.setObject(5,produto.getCnpj());
				
				
				 stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
