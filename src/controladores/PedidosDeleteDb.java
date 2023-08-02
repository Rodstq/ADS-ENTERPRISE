package controladores;

import conexaoDb.Db;

import java.sql.PreparedStatement;

public class PedidosDeleteDb {

    public boolean deletarPedido(String idPedido) {
        try {
        	// deleta os registros de pedido_produto antes, por causa da chave estrangeira
            String deletePedidoProdutoQuery = "DELETE FROM pedido_produto WHERE id_pedido = ?";
            PreparedStatement deletePedidoProdutoStmt = Db.Connect().prepareStatement(deletePedidoProdutoQuery);
            deletePedidoProdutoStmt.setString(1, idPedido);
            deletePedidoProdutoStmt.executeUpdate();
            
            String deletePedidoQuery = "DELETE FROM pedido WHERE id_pedido = ?";
            PreparedStatement deletePedidoStmt = Db.Connect().prepareStatement(deletePedidoQuery);
            deletePedidoStmt.setString(1, idPedido);
            int rowsDeleted = deletePedidoStmt.executeUpdate();

            
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            Db.CloseDb();
        }
    }
}
