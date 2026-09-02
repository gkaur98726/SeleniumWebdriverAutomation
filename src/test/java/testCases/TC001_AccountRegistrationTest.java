package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("****** Starting TC001_AccountRegistrationTest  ******");
		
		
		try {
		HomePage hp=new HomePage(driver);//object creation
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setLastName(randomeString().toUpperCase());
		regPage.setEmail(randomeString()+"@gmail.com");//random email bcz it will register in page  that'why
		regPage.setTelephone(randomeNumber());
		logger.info("Providing custome details......");
		
		String password=randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.selectPrivacyPolicy();
		regPage.clickContinue();
		
		
		logger.info("Validating expected message.....");      //usually we use only info or debug to capture all the information of the log bcz fatal or fail both terminate or finish code
		String confmsg =regPage.getConfirmationMessage();
		
		if(confmsg.equals("Your Account Has Been Created!")) {// we did attentionally to run failed and debug msg
			Assert.assertTrue(true);
		}
		
		else {
			logger.error("Test failed....");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);
		}
	//	Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		catch (Exception e) {
			
			Assert.fail();
			
		}
		logger.info("****** Finished TC001_AccountRegistrationTest  ******");
	}


}
