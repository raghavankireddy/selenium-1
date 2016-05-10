package selenium.selenium;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class challengingDOM {
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
    @BeforeClass
	public static void start() throws Exception {
		System.out.println("The start");    	
    	Initialize init = new Initialize();
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/challenging_dom" );
    }
 
	@AfterClass
	public static void end(){
		System.out.println("The end");
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
		System.out.println("In Verify Challenging DOM page Label");	
		WebElement item; 
		item = driver.findElement(By.cssSelector(".example>h3"));
		assertTrue(item.getText().contains("Challenging DOM"));
	}

	@Test
	public void testB(){
		// verify that locating the 3 button with dynamic labels can be located by class using Xpath
		System.out.println("");	
		WebElement item; 
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[1]/a[@class='button']"));
		System.out.println(item.getText());
		
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[1]/a[@class='button alert']"));
		System.out.println(item.getText());		
		
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[1]/a[@class='button success']"));
		System.out.println(item.getText());			
	}
	
	@Test
	public void testC(){
		// verify that locating the 3 button with dynamic labels can be located by class using Xpath
		String result;
		System.out.println("");	
		WebElement item; 
		// assert canvas' height
		result = driver.findElement(By.cssSelector("#canvas")).getAttribute("height");
		assertEquals(result,"200");
		// assert canvas' width
		result = driver.findElement(By.cssSelector("#canvas")).getAttribute("width");
		assertEquals(result,"599");	
		result = driver.findElement(By.cssSelector("#canvas")).getAttribute("style");
		assertTrue(result.contains("border"));	
		assertTrue(result.contains("1px dotted"));	
		
	}
		
	
}
