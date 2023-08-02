package controladores;

import conexaoDb.Db;
import models.classesPedidos.PedidosConsulta;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class PedidosConsultaDb {
	
	public double calcularSomaValoresProdutos(int idPedido) {
	    double soma = 0;
	    try {
	        Statement stmt = Db.Connect().createStatement();
	        String query = "SELECT SUM(valor_total_produto_comprado) AS total FROM pedido_produto WHERE id_pedido = " + idPedido;
	        ResultSet rs = stmt.executeQuery(query);
	        if (rs.next()) {
	            soma = rs.getDouble("total");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return soma;
	}
	
	public int calcularQuantidadeProdutos(int idPedido) {
	    int soma = 0;
	    try {
	        Statement stmt = Db.Connect().createStatement();
	        String query = "SELECT SUM(quantidade_comprada) AS quantidadetotalcomprada FROM pedido_produto WHERE id_pedido = " + idPedido;
	        ResultSet rs = stmt.executeQuery(query);
	        if (rs.next()) {
	            soma = rs.getInt("quantidadetotalcomprada");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return soma;
	}


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
                Date dataPedido = rs.getDate("data_pedido");
                double valorTotalCompra = calcularSomaValoresProdutos(idPedido);
                int quantidadeTotalComprada = calcularQuantidadeProdutos(idPedido);

                PedidosConsulta pedido = new PedidosConsulta();
                pedido.setIdPedido(idPedido);
                pedido.setCpfVendedor(cpfVendedor);
                pedido.setCpfCliente(cpfCliente);
                pedido.setDataPedido(dataPedido);
                pedido.setValorProdutos(valorTotalCompra);
                pedido.setQuantitadeTotalProdutos(quantidadeTotalComprada);

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
