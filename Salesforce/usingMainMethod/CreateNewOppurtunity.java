package com.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOppurtunity {
	public static void main(String[] args) {
	WebDriverManager.firefoxdriver().setup();
	// Disable Notification
	FirefoxOptions options = new FirefoxOptions();
	options.addArguments("--disable-notifications");
	FirefoxDriver driver = new FirefoxDriver(options);
	driver.manage().window().maximize();
	driver.get(" https://login.salesforce.com");
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	driver.findElement(By.id("password")).sendKeys("Tuna@123");
	driver.findElement(By.id("Login")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='slds-button']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Opportunities']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Opportunity Name']//following::input")))
		.sendKeys("Salesforce Automation by Siva");
	WebElement closeDateElement = driver.findElement(By.xpath("//label[text()='Close Date']//following::input"));
	closeDateElement.sendKeys("7/20/2022");
	WebElement stageElement = driver.findElement(By.xpath("(//label[text()='Stage']//following::button)[1]"));
	stageElement.click();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='slds-media__body']")));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='slds-media__body'])[4]"))).click();
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	WebElement createdName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1//slot")));
	String title = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]//a")).getAttribute("title");
	if (createdName.getText().equalsIgnoreCase(title))
		System.out.println("Verified Opportunity Name");
	}
}
