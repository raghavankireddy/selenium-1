package selenium.selenium;
//
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class dragAnddrop {
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
    @BeforeClass
	public static void start() throws Exception {   
		System.out.println("[Download file test]  - Test Not Implemented.  Selenium HTML control broken");	
    	Initialize init = new Initialize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/drag_and_drop" );
    }
 
	@AfterClass
	public static void end(){
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
/*		System.out.println("Drag and Drop broken because Selenium control doesn't work with HTML5");	
		WebElement source;
		WebElement target;
		String sourceXpath =  ".//*[@id='column-a']";
		String targetXpath = ".//*[@id='column-b']";
	
		source = driver.findElement(By.xpath(sourceXpath));
		target = driver.findElement(By.xpath(targetXpath));
		
		//  Seems to be broken according to google searches
		// todo: check later for a fix that doesn't use screen positioning.
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		
		sourceXpath = ".//*[@id='column-a']";
		targetXpath = ".//*[@id='column-b']";
		source = driver.findElement(By.xpath(sourceXpath));
		target = driver.findElement(By.xpath(targetXpath));
		System.out.println("DEBUG: source gettext = " + source.getText());
		System.out.println("DEBUG: source gettext = " + target.getText());
		assertTrue(source.getText().contains("B"));
		assertTrue(source.getText().contains("A"));*/
	}
}
