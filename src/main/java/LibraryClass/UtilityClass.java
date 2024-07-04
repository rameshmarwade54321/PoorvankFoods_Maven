package LibraryClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{

	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\workspace java\\PoorvankFoods_Maven\\PropertyFile.properties");
		Properties pf=new Properties();
		pf.load(file);
		String value = pf.getProperty(key);
		return value;
	}
	
	public static void caputresScreesnShot(WebDriver driver, int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\workspace java\\PoorvankFoods_Maven\\FailedTestCases_Screenshots\\TestCase"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\workspace java\\PoorvankFoods_Maven\\TestData\\PoorvankFoods_testData.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
		return value;
	}
	
	public static Actions performAction(WebDriver driver)
	{
		Actions pact=new Actions(driver);
		return pact;
	}
	
	
	
}
