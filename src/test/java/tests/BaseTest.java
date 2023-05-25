package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.BrowserLauncher;
import config.Config;
import context.Context;
import context.TestContext;
import pages.LoginPage;
import utils.FileUtil;

public class BaseTest {

	protected Config config;
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		init();
	}

	@AfterMethod
	public void tearDown() {
		TestContext.get().destroy();
		TestContext.remove();
	}

	private void init() {
		if (TestContext.get() == null) {
			config = FileUtil.readConfig();
			Context context = new Context();
			context.init(config);
			TestContext.set(context);
			driver = new BrowserLauncher().getDriver(this.config);
			TestContext.get().setDriver(driver);
		}
	}

	protected void login() {
		new LoginPage().login("standard_user", "secret_sauce");
	}

}
