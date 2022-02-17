package seleniumsessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	public static WebDriver driver;
	
	public static void main(String[] args) {

		//WAP:
		//1. Total links
		//2. print the text of each link
		//3. print the href value of each link 
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		//By linklist = By.tagName("a");
		//List<WebElement> linksList= driver.findElements(By.tagName("a"));
		//System.out.println(linksList.size());
		
//		int c = 0;
//		for (WebElement ele : linksList) {
//		
//			String text = ele.getText();
//			if (!text.isEmpty()) {
//				System.out.println(c +" : "+ text);
//			}
//			System.out.println(ele.getAttribute("href"));
//			c++;
//		}
		
//		for( int i=0; i< linksList.size();i++) {
//
//			String text = linksList.get(i).getText();
//			if (!text.isEmpty()) {
//				System.out.println(i +" : "+ text);
//			}
//			System.out.println(linksList.get(i).getAttribute("href"));
//		}
		
		By linklist = By.tagName("a");//for links
		By images = By.tagName("img");//for images
		//printElementsList(linklist);
		//printElementsList(images);
		//System.out.println(getElementsCount(linklist));
		System.out.println(getElementsCount(images));
		
		if(getElementsTextList(linklist).contains("Gift Cards")) {
			
			System.out.println("Link exist: Gifts Cards");
		}
		
		List<String> altTextList = getElementsAttributeList(images, "alt");
		for (String s : altTextList) {
			
			System.out.println(s);
		}
		
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public static void printElementsList(By locator) {
		List <WebElement> elist = getElements(locator);
		for (WebElement wElement : elist) {
			System.out.println(wElement.getText());
		}	
	}
	
	public static WebElement getElement(By locator) {
		
		return driver.findElement(locator);		
	}
	
	public static String doGetAttribute(By Locator, String attValue) {
		
		return getElement(Locator).getAttribute(attValue);
	}
	
	/**
	 * This method will return list of elements text
	 * @param locator
	 * @return
	 */
	public static List<String> getElementsTextList(By locator) {
		List <WebElement> elist = getElements(locator);
		List <String> eTextlist = new ArrayList<String>();
		
		for (WebElement e : elist) {
			
			String text = e.getText();
			if(!text.isEmpty()) {
				eTextlist.add(text);
			}
		}
		return eTextlist;
	}
	
	/**
	 * This method will return list of elements attribute
	 * @param locator
	 * @return
	 */
	public static List<String> getElementsAttributeList(By locator, String attribute) {
		List <WebElement> elist = getElements(locator);
		List <String> attList = new ArrayList<String>();
		
		for (WebElement e : elist) {
			
			//String attr = doGetAttribute(locator, attribute);// by calling doGetAttribute method
			String attr = e.getAttribute(attribute);
			if(!attr.isEmpty()) {
				attList.add(attr);
			}
		}
		return attList;
	}
}