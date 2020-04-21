package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductEmailaFriendPage extends PageBase{

	public ProductEmailaFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FriendEmail") WebElement friendEmailTxtsBox;
	@FindBy(id="PersonalMessage") WebElement personalMessageTxtsBox;
	@FindBy(css="input.button-1.send-email-a-friend-button") WebElement sendEmailBtn;

	@FindBy(css="div.result") public WebElement resultEmail;
	
	public void emailProductToFrind(String frindEmailValue,String  personalMessageValue) {
		setText(friendEmailTxtsBox, frindEmailValue);
		setText(personalMessageTxtsBox, personalMessageValue);
		clickButton(sendEmailBtn);
	}

}
