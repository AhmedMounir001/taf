package tasts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegiserationPage;

public class UserRegisterationTestWithDDTAndDataProvider extends TestBase
{
	HomePage homeObject;
	UserRegiserationPage userRegiserationObject;
	LoginPage loginObject;

	String fName="Bosy";
	String lName="Samir";
	String email="bm163@gmail.com";
	String PD="123456";
	String Message="Your registration ";

	@DataProvider(name = "testData")
	public static Object [][] userData() {
		return new Object[][] {
			{"Bosy","Samir","bm7@easy.com","123456789"},
			{"Bosy","Samir","bm7@veryeasy.com","123456789"}
		};

	}

	@Test(priority = 1,alwaysRun=true,dataProvider = "testData")
	public void userRegisterSuccessully(String fName,String lName,String email,String PD  ) throws InterruptedException {
		homeObject = new HomePage(testBaseDriver);
		homeObject.openRegisterationPage();
		userRegiserationObject = new UserRegiserationPage(testBaseDriver);
		userRegiserationObject.userRegisteration(fName, lName, email, PD);
		Assert.assertTrue(userRegiserationObject.successMsg.getText().contains(Message));
		System.out.println(userRegiserationObject.successMsg.getText());
		registeredUserLogOut();
		//userRegiserationObject.userLogOut(); //Replaced by next code
		homeObject.openLoginLink();
		//loginObject = new LoginPage(testBaseDriver);  //Replaced by next code
		registerdUserCanLogin();
		//loginObject.userLolginSuccessfully(email, PD);  //Replaced by next code
		registeredUserLogOut();
		//userRegiserationObject.userLogOut();// Useless  

	}

	//@Test(dependsOnMethods = {"userRegisterSuccessully"})
	public void registeredUserLogOut() throws InterruptedException {
		userRegiserationObject.userLogOut();	
	}

	//@Test(dependsOnMethods = {"registeredUserLogOut"},enabled = false)
	public void registerdUserCanLogin() throws InterruptedException {
		homeObject.openLoginLink();
		loginObject = new LoginPage(testBaseDriver);
		loginObject.userLolginSuccessfully(email, PD);
		
	}
}
