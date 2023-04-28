package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;

public class OrgVerify 
{
       public OrgVerify(WebDriver driver)
       {
    	   PageFactory.initElements(driver,this);
       }
       
       @FindBy(xpath = "//span[@id=\"dtlview_Organization Name\"]")
       private WebElement orgtext;
       
       public void orgValid(WebDriver driver,String data) throws Throwable
       {
      
   	   
   	   String expdata = orgtext.getText();
   	   
   	   if (expdata.equals(data)) 
   	   {
		System.out.println("org is verified");
	   } 
   	   else 
   	   {
   		System.out.println("org is not verified");
	   }
   	   
       }
}
