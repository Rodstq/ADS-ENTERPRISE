package classesProdutos;

public class Produto {

   private String id_produto;
   private String nome_produto;
   private int quantidade;
   private double valor;
   private String id_estoque;
   
   
public String getId_produto() {
	return id_produto;
}
public void setId_produto(String id_produto) {
	this.id_produto = id_produto;
}
public String getNome_produto() {
	return nome_produto;
}
public void setNome_produto(String nome_produto) {
	this.nome_produto = nome_produto;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
public String getId_estoque() {
	return id_estoque;
}
public void setId_estoque(String id_estoque) {
	this.id_estoque = id_estoque;
} 
	

	
}
