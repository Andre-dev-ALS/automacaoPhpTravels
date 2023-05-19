package br.com.phptravels.utilities;

import java.util.ArrayList;

import io.cucumber.core.api.Scenario;

public class Context {
	private static String id;

	public static String getId() {

	return id;
	}

	public static void setId(Scenario cenario) {
		String idFormatado = "";

		ArrayList<String> ids = (ArrayList<String>) cenario.getSourceTagNames();
		for (int i = 0; i < ids.size(); i++) {
			idFormatado = FormatadorDeString.formatarString(ids.get(i), "@", "");
			id = idFormatado;
		}

	}
	
	
	public static void limparId() {
		id = "";
	}
}
