package tasts;



import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

import pages.UserRegiserationPage;

import java.util.concurrent.TimeUnit;

import tasts.TestBase;

public class UserRegisterationTest extends TestBase{
	HomePage homeObject;
	UserRegiserationPage userRegiserationObject;
	LoginPage loginObject;

	String fName="Bosy";
	String lName="Samir";
	String email="اfdsfcgfgfg@gmail.com";
	String PD="123456";
	String Message="Your registration ";

	@Test(priority = 1,alwaysRun=true)
	public void userRegisterSuccessully() throws InterruptedException {
		homeObject = new HomePage(testBaseDriver);
		//homeObject = new HomePage(testBaseDriver);
		homeObject.openRegisterationPage();
		userRegiserationObject = new UserRegiserationPage(testBaseDriver);
		userRegiserationObject.userRegisteration("hdfgddbd", lName, email, PD);
		//userRegiserationObject.userRegisteration(fName, lName, email, PD);
		//Assert.assertTrue(userRegiserationObject.successMsg.getText().contains(Message));
		System.out.println(userRegiserationObject.successMsg.getText());

	}

	@Test(priority = 2)
	public void registeredUserLogOut() throws InterruptedException {
		testBaseDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		WebDriverWait wait= new WebDriverWait(testBaseDriver, 5);
//		wait.until(ExpectedConditions.elementToBeClickable(locator);
		userRegiserationObject.userLogOut();	
	}

	@Test(priority = 3)
	public void registerdUserCanLogin() throws InterruptedException {
		testBaseDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homeObject.openLoginLink();
		loginObject = new LoginPage(testBaseDriver);
		loginObject.userLolginSuccessfully(email, PD);
	}
}
