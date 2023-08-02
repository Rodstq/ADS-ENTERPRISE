package controladores;

import conexaoDb.Db;
import models.classesPedidos.ProdutoDetalhado;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoProdutoDetalheDb {

    public List<ProdutoDetalhado> obterDetalhesPedido(int idPedido) {
        List<ProdutoDetalhado> detalhes = new ArrayList<>();
        try {
            Statement stmt = Db.Connect().createStatement();
            String query = "SELECT produto.id_produto, produto.nome_produto, produto.valor_de_venda, pedido_produto.quantidade_comprada "
                    + "FROM pedido_produto "
                    + "JOIN produto ON pedido_produto.id_produto = produto.id_produto "
                    + "WHERE pedido_produto.id_pedido = " + idPedido;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int idProduto = rs.getInt("id_produto");
                String nomeProduto = rs.getString("nome_produto");
                double valorProduto = rs.getDouble("valor_de_venda");
                int quantidadeComprada = rs.getInt("quantidade_comprada");
                double valorTotalProduto = valorProduto * quantidadeComprada;

                ProdutoDetalhado detalhe = new ProdutoDetalhado(idProduto, nomeProduto, valorProduto, quantidadeComprada, valorTotalProduto);
                detalhes.add(detalhe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Db.CloseDb();
        }
        return detalhes;
    }
}
