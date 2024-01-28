package com.testng.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@BeforeTest
	public void InitialiseBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
	@Test
	public void LauchApp() throws Exception {
		System.out.println("Lauching App");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(10000);
	}
	
	@Test
	public void Login() throws Exception {
		System.out.println("Login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void NavigateToMyInfo() throws Exception {
		System.out.println("NavigateToMyInfo");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void VerifyMyInfo() {
		System.out.println("VerifyMyInfo");
		System.out.println(driver.findElement(By.className("orangehrm-edit-employee-content")).isDisplayed());
	}
	
	@Test
	public void VerifyLogin() {
		System.out.println("VerifyLogin");
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		System.out.println(ele.isDisplayed());
		System.out.println(ele.getText());
	}
	
	@Test
	public void Logout() {
		System.out.println("Logout");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	}
}
