package ContactPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.Webdriver_utility;

public class ConDetails 
{
   public ConDetails(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(name = "lastname")
   private WebElement lnametf;
   
   @FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
   private WebElement addbtn;
   
   @FindBy(name = "search_text")
   private WebElement searchtf;
   
   @FindBy(name = "search")
   private WebElement searchbtn;
   
   @FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
   private WebElement savebtn;
   
   
   
   public void condt(WebDriver driver,String data,String data1)
   {
	   lnametf.sendKeys(data);
	   addbtn.click();
	   Webdriver_utility wlib=new Webdriver_utility();
	   wlib.switchToWin(driver,"Accounts&action");
	   
	   searchtf.sendKeys(data1);
	   searchbtn.click();
	   driver.findElement(By.xpath("//a[text()='"+data1+"']")).click();
	   wlib.switchToWin2(driver,"Contacts&action");
	   
	   savebtn.click();
   }
}
