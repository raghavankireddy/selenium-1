package selenium.selenium;
//
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkBoxes {
	public static WebDriver driver;	
	Utilities utility = new Utilities();
	static Initialize init = new Initialize();	
	static String browserDriverType = "FireFoxDriver";
	WebElement item;
	
    @BeforeClass
	public static void start() throws Exception {  
		System.out.println("[Checkboxes test]");	
    	Initialize init = new Initialize();
    	driver = init.setUp( browserDriverType,"http://the-internet.herokuapp.com/checkboxes" );
    }
 
	@AfterClass
	public static void end(){
		init.teardown(driver);
	}
	
	@Test
	public void testA(){
		System.out.println("     - Checkboxes test - Verify page title.");	
		WebElement item; 
		item = driver.findElement(By.cssSelector(".example>h3"));
		assertTrue(item.getText().contains("Checkboxes"));
	}

	@Test
	public void testB(){
		System.out.println("     - Checkboxes test - Verify button innerText, AKA labels.");	
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes>input"));
		//Verify there are only two check boxes and they are named correctly.
		assertTrue(checkboxes.size()== 2);
		String el = driver.findElement(By.cssSelector("#checkboxes")).getAttribute("innerText");
		assertTrue(el.contains("checkbox 1"));
		assertTrue(el.contains("checkbox 2"));
	}

	public void testC(){
		System.out.println("     - Checkboxes test - verify the second checkbox on the page is selected and the first is not.");	
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[1]"));
		assertFalse(item.isSelected());
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[2]"));
		assertTrue(item.isSelected());
	}
	
	public void testD(){
		System.out.println("     - Checkboxes test - check first checkbox uncheck second checkbox and verify both.");	
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[1]"));
		item.click();
		assertTrue(item.isSelected());
		item = driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[2]"));
		item.click();
		assertFalse(item.isSelected());
	}
}
