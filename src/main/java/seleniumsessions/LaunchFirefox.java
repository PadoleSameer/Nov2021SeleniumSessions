package seleniumsessions;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\spadole\\OneDrive - DXC Production\\Sameer\\Trainings\\AutomationNavin\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");//enter the url
		String title = driver.getTitle();//get title of the page
		driver.quit();
	}

}
