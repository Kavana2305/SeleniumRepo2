package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class Homepage 
{
   public Homepage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   
   @FindBy(linkText = "Organizations")
   private WebElement orglink;
   
   @FindBy(linkText = "Contacts")
   private WebElement conlink;
   
   @FindBy(linkText = "Products")
   private WebElement prolink;
   
   @FindBy(xpath = "//img[@src=\"themes/softed/images/menuDnArrow.gif\"]")
   private WebElement moredd;
   
   @FindBy(name = "Campaigns")
   private WebElement camplink;
   
   @FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
   private WebElement adminbtn;
   
   @FindBy(linkText = "Sign Out")
   private WebElement signbtn;
   
   public void orgclick()
   {
	   orglink.click();
   }
   
   public void conclick()
   {
	   conlink.click();
   }
   
   public void proclick()
   {
	   prolink.click();
   }

   public void campclick()
   {
	   moredd.click();
	   camplink.click();
	   
   }

   public void signout()
   {
	   adminbtn.click();
	   signbtn.click();
   }

  


   
}


