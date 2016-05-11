package selenium.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Initialize {
	
	Utilities utility = new Utilities();
	
	public WebDriver setUp(String browserDriverType, String URL) throws Exception {
		System.out.println("In setUP");
		WebDriver driver = null;
		if (browserDriverType == "FireFoxDriver"){
			driver = new FirefoxDriver(newProfile());
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
 
	public FirefoxProfile newProfile(){
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream,application/xml,text/plain,text/xml,image/jpeg");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream,application/xml,text/plain,text/xml,image/jpeg");
		profile.setPreference("browser.download.folderList", 1);
		profile.setPreference("browser.download.dir", utility.downloadPath);
		return profile;
	}
	
	public void teardown(WebDriver driver){
		System.out.println("In teardown");
    	driver.close();
	}
}
