package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Validadora extends PlainDocument{

	public enum dadoInserido{
		nome,email,data,numeroInt,numeroDouble,dadoLivre;
	}

	private int qtdCaracteres;
	private dadoInserido dadoEntrada;



	public Validadora(int qtdCaracteres, dadoInserido dadoEntrada) {
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
			case nome: regex = "[^\\p{IsLatin} ]"; break;
			case email: regex = "[^\\p{IsLatin}@.\\-_][^0-9]"; break;
			case numeroInt: regex = "[^0-9]"; break;
			case numeroDouble: regex = "[^0-9/]"; break;
			case dadoLivre: regex = "[^\\p{IsLatin}@. ][^0-9]"; break;
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
