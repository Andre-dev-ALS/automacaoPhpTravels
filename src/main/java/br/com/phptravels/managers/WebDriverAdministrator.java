package br.com.phptravels.managers;

import static br.com.phptravels.utilities.Context.getConfigFileReader;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.com.phptravels.enums.DriverType;
import br.com.phptravels.enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverAdministrator {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	public WebDriverAdministrator() {
		driverType = getConfigFileReader().getBrowser();
		environmentType = getConfigFileReader().getEnvironment();
	}

	public WebDriver getDriver() {

		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}

		if (getConfigFileReader().getBrowserWindowSize()) {
			driver.manage().window().maximize();
		}
driver.manage().timeouts().pageLoadTimeout(getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}