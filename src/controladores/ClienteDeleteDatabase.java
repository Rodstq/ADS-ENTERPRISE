package controladores;
import java.sql.Statement;

import conexaoDb.Db;
public class ClienteDeleteDatabase {

	
	public void deletarClienteCadastro(String cpfDeleteCadastro) {
		
			
		
		try {
			Statement stmt = Db.Connect().createStatement();
			String deleteEndereco = "delete from cliente_endereco where cpf_cliente='"+cpfDeleteCadastro+"'";;
			String deleteCliente ="delete from cliente where cpf_cliente='"+cpfDeleteCadastro+"'";
			String deleteProdutoCliente ="delete from pedido where cpf_cliente='" + cpfDeleteCadastro+"'";
			
			stmt.execute(deleteEndereco);
			stmt.execute(deleteCliente);
			stmt.execute(deleteProdutoCliente);
			
		}catch(Exception e) {
			
			
		}
		
		
		}
	
	public void deletarClientePedido(String cpfDeletePedido) {
		try {
			Statement stmt = Db.Connect().createStatement();
			
			String deletePedidoProduto = "DELETE FROM pedido_produto WHERE id_pedido IN "
					  + "(SELECT id_pedido FROM pedido WHERE cpf_cliente = '"+ cpfDeletePedido +"')";
			String deletePedido = "DELETE FROM pedido WHERE cpf_cliente = '" + cpfDeletePedido +"'";
			
			stmt.execute(deletePedidoProduto);
			stmt.execute(deletePedido);
			
		}catch(Exception e) {
			
			
		}
		
		
		
	}
		
	}
	
	
	

