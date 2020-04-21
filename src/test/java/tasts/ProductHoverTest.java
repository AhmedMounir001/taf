package tasts;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverTest extends TestBase{
	HomePage homeObject;
	
	@Test
	public void userCanHoveOnElectronices() {
		homeObject = new HomePage(testBaseDriver);
		homeObject.selectCameraAndPhoto();
		
	}

}
