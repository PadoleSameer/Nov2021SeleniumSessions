package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		Actions act = new Actions(driver);
		
		WebElement sourceEle= driver.findElement(By.id("draggable"));
		WebElement targetEle= driver.findElement(By.id("droppable"));
		
//		act
//			.clickAndHold(sourceEle)
//				.moveToElement(targetEle)
//					.release()
//						.build().perform();
		
		act.dragAndDrop(sourceEle, targetEle).build().perform();
	}
}
