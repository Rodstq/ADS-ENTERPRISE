package models.classesProdutos;

import controladores.Produtos.ProdutosConsulta;

public class ProdutoConsultaTratamento extends Produto{
	
	ProdutosConsulta produtoConsulta = new ProdutosConsulta();
	
	public String  setRetorno(String nome_produto) throws Exception{
		setNome_produto(nome_produto);
		
		String resultadosProdutos = produtoConsulta.consultarProdutos();
		
		return resultadosProdutos;
	}

}
