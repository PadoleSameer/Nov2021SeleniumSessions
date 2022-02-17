package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClickSendKeys {

	public static WebDriver driver;
	
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		By fn = By.id("input-firstname");
		By ln = By.id("input-lastname");
		By continueBtn= By.xpath("//input[@value='Continue']");
		
		Actions act = new Actions(driver);
		
//		act.sendKeys(driver.findElement(fn),"test@gmail.com").perform();
//		act.sendKeys(driver.findElement(ln),"automation").perform();
//		act.click(driver.findElement(continueBtn)).perform();
		
		actionsSendKeys(fn, "Sameer");
		actionsSendKeys(ln, "automation");
		actionsClick(continueBtn);
		
	}
	public static WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}
		
	public static void actionsSendKeys(By locator, String value) {
		
		WebElement ele = getElement(locator);
		Actions a = new Actions(driver);
		a.sendKeys(ele, value).perform();
	}
	
	/**
	 * Clicks in the middle of the given element. 
	 * Equivalent to: Actions.moveToElement(onElement).click()
	 * @param locator
	 */
	public static void actionsClick(By locator) {
		
		WebElement ele = getElement(locator);
		Actions a = new Actions(driver);
		a.click(ele).perform();
	}
}
