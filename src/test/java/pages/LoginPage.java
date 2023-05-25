package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css = "[data-test='username']")
	private WebElement username;

	@FindBy(css = "[data-test='password']")
	private WebElement password;

	@FindBy(css = "[data-test='login-button']")
	private WebElement loginButton;

	@FindBy(css = "[data-test='error']")
	private WebElement loginError;

	@FindBy(css = ".error-button")
	private WebElement clearError;

	public void login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginButton.click();
	}

	public String getLoginError() {
		return loginError.getText();
	}

	public void clearLoginError() {
		clearError.click();
	}

}
