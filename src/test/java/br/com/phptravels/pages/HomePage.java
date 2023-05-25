package br.com.phptravels.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.managers.WebDriverManager;
import br.com.phptravels.utilities.Espera;
import br.com.phptravels.utilities.Dsl;

public class HomePage extends Dsl {
	@FindBy(xpath = "//input[@name='first_name' and @placeholder='First Name']")
	private WebElement txtNome;

	@FindBy(xpath = "//input[@name='last_name' and @placeholder='Last Name']")
	private WebElement txtSobreNome;

	@FindBy(xpath = "//input[@name='business_name' and @placeholder='Business Name']")
	private WebElement txtNomeDaEmpresa;

	@FindBy(xpath = "//input[@name='email' and @placeholder='Email']")
	private WebElement txtEmail;

	@FindBy(id = "demo")
	private WebElement btmEnviar;

	@FindBy(id = "numb1")
	private WebElement tempValor1;

	@FindBy(id = "numb2")
	private WebElement tempValor2;

	@FindBy(id = "number")
	private WebElement txtResultado;

	@FindBy(xpath = "//strong[contains(text(), 'Thank you!')]")
	private WebElement lblMensagemBemSucedida;

	public HomePage() {
		PageFactory.initElements(WebDriverManager.getDriver(), this);
	}

	public void navegarParaPaginaInicial() {
		WebDriverManager.getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void preencherCampoNome(String nome) {
		escrever(txtNome, nome);
	}

	public void preencherCampoSobrenome(String sobrenome) {
		escrever(txtSobreNome, sobrenome);
	}

	public void preencherCampoNomeDaEmpresa(String nomeDaEmpresa) {
		escrever(txtNomeDaEmpresa, nomeDaEmpresa);
	}

	public void preencherCampoEmail(String email) {
		escrever(txtEmail, email);
	}

	public void clicarBotaoEnviar() {
		clicarBotao(btmEnviar);
	}

	public void preencherCampoResultado() {
		int valor1 = Integer.parseInt(tempValor1.getText());
		int valor2 = Integer.parseInt(tempValor2.getText());
		String resultado = Integer.toString(valor1 + valor2);

		escrever(txtResultado, resultado);
	}

	public void getMensagemSucesso() {
		Espera.esperarElementoSerVisivel(lblMensagemBemSucedida);
		Assert.assertTrue(lblMensagemBemSucedida.isDisplayed());
	}
}