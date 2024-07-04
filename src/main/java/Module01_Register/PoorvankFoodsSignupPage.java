package Module01_Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoorvankFoodsSignupPage 
{

	@FindBy(xpath="//input[@class='xoo-aff-required xoo-aff-email']") private WebElement emailText;
	@FindBy(xpath="//input[@name='xoo_el_reg_fname']") private WebElement FNText;
	@FindBy(xpath="//input[@name='xoo_el_reg_lname']") private WebElement LNText;
	@FindBy(xpath="//input[@name='xoo_el_reg_pass']") private WebElement PWD;
	@FindBy(xpath="//input[@name='xoo_el_reg_pass_again']") private WebElement CPWD;
	@FindBy(xpath="//input[@name='xoo_el_reg_terms']") private WebElement acceptCBox;
	@FindBy(xpath="//button[text()='Sign Up']") private WebElement signupBtn;
	
	public PoorvankFoodsSignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpPoorvankFoodsSignupPageEmailText(String email)
	{
		emailText.sendKeys(email);
	}
	
	public void inpPoorvankFoodsSignupPageFirstName(String FirstName)
	{
		FNText.sendKeys(FirstName);
	}
	
	public void inpPoorvankFoodsSignupPageLastname(String LastNAme)
	{
		LNText.sendKeys(LastNAme);
	}
	
	public void inpPoorvankFoodsSignupPagePassword(String Password)
	{
		PWD.sendKeys(Password);
	}
	
	public void inpPoorvankFoodsSignupPageConfirmPassword(String confirmPassword)
	{
		CPWD.sendKeys(confirmPassword);
	}
	
	public void selectPoorvankFoodsSignupPageAcceptTerm()
	{
		acceptCBox.click();
	}
	
	
	public void clickPoorvankFoodsSignupPageSignupBtn()
	{
		signupBtn.click();
	}
}
