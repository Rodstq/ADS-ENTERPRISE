package data.tratamento.fornecedores;

import javax.swing.JTextField;

public class AtualizarFornecedorTratamento {
	
	

	
	
	public void checkBoxValidacao(boolean selected, JTextField TF) {
		if (selected) {
			TF.setEnabled(true);
			TF.setText("");
			} else {
				TF.setEnabled(false);
				TF.setText("desabilitado");
			}
	}

}
