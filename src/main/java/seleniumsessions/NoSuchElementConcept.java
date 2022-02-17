package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {

	public static void main(String[] args) {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(By.id("input-email11")).sendKeys("test@test.com");
		//NoSuchElementException: no such element: Unable to locate element
	}

}
