package classesPedidos;

public class ProdutoDetalhado {
    private int idProduto;
    private String nomeProduto;
    private double valor;
    private int quantidadeComprada;
    private double valorTotalProduto;

    public ProdutoDetalhado(int idProduto, String nomeProduto, double valor, int quantidadeComprada, double valorTotalProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.quantidadeComprada = quantidadeComprada;
        this.valorTotalProduto = valorTotalProduto;
    }

    // Getters e Setters

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }
}
