package tasts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegiserationPage;

public class MyAccountTest extends TestBase {

	HomePage homeObject;
	UserRegiserationPage userRegiserationObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;

	String fName="Bosy";
	String lName="Samir";
	String email="bmmat86@gmail.com";
	String PD="123456";
	String Message="Your registration ";
	String newPD="12345678";
	String resultMessage= "Password was changed";

	@Test(priority = 1,alwaysRun=true)
	public void userRegisterSuccessully() throws InterruptedException {
		homeObject = new HomePage(testBaseDriver);
		homeObject.openRegisterationPage();
		userRegiserationObject = new UserRegiserationPage(testBaseDriver);
		userRegiserationObject.userRegisteration(fName, lName, email, PD);
		Assert.assertTrue(userRegiserationObject.successMsg.getText().contains(Message));
		System.out.println(userRegiserationObject.successMsg.getText());

	}
	@Test(dependsOnMethods = {"userRegisterSuccessully"} )
	public void registeredUserChangePassword() 
	{
		myAccountObject = new MyAccountPage(testBaseDriver);
		userRegiserationObject.userAccount();
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(PD, newPD);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains(resultMessage));
		System.out.println(myAccountObject.resultLbl.getText());
	}
	@Test(dependsOnMethods = {"registeredUserChangePassword"})
	public void registeredUserLogOut() throws InterruptedException {
		userRegiserationObject.userLogOut();	
	}

	@Test(priority = 4)
	public void registerdUserCanLogin() throws InterruptedException {
		loginObject = new LoginPage(testBaseDriver);
		homeObject.openLoginLink();
		loginObject.userLolginSuccessfully(email, newPD);
	}
}
