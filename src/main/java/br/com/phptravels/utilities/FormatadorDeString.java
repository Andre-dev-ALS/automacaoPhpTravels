package br.com.phptravels.utilities;

public class FormatadorDeString {

	public static String formatarString(String texto, String caractereSubstituido, String novoCaractere) {
		String textoFormatado = texto.replaceAll(caractereSubstituido, novoCaractere);
		return textoFormatado;
	}
}
