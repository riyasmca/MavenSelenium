package com.selenium.testing.SeleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login_Chromedriver {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.10 Files\\chromedriver_win32_2.36\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				
		driver.get("http://leaftaps.com/opentaps/");

		driver.findElement(By.xpath("//input[contains(@name,'USERNAME')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[contains(@name,'PASSWORD')]")).sendKeys("crmsfa");

		//driver.findElement(By.xpath("//input[contains(@class,'decorativeSubmit')] ")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
