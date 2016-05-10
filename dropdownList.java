package selenium.selenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class dropdownList {
	
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";

	
    @BeforeClass
	public static void start() throws Exception {
		System.out.println("The start");    	
    	Initialize init = new Initialize();
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/dropdown" );
    }
 
	@AfterClass
	public static void end(){
		System.out.println("The end");
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
		System.out.println("In Verify Dropdown list Label");	
		WebElement item; 
		item = driver.findElement(By.cssSelector(".example>h3"));
		assertTrue(item.getText().contains("Dropdown List"));
	}

	@Test
	public void testB(){
		System.out.println("In Verify option selector in dropdown list ");	
		WebElement item; 
		item = driver.findElement(By.cssSelector("#dropdown>option[value='1'"));
		assertTrue(item.getText().contentEquals("Option 1"));
		item = driver.findElement(By.cssSelector("#dropdown>option[value='2'"));
		assertTrue(item.getText().contentEquals("Option 2"));
	}

	
}
