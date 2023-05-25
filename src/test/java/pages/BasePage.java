package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import context.TestContext;

public class BasePage {
	
	protected WebDriver driver = null;

	protected BasePage() {
		driver = TestContext.get().getDriver();
		PageFactory.initElements(driver, this);
	}

}
