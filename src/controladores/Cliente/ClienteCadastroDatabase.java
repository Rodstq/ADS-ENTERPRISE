package controladores.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import data.tratamento.clients.ClienteCadastroTratamento;
import conexaoDb.Db;

import interfacesCliente.InterfaceClienteEstatic;

import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;
import interfacesCliente.InterfaceClienteEstatic;

public class ClienteCadastroDatabase implements InterfaceClienteEstatic {
	
    public void infoCliente(Clientes cliente) throws infoClienteException{
    			
        try (Connection connection = Db.Connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO cliente (cpf_cliente, nome_cliente, nascimento_cliente, telefone) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, cliente.getCpf()); 
            stmt.setString(2, cliente.getNomeCliente()); 
            stmt.setObject(3, cliente.getDataNascimentoCliente()); 
            stmt.setString(4, cliente.getTelefoneCliente()); 
            stmt.executeUpdate();
            
            
            
        } catch (SQLException e) {
     
        	if (e.getMessage().contains("Duplicate entry")){
        		throw new infoClienteException("já existe um cliente cadastrado com esse cpf");
			}
        	
        	
        } finally {
            Db.CloseDb();
        }
   
        
    }

    public void enderecoCliente(Clientes clienteEndereco) {

        try (Connection connection = Db.Connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO cliente_endereco (cep, estado, cidade, bairro, rua, complemento, cpf_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, clienteEndereco.getCepCliente());
            stmt.setString(2, clienteEndereco.getEstadoCliente());
            stmt.setString(3, clienteEndereco.getCidadeCliente());
            stmt.setString(4, clienteEndereco.getBairroCliente());
            stmt.setString(5, clienteEndereco.getRuaCliente());
            stmt.setString(6, clienteEndereco.getDescricaoRuaCliente());
            stmt.setString(7, clienteEndereco.getCpf());

            stmt.executeUpdate();

        } catch (SQLException e) {
        	
            e.printStackTrace();
            
        } finally {
        	
            Db.CloseDb();
        }
    }

  
}
