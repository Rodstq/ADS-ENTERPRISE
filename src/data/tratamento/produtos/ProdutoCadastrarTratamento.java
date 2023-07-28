package data.tratamento.produtos;

import javax.swing.JOptionPane;

public class ProdutoCadastrarTratamento {
	
	private String erro;
	private String messageCnpjInexistente;
	
	public String verificaErro(String erro) {
		
		if(erro.contains("Cannot add or update a child row: a foreign key constraint fails (`ads`.`produto`, CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`cnpj_fornecedor`) REFERENCES `fornecedor` (`cnpj_fornecedor`))")) {
			erro = "Cnpj inexistente, registre-o ou verifique novamente";
		}else if (erro.contains("Duplicate entry")){
			erro = "Id informado já pertence a um produto, digite novamente";
		}
		return erro;
	}

	public String getErroCadastrar() {
		return this.erro;
	}
	
	public void verificarVazios(String id, String nome, String cnpj, String valor, int id_estoque) throws Exception {
		if(id.isBlank() || nome.isBlank() || cnpj.isBlank() || valor.isBlank() || Integer.toString(id_estoque).isBlank()) {
			throw new Exception();
		}		
	}
}
