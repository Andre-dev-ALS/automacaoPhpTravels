package br.com.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.managers.WebDriverManager;
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
	private WebElement lblValor1;

	@FindBy(id = "numb2")
	private WebElement lblValor2;

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

	public WebElement getTxtNome() {
		return txtNome;
	}

	public WebElement getTxtSobreNome() {
		return txtSobreNome;
	}

	public WebElement getTxtNomeDaEmpresa() {
		return txtNomeDaEmpresa;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getBtmEnviar() {
		return btmEnviar;
	}

	public WebElement getTempValor1() {
		return lblValor1;
	}

	public WebElement getTempValor2() {
		return lblValor2;
	}

	public WebElement getTxtResultado() {
		return txtResultado;
	}

	public WebElement getLblMensagemBemSucedida() {
		return lblMensagemBemSucedida;
	}

}