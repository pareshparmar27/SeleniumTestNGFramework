package tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	ProductsPage productsPage;

	@Test(dataProvider = "ValidCreds")
	public void successfullLogin(String username, String password) {
		loginPage = new LoginPage();
		loginPage.login(username, password);
		productsPage = new ProductsPage();
		
		assertThat("login is successfull", productsPage.isProductsTitleVisible(), is(true));
	}

	@Test(dataProvider = "InvalidCreds")
	public void unsuccessfullLogin(String username, String password) {
		loginPage = new LoginPage();
		loginPage.login(username, password);
		
		assertThat("login is unsuccessfull", loginPage.getLoginError(), containsString("Username and password do not match any user in this service"));
	}

	@DataProvider(name = "ValidCreds")
	public Object[][] getValidLoginData() {
		return new Object[][] 
				{ 
					{ "standard_user", "secret_sauce" } 
				};
	}

	@DataProvider(name = "InvalidCreds")
	public Object[][] getInvalidLoginData() {
		return new Object[][] 
				{ 
					{ "general_user", "secret_sauce" }, 
					{ "standard_user", "public_sauce" } 
				};
	}

}
