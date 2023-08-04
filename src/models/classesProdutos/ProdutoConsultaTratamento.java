package models.classesProdutos;

import controladores.Produtos.ProdutosConsulta;

public class ProdutoConsultaTratamento extends Produto{

	ProdutosConsulta produtoConsulta = new ProdutosConsulta();
<<<<<<< HEAD
	
	public String  setRetorno(String nome_produto) throws Exception{
=======

	public String  setRetorno(String nome_produto){
>>>>>>> 4ddb029a23ac4553828eb37006c12602628d1f2e
		setNome_produto(nome_produto);

		String resultadosProdutos = produtoConsulta.consultarProdutos();

		return resultadosProdutos;
	}

}
