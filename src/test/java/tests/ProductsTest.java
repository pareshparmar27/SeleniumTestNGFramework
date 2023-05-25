package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import pages.ProductsPage;

public class ProductsTest extends BaseTest {

	ProductsPage productsPage;

	@Test
	public void productsNameAscendingOrder() {
		login();
		productsPage = new ProductsPage();
		productsPage.sort("Name (A to Z)");

		boolean sorted = Ordering.natural().isOrdered(productsPage.getProductNames());

		assertThat("the products name in ascending order", sorted, is(true));
	}

	@Test
	public void productsNameDescendingOrder() {
		login();
		productsPage = new ProductsPage();
		productsPage.sort("Name (Z to A)");

		boolean reverseSorted = Ordering.natural().reverse().isOrdered(productsPage.getProductNames());

		assertThat("the products name in descending order", reverseSorted, is(true));
	}

	@Test
	public void productsPriceAscendingOrder() {
		login();
		productsPage = new ProductsPage();
		productsPage.sort("Price (low to high)");

		boolean sorted = Ordering.natural().isOrdered(productsPage.getProductsPrice());

		assertThat("the products price in ascending order", sorted, is(true));
	}

	@Test
	public void productsPriceDescendingOrder() {
		login();
		productsPage = new ProductsPage();
		productsPage.sort("Price (high to low)");

		boolean sorted = Ordering.natural().reverse().isOrdered(productsPage.getProductsPrice());

		assertThat("the products price in descending order", sorted, is(true));
	}

}
