package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class autosuggestiveconcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yadav\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.ksrtc.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
	
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String script= "return document.getElementById(\"fromPlaceName\").value;";
		String text=(String) js.executeScript(script);
		int i=0;
		
		
		
		while(!text.equalsIgnoreCase("BENGALURU INATION AIPORT")) { //when spelling is changed and there is no such value is present then checking value of i 
			//and breaking while loop
			
			 System.out.println(text);
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			 text=(String) js.executeScript(script);
			
			 if(i>10) {
				 break;
			 }
		}
		if(i>10) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element is found in second scripts ");
		}
	}
}
