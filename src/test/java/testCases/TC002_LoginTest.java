package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("****** Statring TC002_LoginTest ******");
		
		
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		
		//login
		LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
lp.setPassword(p.getProperty("password"));
lp.clickLogin();



//myaccount page
MyAccountPage macc=new MyAccountPage(driver);
boolean targetPage=macc.isMyAccountPageExists();
//Assert.assertEquals(targetPage, true,"Login failed");   //use this or below statement both re good
Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
logger.info("****** Finished TC002_LoginTest ******");


	
}	
	
}
