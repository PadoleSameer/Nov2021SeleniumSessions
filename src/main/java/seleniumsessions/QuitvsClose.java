package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitvsClose {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		String title = driver.getTitle();
		
		if(title.equals("google"))
			System.out.println("Correct Title");
		else
			System.out.println("Incorrect Title");
		
		System.out.println(driver.getCurrentUrl());
		
		//1. Quit
		//driver.quit();
		//System.out.println(driver.getCurrentUrl());//NoSuchSessionException:
		//Session ID is null. Using WebDriver after calling quit()?
		
		//driver = new ChromeDriver();//will create new session id
		//System.out.println(driver.getCurrentUrl());
		
		//2. Close
		driver.close();
		//System.out.println(driver.getCurrentUrl());//NoSuchSessionException
		//invalid session id
		driver = new ChromeDriver();
		System.out.println(driver.getCurrentUrl());
				
	}

}
