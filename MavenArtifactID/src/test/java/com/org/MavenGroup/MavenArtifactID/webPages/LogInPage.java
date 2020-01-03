package com.org.MavenGroup.MavenArtifactID.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  LogInPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Identify all elements
	
	By UserName = By.id("i0116");
	By Password = By.id("i0118");
	
	By LogInButtonHome = By.xpath("/html/body/div/div/div/div/div/button");

	By LogInButton = By.id("idSIButton9");
	
	// 
	public LogInPage(WebDriver driver, WebDriverWait wait)
	{
		this.driver= driver;
		this.wait = wait;
	}
	
	public void typeUserName(String uname)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
		driver.findElement(UserName).sendKeys(uname);
	}

	
	public void typePassword(String pwd)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
		driver.findElement(Password).sendKeys(pwd);
	}
	

	public void clickLogInButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		
		driver.findElement(LogInButton).click();
	}
	
	public void clickLogInButtonHome()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/div/button")));
		driver.findElement(LogInButtonHome).click();
	}
	
	
	
}
