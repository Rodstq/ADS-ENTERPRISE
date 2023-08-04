package controladores.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaoDb.Db;

public class ProdutosAtualizar {

	private String erro;
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

	public String execQuery(boolean nomeBoolean,boolean cnpjBoolean,boolean valorBoolean,boolean quantidadeBoolean,

		String id,String nome,String cnpj,String valor,String quantidade) {
//
//		String query = "";
//		StringBuffer queryFinal = new StringBuffer(query);
//
//		if (nomeBoolean && !nome.isBlank()) {
//
//			query = "update produto set nome_produto = 'x' where id_produto = y;";
//
//			int i = query.indexOf('x');
//
//			queryFinal.setCharAt(i, nome);
//		}
//
		return query;

	}
}
