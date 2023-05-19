package br.com.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.managers.WebDriverManager;
import br.com.phptravels.utilities.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//input[@placeholder='First Name' and @name ='first_name']")
	WebElement txtNome;

	public void navegarParaPaginaInicial() {
		WebDriverManager.getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void preencherCampoNome() {
		escrever(txtNome, "oi");
	}
}
