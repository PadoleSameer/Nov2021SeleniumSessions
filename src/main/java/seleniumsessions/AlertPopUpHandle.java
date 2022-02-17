package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		//Alert : JS Alert Pop up//model pop up

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		
		//alert will pop-up
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		
		System.out.println(text);
		
		alert.accept(); //Click on ok
		//alert.dismiss(); //click on cancel
		
		//alert.sendKeys("test");
	
	}
}
