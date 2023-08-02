package controladores.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexaoDb.Db;

import interfaces.interfacesCliente.InterfaceClienteUpdates;
import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;

public class ClienteAtualizarDatabase implements InterfaceClienteUpdates{
	
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
	
	public void infoCliente (Clientes cliente) {
	    ArrayList<Object> infoCliente = new ArrayList<Object>();
	    infoCliente.add(cliente.getNomeCliente());
	    infoCliente.add(cliente.getDataNascimentoCliente());
	    infoCliente.add(cliente.getTelefoneCliente());

	    ArrayList<Object> colunas = new ArrayList<Object>();
	    colunas.add("nome_cliente");
	    colunas.add("nascimento_cliente");
	    colunas.add("telefone");

	    try {
	        Connection connection = Db.Connect();
	        for (int i = 0; i < infoCliente.size(); i++) {
	            Object element = infoCliente.get(i);
	            if (element != null && !element.toString().isEmpty()) {
	                String atualizarCliente = "UPDATE cliente SET " + colunas.get(i) + " = ? WHERE cpf_cliente = ?";
	                PreparedStatement pstmt = connection.prepareStatement(atualizarCliente);
	                pstmt.setObject(1, element);
	                pstmt.setString(2, cliente.getCpf());
	                pstmt.executeUpdate();
	                pstmt.close();
	                	                
	           
	                
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        Db.CloseDb();
	    }
	   
	}
	

	public void enderecoCliente(Clientes cliente) {
	    ArrayList<Object> enderecoCliente = new ArrayList<Object>();
	    enderecoCliente.add(cliente.getCepCliente());
	    enderecoCliente.add(cliente.getEstadoCliente());
	    enderecoCliente.add(cliente.getCidadeCliente());
	    enderecoCliente.add(cliente.getBairroCliente());
	    enderecoCliente.add(cliente.getRuaCliente());
	    enderecoCliente.add(cliente.getDescricaoRuaCliente());

	    ArrayList<Object> colunas = new ArrayList<Object>();
	    colunas.add("cep");
	    colunas.add("estado");
	    colunas.add("cidade");
	    colunas.add("bairro");
	    colunas.add("rua");
	    colunas.add("complemento");

	    try {
	        Connection connection = Db.Connect();
	        for (int i = 0; i < enderecoCliente.size(); i++) {
	            Object element = enderecoCliente.get(i);
	            if (element != null && !element.toString().isEmpty()) {
	                String dadosEndecoCliente = "UPDATE cliente_endereco SET " + colunas.get(i) + " = ? WHERE cpf_cliente = ?";
	                PreparedStatement pstmt = connection.prepareStatement(dadosEndecoCliente);
	                pstmt.setObject(1, element);
	                pstmt.setString(2, cliente.getCpf());
	                pstmt.executeUpdate();
	                pstmt.close();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        Db.CloseDb();
	    }
	}

}


