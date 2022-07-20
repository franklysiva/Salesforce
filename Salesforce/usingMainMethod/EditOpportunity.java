package com.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditOpportunity {
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.firefoxdriver().setup();
	FirefoxOptions options = new FirefoxOptions();
	options.addArguments("--disable-notifications");
	FirefoxDriver driver = new FirefoxDriver(options);
	driver.manage().window().maximize();
	driver.get(" https://login.salesforce.com");
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	driver.findElement(By.id("password")).sendKeys("Tuna@123");
	driver.findElement(By.id("Login")).click();
	new WebDriverWait(driver,  Duration.ofMinutes(1))
			.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
	new WebDriverWait(driver, Duration.ofMinutes(1))
			.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='slds-button']"))).click();
	new WebDriverWait(driver, Duration.ofMinutes(1))
			.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']"))).click();
	new WebDriverWait(driver, Duration.ofMinutes(1))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Opportunities']"))).click();
	new WebDriverWait(driver, Duration.ofMinutes(1))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Opportunity-search-input']")))
		.sendKeys("Salesforce Automation by Siva", Keys.ENTER);
	Thread.sleep(5000);
	WebElement showMoreElement = driver.findElement(By.xpath("(//tr//td//a[@role='button'])[1]"));
	driver.executeScript("arguments[0].click()", showMoreElement);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(@class,'actionMenu')]//li[@class='uiMenuItem']//a[@title='Edit']")).click();
	Thread.sleep(5000);
	WebElement closeDateElement = driver.findElement(By.xpath("//label[text()='Close Date']//following::input[@name='CloseDate']"));
	closeDateElement.clear();
	closeDateElement.sendKeys("7/21/2022");
	WebElement stageElement = driver.findElement(By.xpath("(//label[text()='Stage']//following::button)[1]"));
	stageElement.click();
	new WebDriverWait(driver, Duration.ofMinutes(1))
	.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='slds-media__body']")));
	new WebDriverWait(driver,  Duration.ofMinutes(1))
	.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='slds-media__body'])[7]"))).click();
	Thread.sleep(2000);
	WebElement deliveryElement = driver.findElement(By.xpath("//label[contains(text(),'Installation Status')]//following::div//span[@class='slds-truncate']"));
	driver.executeScript("arguments[0].scrollIntoView", deliveryElement);
	Thread.sleep(2000);
	driver.executeScript("arguments[0].click()", deliveryElement);
	new WebDriverWait(driver, Duration.ofMinutes(1))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[contains(text(),'Installation Status')]//following::div//span[@class='slds-media__body'])[2]"))).click();
	WebElement descElement = driver.findElement(By.xpath("//label[text()='Description']//following::textarea"));
	driver.executeScript("arguments[0].scrollIntoView", descElement);
	descElement.sendKeys("SalesForce");
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	Thread.sleep(5000);
	String currentStage = driver.findElement(By.xpath("//div[@class='slds-path']//a[@aria-checked='true']")).getAttribute("title");
	System.out.println("Stage Verified as: \""+currentStage+"\"");
	}
}