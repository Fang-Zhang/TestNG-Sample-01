package com.testng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
	
	@Test
	public void TestGoogle() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorial", Keys.ENTER);
		String expectedTitle = "HYR Tutorial - Google Search";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		assertEquals(actualTitle, expectedTitle, "Title is matched!");
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void TestYahoo() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.yahoo.com/");
		driver.findElement(By.id("header-search-input")).sendKeys("HYR Tutorial", Keys.ENTER);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println(driver.getWindowHandle());
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void TestBing() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("HYR Tutorial", Keys.ENTER);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println(driver.getWindowHandle());
		Thread.sleep(5000);
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestFacebook() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // implicit wait 5 seconds
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        // driver.get("https://facebook.com/");
        driver.navigate().to("https://facebook.com/");
        driver.findElement(By.name("email")).sendKeys("walter");
        driver.findElement(By.name("pass")).sendKeys("123");
        driver.findElement(By.name("login")).click();
        
        //Soft assertion
        SoftAssert softAssert = new SoftAssert();
        
        // Title assertion
        String actualTitleSoft = driver.getTitle();
        String expectedTitleSoft = "Facebook - Log In or Sign Up";
        softAssert.assertEquals(actualTitleSoft, expectedTitleSoft, "Title is mismatched!");
        
        // URL assertion
        String actualUrlSoft = driver.getCurrentUrl();
        String expectedUrlSoft = "https://www.facebook.com/login/";
        softAssert.assertEquals(actualUrlSoft, expectedUrlSoft, "URL is matched!");
        
        // Text assertion
        String actualTextSoft = driver.findElement(By.name("email")).getAttribute("value");
        String expectedTextSoft = "";
        softAssert.assertNotEquals(actualTextSoft, expectedTextSoft, "Text is mismatched!");
        
        // Border assertion
        String actualBorderSoft = driver.findElement(By.name("email")).getCssValue("border");
        String expectedBorderSoft = "1px solid rgb(240, 40, 73)";	// red
        softAssert.assertNotEquals(actualBorderSoft, expectedBorderSoft, "Border is mismatched!");
        
        //Error message assertion
        String actualErrorMessageSoft = driver.findElement(By.xpath("(//div[@id=`email_container`]/div)[last()]")).getText();
        String expectedErrorMessageSoft = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
        softAssert.assertNotEquals(actualErrorMessageSoft, expectedErrorMessageSoft, "User error message is mismatched!");
        
        driver.quit();
        softAssert.assertAll();
        
        
//        //Hard assertion
//        
//        // Title assertion
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Facebook - Log In or Sign Up";
//        assertEquals(actualTitle, expectedTitle, "Title is mismatched!");
//        
//        // URL assertion
//        String actualUrl = driver.getCurrentUrl();
//        String expectedUrl = "https://www.facebook.com/login/";
//        assertEquals(actualUrl, expectedUrl, "URL is matched!");
//        
//        // Text assertion
//        String actualText = driver.findElement(By.name("email")).getAttribute("value");
//        String expectedText = "";
//        assertEquals(actualText, expectedText, "Text is mismatched!");
//        
//        // Border assertion
//        String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
//        String expectedBorder = "1px solid rgb(240, 40, 73)";	// red
//        assertEquals(actualBorder, expectedBorder, "Border is mismatched!");
//        
//        //Error message assertion
//        String actualErrorMessage = driver.findElement(By.xpath("(//div[@id=`email_container`]/div)[last()]")).getText();
//        String expectedErrorMessage = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
//        assertEquals(actualErrorMessage, expectedErrorMessage, "User error message is mismatched!");
        
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.quit();
	}
}
