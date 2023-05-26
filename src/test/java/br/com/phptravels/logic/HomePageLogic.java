package br.com.phptravels.logic;

import org.junit.Assert;

import br.com.phptravels.pages.HomePage;
import br.com.phptravels.utilities.Dsl;
import br.com.phptravels.utilities.Espera;

public class HomePageLogic extends Dsl {

	private HomePage home;

	public HomePageLogic() {
		home = new HomePage();
	}

	public void preencherCampoNome(String nome) {
		escrever(home.getTxtNome(), nome);
	}

	public void preencherCampoSobrenome(String sobrenome) {
		escrever(home.getTxtSobreNome(), sobrenome);
	}

	public void preencherCampoNomeDaEmpresa(String nomeDaEmpresa) {
		escrever(home.getTxtNomeDaEmpresa(), nomeDaEmpresa);
	}

	public void preencherCampoEmail(String email) {
		escrever(home.getTxtEmail(), email);
	}

	public void preencherCampoResultado() {
		int valor1 = Integer.parseInt(home.getTempValor1().getText());
		int valor2 = Integer.parseInt(home.getTempValor2().getText());
		String resultado = Integer.toString(valor1 + valor2);

		escrever(home.getTxtResultado(), resultado);
	}

	public void clicarBotaoEnviar() {
		clicarBotao(home.getBtmEnviar());
	}

	public void getMensagemSucesso() {
		Espera.esperarElementoSerVisivel(home.getLblMensagemBemSucedida());
		Assert.assertTrue(home.getLblMensagemBemSucedida().isDisplayed());
	}

}
