package classesPedidos;

import java.util.Date;

public class PedidosConsulta {
    private int idPedido;
    private Date dataPedido;
    private double valorProdutos;
    private String cpfVendedor;
    private String cpfCliente;
    private int quantitadeTotalProdutos;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuantitadeTotalProdutos() {
        return quantitadeTotalProdutos;
    }

    public void setQuantitadeTotalProdutos(int quantitadeTotalProdutos) {
        this.quantitadeTotalProdutos = quantitadeTotalProdutos;
    }
    
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(String cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}