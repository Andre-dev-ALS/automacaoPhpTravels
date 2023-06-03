package br.com.phptravels.logic;

import static br.com.phptravels.utilities.Context.getWait;
import static br.com.phptravels.utilities.Context.getWebActions;
import static br.com.phptravels.utilities.Context.getWebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.pages.HomePage;
import br.com.phptravels.utilities.WaitActions;
import br.com.phptravels.utilities.WebActions;

public class HomePageLogic {
	private WebDriver driver;
	private WaitActions espera;
	private WebActions acaoWeb;
	private HomePage home;

	public HomePageLogic() {
		driver = getWebDriverManager().getDriver();
		espera = getWait();
		acaoWeb = getWebActions();
		home = new HomePage(driver);
	}

	public void navegarParaPaginaInicial() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void preencherCampoNome(String nome) {
		acaoWeb.escrever(home.getTxtNome(), nome, 0);
	}

	public void preencherCampoSobrenome(String sobrenome) {
		acaoWeb.escrever(home.getTxtSobreNome(), sobrenome);
	}

	public void preencherCampoNomeDaEmpresa(String nomeDaEmpresa) {
		acaoWeb.escrever(home.getTxtNomeDaEmpresa(), nomeDaEmpresa);
	}

	public void preencherCampoEmail(String email) {
		acaoWeb.escrever(home.getTxtEmail(), email);
	}

	public void preencherCampoResultado() {
		int valor1 = Integer.parseInt(home.getTempValor1().getText());
		int valor2 = Integer.parseInt(home.getTempValor2().getText());
		String resultado = Integer.toString(valor1 + valor2);

		acaoWeb.escrever(home.getTxtResultado(), resultado);
	}

	public void clicarBotaoEnviar() {
		acaoWeb.clicarBotao(home.getBtmEnviar(), 0);
	}

	public void getMensagemSucesso() {
		espera.waitForElementToBeVisible(home.getLblMensagemBemSucedida(), 2);
		Assert.assertTrue(home.getLblMensagemBemSucedida().isDisplayed());
	}

}
