package br.com.phptravels.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.managers.WebDriverManager;
import br.com.phptravels.utilities.Espera;
import br.com.phptravels.utilities.Page;

public class HomePage extends Page {
	@FindBy(xpath = "//input[@name='first_name' and @placeholder='First Name']")
	WebElement txtNome;

	@FindBy(xpath = "//input[@name='last_name' and @placeholder='Last Name']")
	WebElement txtSobreNome;

	@FindBy(xpath = "//input[@name='business_name' and @placeholder='Business Name']")
	WebElement txtNomeDaEmpresa;

	@FindBy(xpath = "//input[@name='email' and @placeholder='Email']")
	WebElement txtEmail;

	@FindBy(id = "demo")
	WebElement btmEnviar;

	@FindBy(id = "numb1")
	WebElement tempValor1;

	@FindBy(id = "numb2")
	WebElement tempValor2;

	@FindBy(id = "number")
	WebElement txtResultado;

	@FindBy(className = "text-center cw")
	WebElement lblMensagemBemSucedida;

	public HomePage() {
		PageFactory.initElements(WebDriverManager.getDriver(), this);
	}

	public void navegarParaPaginaInicial() {
		WebDriverManager.getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void preencherCampoNome(String nome) {
		Espera.esperarElemento(txtNome);

		escrever(txtNome, nome);
	}

	public void preencherCampoSobrenome(String sobrenome) {
		Espera.esperarElemento(txtSobreNome);
		escrever(txtSobreNome, sobrenome);
	}

	public void preencherCampoNomeDaEmpresa(String nomeDaEmpresa) {
		Espera.esperarElemento(txtNomeDaEmpresa);
		escrever(txtNomeDaEmpresa, nomeDaEmpresa);
	}

	public void preencherCampoEmail(String email) {
		Espera.esperarElemento(txtEmail);
		escrever(txtEmail, email);
	}

	public void clicarBotaoEnviar() {
		Espera.esperarElemento(btmEnviar);
		clicarBotao(btmEnviar);
	}

	public String getValor1() {
		return tempValor1.getText();
	}

	public String getValor2() {
		return tempValor2.getText();
	}

	public void preencherCampoResultado(String resultado) {
		Espera.esperarElemento(txtResultado);
		escrever(txtResultado, resultado);
	}

	public void getMensagemSucesso() {
		// Espera.esperarElemento(lblMensagemBemSucedida);
		if (lblMensagemBemSucedida.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}
}