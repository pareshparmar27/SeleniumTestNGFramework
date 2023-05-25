package config;

import static org.openqa.selenium.firefox.FirefoxDriver.SystemProperty.BROWSER_LOGFILE;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher {

	WebDriver driver;

	public WebDriver getDriver(Config config) {
		switch (BrowserTypes.valueOf(config.getBrowser().toUpperCase())) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(BROWSER_LOGFILE, "/dev/null");
			driver = new FirefoxDriver();
			driver.get(config.getApplication());
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();
			driver.get(config.getApplication());
			break;
		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.get(config.getApplication());
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(config.getApplication());
			break;
		case SAFARI:
			// TODO:
			break;
		default:
			throw new IllegalArgumentException(
					String.format("%s browser is not valid please provide valid browser name", config.getBrowser()));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}

}
