package Module01_Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryClass.UtilityClass;

public class PoorvankFoodsDashboardPage 
{

	@FindBy(xpath="//span[text()='Register']")private WebElement register;
	@FindBy(xpath="//span[text()='Logout']") private WebElement logout;
	@FindBy(xpath="//span[text()='Login']") private WebElement login;
	@FindBy(xpath="//span[text()='Products']") private WebElement Products;
	@FindBy(xpath="//span[text()='Mango Pickle']") private WebElement mangopickle;
	@FindBy(xpath="//h1[text()='Mango Pickle']") private WebElement pgtitleMangoPickle;
	
	public PoorvankFoodsDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPoorvankFoodsDashboardPageRegisterBtn()
	{
		register.click();
	}
	
	public String getPoorvankFoodsDashboardPageLogoutText()
	{
		String text = logout.getText();
		return text;
	}
	
	public void clickPoorvankFoodsDashboardPageLogoutBtn()
	{
		logout.click();
	}
	
	public void clickPoorvankFoodsDashboardPageLoginBtn()
	{
		login.click();
	}
	
	public String performActionOnPoorvankFoodsDashboardPageProductsDropDown(WebDriver driver) throws InterruptedException
	{
		Actions act = UtilityClass.performAction(driver);
		act.moveToElement(Products).perform();
		Thread.sleep(2000);
		mangopickle.click();
		Thread.sleep(3000);
		String text = pgtitleMangoPickle.getText();
		return text;
		
	}
}
