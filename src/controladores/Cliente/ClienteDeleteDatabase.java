package controladores.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexaoDb.Db;
import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;
import interfaces.interfacesCliente.interfaceClientePedido;

public class ClienteDeleteDatabase implements interfaceClientePedido{

	 @Override
	public boolean verificarCpfDb(Clientes verificarCpf) throws infoClienteException {

	        try {
	            Connection connection = Db.Connect();

	            String verificarCPFQuery = "SELECT COUNT(*) FROM cliente WHERE cpf_cliente = ?";
	            PreparedStatement pstmt = connection.prepareStatement(verificarCPFQuery);
	            pstmt.setString(1, verificarCpf.getCpf());
	            ResultSet rs = pstmt.executeQuery();


	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0;
	            }

	        } catch (SQLException e) {

	        	throw new infoClienteException("houve um erro na consulta, por favor avise ao administrador");

	        } finally {
	            Db.CloseDb();
	        }


	        return false;
	    }

	 @Override
	public boolean verificarPedido(int verificarPedido) throws infoClienteException {

	        try {
	            Connection connection = Db.Connect();

	            String verificarCPFQuery = "SELECT COUNT(*) FROM cliente WHERE cpf_cliente = ?";
	            PreparedStatement pstmt = connection.prepareStatement(verificarCPFQuery);
	            pstmt.setInt(1, verificarPedido);
	            ResultSet rs = pstmt.executeQuery();


	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0;
	            }

	        } catch (SQLException e) {

	        	throw new infoClienteException("houve um erro na consulta, por favor avise ao administrador");

	        } finally {
	            Db.CloseDb();

	        }
			return false;
	 }

	@Override
	public void deletarClienteCadastro(Clientes clienteDeleteCadastro) throws infoClienteException  {
	    try {

	        Connection connection = Db.Connect();

	        String deleteEndereco = "DELETE FROM  cliente_endereco, cliente USING cliente_endereco "
	        						+ "JOIN  cliente ON  cliente_endereco.cpf_cliente = cliente.cpf_cliente "
	        						+ "WHERE cliente_endereco.cpf_cliente = ?";

	        PreparedStatement pstmt = connection.prepareStatement(deleteEndereco);
	        pstmt.setString(1, clienteDeleteCadastro.getCpf());
	        pstmt.executeUpdate();

	    } catch (Exception e) {

	    	if(e.getMessage().contains("Cannot delete or "
	    			+ "update a parent row: a foreign key constraint fails "
	    			+ "(`ads`.`pedido`, CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cpf_cliente`) "
	    			+ "REFERENCES `cliente` (`cpf_cliente`))")) {

	    		throw new infoClienteException("o cadastro do cliente não pode ser deletado, porque há pedidos atrelados a ele");
	    	}


	    } finally {
	        Db.CloseDb();
	    }
	}

	@Override
	public void deletarClientePedido(Clientes clienteDeletePedido) throws infoClienteException {
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
	    	throw new infoClienteException("erro ao deletar pedido");
	    } finally {
	        Db.CloseDb();
	    }




	}

	@Override
	public void deletarUnicoPedido(Clientes clienteDeletePedido, int idPedido) throws infoClienteException {

	    try {

	        Connection connection = Db.Connect();

	        String deleteUnicoPedidoProduto = "DELETE FROM pedido_produto WHERE id_pedido = ?";
	        String deleteUnicoPedido = "DELETE FROM pedido where pedido.id_pedido = ? and pedido.cpf_cliente = ?";

	        PreparedStatement pstmt = connection.prepareStatement(deleteUnicoPedidoProduto);
	        pstmt.setInt(1, idPedido);
	        pstmt.executeUpdate();

	        pstmt = connection.prepareStatement(deleteUnicoPedido);
	        pstmt.setInt(1, idPedido);
	        pstmt.setString(2, clienteDeletePedido.getCpf());
	        pstmt.executeUpdate();


	    }catch(Exception e2) {

	    	throw new infoClienteException("erro ao deletar pedido");
	    }



	}

}




