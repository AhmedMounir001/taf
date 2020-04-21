package tasts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchTest extends TestBase{
	SearchPage searchObject;
	String productName0="Fahrenheit 451 by Ray Bradbury";
	String productName="Fahre";
	String productName2="Apple MacBook Pro 13-inch";
	
	
	@Test(priority = 1)
	public void useAutocompleteSearch() {
		searchObject = new SearchPage(testBaseDriver);
		searchObject.autocompleteSearch(productName);
		Assert.assertEquals(searchObject.currentItemElement.getText(), productName0);
	}
	
	@Test(priority = 2)
	public void useSearchBtn() {
		searchObject = new SearchPage(testBaseDriver);
		searchObject.searchBtnSearch(productName2);
		searchObject.openProductDetailsPage();
		searchObject.explicitWait("Apple");
		Assert.assertTrue(searchObject.currentItemElement.getText().equalsIgnoreCase(productName2));
		
	}

}
