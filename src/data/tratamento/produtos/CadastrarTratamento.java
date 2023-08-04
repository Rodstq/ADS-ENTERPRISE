package data.tratamento.produtos;

import java.sql.SQLException;

public class CadastrarTratamento {

	private String erro;


	public String verificaErro(String erro) {

		if(erro.contains("(`ads`.`produto`, CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`cnpj_fornecedor`) REFERENCES `fornecedor` (`cnpj_fornecedor`))")) {
			erro = " O cnpj é inexistente, registre-o ou verifique novamente";
		}else if (erro.contains("for key 'fornecedor.PRIMARY'")) {
			erro = " O CNPJ informado já existe, digite novamente";
		}else if (erro.contains("Duplicate entry")){
			erro = " O id informado já pertence a um produto, digite novamente";
		} else if (erro.contains("Cnpj menor que 14")) {
			erro = "O Cnpj não pode ser menor que 14";
		}
		return erro;
	}

	public String getErroCadastrar() {
		return this.erro;
	}

	public void verificarVazios(String id, String nome, String cnpj, String valor, String id_estoque, String quantidade) throws Exception {
		if(id.isBlank() || nome.isBlank() || cnpj.isBlank() || valor.isBlank() || id_estoque.isBlank()|| quantidade.isBlank()) {
			throw new Exception();
		}
	}

	public void verificarVaziosFornecedor(String cnpj, String nome) throws Exception {
		if(cnpj.isBlank() || nome.isBlank()) {
			throw new Exception();
		}
	}

	public String lancarException(CadastrarTratamento verificar, String erro) throws Exception {
		System.out.println(" ============" + erro);
		verificar.verificaErro(erro);
		this.erro = verificar.verificaErro(erro);
		throw new SQLException();

	}

}
