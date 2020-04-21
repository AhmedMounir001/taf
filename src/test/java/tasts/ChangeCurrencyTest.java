package tasts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailesPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ProductDetailesPage ProductDetailesObject;
	SearchPage searchObject;
	String productName0="Fah";
	String productPrice="23.22";
	
	@Test(priority = 1)
	public void userCanChangeCurrency() {
		homeObject = new HomePage(testBaseDriver);
		homeObject.changeCurrency();
	}
	
	@Test(priority = 2)
	public void useAutocompleteSearch() {
		searchObject = new SearchPage(testBaseDriver);
		ProductDetailesObject = new ProductDetailesPage(testBaseDriver);
		searchObject.autocompleteSearch(productName0);
		//Assert.assertEquals(ProductDetailesObject.productPriceLbl.getText(), productPrice);
		Assert.assertTrue(ProductDetailesObject.productPriceLbl.getText().contains(productPrice));
	}
	


}
