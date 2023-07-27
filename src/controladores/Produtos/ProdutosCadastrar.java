package controladores.Produtos;

import conexaoDb.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import classesProdutos.Produto;

public class ProdutosCadastrar extends Produto {

	private String erro;
	
	public void cadastrarProdutos(Produto produto) throws SQLException{
		
		
		try (Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (id_produto, nome_produto, valor_de_venda, id_estoque,cnpj_fornecedor) values (?,?,?,?,?)")){
		
		
				stmt.setInt(1,produto.getId_produto());
				stmt.setString(2,produto.getNome_produto());
				stmt.setObject(3,produto.getValorVenda());
				stmt.setInt(4,1);
				stmt.setObject(5,produto.getCnpj());
				
				
				 stmt.executeUpdate();
			
		} catch (SQLException e) {
			String erro = e.getMessage();
			System.out.println(erro);
			if(erro.contains("Cannot add or update a child row: a foreign key constraint fails (`ads`.`produto`, CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`cnpj_fornecedor`) REFERENCES `fornecedor` (`cnpj_fornecedor`))")) {
				this.erro = "cnpj";
			} else if (erro.contains("Duplicate entry")){
				this.erro = "Id informado já pertence a um produto, digite novamente";
			}
			throw new SQLException();			
		}
		
	}
	
	public String getErroMessage() {
		return this.erro;
	}
}
