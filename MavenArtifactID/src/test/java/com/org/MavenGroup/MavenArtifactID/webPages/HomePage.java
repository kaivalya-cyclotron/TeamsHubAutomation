/**
 * 
 */
package com.org.MavenGroup.MavenArtifactID.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author kaiva
 *
 */
public class HomePage {
	
	WebDriver driver;
	
	By searchText = By.id("SearchBox22");
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void typeSearch(String search)
	{
		driver.findElement(searchText).sendKeys(search);
	}

	
}
