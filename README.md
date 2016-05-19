# Selenium
Webdriver examples
Selenium webdriver v2.0. 
Examples (Java/Junit)

Below are my Selenium Webdriver 2 examples written in Java within JUnit.  Providing a simple concise usage of the following methods and classes, they demonstrate how I use the  webdriver and webelement classes to locate HTML and HTML5 elements within a Document Object Model (DOM).  These examples do not demonstrate a full testing framework but they are functional when executed using JUnit v4.12, Selenium Support v2.53.0 and Selenium-firefox-driver v2.53.

Examples of Webdriver API for locators used;

findElements(By.xpath(<xpath>)), 
findElements(By.cssSelector(<cssSelector >)), 
findElements(By.xpath(<xpath>)), 
findElements(By.cssSelector(<cssSelector >)), 
getDriver()
getcurrentURL()
WebElement and WebDriver classes
switchTo()
File Class:  exists(), delete()
sendKeys, 
FireFox Profile, 
fireFoxdriver, 
HTTPClient,
 HTTPResponse, 
HTTPClientBuilder, 
HTTPGet, 
GetWindowsHandles, 
Junit Annotations (@Test, @BeforeClass, @AfterClass), 
Assertions; 


JUnit tests;

ParkingCalc.java:

Demonstrates how to use locators such for Xpath and CSS, sendkeys, and validates that the calculation from the Scripts are providing the correct information on parking fees.

BrokenImage.java:

Selenium webdriver test to determine if images on the DOM are good.

ChallenginDOM:

Validation of when there are many different type of locators used.

CheckBoxes.java:

Validates that check boxes contain the initial box selected and are selectable as well as unselectable.

DynamicContent.java:

This example demonstrates how to handle dynamic and static content.

Upload and Download.java:

These demonstrate how to validate upload and downloading of files.

LoginPage:

Demonstrates how to validate the login user and password and what will happen if the user input bad credentials.

dropdownList.java:

How to select an item within a dropdown list.




