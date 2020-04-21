package pages;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver pDriver;
	public static Select select;
	public JavascriptExecutor jse;
	static List<WebElement> listElement;
	public Actions actions;

	//Create Constructor 
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button)
	{ button.click();}

	protected static void setText(WebElement textElement, String value)
	{
		//textElement.clear();
		textElement.sendKeys(value);		
	}

	public void scrollToBottom() {
		jse.executeScript("scrollBy(0,250)");
	}
	/*protected static void selectFromList(WebElement texElement) {
		listElement.get(0).click();
	}*/

	/*private boolean isElementPresnt(By by)
	{
		try {
			pDriver.findElement(by);
			return true;
			
		} catch (NoSuchElementException e) {
			return false;
		}
	}*/
	public void explicitWait(String Condition) {
		WebDriverWait wait= new WebDriverWait(pDriver, 1);
		wait.until(ExpectedConditions.titleContains(Condition));
	}
}
