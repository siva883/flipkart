package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsExamples {
	WebDriver driver;

	@Test
	public void testSuccessfulLoginToNicheThyself() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");

		// How to ask Selenium to get a particular field/element?
//		WebElement user = driver.findElement(By.name("username"));
		WebElement user = driver.findElement(with(By.tagName("a"))
		        .toLeftOf(By.xpath("//a[text()='All about the world']")));
//		        .below(By.id("logo")));
		
		
		WebElement passwordField = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(with(By.tagName("input")).above(passwordField));
		passwordField.sendKeys("12345");
		email.sendKeys("stc123");
		Thread.sleep(4000);
		
		System.out.println(user.getText());

	}
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
		
	}

	@BeforeClass
	public void beforeClass() {
		String browser = "CH";

		if (browser.equals("CH")) {
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
