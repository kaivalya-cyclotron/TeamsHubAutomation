package com.org.MavenGroup.MavenArtifactID.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TeamRequests {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Identify all elements
	
	
	By TeamRequestSection = By.cssSelector("[title^='Team Requests']");
	By PendingApproval = By.xpath("//*[text()='Pending Approval']");
	By ApproveButton = By.xpath("//td[text()='Automation Team ID_12']/following-sibling::td/i[1]");
	
	public TeamRequests(WebDriver driver, WebDriverWait wait)
	{
		this.driver= driver;
		this.wait = wait;
	}
	
	public void TeamRequestSection()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(TeamRequestSection));
		driver.findElement(TeamRequestSection).click();
	}
	
	
	public void SelectPendingApproval()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(PendingApproval));
		driver.findElement(PendingApproval).click();
	}
	
	public void ClickApproveButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ApproveButton));
		driver.findElement(ApproveButton).click();
	}
	

	
		

}
