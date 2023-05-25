package br.com.phptravels.utilities;

import java.util.ArrayList;

import io.cucumber.core.api.Scenario;

public class Context {
	private static String ID;

	public static String getId() {
		return ID;
	}

	public static void setId(Scenario cenario) {
		String idFormatado = "";

		ArrayList<String> ids = (ArrayList<String>) cenario.getSourceTagNames();
		for (int i = 0; i < ids.size(); i++) {
			idFormatado = FormatadorDeString.formatarString(ids.get(i), "@", "");
			ID = idFormatado;
		}

	}

	public static void limparId() {
		ID = "";
	}
}
