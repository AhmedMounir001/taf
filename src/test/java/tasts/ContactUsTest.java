package tasts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;
import pages.UserRegiserationPage;

public class ContactUsTest extends TestBase{
	HomePage homeObject = new HomePage(testBaseDriver);
	ContactUsPage contactUsObject ;
	
	String enquiryMessage = "Thank you nopcommerce team";
	String contactUsFeedBack= "Your enquiry has been successfully sent to the store owner.";
	UserRegiserationPage userRegiserationObject;
	String fName="Bosy";
	String lName="Samir";
	String email="bm79@gmail.com";
	String PD="123456";
	String Message="Your registration ";

	@Test(priority = 1,alwaysRun=true)
	public void userRegisterSuccessully() throws InterruptedException {
		homeObject = new HomePage(testBaseDriver);
		homeObject.openRegisterationPage();
		userRegiserationObject = new UserRegiserationPage(testBaseDriver);
		userRegiserationObject.userRegisteration(fName, lName, email, PD);
		Assert.assertTrue(userRegiserationObject.successMsg.getText().contains(Message));
		System.out.println(userRegiserationObject.successMsg.getText());

	}

	@Test (priority = 2)
	public void registeredUserCanUseConactUs() {
		homeObject.openContactUs();
		contactUsObject = new ContactUsPage(testBaseDriver);
		contactUsObject.contactUsEnquiry(enquiryMessage);
		Assert.assertEquals(contactUsObject.resultEnquiry.getText(), contactUsFeedBack);

	}

}
