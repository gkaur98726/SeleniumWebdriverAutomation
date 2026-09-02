package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT  extends BaseClass{

	/*
	 1]condition] Data is valid --login success--test pass---logout
	 * Data is valid --login fail--test fail
	 * 
	 * 
	 * 
	 1]condition] Data is invalid --login success--test fail---logout
	 * Data is invalid --login fail--test pass
	 * */
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="DataDriven")//getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		
		logger.info("******* Starting TC003_LoginDDT******");
		
		try {
		//homepage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				
				
				//login
				LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		
		
		//my account
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		
		if(exp.equalsIgnoreCase("Valid"))//successfully login 1] condition
		{
			
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			
			else { 
				Assert.assertTrue(false);
			}
		}
		
		
		if(exp.equalsIgnoreCase("Invalid")) 
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("******* Finished TC003_LoginDDT******");
	}
	
	
	
}
