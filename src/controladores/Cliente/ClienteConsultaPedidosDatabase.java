package controladores.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexaoDb.Db;
import data.tratamento.clients.infoClienteException;

public class ClienteConsultaPedidosDatabase {



	public static List<Object[]> consultaProdutos(String nomeCliente, String cpfCliente) throws infoClienteException {
	    List<Object[]> resultadosProdutos = new ArrayList<>();

	    try {
	        Connection connection = Db.Connect();
	        String query = "SELECT pedido.id_pedido, pedido.cpf_cliente, pedido.data_pedido, vendedor.nome_vendedor, SUM(pedido_produto.valor_total_produto_comprado) AS valor_total_comprado " +
	                "FROM pedido " +
	                "JOIN vendedor ON pedido.cpf_vendedor = vendedor.cpf_vendedor " +
	                "JOIN cliente ON pedido.cpf_cliente = cliente.cpf_cliente " +
	                "JOIN pedido_produto ON pedido.id_pedido = pedido_produto.id_pedido ";


	        if (!nomeCliente.isBlank()) {
	            query += "WHERE cliente.nome_cliente = ?"+"GROUP BY pedido.id_pedido";
	            PreparedStatement pstmt = connection.prepareStatement(query);
	            pstmt.setString(1, nomeCliente);
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	            	int id_pedido = rs.getInt("id_pedido");
	                String cpf_cliente = rs.getString("cpf_cliente");
	                Date data_pedido = rs.getDate("data_pedido");
	                String nome_vendedor = rs.getString("nome_vendedor");
	                float valor_total = rs.getFloat("valor_total_comprado");

	                Object[] produtosInfo = {id_pedido, cpf_cliente, data_pedido, nome_vendedor, valor_total};
	                resultadosProdutos.add(produtosInfo);
	            }
	        } else if (!cpfCliente.isBlank()) {
	            query += "WHERE cliente.cpf_cliente = ? "+ "GROUP BY pedido.id_pedido";
	            PreparedStatement pstmt = connection.prepareStatement(query);
	            pstmt.setString(1, cpfCliente);
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	            	int id_pedido = rs.getInt("id_pedido");
	                String cpf_cliente = rs.getString("cpf_cliente");
	                Date data_pedido = rs.getDate("data_pedido");
	                String nome_vendedor = rs.getString("nome_vendedor");
	                float valor_total = rs.getFloat("valor_total_comprado");

	                Object[] produtosInfo = {id_pedido, cpf_cliente, data_pedido, nome_vendedor, valor_total};
	                resultadosProdutos.add(produtosInfo);
	            }
	        }

	    } catch (Exception e) {

	    	throw new infoClienteException("Desculpe, houve um erro na consulta contate seu administrador para corrigir");

	    } finally {
	        Db.CloseDb();
	    }

	    return resultadosProdutos;
	}


}
