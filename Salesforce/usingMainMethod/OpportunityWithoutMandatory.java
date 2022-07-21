package com.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunityWithoutMandatory {
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='slds-button']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Opportunities']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New']"))).click();
		Thread.sleep(5000);
		WebElement closeDateElement = driver.findElement(By.xpath("//label[text()='Close Date']//following::input"));
		closeDateElement.sendKeys("7/22/2022");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(2000);
		String notification = driver.findElement(By.xpath("//div[@class='fieldLevelErrors']//strong")).getText();
		List<WebElement> errorFields = driver.findElements(By.xpath("//div[@class='fieldLevelErrors']//a"));
		String Field1 = errorFields.get(0).getText();
		String Field2 = errorFields.get(1).getText();
		System.out.print(notification+":\n"+Field1+"\n"+Field2);
	}
}
