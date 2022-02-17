package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public static void main(String[] args) {
	
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/login");
		
		System.out.println(br.getPageTitle());
		
		By email = By.id("input-email");
		By pwd = By.id("input-password");
		
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.doSendKeys(email, "test123@yahoo.com");
		eUtil.doSendKeys(pwd, "9876543");
		
	}		
}
