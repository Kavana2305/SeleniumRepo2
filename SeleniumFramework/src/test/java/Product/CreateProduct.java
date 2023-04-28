package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import Generic_utility.Property_utility;

public class CreateProduct {

	public static void main(String[] args) throws Throwable, InvalidFormatException, IOException 
	{
		String key="webdriver.chrome.driver";
		String value="./src/main/resources/chromedriver1.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		FileInputStream fis=new FileInputStream("./src/test/resources/propertyfile.properties.txt");
//		Properties pro=new Properties();
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
		Property_utility plib=new Property_utility();
		String URL = plib.get_key_value("url");
		String USERNAME = plib.get_key_value("username");
		String PASSWORD = plib.get_key_value("password");
		
		driver.get(URL);
		
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
//		Random ran=new Random();
//	        
//	    int ranNum = ran.nextInt(1000);
	    
//	    FileInputStream fes1=new FileInputStream("./src/test/resources/pro.xlsx");
//	    
//	    Workbook book = WorkbookFactory.create(fes1);
//	    
//	    org.apache.poi.ss.usermodel.Sheet she = book.getSheet("product");
//	    
//	    Row rw = she.getRow(0);
//	    
//	    org.apache.poi.ss.usermodel.Cell cell = rw.getCell(0);
//	    
//	    String exdata = cell.getStringCellValue()+ranNum;
		
		Java_utility jlib=new Java_utility();
		int ranNum = jlib.getRandomNum();
	    
	    Excel_utility elib=new Excel_utility();
	    String exdata = elib.getExcelDataFormater("product", 0, 0) + ranNum;
	    
		
		driver.findElement(By.name("productname")).sendKeys(exdata);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);

        WebElement sign = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
        
        Actions act=new Actions(driver);
        
        act.moveToElement(sign).perform();
		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
        
        driver.findElement(By.linkText("Sign Out")).click();
        
        driver.quit();
		
		
		
		
		
	}

}
