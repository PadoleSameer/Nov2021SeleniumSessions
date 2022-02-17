package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");//launch the URL
		System.out.println("Title of the window is "+driver.getTitle());
		
		driver.navigate().to("http://amazon.com");
		System.out.println("Title of the window is "+driver.getTitle());
		
		driver.navigate().back();
		//Google
		System.out.println("Title of the window is "+driver.getTitle());
		
		driver.navigate().forward();
		//amazon
		System.out.println("Title of the window is "+driver.getTitle());
		
		driver.navigate().refresh();
	}

}
