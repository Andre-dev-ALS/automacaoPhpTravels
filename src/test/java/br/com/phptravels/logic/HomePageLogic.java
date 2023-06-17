package br.com.phptravels.logic;

import static br.com.phptravels.utilities.Context.getConfigFileReader;
import static br.com.phptravels.utilities.Context.getWait;
import static br.com.phptravels.utilities.Context.getWebActions;
import static br.com.phptravels.utilities.Context.getWebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.phptravels.model.HomePageModel;
import br.com.phptravels.pages.HomePage;
import br.com.phptravels.utilities.WaitActions;
import br.com.phptravels.utilities.WebActions;

public class HomePageLogic {
	private WebDriver driver;
	private WaitActions espera;
	private WebActions acaoWeb;
	private HomePage home;
	private HomePageModel dadosPessoais;

	public HomePageLogic() {
		driver = getWebDriverManager().getDriver();
		espera = getWait();
		acaoWeb = getWebActions();
		home = new HomePage();
		dadosPessoais = new HomePageModel();
	}

	public void navegarParaPaginaInicial() {
		driver.get(getConfigFileReader().getApplicationUrl());
	}

	public void preencherCampoNome() {
		acaoWeb.write(home.getTxtNome(), dadosPessoais.getNome());
	}

	public void preencherCampoSobrenome() {
		acaoWeb.write(home.getTxtSobreNome(), dadosPessoais.getSobreNome());
	}

	public void preencherCampoNomeDaEmpresa() {
		acaoWeb.write(home.getTxtNomeDaEmpresa(), dadosPessoais.getNomeDaEmpresa());
	}

	public void preencherCampoEmail() {
		acaoWeb.write(home.getTxtEmail(), dadosPessoais.getEmail());
	}

	public void preencherCampoResultado() {
		int valor1 = Integer.parseInt(home.getLblValor1().getText());
		int valor2 = Integer.parseInt(home.getLblValor2().getText());
		String resultado = Integer.toString(valor1 + valor2);

		acaoWeb.write(home.getTxtResultado(), resultado);
	}

	public void clicarBotaoEnviar() {
		acaoWeb.clickButton(home.getBtmEnviar(), 0);
	}

	public void getMensagemSucesso() {
		espera.waitForElementToBeVisible(home.getLblMensagemBemSucedida(), 2);
		Assert.assertTrue(home.getLblMensagemBemSucedida().isDisplayed());
	}

}
