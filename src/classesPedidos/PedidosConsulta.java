package classesPedidos;
import java.util.Date;

public class PedidosConsulta {
    private int id_pedido;
    private Date data_pedido;
    private double valor_produtos;
    private int cpf_vendedor;
    private int cpf_cliente;

    public int getId_pedido() {
        return id_pedido;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public double getValor_produtos() {
        return valor_produtos;
    }

    public int getCpf_vendedor() {
        return cpf_vendedor;
    }

    public int getCpf_cliente() {
        return cpf_cliente;
    }



}
