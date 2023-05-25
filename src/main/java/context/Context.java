package context;

import org.openqa.selenium.WebDriver;

import config.Config;

public class Context {

	WebDriver driver = null;
	Config config = null;

	public void init(Config config) {
		if (config == null) {
			this.config = config;
		}
	}

	public void destroy() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

}
