package Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoDb.Db;

public class EstoqueManager {
    public static void venderProduto(int idProduto) {
        String query = "UPDATE estoque SET quantidade = quantidade - 1 WHERE id_estoque = ?";
        PreparedStatement stmt = null;

        try {
            Connection con = Db.getCon();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();

            System.out.println("Produto vendido com sucesso!");

            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao vender produto: " + ex.getMessage(), ex);
        }
    }
}
