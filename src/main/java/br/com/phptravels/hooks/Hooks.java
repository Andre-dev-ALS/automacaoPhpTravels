package br.com.phptravels.hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.phptravels.managers.WebDriverManager;
import br.com.phptravels.utilities.Context;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void inicializar(Scenario cenario) {
		Context.setId(cenario);
	}

	@After
	public void finalizar(Scenario scenario) {

		File imagens = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String data = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
		String mensagem;
		if (scenario.isFailed()) {
			mensagem = "Falhou";
		} else {
			mensagem = "Passou";
		}
		try {
			String pastaImagens = new File("").getAbsolutePath() + "/evidencias/";
			FileUtils.copyFile(imagens,
					new File(pastaImagens + scenario.getName() + "-" + data + "-" + mensagem + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Context.limparId();
		WebDriverManager.closeDriver();
	}
}