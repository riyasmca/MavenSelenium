package com.selenium.testing.SeleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_Firefox {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*
		 * System.setProperty("webdriver.chrome.driver", "D:\\Selenium 2.53 Files\\chromedriver_win32\\chromedriver.exe");
		 * ChromeDriver driver = new ChromeDriver();
		 */
		
		WebDriver driver = new FirefoxDriver();
		 		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				
		driver.get("http://leaftaps.com/opentaps/");

		driver.findElement(By.xpath("//input[contains(@name,'USERNAME')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[contains(@name,'PASSWORD')]")).sendKeys("crmsfa");

		//driver.findElement(By.xpath("//input[contains(@class,'decorativeSubmit')] ")).click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		
		
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
