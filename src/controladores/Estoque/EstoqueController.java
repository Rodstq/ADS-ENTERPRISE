package controladores.Estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoDb.Db;

public class EstoqueController {
    public static void venderProduto(int idProduto) {
        String query = "UPDATE estoque SET quantidade_produto = quantidade_produto - 1 WHERE id_estoque = ?";
        PreparedStatement stmt = null;

        try {
            Connection con = Db.getCon();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idProduto);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Produto vendido com sucesso!");
            } else {
                System.out.println("Produto não encontrado ou estoque insuficiente.");
            }

            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao vender produto: " + ex.getMessage(), ex);
        }
    }
}
