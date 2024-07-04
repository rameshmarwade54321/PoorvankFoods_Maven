package Module01_RegisterTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryClass.BaseClass;
import LibraryClass.UtilityClass;
import Module01_Register.PoorvankFoodsDashboardPage;
import Module01_Register.PoorvankFoodsLoginPage;

public class PoorvankFoodsLoginTest extends BaseClass
{
	PoorvankFoodsDashboardPage dashboard;
	PoorvankFoodsLoginPage login;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initialiseBrowser();
		dashboard=new PoorvankFoodsDashboardPage(driver);
		login=new PoorvankFoodsLoginPage(driver);
		
	}
	
	@BeforeMethod
	public void loginToapp() throws InterruptedException, IOException
	{
		
		dashboard.clickPoorvankFoodsDashboardPageLoginBtn();
		Thread.sleep(2000);
		login.inpPoorvankFoodsLoginPageUserName(UtilityClass.getPFData("UN"));
		Thread.sleep(1000);
		login.inpPoorvankFoodsLoginPagePassword(UtilityClass.getPFData("PWD"));
		Thread.sleep(1000);
		login.clickPoorvankFoodsLoginPageRememberMeBox();
		Thread.sleep(1000);
		login.clickPoorvankFoodsLoginPageSigninBtn();
		Thread.sleep(3000);
			}
	@Test (priority=1)
	public void verifyLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=2;
		String acttext = dashboard.getPoorvankFoodsDashboardPageLogoutText();
		String exptext = UtilityClass.getTestData(1, 0);
		Assert.assertEquals(acttext, exptext, "failed=results are not matched");
		Thread.sleep(3000);
	}
	
	@Test (priority=2)
	public void verifyMangoPickleSelection() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=3;
		String acttext = dashboard.performActionOnPoorvankFoodsDashboardPageProductsDropDown(driver);
		String exptext = UtilityClass.getTestData(2, 0);
		Assert.assertEquals(acttext, exptext,"failed=results are  not matched");
		Thread.sleep(3000);
	}

	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.caputresScreesnShot(driver, TCID);
		}
		
		dashboard.clickPoorvankFoodsDashboardPageLogoutBtn();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
}
