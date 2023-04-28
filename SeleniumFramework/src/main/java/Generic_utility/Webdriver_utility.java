package Generic_utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_utility 
{
    public void switchToWin(WebDriver driver,String partialWindowTitle)
    {
    	Set<String> allId1 = driver.getWindowHandles();
	    java.util.Iterator<String> id1 = allId1.iterator();
	    
	    while(id1.hasNext())
	    {
	    	String wid = id1.next();
	    	driver.switchTo().window(wid);
	    	String title1 = driver.getTitle();
	    	
	    	if(title1.contains(partialWindowTitle))
	    	{
	    		break;
	    	}
	    }
    }
	
    public void switchToWin2(WebDriver driver,String partialWindowTitle)
    {
    	Set<String> allId1 = driver.getWindowHandles();
	    java.util.Iterator<String> id1 = allId1.iterator();
	    
	    while(id1.hasNext())
	    {
	    	String wid = id1.next();
	    	driver.switchTo().window(wid);
	    	String title1 = driver.getTitle();
	    	
	    	if(title1.contains(partialWindowTitle))
	    	{
	    		break;
	    	}
	    }
    }
    
    public void hovering(WebDriver driver, WebElement data)
    {
    	
    Actions act=new Actions(driver);
	
	act.moveToElement(data).perform();
    }

}
