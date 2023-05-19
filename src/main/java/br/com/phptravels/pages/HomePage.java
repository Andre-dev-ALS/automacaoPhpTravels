package br.com.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.managers.WebDriverManager;
import br.com.phptravels.utilities.Espera;
import br.com.phptravels.utilities.Page;

public class HomePage extends Page {
	@FindBy(name = "first_name")
	WebElement txtNome;

	public HomePage() {
		PageFactory.initElements(WebDriverManager.getDriver(), this);
	}

	public void navegarParaPaginaInicial() {
		WebDriverManager.getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void preencherCampoNome(String nome) {
		// executarJS("window.scrollBy(0, arguments[0])", txtNome.getLocation().y);
		Espera.esperarElemento(txtNome);

		escrever(txtNome, nome);
	}
}
