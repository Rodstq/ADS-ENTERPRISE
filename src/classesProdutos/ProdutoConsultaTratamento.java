package classesProdutos;

import controladores.Produtos.ProdutosConsulta;

public class ProdutoConsultaTratamento extends Produto{
	
	ProdutosConsulta produtoConsulta = new ProdutosConsulta();
	
	public String  setRetorno(String nome_produto){
		setNome_produto(nome_produto);
		
		String resultadosProdutos = produtoConsulta.consultarProdutos(nome_produto);
		
		return resultadosProdutos;
	}

}
