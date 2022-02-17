package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//win
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\spadole\\OneDrive - DXC Production\\Sameer\\Trainings\\AutomationNavin\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		//automation steps
		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("https://www.google.com");//enter the url
		
		String title = driver.getTitle();//get the title of the page
		System.out.println(title);
		
		//verification point/checkpoint/actual vs expected:
		if(title.equals("Google"))
			System.out.println("Correct title");
		else
			System.out.println("Correct title");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
		driver.quit();
	}

}
