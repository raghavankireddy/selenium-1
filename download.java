package selenium.selenium;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;

public class download {
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
    @BeforeClass
	public static void start() throws Exception {
		System.out.println("The start");    	
    	Initialize init = new Initialize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/download" );
    }
 
	@AfterClass
	public static void end(){
		System.out.println("The end");
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
		System.out.println("TestA - Download page");	
		WebElement item;
		String fileName = null;
		
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/a"));
		item.click();
		String s = item.getAttribute("href");
		int index = s.lastIndexOf('/') + 1;
		fileName = utility.downloadPath + s.substring(index);
		System.out.println("Filename = " + fileName);

		assertTrue(utility.fileExist(fileName));

		
	}
}
