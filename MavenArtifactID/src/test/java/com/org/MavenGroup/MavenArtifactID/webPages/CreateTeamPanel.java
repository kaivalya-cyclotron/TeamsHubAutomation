package com.org.MavenGroup.MavenArtifactID.webPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTeamPanel {
	
WebDriver driver;
WebDriverWait wait;

	
	// Identify all elements
	
	String CreateTeamButtonlabel = "Create a Team";
	By CreateTeamButton = (By.xpath("//button[contains(.,'" + CreateTeamButtonlabel + "')]"));
	
	String SubmitButtonLabel = "Submit";
	By SubmitButton = (By.xpath("//button[contains(.,'" + SubmitButtonLabel + "')]"));
	     
	By DisplayName = By.id("txtTeamName");
	By Description = By.id("txtTeamDescription");
	By AliasName = By.id("txtNickName");
	By OwnersPeoplePicker = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/div[2]/div/div/div[5]/div/div/div/div/div/input");
	By OwnersSelection  = By.xpath("/html/body/div[3]/div/div/div/div/div/div[3]/div[1]/div/button/div");
	
	
	public CreateTeamPanel(WebDriver driver, WebDriverWait wait)
	{
		this.driver= driver;
		this.wait = wait;
	}
	
	public void typeDisplayName(String name)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(DisplayName));
		driver.findElement(DisplayName).sendKeys(name);
	}

	public void typeDescription(String desc)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(Description));
		driver.findElement(Description).sendKeys(desc);
	}
	
	public void typeAliasName(String alias)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(AliasName));
		driver.findElement(AliasName).sendKeys(alias);
	}
	
	public void typeOwnersPeoplePicker(String ownerPicker)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(OwnersPeoplePicker));
		driver.findElement(OwnersPeoplePicker).sendKeys(ownerPicker);
	}
	

	public void clickSubmitButton()
	{
	   //wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
		driver.findElement(SubmitButton).click();
	}
	
	public void clickCreateTeamButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(CreateTeamButton));
		driver.findElement(CreateTeamButton).click();
	}

	
	public void clickOwnerSelection()
	{
		driver.findElement(OwnersSelection).click();
	}
}
