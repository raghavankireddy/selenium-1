package selenium.selenium;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class dynamicContent {

	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
    @BeforeClass
	public static void start() throws Exception {  	
		System.out.println("[Dynamic Content test]");	
    	Initialize init = new Initialize();
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/dynamic_content" );
    }
 
	@AfterClass
	public static void end(){
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
		System.out.println("     - Dynamic Content test -  Test dynamic image top");	
		WebElement itemOne, itemTwo;
		// get the top image the first time
		itemOne = driver.findElement(By.xpath(".//*[@id='content']/div[1]/div[1]/img"));
		// refresh the page by getting the current URL
		driver.get(driver.getCurrentUrl());
		// get the top image the second time
		itemTwo = driver.findElement(By.xpath(".//*[@id='content']/div[1]/div[1]/img"));	
		assertNotEquals(itemOne,itemTwo);
		}
	
	@Test
	public void testB(){
		System.out.println("     - Dynamic Content test - Test dynamic image top.");	
		WebElement itemOne, itemTwo;
		itemOne = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[1]/div[1]/img"));
		// refresh the page by getting the current URL
		driver.get(driver.getCurrentUrl());
		itemTwo = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[1]/div[1]/img"));
		assertNotEquals(itemOne,itemTwo);
		
	}
	
	@Test
	public void testC(){
		System.out.println("     - Dynamic Content test - Test static text top.");	
		WebElement item;	
		String str1, str2;
		utility.refreshPage(driver);
		// make image and text of top item static so that they will not be change when a page refresh occurs
		item = driver.findElement(By.cssSelector(".example>p>a"));
		item.click();
		utility.snooze(3000);
		str1 = driver.findElement(By.xpath(".//*[@id='content']/div[1]/div[2]")).getAttribute("src");
		utility.refreshPage(driver);
		 str2 = driver.findElement(By.xpath(".//*[@id='content']/div[1]/div[2]")).getAttribute("src");
		// Verify that both copies of the text is static and are equal
		assertEquals(str1,str2);		
	}
	

	@Test
	public void testD(){
		System.out.println("     - Dynamic Content test - test static image top.");	
		WebElement item;	
		String str1, str2;
		utility.refreshPage(driver);
    	// make image and text of top item static so that they will not be change when a page refresh occurs
		item = driver.findElement(By.cssSelector(".example>p>a"));
		item.click();
		utility.snooze(3000);
		// get the top image the first time
		str1 = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[1]/div[1]/img")).getText();
		utility.refreshPage(driver);
		// get the top image the second time
		str2 = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[1]/div[1]/img")).getText();	
		// Verify that both copies of the text is static and are equal
		assertEquals(str1,str2);		
	}
	
	
}
