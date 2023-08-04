package controladores.Estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexaoDb.Db;

public class EstoqueController {
    public static void venderProduto(int idProduto) {
        int quantidadeNoEstoque = getQuantidadeNoEstoque(idProduto);

        if (quantidadeNoEstoque > 0) {
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
                    System.out.println("Produto não encontrado.");
                }

                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao vender produto: " + ex.getMessage(), ex);
            }
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }

    public static int getQuantidadeNoEstoque(int idProduto) {
        String query = "SELECT quantidade_produto FROM estoque WHERE id_estoque = ?";
        try {
            Connection con = Db.getCon();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idProduto);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quantidade_produto");
                } else {
                    throw new IllegalArgumentException("Produto não encontrado com o ID: " + idProduto);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao obter a quantidade de produtos no estoque: " + ex.getMessage(), ex);
        }
    }

    public static boolean EstoqueSuficiente(int idProduto, int quantidadeDesejada) {
        int quantidadeNoEstoque = getQuantidadeNoEstoque(idProduto);
        return quantidadeNoEstoque >= quantidadeDesejada;
    }

    public static double getValorDeVendaProduto(int idProduto) {
        String query = "SELECT valor_de_venda FROM produto WHERE id_produto = ?";
        try{
            Connection con = Db.getCon();
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, idProduto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("valor_de_venda");
                } else {
                    throw new IllegalArgumentException("Produto não encontrado com o ID: " + idProduto);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao obter o valor de venda do produto: " + ex.getMessage(), ex);
        }
    }
}