package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class WebElementCommands {
	WebDriver driver;

	@Test
	public void verifyloginToNicheThyselfIsSuccessful() throws InterruptedException {
		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		boolean isHeadLampEnabled = driver.findElement(By.name("ledheadlamp")).isEnabled();
		System.out.println(isHeadLampEnabled);
		WebElement parkSensor = driver.findElement(By.name("parksensor"));
		parkSensor.click();
		boolean isParkingSensorSelected = parkSensor.isSelected();
		System.out.println("Parkins Sensor is visible - " + parkSensor.isDisplayed());
		System.out.println(isParkingSensorSelected);
		Thread.sleep(5000);
		System.out.println(parkSensor.getTagName());
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		WebElement hiddenElement = driver.findElement(By.id("finish"));
		System.out.println("Hidden Element isDisplayed is False - " + hiddenElement.isDisplayed());
	}

//	@Test
	public void handlingCheckBox() throws InterruptedException {
		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		WebElement parkSensor = driver.findElement(By.name("parksensor"));

		if (!parkSensor.isSelected()) {
			parkSensor.click(); // This is not the right way.
		}
		// boolean isParkingSensorSelected = parkSensor.isSelected();

	}
	
	//@Test
	public void handlingDropDown() throws InterruptedException {
		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		WebElement dropdown = driver.findElement(By.name("make"));
		//driver.findElement(By.xpath("//option[@value = 'honda']")).click();
		Thread.sleep(5000);
		
		//Selenium has given us a class which will reduce the complexity for us. 
		//Select class
		
		Select make = new Select(dropdown);//Select construct requires WebElement which dropdown as a parameter
		assertEquals(make.isMultiple(),false);
		assertFalse(make.isMultiple());
		assertEquals(make.getFirstSelectedOption().getText(), "BMW");
		
		make.selectByVisibleText("Audi");
		Thread.sleep(3000);
		make.selectByValue("mercedes");
		Thread.sleep(3000);
		make.selectByIndex(3);
		Thread.sleep(3000);
		assertEquals(make.getFirstSelectedOption().getText(), "Honda");
		assertEquals(make.getOptions().size(),4);
		List<String> expectedOptions = new ArrayList<String>();
				
		expectedOptions.add("BMW");
		expectedOptions.add("Mercedes");
		expectedOptions.add("Audi1");
		expectedOptions.add("Honda");
		
		List<String> actualOptions = new ArrayList<String>();
		List<WebElement> allOptions =  make.getOptions();
		
		for (WebElement oneOption: allOptions) {
			actualOptions.add(oneOption.getText());
		}
		assertEquals(actualOptions, expectedOptions);
	}
	
	@Test
	public void handlingMultiSelect() throws InterruptedException {
		driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
		WebElement multiSelect = driver.findElement(By.name("color"));
		Select color = new Select(multiSelect);
		
		assertEquals(color.isMultiple(),true);
		assertTrue(color.isMultiple());
		color.selectByVisibleText("Black");
		color.selectByValue("sl");
		color.selectByIndex(2);
		Thread.sleep(3000);
		List<WebElement> allSelected = color.getAllSelectedOptions();
		
		for (WebElement selected : allSelected) {
			System.out.println("Selected Option " + selected.getText());
		}
		
		color.deselectByVisibleText("Silver");
		color.deselectByValue("rd");
		color.deselectByIndex(0);
		Thread.sleep(3000);
		color.selectByVisibleText("Black");
		color.selectByValue("sl");
		color.selectByIndex(2);
		Thread.sleep(3000);
		color.deselectAll();		
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
