package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObects.HomePage;
import pageObects.LoginPage;
import pageObects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass 
{
	@Test(groups={"sanity", "master"})
	public void verify_login()
	{
		logger.info("*****Starting TC_002_LoginTest **** ");
		logger.debug("capturing application debug logs....");
		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on the home page..");
	    hp.clickLogin();
	    logger.info("click on login link under myaccount..");
	    
	    
	    //Login page
	    LoginPage lp=new LoginPage(driver);
	    
	    logger.info("Entering valid email and password");
	    lp.setEmail(p.getProperty("email"));
	    lp.setPassword(p.getProperty("password"));
	    lp.clickLogin();//Login button
	    logger.info("clicked on login button....");
	    
	    //My Account Page
	    MyAccountPage macc=new MyAccountPage(driver);
	    
	    boolean targetPage=macc.isMyAccountPageExists();
	    
	    
	    if(targetPage==true)
	    {
	    	logger.info("loggin test passed...");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	logger.info("Login test failed");
	    	Assert.fail();
	    }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	    
	    logger.info("**** Finished TC_002_LoginTest **** ");
	    
		
	}

}

