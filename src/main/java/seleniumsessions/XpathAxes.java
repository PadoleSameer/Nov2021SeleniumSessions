package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.context.Scope;

public class XpathAxes {

	public static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/india-in-south-africa-2021-22-1277060/south-africa-vs-india-1st-odi-1277082/full-scorecard");

		String name = getWicketTakerName("Aiden Markram");
		System.out.println(name);
		
		System.out.println(getPlayersScoreCard("Aiden Markram"));
	
	}

	public static List<String> getPlayersScoreCard(String batsman) {
		
		List<String> actualScoreList = new ArrayList<String>(); 
		//List<WebElement> scoreList=  
			//driver.findElements(By.xpath("//a[text()='"+batsman+"']/parent::td//following-sibling::td"));
		
		List<WebElement> scoreList=  
				driver.findElements(By.xpath("//table[@class='table batsman']//a[text()='"+batsman+"']/parent::td//following-sibling::td"));

		
		for(int i =1; i<scoreList.size(); i++) {
			
			String score = scoreList.get(i).getText();
			actualScoreList.add(score);
		}
		
		return actualScoreList;
	}
	public static String getWicketTakerName(String batsman) {

		WebElement batsMan = driver
				.findElement(By.xpath("//a[text()='"+batsman+"']/parent::td//following-sibling::td/span"));

		return batsMan.getText();
	}
}