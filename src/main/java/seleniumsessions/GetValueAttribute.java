package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetValueAttribute {

	public static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId =By.id("input-email");
		doSendKeys(emailId, "test@test.com");		
			
		System.out.println(doGetAttribute(emailId, "value"));
		System.out.println(doGetAttribute(emailId, "Type"));
		System.out.println(doGetAttribute(emailId, "placeholder"));
		System.out.println(doGetAttribute(emailId, "id"));
	}
	
	public static By getBy(String locatorType, String locatorValue) {
		
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator =  By.id(locatorValue);
			break;
			
		case "name":
			locator =  By.name(locatorValue);
			break;
			
		case "xpath":
			locator =  By.xpath(locatorValue);
			break;
			
		case "className":
			locator =  By.className(locatorValue);
			break;
			
		case "cssSelector":
			locator =  By.cssSelector(locatorValue);
			break;
			
		default:
			break;
		}
		return locator;
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);		
	}
	
	public static String doGetText(By locator) {
		
		return getElement(locator).getText();
	}
	
	public static String doGetAttribute(By Locator, String attValue) {
		
		return getElement(Locator).getAttribute(attValue);
	}
	
	public static String doGetAttribute(String LocatorType, String LocatorValue, String attValue) {
		
		return getElement(getBy(LocatorType, LocatorValue)).getAttribute(attValue);
	}
}