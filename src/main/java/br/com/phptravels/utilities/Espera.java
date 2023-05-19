package br.com.phptravels.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.phptravels.managers.WebDriverManager;

public class Espera {
	static WebDriverWait wait;

	public static void esperarElemento(WebElement elemento) {

		try {
			WebDriverManager.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar a página");
		}

		try {
			wait = new WebDriverWait(WebDriverManager.getDriver(), 30);
			wait.until(ExpectedConditions.visibilityOf(elemento));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("O elemento da página não foi encontrado");
		}
	}

}
