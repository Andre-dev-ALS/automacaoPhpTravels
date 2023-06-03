package br.com.phptravels.utilities;

public class StringFormatter {

	public static String formatString(String texto, String caractereSubstituido, String novoCaractere) {
		String textoFormatado = texto.replaceAll(caractereSubstituido, novoCaractere);
		return textoFormatado;
	}
}
