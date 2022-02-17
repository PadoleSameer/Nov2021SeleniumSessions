package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {

	public static WebDriver driver;
	
	public static void main(String[] args) {

		// 2.b :Explicit wait
		// 2.b.1 :WebDriverWait ( class)
		// 2.b.2 :FluentWait ( class)

		// WebDriverWait(C) --> extends --> FluentWait(c) -->Implements --> Wait(I)
		// Until(){} 						Until(){} 						Until() method
		// other methods other methods

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By pwd = By.id("input-password");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement email_ele =  waitForElementPresense(emailId, 10);
		email_ele.sendKeys("test@test.com");
		
//		driver.findElement(pwd).sendKeys("@lt123456");
		getElement(pwd).sendKeys("@lt123456");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement waitForElementPresense(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
