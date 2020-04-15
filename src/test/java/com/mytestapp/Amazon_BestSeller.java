package com.mytestapp;

import org.testng.annotations.Test;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon_BestSeller {
	public WebDriver driver;

	@BeforeTest
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
	}

	@Parameters({ "URL" })
	@BeforeMethod
	public void OpenURL(String url) {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test(priority = 2)
	public void Best_Sellers() throws InterruptedException {
		WebElement menu = driver.findElement(By.xpath("//div[@id='nav-xshop']"));
		List<WebElement> links = menu.findElements(By.tagName("a"));
		int count = links.size();
		for (int i = 0; i < count; i++) {
			System.out.println(links.get(i).getText());
		}
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
