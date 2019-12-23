package com.org.MavenGroup.MavenArtifactID.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Feedback {
	
		WebDriver driver;
		WebDriverWait wait;

		
		By rating = (By.xpath("//button[contains(@id,'star-4')]"));	
		By feedbackText = (By.xpath("//textarea[contains(@placeholder,'Tell us what you')]"));
				
		String feedback = "Give Feedback";
		By GiveFeedbackButton = (By.xpath("//button[contains(.,'" + feedback + "')]"));
		
		String sendfeedback = "Send";
		By SendFeedbackButton = By.xpath("//button[contains(.,'" + sendfeedback + "')]");
		
		
		public Feedback(WebDriver driver, WebDriverWait wait)
		{
			this.driver= driver;
			this.wait = wait;
		}
				
		public void ClickGiveFeedbackButton()
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(GiveFeedbackButton));
			driver.findElement(GiveFeedbackButton).click();
		}
		
		public void GiveRating()
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(rating));
			driver.findElement(rating).click();
		}
		
		
		public void typeFeedback(String feedback_text)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackText));
			driver.findElement(feedbackText).sendKeys(feedback_text);
		}
		
		public void ClickSendFeedbackButton()
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(SendFeedbackButton));
			driver.findElement(SendFeedbackButton).click();
		}

}
