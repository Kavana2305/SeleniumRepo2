package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import Generic_utility.Property_utility;
import Generic_utility.Webdriver_utility;

public class CreateContactWithOrg {

	public static void main(String[] args) throws Throwable 
	{
		String key="webdriver.chrome.driver";
		String value="./src/main/resources/chromedriver1.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
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
		
		Java_utility jlib=new Java_utility();
		int ranNum = jlib.getRandomNum();
        
//		driver.findElement(By.name("accountname")).sendKeys("Org" +ranNum);
        
//        FileInputStream fes=new FileInputStream("./src/test/resources/org.xlsx");
//        
//        Workbook book = WorkbookFactory.create(fes);
//        
//        Sheet sh = book.getSheet("organization");
//        
//        Row ro = sh.getRow(0);
//        
//        Cell ce = ro.getCell(0);
//        
//        String data = ce.getStringCellValue()+ranNum;
		
		 Excel_utility elib=new Excel_utility();
	        String data = elib.getExcelDataFormater2("organization",0,0)+ranNum;
        
        driver.findElement(By.name("accountname")).sendKeys(data);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
//		 FileInputStream fes1=new FileInputStream("./src/test/resources/contact.xlsx");
//	        
//	        Workbook book1 = WorkbookFactory.create(fes1);
//	        
//	        Sheet sh1 = book1.getSheet("contact");
//	        
//	        Row ro1 = sh1.getRow(0);
//	        
//	        Cell ce1 = ro1.getCell(0);
//	        
//	        String data1 = ce1.getStringCellValue()+ranNum;
		
		String data1 = elib.getExcelDataFormater4("contact",0,0)+ranNum;
		
		driver.findElement(By.name("lastname")).sendKeys(data1);
		
		driver.findElement(By.xpath("(//img[@language=\"javascript\"])[1]")).click();
		
//		Set<String> allId1 = driver.getWindowHandles();
//	    Iterator<String> id1 = allId1.iterator();
//	    
//	    while(id1.hasNext())
//	    {
//	    	String wid = id1.next();
//	    	driver.switchTo().window(wid);
//	    	String title1 = driver.getTitle();
//	    	
//	    	if(title1.contains("Accounts&action"))
//	    	{
//	    		break;
//	    	}
//	    }
		
		Webdriver_utility wlib=new Webdriver_utility();
		wlib.switchToWin(driver, "Accounts&action");
	    
	    driver.findElement(By.name("search_text")).sendKeys(data);
	    
	    driver.findElement(By.name("search")).click();
	    
	    driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
	    
//	    Set<String> allId2 = driver.getWindowHandles();
//	    Iterator<String> id2 = allId2.iterator();
//	    
//	    while(id2.hasNext())
//	    {
//	    	String wid1 = id2.next();
//	    	driver.switchTo().window(wid1);
//	    	String title2 = driver.getTitle();
//	    	
//	    	if(title2.contains("Contacts&action"))
//	    	{
//	    		break;
//	    	}
//	    }
	    
	    wlib.switchToWin2(driver,"Contacts&action" );
	    
	    driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);

        WebElement sign = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
        
//        Actions act1=new Actions(driver);
//        
//        act1.moveToElement(sign).perform();
        
        
		wlib.hovering(driver,sign);
		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
        
        driver.findElement(By.linkText("Sign Out")).click();
        
        driver.quit();
	    
	    
	    
		
		
		
		
		
	}

	}


