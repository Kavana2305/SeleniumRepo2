package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgDetails 
{
   public OrgDetails(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(name = "accountname")
   private WebElement orgtf;
   
   @FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
   private WebElement savebtn;
   
   public void orgName(WebDriver driver,String data) throws Throwable
   {
	  
	   orgtf.sendKeys(data);
	   
	   savebtn.click();
   }
   
   
   
}
