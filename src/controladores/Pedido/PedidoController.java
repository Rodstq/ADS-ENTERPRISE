package controladores.Pedido;

import conexaoDb.Db;
import controladores.Estoque.EstoqueController;
import interfaces.interfacesVendas.TelaVendas;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
            HashMap<Integer, Integer> quantidadePorProduto = new HashMap<>();

            // Contar a quantidade de produtos na lista ProdutosComprados
            for (int idProduto : ProdutosComprados) {
                quantidadePorProduto.put(idProduto, quantidadePorProduto.getOrDefault(idProduto, 0) + 1);
            }

            // Verificar se há estoque suficiente para todos os produtos na lista
            for (int idProduto : quantidadePorProduto.keySet()) {
                int quantidadeDesejada = quantidadePorProduto.get(idProduto);

                if (!EstoqueController.EstoqueSuficiente(idProduto, quantidadeDesejada)) {
                    JOptionPane.showMessageDialog(null, "Estoque insuficiente para o produto com ID: " + idProduto, "Erro de Estoque", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Vender os produtos e atualizar o estoque
            for (int idProduto : quantidadePorProduto.keySet()) {
                int quantidadeDesejada = quantidadePorProduto.get(idProduto);
                double valorTotalProdutoComprado = EstoqueController.getValorDeVendaProduto(idProduto);

                stmtPedidoProduto.setInt(1, idProduto);
                stmtPedidoProduto.setInt(2, novoIdPedido);
                stmtPedidoProduto.setDouble(3, valorTotalProdutoComprado);
                stmtPedidoProduto.setInt(4, quantidadeDesejada);
                stmtPedidoProduto.executeUpdate();

                for (int i = 0; i < quantidadeDesejada; i++) {
                    EstoqueController.venderProduto(idProduto);
                    JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso!", "Compra finalizada", JOptionPane.INFORMATION_MESSAGE);
                }
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
            throw new RuntimeException("Erro ao tentar acessar o último id de Pedido: " + ex.getMessage(), ex);
        }
    }

    public static int contarElemento(ArrayList<Integer> lista, int elemento) {
        int contador = 0;

        for (int item : lista) {
            if (item == elemento) {
                contador++;
            }
        }

        return contador;
    }
}
