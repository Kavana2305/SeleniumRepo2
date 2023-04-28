package Generic_utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	@BeforeSuite 
    public void BS()
    {
    	System.out.println("database connection started");
    }
    @BeforeTest
    public void BT()
    {
    	System.out.println("parallel execution");
    }
    
    @BeforeClass
    public void BC()
    {
    	String key="webdriver.chrome.driver";
		String value="./src/main/resources/chromedriver1.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	System.out.println("browser launched");
    }
    @BeforeMethod
    public void BM() throws Throwable
    {
//    	Property_utility plib=new Property_utility();
//         	String URL = plib.get_key_value("url");
//         	String USERNAME = plib.get_key_value("username");
//         	String PASSWORD = plib.get_key_value("password");
//    	FileInputStream fis=new FileInputStream("./src/test/resources/propertyfile.properties.txt");
//		Properties pro=new Properties();
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
//        driver.get(URL);
//    	LoginPage log=new LoginPage(driver);
//		log.loginToApp(USERNAME, PASSWORD);
    	
    	System.out.println("login");
    }
    
    //test script
    
    @AfterMethod
    public void AM()
    {
    	System.out.println("logout");
    }
    @AfterClass
    public void AC()
    {
    	System.out.println("browser closed");
    }
    @AfterTest
    public void AT()
    {
    	System.out.println("parallel execution done");
    }
    @AfterSuite
    public void AS()
    {
    	System.out.println("database connection closed");
    }
}
