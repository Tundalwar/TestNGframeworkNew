package Com.Demosite.testCases;


import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Com.Demosite.PageObjects.LoginPage;


public class Tc_LoginTest_001 extends BaseClass
{  
	LoginPage lp;
    
	
	@BeforeMethod
	public void objectIntialize()
	{
		lp = new LoginPage(driver);
		
	}
	
	@Test
	public void loginTest()
	{
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		lp.clickLoginButtton();
		logger.info("Redirected to login page");
		test.log(Status.INFO, "This status shows loginButton");
		test.info("Click on login button");
		lp.setUserEmail(useremail);
		logger.info("Entered email");
		lp.setUserPassword(usepassword);
		logger.info("Entered Password");
		lp.clickOnSubmit();
		logger.info("Succefully login");
		
		
		if(driver.getTitle().equals("OpenCart - Account Login"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
	}
	

}
