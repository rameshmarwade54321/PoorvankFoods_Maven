package Module01_Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoorvankFoodsLoginPage 
{
	@FindBy(xpath="//input[@name='xoo-el-username']") private WebElement UN;
	@FindBy(xpath="//input[@name='xoo-el-password']") private WebElement PWD;
	@FindBy(xpath="//input[@name='xoo-el-rememberme']") private WebElement rememberMe;
	@FindBy(xpath="//button[text()='Sign In']") private WebElement signinBtn;

	public PoorvankFoodsLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpPoorvankFoodsLoginPageUserName(String username)
	{
		UN.sendKeys(username);
	}
	
	public void inpPoorvankFoodsLoginPagePassword(String password)
	{
		PWD.sendKeys(password);
	}
	
	public void clickPoorvankFoodsLoginPageRememberMeBox()
	{
		rememberMe.click();
	}
	
	public void clickPoorvankFoodsLoginPageSigninBtn()
	{
		signinBtn.click();
	}
	

}
