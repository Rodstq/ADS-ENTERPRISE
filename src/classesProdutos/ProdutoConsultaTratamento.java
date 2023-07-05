package classesProdutos;

import java.util.List;

import controladores.ProdutosConsulta;

public class ProdutoConsultaTratamento extends Produto{
	
	ProdutosConsulta produtoConsulta = new ProdutosConsulta();
	
	public String  setRetorno(String nome_produto){
		setNome_produto(nome_produto);
		
		String resultadosProdutos = produtoConsulta.consultarProdutos(nome_produto);
		
		return resultadosProdutos;
	}

}
