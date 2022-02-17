package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/register");

		System.out.println(br.getPageTitle());
		
		ElementUtil eUtil = new ElementUtil(driver);
		
		By fName = By.id("input-firstname");
		By lName = eUtil.getBy("name", "lastname");
		
		By eMail = By.xpath("//input[@id='input-email']");
		By telphone = By.cssSelector("#input-telephone");
		
		By pwd= By.id("input-password");
		By cnfPwd = By.id("input-confirm");
		
		By subYes = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
		By subNo = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
		
		By privacy = By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)");
	
		By submit = By.xpath("//input[@type='submit']");
		
		eUtil.doSendKeys(fName, "Sameer");
		eUtil.doSendKeys(lName, "Padole");
		
		eUtil.doSendKeys("xpath","//input[@id='input-email']","sam@sam234.com");
		
		eUtil.doSendKeys(telphone, "447799000");
		eUtil.doSendKeys(pwd, "123@123");
		eUtil.doSendKeys(cnfPwd,"123@123");
		
		eUtil.doClick(subNo);
		
		eUtil.doClick(privacy);
		
		eUtil.doClick(submit);

		if(driver.getPageSource().contains("Your Account Has Been Created!")) {
			System.out.println("Congratulations! Your new account has been successfully created!");
		}
		else if (driver.getPageSource().contains("Warning: E-Mail Address is already registered!")) {
			
			System.out.println("Account is already exists");
		}	
	}
}
