package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization 
{
	 public CreateOrganization(WebDriver driver)
	   {
		 PageFactory.initElements(driver, this);
	   }
	 
	 @FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	 private WebElement createbtn;
	 
	 public void createClick()
	 {
		 createbtn.click(); 
	 }
}
