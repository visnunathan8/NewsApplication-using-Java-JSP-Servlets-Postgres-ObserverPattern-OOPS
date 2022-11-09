package com.concorida.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsAppApplicationTesting {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/4.21 Eclipse/project/Jars/chromedriver");
	  	WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/FinalTest/login.jsp");
		Thread.sleep(500);
		WebElement usernameDriver = driver.findElement(By.id("username"));
		usernameDriver.sendKeys("reviewer1");
		Thread.sleep(500);
		WebElement passwordDriver = driver.findElement(By.id("password"));
		passwordDriver.sendKeys("reviewer1");
		Thread.sleep(500);
		WebElement signin = driver.findElement(By.id("signin"));
		signin.click();
		
		
		WebElement common = driver.findElement(By.name("disptitle"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.name("headline"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.name("mpaa"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.name("critics"));
		common.sendKeys("1");
		Thread.sleep(500);
		common = driver.findElement(By.name("dateupdated"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.name("byline"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.name("openingdate"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.name("publicationdate"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.name("shortsummary"));
		common.sendKeys("display1");
		Thread.sleep(500);
		common = driver.findElement(By.id("submitButton"));
		common.click();
		Thread.sleep(500);
		common = driver.findElement(By.id("logout"));
		common.click();
		Thread.sleep(500);
		
		
	
		usernameDriver = driver.findElement(By.id("username"));
		usernameDriver.sendKeys("user1");
		Thread.sleep(500);
		passwordDriver = driver.findElement(By.id("password"));
		passwordDriver.sendKeys("user1");
		Thread.sleep(500);
		signin = driver.findElement(By.id("signin"));
		signin.click();
		
		common = driver.findElement(By.id("subContent"));
		String actual_title = common.getText();
		String expected_title = "display1";
		System.out.println(actual_title+"===="+expected_title);
		
		Assert.assertEquals(expected_title, actual_title);
  }
}
