package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUp {

	public static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		String username= "admin";
		String password = "admin";
		
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		
		//CDP Tool : selenium 4
	}

}
