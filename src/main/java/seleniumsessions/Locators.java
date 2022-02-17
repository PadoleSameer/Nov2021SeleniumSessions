package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//1. id: unique
		//2. name : can be duplicate
		//driver.findElement(By.name("email")).sendKeys("test@test.com");
		//driver.findElement(By.name("password")).sendKeys("pass@123");
		
		//3. Class name : Can be duplicate
		//driver.findElement(By.className("form-control")).sendKeys("hello");
		
		//4. Xpath : is not an attribute
		//address of the element in HTML DOM
		//abs xpath
		//relative xpath
		
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@12345");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
//		By email = By.xpath("//input[@id='input-email']");
//		By pwd = By.xpath("//input[@id='input-password']");
//		By loginBtn =By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		doSendKeys(email,"test@test.com");
//		doSendKeys(pwd,"test@1234");
//		doClick(loginBtn);
//		
		//5. CssSelector : is not an attribute
		//CSS : Cascaded Style Sheet
//		By eMail= By.cssSelector("#input-email");
//		By pwd = By.cssSelector("#input-password");
//		By loginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(eMail, "css@test.com");
//		doSendKeys(pwd, "test@123");
//		doClick(loginBtn);
	
		//6. linkText : Only for links : <a>
		//By register = By.linkText("Register");
		//doClick(register);
		
		//7. Partial link text : <a>
	//	By forgotPwd = By.partialLinkText("Forgotten");
	//	doClick(forgotPwd);
		
		//8. Tag name : HTML tag name
//		String label = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(label);
		By label = By.linkText("Register");
		System.out.println(doGetText(label));
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
}