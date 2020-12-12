/* Author Name : Mohammed Ashraff
 * From www.login.yahoo.com
 * Using Chrome Browser to logged in to Yahoo mail
 * using robot class to attached the file in mail 
 */

package com.yahoo.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooLoginFunction {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "D:\\Yahoomail\\Jar\\chromedriver.exe");
		//To Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//To Yahoo WebPage
		driver.get("https://login.yahoo.com/");
		
		//Wait Command
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Login credentials
		WebElement logininput = driver.findElement(By.id("login-username"));
		logininput.sendKeys("ashraff23.its@yahoo.com");
		
		WebElement nextbtn = driver.findElement(By.id("login-signin"));
		nextbtn.click();
		
		WebElement passinput = driver.findElement(By.id("login-passwd"));
		passinput.sendKeys("me7358060691");
		
		WebElement nextbtn1 = driver.findElement(By.id("login-signin"));
		nextbtn1.click();
		
		//Opening Mail Window
		WebElement mailbtn = driver.findElement(By.id("header-mail-button"));
		mailbtn.click();
		
		//Compose Button
		WebElement composebtn = driver.findElement(By.xpath("//*[@id=\'app\']/div[2]/div/div[1]/nav/div/div[1]/a"));
		composebtn.click();
		
		
		WebElement totext = driver.findElement(By.xpath("//*[@id=\'message-to-field\']"));
		totext.sendKeys("sample123@gmail.com");
				
		WebElement subjecttext = driver.findElement(By.xpath("//*[@id=\'mail-app-component\']/div/div/div[1]/div[3]/div/div/input"));
		subjecttext.sendKeys("Testing");
		
		WebElement contenttext = driver.findElement(By.xpath("//*[@id=\'editor-container\']/div[1]"));
		contenttext.sendKeys("Hi Good Morning");
		
		//Attachment Details
		WebElement attachbtn = driver.findElement(By.xpath("//*[@id=\'mail-app-component\']/div/div/div[2]/div[2]/div/span[1]/div/div/button"));
		attachbtn.click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement attachdocbtn = driver.findElement(By.xpath("//*[@id=\'app\']/div[7]/div/div[1]/div/ul/li[5]/button"));
		attachdocbtn.click();

		//Upload Window Control
		
		String file = "D:\\Yahoomail\\Test.xlsx";
		StringSelection selection = new StringSelection(file);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//Sending mail
		WebElement sendbtn = driver.findElement(By.xpath("//*[@id=\'mail-app-component\']/div/div/div[2]/div[2]/div/button"));
		sendbtn.click();
		

	}

}
