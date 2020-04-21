package tasts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailesPage;
import pages.ProductEmailaFriendPage;
import pages.SearchPage;
import pages.UserRegiserationPage;

public class ProductEmailaFriendTest extends TestBase{

	ProductEmailaFriendPage ProductEmailFriendobject;
	ProductDetailesPage ProductDetailesObject;
	SearchPage searchObject;
	HomePage homeObject;
	UserRegiserationPage userRegiserationObject;

	//1-Variables for Register user
	String fName="Bosfdsy";
	String lName="Samir";
	String email="bm44as7@gmail.com";
	String PD="123456";
	String Message="Your registration ";

	//2-Variables for search product
	String productName0="Fahrenheit 451 by Ray Bradbury";
	String productName="Fahre";

	//3-Variables for send Email
	String frindEmail ="tito@ziko.com";
	String personalMessage = "Hello";
	String resultEmailMessageString ="Your message has been sent.";

	//1-User Registration
	@Test(priority = 1,alwaysRun=true)
	public void userRegisterSuccessully() throws InterruptedException {
		homeObject = new HomePage(testBaseDriver);
		homeObject.openRegisterationPage();
		userRegiserationObject = new UserRegiserationPage(testBaseDriver);
		userRegiserationObject.userRegisteration(fName, lName, email, PD);
		Assert.assertTrue(userRegiserationObject.successMsg.getText().contains(Message));
		System.out.println(userRegiserationObject.successMsg.getText());

	}

	//2-Search about product
	@Test(priority = 2)
	public void useAutocompleteSearch() {
		searchObject = new SearchPage(testBaseDriver);
		searchObject.autocompleteSearch(productName);
		Assert.assertEquals(searchObject.currentItemElement.getText(), productName0);
	}
	//3-Email product to friend
	@Test(priority = 3)
	public void emailProductToFriend() {
		ProductEmailFriendobject = new ProductEmailaFriendPage(testBaseDriver);

		ProductDetailesObject = new ProductDetailesPage(testBaseDriver);
		ProductDetailesObject.clickEmailFrind();
		ProductEmailFriendobject.emailProductToFrind(frindEmail, personalMessage);
		Assert.assertEquals(ProductEmailFriendobject.resultEmail.getText(), resultEmailMessageString);

	}

}
