package br.com.phptravels.managers;

import br.com.phptravels.pages.HomePage;

public class PageObjectManager {

	private static PageObjectManager PageObjectManager = new PageObjectManager();
	private static HomePage homePage;


	
public static PageObjectManager getPageObjectManager() {
return PageObjectManager;
}
	
	
	public static HomePage getHomePage() {

		return (homePage == null) ? homePage = new HomePage() : homePage;

	}

}
