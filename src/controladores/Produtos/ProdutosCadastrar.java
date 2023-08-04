package controladores.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoDb.Db;
import data.tratamento.produtos.CadastrarTratamento;
import models.classesProdutos.Produto;

public class ProdutosCadastrar extends Produto {

	private String erro;

	public void cadastrarProdutos(Produto produto) throws Exception{
<<<<<<< HEAD


		try (Connection connection = Db.Connect();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (id_produto, nome_produto, valor_de_venda, id_estoque,cnpj_fornecedor) values (?,?,?,?,?)")){


=======
		
		try {
			Connection connection = Db.Connect();
			
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO estoque (id_estoque, quantidade_produto) values (?,?)");
			
			pstmt.setInt(1,produto.getId_estoque());
			pstmt.setInt(2,produto.getQuantidade());
			
			pstmt.executeUpdate();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (id_produto, nome_produto, valor_de_venda,id_estoque,cnpj_fornecedor) values (?,?,?,?,?)");
		
		
>>>>>>> a38dcf1a373f42fbe394e886dde4872134e5f8c9
				stmt.setInt(1,produto.getId_produto());
				stmt.setString(2,produto.getNome_produto());
				stmt.setObject(3,produto.getValorVenda());
				stmt.setInt(4,produto.getId_estoque());
				stmt.setString(5,produto.getCnpj());

				stmt.executeUpdate();
<<<<<<< HEAD

				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO estoque (id_estoque, nome_produto, quantidade_produto) values (?,?,?)");

					pstmt.setInt(1,produto.getId_produto());
					pstmt.setString(2,produto.getNome_produto());
					pstmt.setInt(3,produto.getQuantidade());

				pstmt.executeUpdate();

=======
				
			
			
>>>>>>> a38dcf1a373f42fbe394e886dde4872134e5f8c9
		} catch (Exception e) {
			CadastrarTratamento verificar = new CadastrarTratamento();
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
