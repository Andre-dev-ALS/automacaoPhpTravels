package br.com.phptravels.logic;

import br.com.phptravels.pages.HomePage;

public class DemonstracaoLogic {
	HomePage home;

	public String calcular() {
		home = new HomePage();
		int valor1 = 0, valor2 = 0;
		String resultado = "";

		valor1 = Integer.parseInt(home.getValor1());
		valor2 = Integer.parseInt(home.getValor2());
		resultado = Integer.toString(valor1 + valor2);
		return resultado;
	}
}