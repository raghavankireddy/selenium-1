package selenium.selenium;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
    @BeforeClass
	public static void start() throws Exception { 
		System.out.println("[Login page test]");    	
    	Initialize init = new Initialize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/login" );
    }
 
	@AfterClass
	public static void end(){
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
		System.out.println("     - Login page test - Login page test - test unsuccessful login");    	
		WebElement itemOne;
		item = driver.findElement(By.cssSelector("#username"));
		item.sendKeys("badusername");
		item = driver.findElement(By.cssSelector("#password"));
		item.sendKeys("badusername");
		item = driver.findElement(By.cssSelector(".radius"));
		item.click();
		item = driver.findElement(By.cssSelector("#flash"));
		assertTrue(item.getText().contains("Your username is invalid!"));
		}
	
	@Test
	public void testB(){
		System.out.println("     - Login page test - Login page test - test successful login");    	
		WebElement itemOne;
		item = driver.findElement(By.cssSelector("#username"));
		item.sendKeys("tomsmith");
		item = driver.findElement(By.cssSelector("#password"));
		item.sendKeys("SuperSecretPassword!");
		item = driver.findElement(By.cssSelector(".radius"));
		item.click();
		item = driver.findElement(By.cssSelector("#flash"));
		assertTrue(item.getText().contains("You logged into a secure area!"));
		// test logout
		item = driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
		item.click();
		item = driver.findElement(By.cssSelector("#flash"));
		assertTrue(item.getText().contains("You logged out of the secure area!"));
	}
}
