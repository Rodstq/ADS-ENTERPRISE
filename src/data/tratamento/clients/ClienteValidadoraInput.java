package data.tratamento.clients;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import utils.Validadora.dadoInserido;

public class ClienteValidadoraInput extends PlainDocument{
	
	public enum dadoInserido{
		nomeCliente, cpfCliente, nascimentoCliente, telefoneCliente,
		estadoCliente, cidadeCliente, bairroCliente, cepCliente, ruaCliente,
		descricaoCliente;
	};
	
	private int qtdCaracteres;
	private dadoInserido dadoEntrada;
	
	
	
	public ClienteValidadoraInput(int qtdCaracteres, dadoInserido dadoEntrada) {
		this.qtdCaracteres = qtdCaracteres;
		this.dadoEntrada = dadoEntrada;
	}



	@Override
	public void insertString(int i, String str, AttributeSet a) throws BadLocationException {
		
		if (str == null || getLength() == qtdCaracteres) {
			return;
		}
		int totalCarac = getLength() + str.length();
		
		String regex = "";			
		switch (dadoEntrada) {
			case nomeCliente: regex = "[^\\p{IsLatin} ]"; break;
			case cpfCliente: regex = "[^0-9]"; break;
			case nascimentoCliente: regex = "[^0-9]"; break;
			case telefoneCliente: regex = "[^0-9/]"; break;
			case estadoCliente: regex = "[^\\p{IsLatin} ]"; break;
			case cidadeCliente: regex = "[^\\p{IsLatin} ]"; break;
			case bairroCliente: regex = "[^\\p{IsLatin} ]"; break;
			case cepCliente: regex = "[^0-9]"; break;
			case ruaCliente: regex = "[^\\p{IsLatin} ]"; break;
			case descricaoCliente: regex = "[^\\p{IsLatin} ]"; break;
		}
		str = str.replaceAll(regex, "");
		
		if (totalCarac<=qtdCaracteres) {
			super.insertString(i, str, a);
		} else {
			String nova = str.substring(0, qtdCaracteres);
			super.insertString(i, str, a);
		}
		
		
		
	}
	
}
