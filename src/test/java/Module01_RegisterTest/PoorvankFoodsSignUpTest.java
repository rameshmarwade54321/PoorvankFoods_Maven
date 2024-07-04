package Module01_RegisterTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryClass.BaseClass;
import LibraryClass.UtilityClass;
import Module01_Register.PoorvankFoodsDashboardPage;
import Module01_Register.PoorvankFoodsSignupPage;

public class PoorvankFoodsSignUpTest extends BaseClass
{

	PoorvankFoodsSignupPage signup;
	PoorvankFoodsDashboardPage dashboard;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initialiseBrowser();
		signup=new PoorvankFoodsSignupPage(driver);
		dashboard=new PoorvankFoodsDashboardPage(driver);
	}
	@BeforeMethod
	public void signupToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		
		dashboard.clickPoorvankFoodsDashboardPageRegisterBtn();
		Thread.sleep(1000);
		signup.inpPoorvankFoodsSignupPageEmailText(UtilityClass.getTestData(0, 0));
		Thread.sleep(1000);
		signup.inpPoorvankFoodsSignupPageFirstName(UtilityClass.getTestData(0, 1));
		Thread.sleep(1000);
		signup.inpPoorvankFoodsSignupPageLastname(UtilityClass.getTestData(0, 2));
		Thread.sleep(1000);
		signup.inpPoorvankFoodsSignupPagePassword(UtilityClass.getTestData(0, 3));
		Thread.sleep(1000);
		signup.inpPoorvankFoodsSignupPageConfirmPassword(UtilityClass.getTestData(0, 4));
		Thread.sleep(1000);
		signup.selectPoorvankFoodsSignupPageAcceptTerm();
		Thread.sleep(1000);
		signup.clickPoorvankFoodsSignupPageSignupBtn();
		Thread.sleep(4000);
	}
	
	@Test
	public void verifySignup() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=1;
		String acttext = dashboard.getPoorvankFoodsDashboardPageLogoutText();
		
		String exptext = UtilityClass.getTestData(0, 5);
		
		Assert.assertEquals(acttext,exptext,"failed-results not same");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws IOException, InterruptedException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.caputresScreesnShot(driver, TCID);	
			Thread.sleep(2000);
			dashboard.clickPoorvankFoodsDashboardPageLogoutBtn();
			
		}
	}
	
	@AfterClass
	public void closeBroswer()
	{
		driver.quit();
	}
	
}
