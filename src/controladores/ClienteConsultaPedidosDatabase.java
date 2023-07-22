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
		
			String query = "SELECT  pedido.cpf_cliente, pedido.data_pedido, vendedor.nome_vendedor, SUM(pedido_produto.valor_total_produto_comprado) AS valor_total_comprado "+
							"FROM pedido "+
							"JOIN vendedor ON pedido.cpf_vendedor = vendedor.cpf_vendedor "+
							"JOIN cliente ON pedido.cpf_cliente = cliente.cpf_cliente "+
							"JOIN pedido_produto ON pedido.id_pedido = pedido_produto.id_pedido "+
							"WHERE cliente.nome_cliente = '" +nomeCliente +"'"+
							"GROUP BY pedido.id_pedido";


		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			
			String cpf_cliente = rs.getString("cpf_cliente");
			Date data_pedido = rs.getDate("data_pedido");
			String nome_vendedor = rs.getString("nome_vendedor");			
			float valor_total = rs.getFloat("valor_total_comprado");
			
		
			 Object[] produtosInfo= {cpf_cliente, data_pedido, nome_vendedor, valor_total};
	         resultadosProdutos.add(produtosInfo);
		}
		
		
	}else if(!cpfCliente.isEmpty()) {
		
		String query ="SELECT  pedido.cpf_cliente, pedido.data_pedido, vendedor.nome_vendedor, SUM(pedido_produto.valor_total_produto_comprado) AS valor_total_comprado "+
						"FROM pedido "+
						"JOIN vendedor on pedido.cpf_vendedor = vendedor.cpf_vendedor " +
						"JOIN cliente ON pedido.cpf_cliente = cliente.cpf_cliente "+
						"JOIN pedido_produto ON pedido.id_pedido = pedido_produto.id_pedido "+
						"WHERE cliente.cpf_cliente = '" + cpfCliente +"'"+
						"GROUP BY pedido.id_pedido ";

		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
						
			String cpf_cliente = rs.getString("cpf_cliente");
			Date data_pedido = rs.getDate("data_pedido");
			String nome_vendedor = rs.getString("nome_vendedor");			
			float valor_total = rs.getFloat("valor_total_comprado");
			
		
			 Object[] produtosInfo= {cpf_cliente, data_pedido, nome_vendedor, valor_total};
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
