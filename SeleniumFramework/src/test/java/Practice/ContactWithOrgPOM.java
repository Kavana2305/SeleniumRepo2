package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ContactPOM.ConDetails;
import ContactPOM.CreateCon;
import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import OrganizationPOM.CreateOrganization;
import OrganizationPOM.OrgDetails;
import POM.Homepage;
import POM.LoginPage;

public class ContactWithOrgPOM {
	
	@Test

	public  void cwo() throws Throwable 
	{
		
		String key="webdriver.chrome.driver";
		String value="./src/main/resources/chromedriver1.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		LoginPage log=new LoginPage(driver);
		log.login(driver);
		
		Homepage home=new Homepage(driver);
		home.orgclick();
		
		CreateOrganization create=new CreateOrganization(driver);
		create.createClick();

		 Java_utility jlib=new Java_utility();
		 int ranNum = jlib.getRandomNum();
		 Excel_utility elib=new Excel_utility();
		 String odata = elib.getExcelDataFormater2("organization",0,0)+ranNum;
		
		
		OrgDetails details=new OrgDetails(driver);
		details.orgName(driver, odata);
		
		Thread.sleep(1000);
		
		home.conclick();
		
		CreateCon create1=new CreateCon(driver);
		create1.create();
		
		String cdata = elib.getExcelDataFormater4("contact",0,0)+ranNum;
		
		ConDetails cdetails=new ConDetails(driver);
		cdetails.condt(driver, cdata, odata);
		

	}

}
