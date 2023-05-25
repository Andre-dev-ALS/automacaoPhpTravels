package br.com.phptravels.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.phptravels.managers.WebDriverManager;

public class Espera {
	private static WebDriverWait WAIT;

	public static void esperarElementoSerVisivel(WebElement elemento) {

		try {
			WebDriverManager.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar a página");
		}

		try {
			WAIT = new WebDriverWait(WebDriverManager.getDriver(), 30);
			WAIT.until(ExpectedConditions.visibilityOf(elemento));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("O elemento da página não foi encontrado");
		}
	}

	public static void esperarAlertaAparecer() {
		try {
			WebDriverManager.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar a página");
		}

		try {
			WAIT = new WebDriverWait(WebDriverManager.getDriver(), 30);
			WAIT.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("O alerta não está presente");
		}

	}

	public static void esperarBotaoSerClicado(WebElement elemento) {
		try {
			WebDriverManager.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar a página");
		}

		try {
			WAIT = new WebDriverWait(WebDriverManager.getDriver(), 30);
			WAIT.until(ExpectedConditions.elementToBeClickable(elemento));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("O botão não pôde ser clicado");
		}

	}

}
