package controladores.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import conexaoDb.Db;
import data.tratamento.clients.Clientes;
public class ClienteDeleteDatabase {

	
	public void deletarClienteCadastro(Clientes clienteDeleteCadastro) {
	    try {
	        Connection connection = Db.Connect();
	        String deleteEndereco = "DELETE FROM cliente_endereco WHERE cpf_cliente=?";
	        String deleteCliente = "DELETE FROM cliente WHERE cpf_cliente=?";
	        String deleteProdutoCliente = "DELETE FROM pedido WHERE cpf_cliente=?";
	        
	        PreparedStatement pstmt = connection.prepareStatement(deleteEndereco);
	        pstmt.setString(1, clienteDeleteCadastro.getCpf());
	        pstmt.executeUpdate();

	        pstmt = connection.prepareStatement(deleteCliente);
	        pstmt.setString(1, clienteDeleteCadastro.getCpf());
	        pstmt.executeUpdate();

	        pstmt = connection.prepareStatement(deleteProdutoCliente);
	        pstmt.setString(1, clienteDeleteCadastro.getCpf());
	        pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        Db.CloseDb();
	    }
	}

	public void deletarClientePedido(Clientes clienteDeletePedido) {
	    try {
	        Connection connection = Db.Connect();
	        String deletePedidoProduto = "DELETE FROM pedido_produto WHERE id_pedido IN "
	                + "(SELECT id_pedido FROM pedido WHERE cpf_cliente = ?)";
	        String deletePedido = "DELETE FROM pedido WHERE cpf_cliente = ?";

	        PreparedStatement pstmt = connection.prepareStatement(deletePedidoProduto);
	        pstmt.setString(1, clienteDeletePedido.getCpf());
	        pstmt.executeUpdate();

	        pstmt = connection.prepareStatement(deletePedido);
	        pstmt.setString(1, clienteDeletePedido.getCpf());
	        pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        Db.CloseDb();
	    }
	}
}
	
	
	

