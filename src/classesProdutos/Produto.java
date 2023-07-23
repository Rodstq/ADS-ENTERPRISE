package classesProdutos;

public class Produto {

   private int id_produto;
   private String nome_produto;
   private double valorVenda;
   private int id_estoque;
   private String cnpj_fornecedor;
   
   
public int getId_produto() {
	return id_produto;
}
public void setId_produto(int id_produto) {
	this.id_produto = id_produto;
}
public String getNome_produto() {
	return nome_produto;
}
public void setNome_produto(String nome_produto) {
	this.nome_produto = nome_produto;
}
public double getValorVenda() {
	return valorVenda;
}
public void setValorVenda(double valorVenda) {
	this.valorVenda = valorVenda;
}
public int getId_estoque() {
	return id_estoque;
}
public void setId_estoque(int id_estoque) {
	this.id_estoque = id_estoque;
} 
public void setCnpj(String cnpj) {
	this.cnpj_fornecedor = cnpj;
}
public String getCnpj() {
	return this.cnpj_fornecedor;
}

//public boolean validacao() {
//	
//	if (id_produto == (int)id_produto &&  nome_produto.equals((String)nome_produto) && valorVenda == (double)valorVenda && id_estoque ==(int)id_estoque && cnpj_fornecedor.equals((String)cnpj_fornecedor))
//	{
//	   return true;
//	}else {
//		return false;
//	}
//}
//	
}
