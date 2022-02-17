package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcepts {

	public static WebDriver driver;
	
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//create webelement(WE)
		//WE = By locator
		//Create a web element + action(click, sendKeys, isDisplayed)
		
		//1.
		//driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("123456");
		
		
		//2.
//		WebElement emailID =  driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailID.sendKeys("test@gmail.com");
//		password.sendKeys("123456");
//		
		//3. By locator
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailId = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//		
//		emailId.sendKeys("test@gmail.com");
//		pwd.sendKeys("123456");
		
		//4. By locator with generic method
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//
//		WebElement emailId = getElement(email);
//		WebElement pwd = getElement(password);
//		
//		emailId.sendKeys("test@gmail.com");
//		pwd.sendKeys("123456");
		
		//5. By Locator with getElement and actions generic methods.
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "test@gmail.com");
//		doSendKeys(password, "123456");
//		
		//6. By Locator with getElement and actions generic methods in util class
	
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleutil = new ElementUtil(driver);
//		eleutil.doSendKeys(email, "test123@gmail.com");
//		eleutil.doSendKeys(password, "123456");
//		
		//7. String Locator with getElement and actions generic methods in util class
		
		String email = "input-email";
		String password = "input-password";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		//eleUtil.doSendKeys(getBy("id",email),"test456@gmail.com");
		//eleUtil.doSendKeys(getBy("id",password), "123456");
		
		doSendKeys("id", email,"test890@gmail.com");
		doSendKeys("id", password, "12345678");
	}
	
	public static By getBy(String locatorType, String value) {
		
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator =  By.id(value);
			break;

		default:
			break;
		}
		return locator;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);		
	}
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	//Overloaded function
	public static void doSendKeys(String locatorType,String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}
}