package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import conexaoDb.Db;

public class ClienteCadastroDatabase {

    public void cadastrarInfoCliente(String cpfCliente, String nomeCliente, LocalDate dataNascimentoCliente,
            String telefoneCliente) {

        try (Connection connection = Db.Connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO cliente (cpf_cliente, nome_cliente, nascimento_cliente, telefone) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, cpfCliente);
            stmt.setString(2, nomeCliente);
            stmt.setObject(3, dataNascimentoCliente);
            stmt.setString(4, telefoneCliente);

            stmt.executeUpdate();

        } catch (SQLException e) {
            // Handle the exception (e.g., log or display an error message)
            e.printStackTrace();
        } finally {
            Db.CloseDb();
        }
    }

    public void cadastrarEnderecoCliente(String cepCliente, String estadoCliente, String cidadeCliente, String bairroCliente,
            String ruaCliente, String complementoCliente, String cpfCliente) {

        try (Connection connection = Db.Connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO cliente_endereco (cep, estado, cidade, bairro, rua, complemento, cpf_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, cepCliente);
            stmt.setString(2, estadoCliente);
            stmt.setString(3, cidadeCliente);
            stmt.setString(4, bairroCliente);
            stmt.setString(5, ruaCliente);
            stmt.setString(6, complementoCliente);
            stmt.setString(7, cpfCliente);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.CloseDb();
        }
    }
}
