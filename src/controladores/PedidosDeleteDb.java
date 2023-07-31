package controladores;

import conexaoDb.Db;

import java.sql.PreparedStatement;

public class PedidosDeleteDb {

    public boolean deletarPedido(String idPedido) {
        try {
            String query = "DELETE FROM pedido WHERE id_pedido = ?";
            PreparedStatement stmt = Db.Connect().prepareStatement(query);
            stmt.setString(1, idPedido);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            Db.CloseDb();
        }
    }
}
