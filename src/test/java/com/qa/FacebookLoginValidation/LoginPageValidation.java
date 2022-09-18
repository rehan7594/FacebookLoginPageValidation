package com.qa.FacebookLoginValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageValidation {
	WebDriver driver;
	public void login(String userName, String password) {  
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@BeforeMethod
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void loginWithCorrectUsernameAndWrongPassword() {
		login("rehansdm94@gmail.com", "rehandimple123");
		System.out.println("The password that you've entered is incorrect. Forgotten password?");
	}

	@Test
	public void loginWithoutUsernameAndPassword() {
		login("", "");
		System.out.println("The email address or mobile number you entered isn't connected to an account. Find your account and log in.");
	}

	@Test
	public void loginWithWrongUsernameAndCorrectPassword() {
		login("abc@gmail.com", "rehandimple");
		System.out.println("The password that you've entered is incorrect. Forgotten password?");
	}
	
	//	@AfterMethod
	//	public void tearDown() {
	//	    driver.close();
	//	}
}
