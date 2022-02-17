package seleniumsessions;

import java.time.Duration;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitNoWebElements {

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
		driver.get("https://www.amazon.com");
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		if(wait.until(ExpectedConditions.titleIs("Amazon.com. Spend less. Smile more."))){
//			System.out.println("Title of the page is correct");
//		}
		
		String title = doGetPageTitle("Amazon",5);
		System.out.println(title);
	}
	
	public static boolean waitForPageTitle(String titleVal, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.titleContains(titleVal));
	}
	
	public static String doGetPageTitle(String titleVal, int timeout) {
		
		if(waitForPageTitle(titleVal, timeout))
			return driver.getTitle();
		else
			return null;
	}
}
