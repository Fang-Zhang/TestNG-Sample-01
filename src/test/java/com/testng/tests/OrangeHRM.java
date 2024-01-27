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
	public void LauchApp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
	}
	
	@Test
	public void Login() throws Exception {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void NavigateToMyInfo() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void VerifyMyInfo() {
		System.out.println(driver.findElement(By.className("orangehrm-edit-employee-content")).isDisplayed());
	    driver.quit();
	}
	
	@Test
	public void VerifyLogin() {
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		System.out.println(ele.isDisplayed());
		System.out.println(ele.getText());
		driver.quit();
	}
	
	@Test
	public void Logout() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		driver.quit();
	}
}
