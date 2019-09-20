package com.org.MavenGroup.MavenArtifactID.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
	
	WebDriver driver;
	
	// Identify all elements
	
	By UserName = By.id("i0116");
	By Password = By.id("i0118");
	By LogInButton = By.id("idSIButton9");
	
	// 
	public LogInPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void typeUserName(String uname)
	{
		driver.findElement(UserName).sendKeys(uname);
	}

	
	public void typePassword(String pwd)
	{
		driver.findElement(Password).sendKeys(pwd);
	}
	

	public void clickLogInButton()
	{
		driver.findElement(LogInButton).click();
	}
}
