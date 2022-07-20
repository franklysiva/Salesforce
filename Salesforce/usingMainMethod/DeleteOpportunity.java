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

public class DeleteOpportunity {
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
	Thread.sleep(2000);
	WebElement showMoreElement = driver.findElement(By.xpath("(//tr//td//a[@role='button'])[1]"));
	driver.executeScript("arguments[0].click()", showMoreElement);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(@class,'actionMenu')]//li[@class='uiMenuItem']//a[@title='Delete']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Delete']")).click();
	String toastMsg = new WebDriverWait(driver, Duration.ofSeconds(30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='forceActionLink']//parent::span"))).getText();
	System.out.println(toastMsg.substring(0,toastMsg.length()-5));
	}
}
