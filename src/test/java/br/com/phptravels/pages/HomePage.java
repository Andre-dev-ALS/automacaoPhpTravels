package br.com.phptravels.pages;

import static br.com.phptravels.utilities.Context.getWebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

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

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(getWebDriverManager().getDriver(), this);
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