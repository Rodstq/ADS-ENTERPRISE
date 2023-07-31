package controladores;

import conexaoDb.Db;
import classesPedidos.PedidosConsulta;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.swing.JOptionPane;


public class PedidosConsultaDb {

    public List<PedidosConsulta> consultarPedidos(String filtro, String tipoFiltro) {
        List<PedidosConsulta> resultados = new ArrayList<>();
        try {
        	Statement stmt = Db.Connect().createStatement();
        	
            String query = "SELECT * FROM pedido WHERE ";

            if (tipoFiltro.equals("CPF do Cliente")) {
                query += "cpf_cliente = '" + filtro + "'";
            } else if (tipoFiltro.equals("CPF do Vendedor")) {
                query += "cpf_vendedor = '" + filtro + "'";
            } else if (tipoFiltro.equals("ID do Pedido")) {
                query += "id_pedido = " + filtro;
            } else if (tipoFiltro.equals("Data de Compra")) {
                query += "data_pedido = '" + filtro + "'";
            } else {
                query = "SELECT * FROM pedido";
            }

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                String cpfVendedor = rs.getString("cpf_vendedor");
                String cpfCliente = rs.getString("cpf_cliente");
                double valorProdutos = rs.getDouble("valor_produtos");
                Date dataPedido = rs.getDate("data_pedido");

                PedidosConsulta pedido = new PedidosConsulta();
                pedido.setIdPedido(idPedido);
                pedido.setCpfVendedor(cpfVendedor);
                pedido.setCpfCliente(cpfCliente);
                pedido.setValorProdutos(valorProdutos);
                pedido.setDataPedido(dataPedido);

                resultados.add(pedido);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            Db.CloseDb();
        }
        return resultados;
    }
    
}
