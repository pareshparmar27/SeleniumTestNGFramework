package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

	@FindBy(css = ".title")
	private WebElement title;

	@FindBy(css = "[data-test='product_sort_container']")
	private WebElement productSortContainer;

	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productNameList;

	@FindBy(css = ".inventory_item_price")
	private List<WebElement> productPriceList;

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuButton;

	@FindBy(css = ".menu-item")
	private List<WebElement> menuItems;

	public boolean isProductsTitleVisible() {
		return title.getText().equalsIgnoreCase("PRODUCTS");
	}

	public void sort(String text) {
		Select sort = new Select(productSortContainer);
		sort.selectByVisibleText(text);
	}

	public List<String> getProductNames() {
		List<String> list = new ArrayList<String>();
		productNameList.forEach(name -> {
			list.add(name.getText());
		});
		return list;
	}

	public List<Integer> getProductsPrice() {
		List<Integer> list = new ArrayList<Integer>();
		productPriceList.forEach(price -> {
			list.add(Integer.parseInt(price.getText().replaceAll("[$.]", "")));
		});
		return list;
	}

	public void logout() {
		menuButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(menuItems));
		menuItems.forEach(menu -> {
			if (menu.getText().equalsIgnoreCase("LOGOUT")) {
				menu.click();
			}
		});
	}

}
