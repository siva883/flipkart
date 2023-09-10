package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstWebDriverTest {
		//"http://www.yahoomail.com"
	public static void main(String[] args) {
		// Open Chrome Browser
//		System.setProperty("webdriver.chrome.driver",
//				"test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.verboseLogging", "true");
		WebDriver driver = new ChromeDriver(); // Opens the chrome browser
		driver.manage().window().maximize();
		driver.get("https://nichethyself.com/tourism/home.html");
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("stc123");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("12345");
		
		//driver.findElement(By.name("password")).sendKeys("12345");
//		driver.findElement(By.name("password")).getText().toLowerCase().toUpperCase().equals("ABC");
		
		password.submit();
		String expectedPageTitleAfterLogin = "My account";
		String actualPageTitleAfterLogin = driver.getTitle();

		if (expectedPageTitleAfterLogin.equals(actualPageTitleAfterLogin)) {
			System.out.println("Test Case passsed.");
		} else {
			System.out.println("Test Case Failed. Expected was - " + expectedPageTitleAfterLogin + " But actual is - "
					+ actualPageTitleAfterLogin);
		}
		
		driver.quit();
	}

}
