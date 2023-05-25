package br.com.phptravels.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.com.phptravels.enums.DriverType;
import br.com.phptravels.enums.EnvironmentType;

public class WebDriverManager {
	private static WebDriverManager WEB_DRIVER_MANAGER = new WebDriverManager();
	private static WebDriver DRIVER;
	private static DriverType DRIVER_TYPE;
	private static EnvironmentType ENVIRONMENT_TYPE;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	private WebDriverManager() {
		DRIVER_TYPE = FileReaderManager.getInstance().getConfigReader().getBrowser();
		ENVIRONMENT_TYPE = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public static WebDriverManager getWebDriverManager() {
		return WEB_DRIVER_MANAGER;
	}

	public static WebDriver getDriver() {
		if (DRIVER == null)
			DRIVER = createDriver();
		return DRIVER;
	}

	private static WebDriver createDriver() {
		switch (ENVIRONMENT_TYPE) {
		case LOCAL:
			DRIVER = createLocalDriver();
			break;
		case REMOTE:
			DRIVER = createRemoteDriver();
			break;
		}
		return DRIVER;
	}

	private static WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private static WebDriver createLocalDriver() {
		switch (DRIVER_TYPE) {
		case FIREFOX:
			DRIVER = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			DRIVER = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			DRIVER = new InternetExplorerDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			DRIVER.manage().window().maximize();
		DRIVER.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return DRIVER;
	}

	public static void closeDriver() {
		DRIVER.close();
		DRIVER.quit();
	}

}