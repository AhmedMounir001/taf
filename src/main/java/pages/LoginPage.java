package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="Email") WebElement emailTextBox;
	@FindBy(id="Password") WebElement PasswordTwxtBox;
	@FindBy(css="input.button-1.login-button") WebElement loginBtn;
	
	public void userLolginSuccessfully(String emailValue, String passwordValue) {
		setText(emailTextBox, emailValue );
		setText(PasswordTwxtBox, passwordValue);
		clickButton(loginBtn);
		
	}
}
