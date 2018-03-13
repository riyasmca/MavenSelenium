package com.selenium.testing.SeleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumBasicOperation {

	public static void main(String[] args) throws InterruptedException {

		/*
		 *  Code for browser invoke through their property files from given files location or PATH 
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.10 Files\\chromedriver_win32_2.35\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		

		/*
		 * Code for Maximize the launch the browser window with maximum size and set the page load timeout 40 seconds include implicitly wait. 
		 */

		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);


		driver.get("http://leaftaps.com/opentaps/");

		/*
		 * Code for pass the values through send key.  
		 */


		driver.findElement(By.xpath("//input[contains(@name,'USERNAME')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[contains(@name,'PASSWORD')]")).sendKeys("crmsfa");


		/*
		 * Code for get the page titles and Current URL before login
		 */ 

		String PageTL1= driver.getTitle();
		System.out.println("Currnet Page Title Before Login --> : " +PageTL1);

		String CurrentUrl = driver.getCurrentUrl();
		System.out.println("Current URL Before Login --> " +CurrentUrl);



		/*
		 * Code for get the page titles and Current URL after login
		 */

		//Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		
		
		
		/*
		 * Code for fix the issue in "Exception in thread "main" org.openqa.selenium.WebDriverException: unknown error: Element <input class="decorativeSubmit" type="submit" value="Login"> is not clickable at point (158, 321). 
		 * Other element would receive the click: <iframe scrolling="no" frameborder="0" style="z-index: 2147483647; border: 0px; position: absolute; height: 70px; width: 185px; left: 109px; top: 293px;"></iframe>"
		 * 
		 * Module1 - Error
		 * 
		 * If we use below code then we are getting this error "Exception in thread "main" org.openqa.selenium.NoSuchElementException: 
		 * no such element: Unable to locate element: {"method":"xpath","selector":"//a[contains(text(),'CRM')]"}
		 * 
		 
		Module-1 -  Element not getting clicked due to JavaScript or AJAX calls present
		
		WebElement loginclick = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(loginclick).click().build().perform();
		
		Module-2
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@value,'Login')]")));
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
		
		Module-3
		
		
		WebElement myelement = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
		
		If we above code this we are hitting with --> Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//a[contains(text(),'CRM')]"}
			
		*/
		
		//fix Module - Element is present but having permanent Overlay.
		
		WebElement ele = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);

		String CurrentUrl1 = driver.getCurrentUrl();
		System.out.println("Current URL after Login --> " +CurrentUrl1);

		String PageTL2= driver.getTitle();
		System.out.println("Currnet Page Title after Login --> : " +PageTL2);

		/*
		 * Code for get the page titles and Current URL before CRM login
		 */ 

		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		Thread.sleep(2000);

		String CurrentUrl2 = driver.getCurrentUrl();
		System.out.println("Current URL Before CRM Click --> " +CurrentUrl2);

		String PageTL3= driver.getTitle();
		System.out.println("Currnet Page Title Before CRM Click --> : " +PageTL3);


		/*
		 * Code for get the page titles and Current URL After CRM login
		 */ 

		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		String CurrentUrl3 = driver.getCurrentUrl();
		System.out.println("Current URL After CRM Click --> " +CurrentUrl3);

		String PageTL4= driver.getTitle();
		System.out.println("Currnet Page Title After CRM Click --> : " +PageTL4);

		Thread.sleep(2000);

		System.out.println("Browser Quit");
		driver.quit();
	}

}
