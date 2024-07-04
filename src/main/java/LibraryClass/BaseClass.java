package LibraryClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public WebDriver driver;
	
	public void initialiseBrowser() throws IOException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get(UtilityClass.getPFData("URL"));
	}

}
