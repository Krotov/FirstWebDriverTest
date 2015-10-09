package ua.pp.krotov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
	
	private WebDriver driver;
	
	@BeforeClass // Runs this method before the first test method in the current class is invoked
	public void setUp() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
	}
	
	@Test // Marking this method as part of the test
	public void gotoSeleniumWikiPage() {
		// Go to the Wikipedia home page
		driver.get("https://en.wikipedia.org/");
		// Find the text input element by its id and type "Selenium"
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		// Click search button		
		driver.findElement(By.id("searchButton")).click();
		// Get text from header of the Selenium page		
		String header = driver.findElement(By.id("firstHeading")).getText();
		// Verify that header equals "Selenium"		
		Assert.assertEquals(header, "Selenium");
	}
	
	@Test // Marking this method as part of the test
	public void gotoSeleniumWikiPageFailure() {
		// Go to the Wikipedia home page
		driver.get("https://en.wikipedia.org/");
		// Find the text input element by its id and type "Selenium"
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		// Click search button
		driver.findElement(By.id("searchButton")).click();
		// Get text from header of the Selenium page
		String header = driver.findElement(By.id("firstHeading")).getText();
		// Verify that header equals "Selenium WebDriver"
		Assert.assertEquals(header, "Selenium WebDriver");
	}
	
	@AfterClass // Runs this method after all the test methods in the current class have been run
	public void tearDown() {
		// Close all browser windows and safely end the session
		driver.quit();
	}

}
