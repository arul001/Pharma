package com.pharmaspectra.qa.testcase;

import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pharmaspectra.qa.base.BaseClass;
import com.pharmaspectra.qa.pages.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	

	@Test
	public void loginTest() throws InterruptedException {

		System.out.println("PharmaSpectra Project Initialization");
		driver.get(baseURL);

		LoginPage lm = new LoginPage(driver);
		lm.setUserName(username);
		lm.setPassword(password);
		lm.clickSubmit();

		Thread.sleep(5000);

		// Selecting Database
		driver.switchTo().frame("myiframe");

		WebElement Demo = driver.findElement(By.linkText("Demo NSCLC - LINK"));
		highlightElement(Demo, driver);
		takeElementScreenShot(Demo, "DemoElement");
		Demo.click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(5000);

		// search data
		driver.findElement(By.xpath("//*[@id=\"activeSearch\"]")).click();
		Thread.sleep(5000);

		WebElement ele = driver.findElement(By.xpath("//input[@id='searchText']"));
		ele.click();
		ele.sendKeys("Pain");

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("James");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='chkBox0']")).click();
		Thread.sleep(5000);

		// Search result check
		WebElement James = driver.findElement(By.xpath("//a[contains(text(),'James Chih-Hsin Yang')]"));
		highlightElement(James, driver);
		takeElementScreenShot(James, "JamesElement");
		James.click();
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		// 1 overview
		driver.switchTo().frame("myiframe");

		WebElement JamesHome = driver.findElement(By.xpath("//a[contains(text(),'chihyang@ntu.edu.tw')]"));
		takeElementScreenShot(JamesHome, "JamesHomeElement");

		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		// 2 roles
		WebElement roles = driver.findElement(By.xpath("//p[contains(text(),'Roles - 18')]"));
		roles.click();
//		takeElementScreenShot(roles, "roles");
		Thread.sleep(5000);

		driver.switchTo().frame("myiframe");

		WebElement AllRoles = driver.findElement(By.xpath("//td[contains(text(),'Planning and Organization')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
		takeElementScreenShot(AllRoles, "AllRolesElement");
		Thread.sleep(5000);

		WebElement currentRoles = driver.findElement(By.id("currRoles"));
		currentRoles.click();
		takeElementScreenShot(currentRoles, "currentRolesElement");

		WebElement PreRoles = driver.findElement(By.xpath("//div[@id='prevRoles']"));
		PreRoles.click();
		takeElementScreenShot(PreRoles, "PreRolesElement");

		WebElement education = driver.findElement(By.xpath("//div[@id='education']"));
		education.click();
		takeElementScreenShot(education, "educationElement");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		// 3 affiliations
		WebElement affiliationsMain = driver.findElement(By.xpath("//p[contains(text(),'Affiliations - 4')]"));
		affiliationsMain.click();
//		takeElementScreenShot(affiliationsMain, "affiliationsMainElement");
		Thread.sleep(5000);

		driver.switchTo().frame("myiframe");
		
		WebElement EditRespoMemb = driver.findElement(By.xpath("//td[contains(text(),'Asia Pacific Journal of Clinical Oncology')]"));
		EditRespoMemb.click();
		takeElementScreenShot(EditRespoMemb, "EditRespoMembElement");
		Thread.sleep(5000);
		
		WebElement sctyMemb = driver.findElement(By.xpath("//div[@id='sctyMemb']"));
		sctyMemb.click();
		takeElementScreenShot(sctyMemb, "sctyMembElement");
		Thread.sleep(5000);

		WebElement award = driver.findElement(By.xpath("//div[@id='award']"));
		award.click();
		takeElementScreenShot(award, "awardElement");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		// 4 publications
		WebElement publication = driver.findElement(By.xpath("//p[contains(text(),'Publications - 2')]"));
		publication.click();
//		takeElementScreenShot(publication, "publicationElement");
		Thread.sleep(5000);
		
		

		// maximize window page
		driver.findElement(By.xpath("//body/div[@id='leftnavstyle']/div[@id='listLeft']/img[1]")).click();

		driver.switchTo().frame("myiframe");

		// click table data
		WebElement tabledata = driver.findElement(
				By.cssSelector("div:nth-child(4) table:nth-child(1) tbody:nth-child(1) tr.records1 > td:nth-child(2)"));
		takeElementScreenShot(tabledata, "tabledataElement");
		highlightElement(tabledata, driver);
		tabledata.click();

		Thread.sleep(5000);

		WebElement title1 = driver.findElement(By.xpath("//tbody/tr[@id='abstractTable_row1']/td[3]/font[1]/font[1]"));
		takeElementScreenShot(title1, "table1Element");
		highlightElement(title1, driver);

		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		driver.navigate().back();
		
		driver.switchTo().frame("myiframe");


		// 2nd table data selecting
		WebElement tabledata2 = driver.findElement(By.xpath("//span[contains(text(),'23328549')]"));
		highlightElement(tabledata2, driver);
		tabledata2.click();

		Thread.sleep(5000);

		WebElement title2 = driver.findElement(By.xpath("//*[@id=\"abstractTable_row1\"]/td[3]/font[1]"));
		takeElementScreenShot(title2, "table2Element");
		highlightElement(title2, driver);

		driver.switchTo().defaultContent();

	}

	public static void takeElementScreenShot(WebElement element, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public static void takeElementScreenShot(WebElement element, String fileName)
	// {
	// File srcFile=element.getScreenshotAs(OutputType.FILE);
	// try {
	// FileUtils.copyFile(srcFile,new File("./target/screenshots/"+
	// fileName+".png"));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public static void highlightElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("background");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, js);
			changeColor(bgcolor, element, js);
		}
	}

	public static void changeColor(String color, WebElement element, JavascriptExecutor js) {
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
		try {
			Thread.sleep(20);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
