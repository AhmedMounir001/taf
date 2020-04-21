package tasts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegiserationPage;

public class UserRegisterationTestWithDDTAndExcelFile extends TestBase
{
	HomePage homeObject;
	UserRegiserationPage userRegiserationObject;
	LoginPage loginObject;

	String fName="Bosy";
	String lName="Samir";
	String email="bm1683@gmail.com";
	String PD="123456";
	String Message="Your registration ";

	@DataProvider(name="ExcelData")
	public Object [][] userRegisteration() throws IOException
	{
		//Get data from excel reader class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}


	@Test(priority = 1,alwaysRun=true,dataProvider = "ExcelData")
	public void userRegisterSuccessully(String firstName,String lastName,
			String email,String PW) throws InterruptedException {
		testBaseDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		homeObject = new HomePage(testBaseDriver);
		homeObject.openRegisterationPage();
		userRegiserationObject = new UserRegiserationPage(testBaseDriver);
		Thread.sleep(1000);
		userRegiserationObject.userRegisteration(firstName,lastName,email,PW);
		//Assert.assertTrue(userRegiserationObject.successMsg.getText().contains(Message));
		System.out.println(userRegiserationObject.successMsg.getText());
		testBaseDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		userRegiserationObject.userLogOut();	
		
		testBaseDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homeObject.openLoginLink();
		loginObject = new LoginPage(testBaseDriver);
		loginObject.userLolginSuccessfully(email, PW);
	}

}
