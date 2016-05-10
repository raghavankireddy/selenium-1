package selenium.selenium;

import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class Utilities {

	public void snooze(int time){
		  try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	public String SetWindowHandle(String mainWindowHandle, WebDriver driver ){
	  
	  String popupHandle = null;
	  Set s = driver.getWindowHandles();
	  Iterator ite = s.iterator();
	  while(ite.hasNext()){
		  popupHandle=ite.next().toString();
		  if(!popupHandle.contains(mainWindowHandle))
		  {
			  driver.switchTo().window(popupHandle);
		  }
	  }
	  return popupHandle;
	}
	
	public static boolean closeAllWindowsExceptMain(String mainWindowHandle, WebDriver driver){
		  String popupHandle = null;
		  Set s = driver.getWindowHandles();
		  Iterator ite = s.iterator();
		  while(ite.hasNext()){
			  popupHandle=ite.next().toString();
			  if(!popupHandle.contains(mainWindowHandle))
			  {
				  driver.switchTo().window(popupHandle);
				  driver.close();
			  }
		  }
		  if (driver.getWindowHandles().size() == 1)
		  		return true;
		  	else
		  		return false;
	}
	
	public static boolean closeAllWindows(String mainWindowHandle, WebDriver driver){
		  String windowsHandle = null;
		  Set s = driver.getWindowHandles();
		  Iterator ite = s.iterator();
		  while(ite.hasNext()){
			  windowsHandle=ite.next().toString();
				  driver.switchTo().window(windowsHandle);
				  driver.close();
		  }
		  if (driver.getWindowHandles().size() == 1)
		  		return true;
		  	else
		  		return false;
	}
	
	public static void gotoWindow(String windowsHandle, WebDriver driver){
		  driver.switchTo().window(windowsHandle);		
	}
	
	public static float getWidth(String str){
		float temp;// length -1 is used to omit % sign
		temp = Float.valueOf(str.substring(str.indexOf(":")+1,str.length() -2)).floatValue();
		return temp;
	}
	
	public static boolean verifyImageIsGood(WebDriver driver, WebElement image){
		boolean result = true;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(image.getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200)
				result = false;			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}
