package br.com.phptravels.utilities;

import java.util.ArrayList;

import br.com.phptravels.managers.WebDriverManager;
import io.cucumber.core.api.Scenario;

public class Context {
	private static String id;
	private static WebDriverManager webDriverManager;
	private static WaitActions wait;
	private static WebActions webActions;

	public static String getId() {
		return id;
	}

	private static void setId(Scenario scenario) {
		String formattedId = "";

		ArrayList<String> ids = (ArrayList<String>) scenario.getSourceTagNames();
		for (int i = 0; i < ids.size(); i++) {
			formattedId = StringFormatter.formatString(ids.get(i), "@", "");
			id = formattedId;
		}

	}

	public static void clearId() {
		id = "";
	}

	public static WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	private static void setWebDriverManager() {
		webDriverManager = new WebDriverManager();
	}

	public static WaitActions getWait() {
		return wait;
	}

	private static void setWait() {
		wait = new WaitActions(webDriverManager.getDriver());
	}

	public static WebActions getWebActions() {
		return webActions;
	}

	private static void setWebActions() {
		webActions = new WebActions(webDriverManager.getDriver(), getWait());
	}

	public static void start(Scenario cenario) {
		setWebDriverManager();
		setId(cenario);
		setWait();
		setWebActions();
	}
}
