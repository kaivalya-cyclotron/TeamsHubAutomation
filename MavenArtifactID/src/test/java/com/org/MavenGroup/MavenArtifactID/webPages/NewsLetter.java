package com.org.MavenGroup.MavenArtifactID.webPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewsLetter {

	
	WebDriver driver;
	WebDriverWait wait;
	
	// Identify all elements
	
	By NewsLetterSection = By.cssSelector("[title^='Newsletter']");
	By TemplateDropdown = By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div");
	By SpecificUserRadioButton =  By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/div/div/div[5]/div[1]/div/div/div/div/div[3]/div/label/span");
	By SepcificUserText = By.xpath("//*[@id='root']/div/div/div/div/div[2]/div[2]/div/div/div[5]/div[3]/div/div[2]/div/div/div/div/div/input");
	
	String dropdownNewsletterValue = "Announcement";
	By Newsletter = (By.xpath("//button[contains(.,'" + dropdownNewsletterValue + "')]"));
	
	String submitNewsletterButton = "Submit";
	By submitNewsletter = (By.xpath("//button[contains(.,'" + submitNewsletterButton + "')]"));
	
	
	public NewsLetter(WebDriver driver, WebDriverWait wait)
	{
		this.driver= driver;
		this.wait = wait;
	}
	
	public void selectNewsLetterSection()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(NewsLetterSection));
		driver.findElement(NewsLetterSection).click();
	}
	
	
	public void selectTemplateDropdown()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateDropdown));
		driver.findElement(TemplateDropdown).click();
	}
	
	public void selectdropdownNewsletterValue()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(Newsletter));
		driver.findElement(Newsletter).click();
	}
	
	public void selectSpecificUserRadioButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SpecificUserRadioButton));
		driver.findElement(SpecificUserRadioButton).click();
	}

	public void typeSepcificUserText(String news_user)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(SepcificUserText));
		driver.findElement(SepcificUserText).sendKeys(news_user);
	}
	
	public void submitNewsletterButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitNewsletter));
		driver.findElement(submitNewsletter).click();
	}
		

}
