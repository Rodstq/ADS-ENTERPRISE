package data.tratamento.produtos;

import javax.swing.JTextField;

public class AtualizarTratamento {
	
	
	public void verificarVazios(String id, String nome, String cnpj, String valor, String quantidade, boolean ativos) throws Exception {
		if (id.isBlank() || (ativos && (nome.isBlank() || cnpj.isBlank() || valor.isBlank() || quantidade.isBlank()))) {
			throw new Exception("Existem campos em branco, preencha-os");
		} else if (!id.isBlank() && !ativos) {
			throw new Exception("Nenhum dado a atualizar selecionado");
		}
	}

	public boolean retornarAtivos(boolean nome,boolean cnpj,boolean valor,boolean quantidade) {
		
		if(nome || cnpj || valor || quantidade) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void checkBoxValidacao(boolean selected, JTextField TF) {
		if (selected) {
			TF.setEnabled(true);
			TF.setText("");
			} else {
				TF.setEnabled(false);
			}
	}
	
	
	public void verificarVaziosFornecedor(String cnpjID,String nome,  boolean ativos) throws Exception {
		if (cnpjID.isBlank() || (ativos && nome.isBlank())) {
			throw new Exception("Existem campos em branco, preencha-os");
		} else if (!cnpjID.isBlank() && !ativos) {
			throw new Exception("Nenhum dado a atualizar selecionado");
		}
	}
	
	public boolean retornarAtivosFornecedor(boolean nome) {
		
		if(nome) {
			return true;
		} else {
			return false;
		}
		
	}
}
