package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import classesCliente.ClienteCadastroTratamento;
import classesCliente.Clientes;
import conexaoDb.Db;

public class ClienteCadastroDatabase {

	

	
    public void setCadastrarInfoCliente(Clientes cliente) {
    			
        try (Connection connection = Db.Connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO cliente (cpf_cliente, nome_cliente, nascimento_cliente, telefone) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, cliente.getCpf()); //cpf
            stmt.setString(2, cliente.getNomeCliente()); //nome
            stmt.setObject(3, cliente.getDataNascimentoCliente());  //date
            stmt.setString(4, cliente.getTelefoneCliente()); //telefone

            stmt.executeUpdate();
            
            
            
        } catch (SQLException e) {
     
            e.printStackTrace();
        } finally {
            Db.CloseDb();
        }
   
        
    }

    public void cadastrarEnderecoCliente(Clientes clienteEndereco) {

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
