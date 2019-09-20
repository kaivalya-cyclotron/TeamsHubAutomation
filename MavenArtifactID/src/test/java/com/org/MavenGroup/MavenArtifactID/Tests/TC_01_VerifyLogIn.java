/**
 * 
 */
package com.org.MavenGroup.MavenArtifactID.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.org.MavenGroup.MavenArtifactID.webPages.LogInPage;

/**
 * @author kaiva
 *
 */
public class TC_01_VerifyLogIn {
	
	@Test
	public void TC_01_LogIn()
	{
		
		 System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaiva\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	  
		
		driver.get("https://teamswebstaging.azurewebsites.net");	
		driver.manage().window().maximize();
		
		LogInPage LogIn = new LogInPage(driver);
		
		LogIn.typeUserName("kunal@cyclotrondev.com");
		LogIn.clickLogInButton();
		
		LogIn.typePassword("Metro@may");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogIn.clickLogInButton();
		
		
		LogIn.clickLogInButton();
		
		String actualTitle = driver.getTitle();
		 
		 String expectedTitle = "Teams Hub";
		 
		 	if(actualTitle.equalsIgnoreCase(expectedTitle))
		 			System.out.println("Title Matched - Test Case Passed");
		 	else
		 			System.out.println("Title didn't match - Test Case Failed");
			
	}

}


