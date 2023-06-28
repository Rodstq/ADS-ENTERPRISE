package controladores;
import java.sql.Statement;

import classesCliente.Clientes;
import conexaoDb.Db;
public class ClienteDeleteDatabase {

	
	public void deletarClienteCadastro(Clientes clienteDeleteCadastro) {
		
			
		
		try {
			Statement stmt = Db.Connect().createStatement();
			String deleteEndereco = "delete from cliente_endereco where cpf_cliente='"+clienteDeleteCadastro.getCpf()+"'";;
			String deleteCliente ="delete from cliente where cpf_cliente='"+clienteDeleteCadastro.getCpf()+"'";
			String deleteProdutoCliente ="delete from pedido where cpf_cliente='" + clienteDeleteCadastro.getCpf()+"'";
			
			stmt.execute(deleteEndereco);
			stmt.execute(deleteCliente);
			stmt.execute(deleteProdutoCliente);
			
		}catch(Exception e) {
			
			
		}finally {
        	
        	Db.CloseDb();
        	
        }
		
		
		}
	
	public void deletarClientePedido(Clientes clienteDeletePedido) {
		try {
			Statement stmt = Db.Connect().createStatement();
			
			String deletePedidoProduto = "DELETE FROM pedido_produto WHERE id_pedido IN "
					  + "(SELECT id_pedido FROM pedido WHERE cpf_cliente = '"+ clienteDeletePedido.getCpf() +"')";
			String deletePedido = "DELETE FROM pedido WHERE cpf_cliente = '" + clienteDeletePedido.getCpf() +"'";
			
			stmt.execute(deletePedidoProduto);
			stmt.execute(deletePedido);
			
		}catch(Exception e) {
			
			
		}finally {
        	
        	Db.CloseDb();
        	
        }
				
	}		
}
	
	
	

