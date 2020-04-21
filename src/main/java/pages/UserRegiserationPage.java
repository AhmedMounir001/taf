package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegiserationPage extends PageBase{

	public UserRegiserationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="gender-female") WebElement femalGenderRadioBtn;
	@FindBy(id="gender-male") WebElement malGenderRadoBtn;
	@FindBy(id="FirstName") WebElement firstNameTxt;
	@FindBy(id="LastName") WebElement lastNameTxt;
	@FindBy(name ="DateOfBirthDay") WebElement selectDayDropList;
	@FindBy(name ="DateOfBirthMonth") WebElement selectMonthDropList;
	@FindBy(name ="DateOfBirthYear") WebElement selectYearDropList;
	@FindBy(id="Email") WebElement emailTxt;
	@FindBy(id="Password") WebElement passwordTxt;
	@FindBy(id="ConfirmPassword") WebElement confirmPasswordTxt;
	@FindBy(id="register-button") WebElement registerBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/form/div/div[2]/div[1]") 
	public WebElement successMsg;
	@FindBy(partialLinkText = "Log out") 
	WebElement logOutLink;
	@FindBy (linkText = "My account") WebElement myAccountLink;

	
	public void userRegisteration(String firstNameValue,String lastNameValue,
			                      String emailValue,String passwordValue) throws InterruptedException {
		
		clickButton(femalGenderRadioBtn);
		
		setText(firstNameTxt, firstNameValue);
		Thread.sleep(3000);
		setText(lastNameTxt, lastNameValue);
		setText(emailTxt, emailValue);
		setText(passwordTxt, passwordValue);
		setText(confirmPasswordTxt, passwordValue);
		//selectDayDropList.click();
		//Select xx88 = new Select(selectDayDropList);
		//xx88.deselectByValue("1");	
		clickButton(registerBtn);
	}
	
	public void userLogOut() throws InterruptedException  {

		
		Thread.sleep(1000);
		clickButton(logOutLink);
	}
	
	public void userAccount() {

		clickButton(myAccountLink);
		
	}
}
