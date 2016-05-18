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

public class upload {
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
    @BeforeClass
	public static void start() throws Exception {  	
		System.out.println("[Upload File Test]");     	
    	Initialize init = new Initialize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/upload" );
    }
 
	@AfterClass
	public static void end(){
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
		System.out.println("     - Upload File Test - Uploading file.");     	
		WebElement item;
		item = driver.findElement(By.xpath(".//*[@id='file-upload']"));
		item.sendKeys("c:\\commands\\testupload.txt");
		item = driver.findElement(By.xpath(".//*[@id='file-submit']"));
		item.click();
		item = driver.findElement(By.id("uploaded-files"));		
		assertTrue(item.getText().contains("testupload.txt"));
	}
}
