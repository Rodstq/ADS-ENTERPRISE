package controladores.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import conexaoDb.Db;
import data.tratamento.clients.Clientes;

public class ClienteAtualizarDatabase implements InterfaceClienteEstatic{
	
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


