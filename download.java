package selenium.selenium;
//
import static org.junit.Assert.*;

import java.util.List;

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
		System.out.println("[Download file test]");	
    	Initialize init = new Initialize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/download" );
    }
 
	@AfterClass
	public static void end(){;
		init.teardown(driver);
	}
	
/*	@Test
	public void testA(){
		System.out.println("     - Download file test - Download a file test");	
		WebElement item;
		String fileName = null;
		//  Note this test uses a Firefox profile to turn off windows dialogs such as Save and open
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/a"));
		item.click();
		String s = item.getAttribute("href");
		int index = s.lastIndexOf('/') + 1;
		fileName = utility.downloadPath + s.substring(index);
		assertTrue(utility.fileExist(fileName));
		
	}*/
	
	@Test
	public void testA(){
		System.out.println("     - Download file test - Download a file test");	
		List<WebElement> items; 
		String fileName = null;
		//  Note this test uses a Firefox profile to turn off windows dialogs such as Save and open
		items = driver.findElements(By.cssSelector(".example>a"));

		for(WebElement we: items){
			if (we.getText().contains("some-file.txt")){
				we.click();
				utility.snooze(2000);
				String s = we.getAttribute("href");
				int index = s.lastIndexOf('/') + 1;
				fileName = utility.downloadPath + s.substring(index);
				assertTrue(utility.fileExist(fileName));
			}
		}
	}
	
}
