package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.Property_utility;

public class LoginPage 
{
   public LoginPage(WebDriver driver)
   {
	 PageFactory.initElements(driver, this);
   }
   
   @FindBy(name = "user_name")
   private WebElement nametf;
   
   @FindBy(name = "user_password")
   private WebElement passtf;
   
   @FindBy(xpath = "//input[@type=\"submit\"]")
   private WebElement submitbtn;
   
   public void loginToApp(String username, String password)
	{
	   nametf.sendKeys(username);
	   nametf.sendKeys(password);
	   submitbtn.click();
	}
      
   
}
   
