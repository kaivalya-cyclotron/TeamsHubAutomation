package com.org.MavenGroup.MavenArtifactID.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HubPage {
	

	WebDriver driver;
	WebDriverWait wait;
	
	
	String SaveHubButtonlabel = "Save Hub";
	By SaveHubButton = By.xpath("//button[contains(.,'" + SaveHubButtonlabel + "')]");
	
	By HubName = By.id("txtHubName");
	By SaveHub = By.xpath("//i[contains(@data-icon-name,'Accept')]");

	public HubPage(WebDriver driver, WebDriverWait wait)
	{
		this.driver= driver;
		this.wait = wait;
	}
	
	
	public void ClickSaveHubButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveHubButton));
		driver.findElement(SaveHubButton).click();
	}
	
	public void TypeHubName(String hubname_by_user)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(HubName));
		driver.findElement(HubName).sendKeys(hubname_by_user);
	}
	
	
	public void ClickSaveHub()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveHub));
		driver.findElement(SaveHub).click();
	}
	
}
