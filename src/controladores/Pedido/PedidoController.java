package controladores.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexaoDb.Db;
import controladores.Estoque.EstoqueController;

public class PedidoController {
    public static void criarPedido(ArrayList<Integer> ProdutosComprados, String cpf_cliente, String cpf_vendedor) throws SQLException {
        int novoIdPedido = UltimoPedidoId() + 1;
        String insertPedidoQuery = "INSERT INTO pedido (id_pedido, data_pedido, cpf_vendedor, cpf_cliente) " +
                "VALUES (?, CURRENT_DATE, ?, ?)";
        String insertPedidoProdutoQuery = "INSERT INTO pedido_produto (id_produto, id_pedido, valor_total_produto_comprado, quantidade_comprada) " +
                "VALUES (?, ?, ?, ?)";
        Db.Connect();
        Connection con = Db.getCon();
        PreparedStatement stmtPedido = con.prepareStatement(insertPedidoQuery);

        try {
            stmtPedido.setInt(1, novoIdPedido);
            stmtPedido.setString(2, cpf_vendedor);
            stmtPedido.setString(3, cpf_cliente);
            stmtPedido.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar um novo pedido: " + ex.getMessage(), ex);
        }

        try (stmtPedido; PreparedStatement stmtPedidoProduto = con.prepareStatement(insertPedidoProdutoQuery)) {
            for (int idProduto : ProdutosComprados) {

                double valorTotalProdutoComprado = EstoqueController.getValorDeVendaProduto(idProduto);
                int quantidadeComprada = 1;

                stmtPedidoProduto.setInt(1, idProduto);
                stmtPedidoProduto.setInt(2, novoIdPedido);
                stmtPedidoProduto.setDouble(3, valorTotalProdutoComprado);
                stmtPedidoProduto.setInt(4, quantidadeComprada);
                stmtPedidoProduto.executeUpdate();

                EstoqueController.venderProduto(idProduto);

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao adicionar produtos ao pedido: " + ex.getMessage(), ex);
        } finally {
            Db.CloseDb();
        }
    }

    public static int UltimoPedidoId() {
        String query = "SELECT MAX(id_pedido) FROM pedido";
        try (Connection con = Db.getCon();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar acessa o último id de Pedido: " + ex.getMessage(), ex);
        }
    }
}
