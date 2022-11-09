//package com.concordia.testing;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class userAccount {
//
//	@Test
//	public void t_01_validate_login_zero_app_ {
//		
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:8080/FinalTest/login.jsp");
//		driver.findElement(By.id("username"));
//		WebElement usernameDriver = driver.findElement(By.id("username"));
//		usernameDriver.sendKeys("admin");
//		
//		WebElement passwordDriver = driver.findElement(By.id("password"));
//		passwordDriver.sendKeys("admin");
//		
//		WebElement signin = driver.findElement(By.id("signin"));
//		signin.click();
//		
//		String expected_title = "NewsApp";
//		String actual_title = driver.getTitle();
//		Assert.assertEquals(expected_title, actual_title);
//	}
//
//}
