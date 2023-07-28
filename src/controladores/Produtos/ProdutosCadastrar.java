package controladores.Produtos;

import conexaoDb.Db;
import data.tratamento.produtos.ProdutoCadastrarTratamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import classesProdutos.Produto;

public class ProdutosCadastrar extends Produto {

	private String erro;
	
	public void cadastrarProdutos(Produto produto) throws Exception{
		
		
		try (Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (id_produto, nome_produto, valor_de_venda, id_estoque,cnpj_fornecedor) values (?,?,?,?,?)")){
		
		
				stmt.setInt(1,produto.getId_produto());
				stmt.setString(2,produto.getNome_produto());
				stmt.setObject(3,produto.getValorVenda());
				stmt.setInt(4,1);
				stmt.setObject(5,produto.getCnpj());
				
				stmt.executeUpdate();
			
		} catch (Exception e) {
			ProdutoCadastrarTratamento verificar = new ProdutoCadastrarTratamento();
			e.printStackTrace();
			String erro = e.getMessage();
			System.out.println(" ============" + erro);
			verificar.verificaErro(erro);
			this.erro = verificar.verificaErro(erro);
			throw new SQLException();			
		}
		
	}
	
	public String getErroMessage() {
		return this.erro;
	}
}
