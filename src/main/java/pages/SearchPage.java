package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id="small-searchterms") WebElement searchStoreTxtBox;
	@FindBy (id="ui-id-1") List<WebElement> autoCompleateList;
	@FindBy(css="strong.current-item") public WebElement currentItemElement;
	@FindBy(css="input.button-1.search-box-button") WebElement searchBoxBtn;
	@FindBy(linkText = "Fahrenheit 451 by Ray Bradbury") WebElement Product1Link;
	@FindBy(linkText = "Apple MacBook Pro 13-inch") WebElement Product2Link;

	public void autocompleteSearch(String searchStoreValue) {
		setText(searchStoreTxtBox, searchStoreValue);
		//clickButton(autoCompleateList);
		autoCompleateList.get(0).click();
	}

	public void searchBtnSearch(String searchStoreValue) {
		setText(searchStoreTxtBox, searchStoreValue);
		clickButton(searchBoxBtn);
	}
	public void openProductDetailsPage() 
	{		clickButton(Product2Link);

	}
	public void explicitWait(String Condition) {
		WebDriverWait wait= new WebDriverWait(pDriver, 10);
		wait.until(ExpectedConditions.titleContains(Condition));
	}


}
