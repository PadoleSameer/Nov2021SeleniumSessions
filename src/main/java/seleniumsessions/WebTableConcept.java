package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		System.out.println(getCompanyName("Francisco Chang"));
		System.out.println(getCountryName("Francisco Chang"));

		System.out.println("Row Count :" + getRowsCount());
		System.out.println("Column Count :" + getColumnCount());

		// table[@id='customers']//tr[2]//td[1] 
		// table[@id='customers']//tr[3]//td[1]
		// table[@id='customers']//tr[4]//td[1]

		String beforeXpath = "//table[@id='customers']//tr[";
		String afterXpath = "]//td[";

//		for(int i=2;i<=getRowsCount();i++)
//		{
//			String xpath = beforeXpath + i +afterXpath;
//			String text = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(text);
//		}

		// Print entire table
		for (int row = 2; row <= getRowsCount(); row++) {
			for (int col = 1; col <= getColumnCount(); col++) {

				String xpath = beforeXpath + row + afterXpath + col + "]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text + "             ");
			}
			System.out.println();
		}

		List<String> companyNames = getCompanyColumnValues();
		System.out.println(companyNames);

		if (companyNames.contains("Island Trading")) {
			System.out.println("Company Exists");
		}

		List<String> contactNames = getContactColumnValues();
		System.out.println(contactNames);
		
		List<String> countryNames = getCountryColumnValues();
		System.out.println(countryNames);
	}

	public static List<String> getCompanyColumnValues() {

		String beforeXpath = "//table[@id='customers']//tr[";
		String afterXpath = "]//td[1]";

		List<String> companyNames = new ArrayList<String>();

		for (int i = 2; i <= getRowsCount(); i++) {
			String xpath = beforeXpath + i + afterXpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			// System.out.println(text);
			companyNames.add(text);
		}
		return companyNames;
	}

	public static List<String> getCountryColumnValues() {

		String beforeXpath = "//table[@id='customers']//tr[";
		String afterXpath = "]//td[3]";

		List<String> countryNames = new ArrayList<String>();

		for (int i = 2; i <= getRowsCount(); i++) {
			String xpath = beforeXpath + i + afterXpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			// System.out.println(text);
			countryNames.add(text);

		}
		return countryNames;
	}

	public static List<String> getContactColumnValues() {

		String beforeXpath = "//table[@id='customers']//tr[";
		String afterXpath = "]//td[2]";

		List<String> contactNames = new ArrayList<String>();

		for (int i = 2; i <= getRowsCount(); i++) {
			String xpath = beforeXpath + i + afterXpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			// System.out.println(text);
			contactNames.add(text);
		}
		return contactNames;
	}

	public static int getRowsCount() {

		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
	}

	public static int getColumnCount() {

		return driver.findElements(By.xpath("(//table[@id='customers']//tr)[1]//th")).size();
	}

	public static String getCompanyName(String contactName) {

		return driver.findElement(By.xpath("//td[text()='" + contactName + "']/preceding-sibling::td")).getText();
	}

	public static String getCountryName(String contactName) {

		return driver.findElement(By.xpath("//td[text()='" + contactName + "']/following-sibling::td")).getText();
	}
}