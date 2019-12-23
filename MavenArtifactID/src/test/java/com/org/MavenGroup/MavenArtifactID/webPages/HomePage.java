/**
 * 
 */
package com.org.MavenGroup.MavenArtifactID.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author kaiva
 *
 */
public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By searchText = By.xpath("//input[@placeholder='Search for Teams']");
	

	public HomePage(WebDriver driver, WebDriverWait wait)
	{
		this.driver= driver;
		this.wait = wait;
	}
	
	public void typeSearch(String search)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchText));
		driver.findElement(searchText).sendKeys(search);
		driver.findElement(searchText).sendKeys(Keys.ENTER);
		//System.out.println("element found");
	}
	
	
}

