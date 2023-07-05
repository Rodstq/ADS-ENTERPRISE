package classesProdutos;

import java.util.List;

import controladores.ProdutosConsulta;

public class ProdutoConsultaTratamento extends Produto{
	
	ProdutosConsulta produtoConsulta = new ProdutosConsulta();
	
	public List<Object[]>  setRetorno(String nome_produto){
		setNome_produto(nome_produto);
		
		List<Object[]> resultadosProdutos = produtoConsulta.consultarProdutos(getNome_produto());
		
		return resultadosProdutos;
	}

}
