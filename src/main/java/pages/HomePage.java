package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		//jse= JavascripttExecutor ()
		actions = new Actions(driver);

	}

	@FindBy(linkText = "Register") WebElement RegisterLink;
	@FindBy(linkText = "Log in") WebElement logILink;
	@FindBy(linkText = "Contact us") WebElement contactUsLink; 
	@FindBy(id="customerCurrency") WebElement currencyeDropdownList;
	@FindBy (linkText = "Electronics") WebElement electronicsMenu;
	@FindBy(linkText = "Cell phones") WebElement CameraAndphotoMenu;
	public void openRegisterationPage() throws InterruptedException {

		Thread.sleep(1000);
		clickButton(RegisterLink);
	}

	public void openLoginLink() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(logILink);	
	}
	public void openContactUs() {
		//scrollToBottom();
		clickButton(contactUsLink);

	}
	public void changeCurrency() {
		select = new Select(currencyeDropdownList);
		select.selectByVisibleText("Euro");
	}
	public void selectCameraAndPhoto() {
		actions.moveToElement(electronicsMenu).moveToElement(CameraAndphotoMenu).click()
		.build().perform();
	}
}
