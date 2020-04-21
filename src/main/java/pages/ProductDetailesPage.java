package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailesPage extends ProductEmailaFriendPage{

	public ProductDetailesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[9]/div[3]/input") WebElement emailFrindBtn;
	@FindBy(css="span.price-value-37") public WebElement productPriceLbl;
	
	public void clickEmailFrind() {
		clickButton(emailFrindBtn);
	}
	


}
