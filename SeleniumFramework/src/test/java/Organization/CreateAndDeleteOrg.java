package Organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import Generic_utility.Property_utility;

public class CreateAndDeleteOrg {

	public static void main(String[] args) throws Throwable 
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
		
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
//        Random ran=new Random();
//        
//        int ranNum = ran.nextInt(1000);
        
		
		
//		driver.findElement(By.name("accountname")).sendKeys("Org" +ranNum);
        
//        FileInputStream fes=new FileInputStream("./src/test/resources/org.xlsx");
//        
//        Workbook book = WorkbookFactory.create(fes);
//        
//        org.apache.poi.ss.usermodel.Sheet sh = book.getSheet("organization");
//        
//        Row ro = sh.getRow(0);
//        
//        org.apache.poi.ss.usermodel.Cell ce = ro.getCell(0);
//        
//        String data = ce.getStringCellValue()+ranNum;
		
		Java_utility jlib=new Java_utility();
		int ranNum = jlib.getRandomNum();
		
		
        
        Excel_utility elib=new Excel_utility();
        String data = elib.getExcelDataFormater2("organization",0,0)+ranNum;
        
        driver.findElement(By.name("accountname")).sendKeys(data);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Organizations")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody//a[text()='"+data+"']/../..//input[@type=\"checkbox\"]")).click();
		
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		
        Alert popup = driver.switchTo().alert();
		
		popup.accept();
		
		boolean flag=false;
		
		driver.findElement(By.linkText("Organizations")).click();
		
		java.util.List<WebElement> org_list = driver.findElements(By.xpath("//a[@title=\"Organizations\"]"));
		
		for(WebElement we:org_list)
		
		{
			String org = we.getText();
			if(org.equals(data))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(data+ " not deleted");
		}
		else
		{
			System.out.println(data + " deleted");
		}
		Thread.sleep(2000);
		    WebElement sign = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	        
	        Actions act=new Actions(driver);
	        
	        act.moveToElement(sign).perform();
			
//			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	        
	        driver.findElement(By.linkText("Sign Out")).click();
	        
	        driver.quit();
		

	}
	}


