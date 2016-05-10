package selenium.selenium;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initialize {
	

	public WebDriver setUp(String browserDriverType, String URL) throws Exception {
		System.out.println("In setUP");
		WebDriver driver = null;
		if (browserDriverType == "FireFoxDriver"){
			driver = new FirefoxDriver();
			driver.get(URL);
		}
		if (driver != null){
			return driver;
		}
		else
		{
			throw new NullPointerException();
		}
	}
 
	public void teardown(WebDriver driver){
		System.out.println("In teardown");
    	driver.close();
	}
}
