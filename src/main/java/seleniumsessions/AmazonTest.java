package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		
		String browser = "chrome";
		BrowserUtil br = new BrowserUtil();
		br.launchBrowser(browser);
		br.enterUrl("https://amazon.com");
		
		String pageTitle = br.getPageTitle();
		
		if (pageTitle.contains("amazon"))
			System.out.println("Page title is : "+pageTitle);
		//br.quitBrowser();
		if(br.getPageURL().contains("amazon"))
			System.out.println("Page URL is "+br.getPageURL());
		
		br.quitBrowser();
	}

}
