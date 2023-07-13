package controladores;

import conexaoDb.Db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteConsultaPedidosDatabase {

	
	
	public static List<Object[]> consultaProdutos(String nomeCliente, String cpfCliente){
		
		List<Object[]> resultadosProdutos = new ArrayList<>();
		
		
		try {
		Statement stmt = Db.Connect().createStatement();
		
		if(!nomeCliente.isEmpty()) {
		
			String query = "SELECT pedido.id_loja, pedido.data_pedido, pedido.valor_produtos, vendedor.nome_vendedor, pedido.cpf_cliente " +
		               "FROM pedido " +
		               "JOIN vendedor ON pedido.cpf_vendedor = vendedor.cpf_vendedor " +
		               "JOIN cliente ON pedido.cpf_cliente = cliente.cpf_cliente " +
		               "WHERE cliente.nome_cliente = '"+nomeCliente+"'";


		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			
			int id_loja = rs.getInt("id_loja");
			Date data_pedido = rs.getDate("data_pedido");
			float valor_total = rs.getFloat("valor_produtos");
			String nome_vendedor = rs.getString("nome_vendedor");
			String cpf_cliente = rs.getString("cpf_cliente");

		
			 Object[] produtosInfo= { id_loja, data_pedido, valor_total, nome_vendedor, cpf_cliente};
	         resultadosProdutos.add(produtosInfo);
		}
		
		
	}else if(!cpfCliente.isEmpty()) {
		
		String query ="SELECT pedido.id_loja, pedido.data_pedido, pedido.valor_produtos, vendedor.nome_vendedor, pedido.cpf_cliente " +
				"FROM pedido " +
				"JOIN vendedor on pedido.cpf_vendedor = vendedor.cpf_vendedor " +
				"WHERE pedido.cpf_cliente = '" + cpfCliente + "'";
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
						
			int id_loja = rs.getInt("id_loja");
			Date data_pedido = rs.getDate("data_pedido");
			float valor_total = rs.getFloat("valor_produtos");
			String nome_vendedor = rs.getString("nome_vendedor");
			String cpf_cliente = rs.getString("cpf_cliente");

			
			 Object[] produtosInfo= { id_loja, data_pedido, valor_total, nome_vendedor, cpf_cliente};
	         resultadosProdutos.add(produtosInfo);
		}
		
		
	}else {
		System.out.println("Campos vázios");
		
		
	}

		}catch (Exception e){
			
			e.printStackTrace();			
		}finally {
        	
        	Db.CloseDb();
        	
        }
							
		return resultadosProdutos;
	}
	
}
