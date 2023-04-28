package Organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import OrganizationPOM.CreateOrganization;
import OrganizationPOM.OrgDetails;
import OrganizationPOM.OrgVerify;
import POM.Homepage;
import POM.LoginPage;

public class CreateOrgPOM extends BaseClass {
	
	@Test

	public  void method() throws Throwable
	{
//		String key="webdriver.chrome.driver";
//		String value="./src/main/resources/chromedriver1.exe";
//		System.setProperty(key, value);
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
//		LoginPage log=new LoginPage(driver);
//		log.login(driver);
		
//		Homepage home=new Homepage(driver);
//		home.orgclick();
		driver.get("http://localhost:8888");
//		CreateOrganization create=new CreateOrganization(driver);
//		create.createClick();
//		
//		 Java_utility jlib=new Java_utility();
//		 int ranNum = jlib.getRandomNum();
//		 Excel_utility elib=new Excel_utility();
//		 String data = elib.getExcelDataFormater2("organization",0,0)+ranNum;
//		
//		
//		OrgDetails details=new OrgDetails(driver);
//		details.orgName(driver, data);
//		
//		OrgVerify veri=new OrgVerify(driver);
//		veri.orgValid(driver,data);
//		
//		home.signout();
	
	System.out.println("Kavana");
	}

}
