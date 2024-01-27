package com.testng.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	@Test
	public void LauchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void Login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test
	public void NavigateToMyInfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	
	@Test
	public void VerifyMyInfo() {
		System.out.println(driver.findElement(By.id("employ-details")).isDisplayed());
	    driver.quit();
	}
	
	@Test
	public void VerifyLogin() {
		WebElement ele = driver.findElement(By.id("welcome"));
		System.out.println(ele.isDisplayed());
		System.out.println(ele.getText());
		driver.quit();
	}
	
	@Test
	public void Logout() {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}
	
	@Test
	public void Test1() {
		System.out.println("Test1");
	}
}
