package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstWebDriverTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); // Opens the chrome browser
		driver.manage().window().minimize();
		driver.get("https://nichethyself.com/tourism/home.html");
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("stc123");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("12345");
		
		
		password.submit();
		String expectedPageTitleAfterLogin = "My account";
		String actualPageTitleAfterLogin = driver.getTitle();

		if (expectedPageTitleAfterLogin.equals(actualPageTitleAfterLogin)) {
			System.out.println("Test Case passsed.");
		} else {
			System.out.println("Test Case Failed. Expected was - " + expectedPageTitleAfterLogin + " But actual is - "
					+ actualPageTitleAfterLogin);
		}
		//This will close the browser. 
		driver.quit();
	}

}
