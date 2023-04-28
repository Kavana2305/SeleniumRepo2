package Campaign;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import Generic_utility.Webdriver_utility;

public class CreateCampWithProd {

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
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
//		Random ran=new Random();
//	        
//	    int ranNum = ran.nextInt(1000);
		
		Java_utility jlib=new Java_utility();
		int ranNum = jlib.getRandomNum();
	    
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
		
		 Excel_utility elib=new Excel_utility();
		 String exdata = elib.getExcelDataFormater("product",0,0)+ranNum;
	    
		
		driver.findElement(By.name("productname")).sendKeys(exdata);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		WebElement ele = driver.findElement(By.linkText("More"));
		
		Webdriver_utility wlib=new Webdriver_utility();
		wlib.hovering(driver,ele);
		
//		
//		Actions act=new Actions(driver);
//		
//		act.moveToElement(ele).perform();
//		
		driver.findElement(By.name("Campaigns")).click();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		
//		FileInputStream fes2=new FileInputStream("./src/test/resources/camp.xlsx");
//		
//		 Workbook boo = WorkbookFactory.create(fes2);
//		    
//		    org.apache.poi.ss.usermodel.Sheet sh = boo.getSheet("campaign");
//		   
//		    Row rwo = sh.getRow(0);
//		    
//		    org.apache.poi.ss.usermodel.Cell cll = rwo.getCell(0);
//		    
//		    String edata = cll.getStringCellValue()+ranNum;
		
		    String edata = elib.getExcelDataFormater3("campaign",0,0)+ranNum;
		    
		    driver.findElement(By.name("campaignname")).sendKeys(edata);
		    
		    driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		    
		    
		    wlib.switchToWin(driver,"Products&action");
		    
		    
		    
		    //
		    
//		    Set<String> allId = driver.getWindowHandles();
//		    java.util.Iterator<String> id = allId.iterator();
//		    
//		    while(id.hasNext())
//		    {
//		    	String wid = id.next();
//		    	driver.switchTo().window(wid);
//		    	String title = driver.getTitle();
//		    	
//		    	if(title.contains("Products&action"))
//		    	{
//		    		break;
//		    	}
//		    }
		    
		    driver.findElement(By.id("search_txt")).sendKeys(exdata);
		    driver.findElement(By.name("search")).click();
		    
		    driver.findElement(By.xpath("//a[text()='"+exdata+"']")).click();
		    
		    wlib.switchToWin2(driver,"Campaigns&action" );
		    
//		    Set<String> allId1 = driver.getWindowHandles();
//		    java.util.Iterator<String> id1 = allId1.iterator();
//		    
//		    while(id1.hasNext())
//		    {
//		    	String wid = id1.next();
//		    	driver.switchTo().window(wid);
//		    	String title1 = driver.getTitle();
//		    	
//		    	if(title1.contains("Campaigns&action"))
//		    	{
//		    		break;
//		    	}
//		    }
		    
		    driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		    
		    
		    
		    String save1 = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		    
		    if (save1.equals(edata)) 
			{
				System.out.println("campaign verfication passed");
			} else 
			{
				System.out.println("campaign verfication failed");
			}
		    Thread.sleep(2000);
		    String save2 = driver.findElement(By.xpath("//a[@href=\"index.php?module=Products&action=DetailView&record=34\"]")).getText();
			
		    if (save2.equals(exdata)) 
			{
				System.out.println("product verfication passed");
			} else 
			{
				System.out.println("product verfication failed");
			}
			
			
//			Thread.sleep(2000);

//	        WebElement sign = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//	        
//	        Actions act1=new Actions(driver);
//	        
//	        act1.moveToElement(sign).perform();
			
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	        
	        driver.findElement(By.linkText("Sign Out")).click();
	        
	        driver.quit();
	

}
	}


