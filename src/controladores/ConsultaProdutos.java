package controladores;

import conexaoDb.Db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {

	
	public static List<Object[]> consultaProdutos(String nomeCliente, String cpfCliente){
		
		List<Object[]> resultadosProdutos = new ArrayList<>();
		
		
		try {
		Statement stmt = Db.Connect().createStatement();
		
		
//		if(!cpfCliente.isEmpty() && !nomeCliente.isEmpty()){
//			String query = "SELECT produtos.* " +
//		               "FROM produtos " +
//		               "JOIN clienteProdutos cp1 ON produtos.idProduto = cp1.idProduto " +
//		               "JOIN clientes ON clientes.cpf = cp1.cpf " +
//		               "WHERE cp1.nome = '" + nomeCliente + "' AND clientes.cpf = '" + cpfCliente + "'";
//
//
//
//			
//		ResultSet rs = stmt.executeQuery(query);
//		
//		while(rs.next()){
//			String idProduto = rs.getString("idProduto");
//			String nomeProduto = rs.getString("nomeProduto");
//			int quantidadeProduto = rs.getInt("quantidadeProduto");
//			double valorProduto = rs.getDouble("valorProduto");
//			Date dataValidade = rs.getDate("dataValidade");
//
//		
//		 Object[] produtosInfo= { idProduto, nomeProduto, quantidadeProduto, valorProduto, dataValidade};
//         resultadosProdutos.add(produtosInfo);
//		}
//		
//		
//		
//	}else 
		if(!nomeCliente.isEmpty()) {
		
			String query = "SELECT produtos.* " +
							"FROM produtos " +
							"JOIN clienteProdutos cp1 ON produtos.idProduto = cp1.idProduto " +
							"JOIN clientes ON clientes.cpf = cp1.cpf " +
							"WHERE clientes.nome = '"+nomeCliente+"'";


		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){

			String idProduto = rs.getString("idProduto");
			String nomeProduto = rs.getString("nomeProduto");
			int quantidadeProduto = rs.getInt("quantidadeProduto");
			double valorProduto = rs.getDouble("valorProduto");
			Date dataValidade = rs.getDate("dataValidade");

		
		 Object[] produtosInfo= {  idProduto, nomeProduto, quantidadeProduto, valorProduto, dataValidade};
         resultadosProdutos.add(produtosInfo);
		}
		
		
	}else if(!cpfCliente.isEmpty()) {
		
		String query ="SELECT produtos.* " +
				"FROM produtos " +
				"JOIN clienteProdutos cp1 On produtos.idProduto = cp1.idProduto " +
				"JOIN clientes ON clientes.cpf = cp1.cpf " +
				"WHERE clientes.cpf = '" + cpfCliente + "'";
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
						
			String idProduto = rs.getString("idProduto");
			String nomeProduto = rs.getString("nomeProduto");
			int quantidadeProduto = rs.getInt("quantidadeProduto");
			double valorProduto = rs.getDouble("valorProduto");
			Date dataValidade = rs.getDate("dataValidade");

		
		 Object[] produtosInfo= { idProduto, nomeProduto, quantidadeProduto, valorProduto, dataValidade};
         resultadosProdutos.add(produtosInfo);
		}
		
		
	}else {
		System.out.println("Campos vázios");
		
		
	}
		
		stmt.close();
		Db.CloseDb();		
				
		}catch (Exception e){
			
			e.printStackTrace();			
		}
							
		return resultadosProdutos;
	}
	
}
