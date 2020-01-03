package com.org.MavenGroup.MavenArtifactID.Tests;

import static org.testng.Assert.fail;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.org.MavenGroup.MavenArtifactID.webPages.CreateTeamPanel;
import com.org.MavenGroup.MavenArtifactID.webPages.Feedback;
import com.org.MavenGroup.MavenArtifactID.webPages.HomePage;
import com.org.MavenGroup.MavenArtifactID.webPages.HubPage;
import com.org.MavenGroup.MavenArtifactID.webPages.LogInPage;
import com.org.MavenGroup.MavenArtifactID.webPages.NewsLetter;
import com.org.MavenGroup.MavenArtifactID.webPages.TeamRequests;


import junit.framework.Assert;

/**
 * @author Kaivalya
 *
 */
public class SmokeTests {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public List <String> list;
	
	@BeforeTest
	public void setup() throws Exception 
	{
			
		System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

	@BeforeClass
	public void init() 
	{
		driver.get("https://teamsweb.azurewebsites.net/");
		driver.manage().window().maximize();	
	}
	
	
	@DataProvider(name="combination_list")
	public Iterator<Object[]> readData() throws IOException
	{
		    List<String> list=new ArrayList<String>();   

	        FileInputStream file = new FileInputStream(new File("BrowserDrivers/input.xlsx"));

	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	       
	        while (rowIterator.hasNext())
	        {
	            Row row = rowIterator.next();
	            
	            //For each row, iterate through all the columns
	            Iterator<Cell> cellIterator = row.cellIterator();

	            while (cellIterator.hasNext()) 
	            {
	            	
	                Cell cell = cellIterator.next();
		                if(cell.getColumnIndex()==0)
		                continue;
		                else
		                {
		                //Check the cell type and format accordingly
			                switch (cell.getCellType()) 
			                {
			                    case NUMERIC:
			                        //System.out.print(cell.getNumericCellValue() + "\t");
			                        break;
			                    case STRING:
			                       // System.out.print(cell.getStringCellValue() + "\t");
			                        list.add(cell.getStringCellValue());
			                        break;
			                }
		                }	            	           		
	            }
	        }
	        
	        int size_combination =list.size();
	        for(int i=0;i<size_combination;i++)
	        {
	        	System.out.println(list.get(i));
	        }
	        
	        String s1 = (String)  list.get(0);
	        String s2 = (String)  list.get(1);
	        String s3 = (String)  list.get(2);
	        
	        List<Map<String,String>> lom = new ArrayList<Map<String,String>>();
	      
	        Map<String,String> map1 = new HashMap<String,String>();

	        map1.put("URL",s1);
	        map1.put("username",s2);
	        map1.put("password",s3);
	       
	        lom.add(map1); 
	            
	        Collection<Object[]> dp = new ArrayList<Object[]>();
	        for(Map<String,String> map:lom)
	        {
	            dp.add(new Object[]{map});
	        }
	        
	        return dp.iterator();
	}
	
	@Test(priority = 1, dataProvider="combination_list")
	public void TC_01_LogIn(Map<String,String> map) {

		System.out.println("---------------------------------------------------------");
	
		LogInPage LogIn = new LogInPage(driver, wait);

		LogIn.clickLogInButtonHome();

		String window1 = driver.getWindowHandle();
		System.out.println(window1);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		
		LogIn.typeUserName(map.get("username"));
		LogIn.clickLogInButton();
		LogIn.typePassword(map.get("password"));
		LogIn.clickLogInButton();
		LogIn.clickLogInButton();

		// Switch back to original browser (first window)
		driver.switchTo().window(window1);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Home')]")));
		boolean isOnHome = driver.getPageSource().contains("Home");
	

		System.out.println("TC_01_LogIn Result: ");

		if (isOnHome == true)
			System.out.println("Title Matched - Logged in successfully");
		else
			Assert.fail("Title didn't match");
		System.out.println("---------------------------------------------------------");


	}


 
	@Test(priority = 2)
	public void TC_02_Team_Request() throws InterruptedException {

		CreateTeamPanel createT = new CreateTeamPanel(driver, wait);

		createT.clickCreateTeamButton();
		createT.typeOwnersPeoplePicker("kunal");
		createT.typeDisplayName("Automation Team ID_12");
		createT.typeDescription("This is sample team Request");
		createT.typeAliasName("Automation Team ID_12");
		// createT.clickOwnerSelection();

		Thread.sleep(12000);
		createT.clickSubmitButton();

		System.out.println("TC_02_Team_Request Result: ");
		System.out.println("Team Request sent to admin");

		System.out.println("---------------------------------------------------------");
	}

	

	@Test(priority = 3)
	public void TC_03_Approve_Request() throws InterruptedException
	{
		
		TeamRequests approve = new TeamRequests(driver, wait);
		
		System.out.println("TC_03_Approve_Request Result: ");
				
		//approve.TeamRequestSection();
		driver.get("https://teamsweb.azurewebsites.net/#TeamRequests");		
		Thread.sleep(3000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollTo(0,0)");

		Thread.sleep(3000);
		approve.SelectPendingApproval();

		Thread.sleep(3000);
		approve.ClickApproveButton();
		System.out.println("Team Request approved");
		System.out.println("---------------------------------------------------------");

	}

	@Test(priority = 4)
	public void TC_04_Search() throws InterruptedException {

		Thread.sleep(4000);
		
		driver.get("https://teamsweb.azurewebsites.net");
		
		HomePage homep = new HomePage(driver, wait);

		Thread.sleep(4000);
		homep.typeSearch("Cyclotron Dev");

		System.out.println("TC_04_Search Result: ");

		String actualTeamTitle = driver.findElement(By.xpath("//*[text()='Cyclotron Dev']")).getText();
		System.out.println("Team name identified in search result : " + actualTeamTitle);

		String expectedTitle = "Cyclotron Dev";

		if (actualTeamTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Search results are correct");
		else
			Assert.fail("Search results are incorrect");

		System.out.println("---------------------------------------------------------");

	}

	@Test(priority = 5)
	public void TC_05_Mark_As_A_Favorite() throws InterruptedException {

		Thread.sleep(8000);
		WebElement element = driver.findElement(By.xpath("//button[@id='favoriteId']/div/i"));
		String elementval = element.getAttribute("data-icon-name");

		System.out.println("TC_05_Mark_As_A_Favorite Result: ");

		if (elementval.equals("SingleBookmark")) {
			element.click();
			Thread.sleep(2000);
			WebElement element1 = driver.findElement(By.xpath("//button[@id='favoriteId']/div/i"));
			String elementval1 = element1.getAttribute("data-icon-name");

			if (elementval1.equals("SingleBookmarkSolid")) {
				System.out.println("Team marked as favorite");
			} else {
				Assert.fail("Failed to mark team as a favorite");
			}
		} else {
			System.out.println("Team is alredy marked as favorite");
		}

		System.out.println("---------------------------------------------------------");

	}

	@Test(priority = 6)
	public void TC_06_Save_Hub() throws InterruptedException 
	{
		
		driver.navigate().refresh();
		HomePage homep = new HomePage(driver, wait);
		homep.typeSearch("Account");
		Thread.sleep(2000);

		HubPage hubp = new HubPage(driver, wait);
		hubp.ClickSaveHubButton();
	
		hubp.TypeHubName("Account Hub");		
		Thread.sleep(10000);
		
		hubp.ClickSaveHub();
		Thread.sleep(4000);

		boolean isHub = driver.getPageSource().contains("Account Hub");

		System.out.println("TC_06_Save_Hub Result: ");

		if (isHub == true)
			System.out.println("Hub Saved and Verified");
		else
			Assert.fail("Hub not found");
		System.out.println("---------------------------------------------------------");
	}

	@Test(priority = 7)
	public void TC_07_CheckHub_Data() throws InterruptedException {
		Thread.sleep(4000);
		driver.get("https://teamsweb.azurewebsites.net/#MyHubs/AccountHub");

		Thread.sleep(10000);

		System.out.println("TC_07_CheckHub_Data Result: ");

		String searchKeyword = "Account";

		List<WebElement> teamname = driver.findElements(By.xpath("//div[contains(@class,'primaryText')]"));
		int teamsize = teamname.size() - 1;
		System.out.println("Number of teams:" + teamsize);

		List<WebElement> tags = driver.findElements(By.xpath("//i[contains(@data-icon-name,'Tag')]"));
		// System.out.println("Number of tag icons:" +tags.size());

		for (int i = 0; i < teamsize; i++) {

			System.out.println("Team Name : " + teamname.get(i + 1).getText());
			if (teamname.get(i + 1).getText().contains(searchKeyword)) {
				System.out.println("Team name matched with " + searchKeyword + "keyword");
			} else {
				tags.get(i).click();
				Thread.sleep(2000);
				String tagdata = driver.findElement(By.xpath("//div[contains(@class,'tags')]")).getText();
				System.out.println("Teams Tag Data = " + tagdata);
				driver.findElement(By.xpath("//i[contains(@data-icon-name,'KnowledgeArticle')]")).click();

				if (tagdata.contains(searchKeyword)) {
					System.out.println("One of the tag matched wih " + searchKeyword + "keyword");
				} else {
					Assert.fail("Team name/tag not matched - Test Case Failed");
				}

			}
			System.out.println("----------------------");
		}
		System.out.println("---------------------------------------------------------");
	}

	@Test(priority = 8)
	public void TC_08_Send_NewsLetter() throws InterruptedException {
		Thread.sleep(4000);
		NewsLetter news = new NewsLetter(driver, wait);

		System.out.println("TC_08_Send_NewsLetter Result: ");

		news.selectNewsLetterSection();

		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,0)");

		news.selectTemplateDropdown();
		Thread.sleep(2000);
		news.selectdropdownNewsletterValue();
		Thread.sleep(2000);

		// Scroll down
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		news.selectSpecificUserRadioButton();
		news.typeSepcificUserText("kaivalya");
		Thread.sleep(10000);
		news.submitNewsletterButton();
		System.out.println("Newsletter sent");
		System.out.println("---------------------------------------------------------");
	}

	@Test(priority = 9)
	public void TC_09_Send_Feedback() throws InterruptedException {
		Thread.sleep(4000);
		Feedback obj = new Feedback(driver, wait);

		System.out.println("TC_09_Send_Feedback Result:");

		obj.ClickGiveFeedbackButton();
		Thread.sleep(3000);
		obj.GiveRating();
		obj.typeFeedback("I like TeamsHub.");
		Thread.sleep(2000);
		obj.ClickSendFeedbackButton();
		System.out.println("Feedback sent");
		System.out.println("---------------------------------------------------------");

	}

	@Test(priority = 10)
	public void TC_10_Check_NewsLetter() throws Exception {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imap");
		props.setProperty("mail.imap.ssl.enable", "true");
		props.setProperty("mail.imaps.partialfetch", "false");
		props.put("mail.mime.base64.ignoreerrors", "true");

		Session mailSession = Session.getInstance(props);
		mailSession.setDebug(true);
		Store store = mailSession.getStore("imap");
		store.connect("outlook.office365.com", "kaivalya@cyclotrondev.com", "Metro@may");

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		System.out.println("TC_10_Check_NewsLetter Result:");

		System.out.println("Total Message:" + folder.getMessageCount());
		System.out.println("Unread Message:" + folder.getUnreadMessageCount());

		int Count = folder.getUnreadMessageCount();

		if (Count >= 1) {
			Message[] messages = folder.getMessages();

			for (Message mail : messages) {
				if (!mail.isSet(Flags.Flag.SEEN)) {
					System.out.println("*************************");
					System.out.println("MESSAGE : \n");

					System.out.println("Subject: " + mail.getSubject());
					System.out.println("From: " + mail.getFrom()[0]);
					System.out.println("To: " + mail.getAllRecipients()[0]);
					System.out.println("Date: " + mail.getReceivedDate());
					System.out.println("Size: " + mail.getSize());
					System.out.println("Body: \n" + mail.getContent().toString());

					String mailBody = mail.getContent().toString();

					if (mailBody.contains("Announcement")) {
						System.out.println("NewsLetter Receieved");
					} else {
						Assert.fail("Newsletter not receieved");
					}
				}
			}
		} else {
			Assert.fail("Newsletter not receieved");
		}

		System.out.println("---------------------------------------------------------");
	}


	@AfterTest
	public void terminateBrowser() {
		 driver.close();
	}
	
	 

}
