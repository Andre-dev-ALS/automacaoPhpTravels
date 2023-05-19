package br.com.phptravels.pages;

import br.com.phptravels.managers.FileReaderManager;
import br.com.phptravels.managers.WebDriverManager;

public class HomePage {
	
	
	
	public void navegarParaPaginaInicial() {
		WebDriverManager.getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	}
