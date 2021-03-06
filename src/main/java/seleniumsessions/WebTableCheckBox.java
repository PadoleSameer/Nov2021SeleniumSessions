package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckBox {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		selectEmployee("Joe.Root");
		selectEmployee("Kevin.Mathews");
		
	}

	public static void selectEmployee(String name) {
		
		String xpath = "//a[text()='"+name+"']//parent::td//preceding-sibling::td//child::input";		
		driver.findElement(By.xpath(xpath)).click();

	}
}
