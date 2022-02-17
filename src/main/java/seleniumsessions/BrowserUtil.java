package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of browsername
	 * 
	 * @param browser
	 * @return webdriver
	 */
	public WebDriver launchBrowser(String browser) {

		driver = null;
		System.out.println("Browser name is " + browser);

		/*
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver",
				//	"C:\\Users\\spadole\\OneDrive - DXC Production\\Sameer\\Trainings\\AutomationNavin\\Drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver",
				///	"C:\\Users\\spadole\\OneDrive - DXC Production\\Sameer\\Trainings\\AutomationNavin\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver",
				//	"C:\\Users\\spadole\\OneDrive - DXC Production\\Sameer\\Trainings\\AutomationNavin\\Drivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else {
			System.out.println("Please pass the right browser...");
		}

		*/
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please pass the right browser...");
			break;
		}
		return driver;
	}

	/**
	 * Method to get the url launched
	 * 
	 * @param url
	 */
	public void enterUrl(String url) {
		System.out.println("URL is " + url);
		if (url.contains("http") || url.contains("https")) {
			driver.get(url);
		} else {
			
			System.out.println("Incorrect url");
			try {
			
				throw new Exception("INCORRECT URL. IT DOES NOT CONTAIN HTTP OR HTTPS");
			}
			catch(Exception e) {
				
			}
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}