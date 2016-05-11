package selenium.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class brokenImage {
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
	
    @BeforeClass
	public static void start() throws Exception {
		System.out.println("The start");    	
    	Initialize init = new Initialize();
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/broken_images" );
    }
 
	@AfterClass
	public static void end(){
		System.out.println("The end");
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
	// verify title of page 
		item = driver.findElement(By.cssSelector(".example>h3"));
		assertTrue(item.getText().contains("Broken Images"));
	}
	
	@Test
	public void testB(){
	// verify title of page 
		boolean result = true;
		boolean allImagesGood = true;
		
		List<WebElement> images = driver.findElements(By.cssSelector(".example>img"));
		for (WebElement imageElement : images ){
			if (imageElement !=null){
				result = utility.verifyImageIsGood(driver, imageElement);
				if(!result){
					allImagesGood = false;
				}
				System.out.println("Image " + imageElement.getAttribute("src") + " good: " + result);
			}
		}
		// test expected to fail because the URL contains 2 bad and 1 good image
		assertFalse(allImagesGood);
	}
	
	
	
	
	
	
	
	
}