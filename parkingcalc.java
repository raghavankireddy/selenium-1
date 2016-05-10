package selenium.selenium;

import java.util.List;
import selenium.selenium.Initialize;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import junit.framework.Assert;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class parkingcalc {
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();
	static String browserDriverType = "FireFoxDriver";

	
    @BeforeClass
	public static void start() throws Exception {

    	driver = init.setUp( browserDriverType,"http://adam.goucher.ca/parkcalc/" );
    }
 
	@AfterClass
	public static void end(){
		System.out.println("In teardown");
		init.teardown(driver);
	}
	
	  @Test
	    public void testA(){
			System.out.println("In chooseALot");
			// Choose A lot option dropdown list
			WebElement item;
	    	List<WebElement> items;
	 
	    	items = driver.findElements(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/select/option"));
	    	item = driver.findElement(By.id("Lot"));
	    	Select selectedItem = new Select(item);
	    	selectedItem.selectByVisibleText("Long-Term Garage Parking");
	    	for(WebElement we: items ){
	    		if(we.getText().contains("Long-Term Garage Parking"))
	    		{
	    			assertTrue(we.isSelected());
	    		}
	    		else
	    		{
	    			assertFalse(we.isSelected());
	    		}
	     	}
	    }
	  
	@Test
	public void testB(){
		System.out.println("In chooseEntryDateime");
		// Choose the entry date and time
	   	WebElement item;
	   	item = driver.findElement(By.id("EntryTime"));
	   	item.clear();
	   	item.sendKeys("8:00");
	   	item = driver.findElement(By.cssSelector("input[type='radio'][value='PM'][name='EntryTimeAMPM'"));
	   	item.click();
	   	item = driver.findElement(By.cssSelector("input[id='EntryDate']"));
	   	item.clear();
	   	item.sendKeys("03/27/1957");
	}
    
	@Test
	public void testC(){
		System.out.println("In chooseLeavingDateTime");
		// Choose leaving Date time
	   	WebElement item;
	   	item = driver.findElement(By.id("ExitTime"));
	   	item.clear();
	   	item.sendKeys("3:00");
	   	item = driver.findElement(By.cssSelector("input[type='radio'][value='PM'][name='ExitTimeAMPM'"));
	   	item.click();
	   	item = driver.findElement(By.cssSelector("input[id='ExitDate']"));
	    item.clear();
	   	item.sendKeys("03/31/1957");
	}

	@Test
    public void testD(){
		System.out.println("In testTableElementLabels");
		// Table label elements such as Choose a lot, Entry and Leaving Date time
    	String result;
    	
    	result = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[1]")).getText();
    	assertTrue(result.contains("Choose a Lot"));
    	
    	result = driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[1]")).getText();
    	assertTrue(result.contains("Choose Entry Date and Time" ));
    	
    	result = driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[1]")).getText();
    	assertTrue(result.contains("Choose Leaving Date and Time" ));
   }

	@Test
	public void testE(){
		System.out.println("In calculateParkingFee");
		// Submit button and does the calculation and assertions
	   	WebElement item;
	   	String result;
	   	item = driver.findElement(By.cssSelector("input[type='submit'][value='Calculate'"));
	   	item.click();
	   	item = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/span[1]/font/b"));
	   	result = item.getText();
	   	assertTrue(result.contains("$ 48.00"));
	   	item = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/span[2]/font/b"));
	   	result = item.getText();
	   	assertTrue(result.contains("(3 Days, 19 Hours, 0 Minutes)"));
	}
}
