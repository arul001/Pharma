package com.pharmaspectra.qa.testcase;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.pharmaspectra.qa.base.BaseClass;
import com.pharmaspectra.qa.pages.LoginPage;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;



public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {

		System.out.println("PharmaSpectra Project Initialization");
		driver.get(baseURL);
		this.takeElementScreenShot(driver, "1.Homepage");

		LoginPage lm = new LoginPage(driver);
		lm.setUserName(username);
		this.takeElementScreenShot(driver, "2.Username");
		lm.setPassword(password);
		this.takeElementScreenShot(driver, "3.Password");
		
		WebElement submt=driver.findElement(By.className("logSubmit"));
		highlightElement(submt, driver);
		this.takeElementScreenShot(driver, "4.submit");
		submt.click();
		//lm.clickSubmit();
		Thread.sleep(5000);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// Selecting Database
		driver.switchTo().frame("myiframe");
		this.takeElementScreenShot(driver, "5.BeforeSelectingDatabase");
		WebElement Demo = driver.findElement(By.linkText("Demo NSCLC - LINK"));
		highlightElement(Demo, driver);
		this.takeElementScreenShot(driver, "6.AfterSelectingDatabase");
		Demo.click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(5000);

		// search data
		this.takeElementScreenShot(driver, "7.SelectedDatabasePage");
		WebElement search = driver.findElement(By.xpath("//*[@id=\"activeSearch\"]"));
		highlightElement(search, driver);
		this.takeElementScreenShot(driver, "8.SearchButtonClick");
		search.click();
		Thread.sleep(5000);

		WebElement ele = driver.findElement(By.xpath("//input[@id='searchText']"));
		ele.click();
		highlightElement(ele, driver);
		this.takeElementScreenShot(driver, "9.BeforeSearchtxt");
		ele.sendKeys("Pain");
		this.takeElementScreenShot(driver, "10.AfterSearchtxt");

		WebElement userdata = driver.findElement(By.xpath("//input[@id='firstName']"));
		userdata.click();
		highlightElement(userdata, driver);
		this.takeElementScreenShot(driver, "11.BeforeUsernametxt");
		userdata.sendKeys("James");
		this.takeElementScreenShot(driver, "12.AfterUsernametxt");

		WebElement searchbtn = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		highlightElement(searchbtn, driver);
		this.takeElementScreenShot(driver, "13.ClickOnSearch");
		searchbtn.click();
		this.takeElementScreenShot(driver, "14.AfterSelectedSearchData");
		Thread.sleep(5000);

		WebElement chckbox = driver.findElement(By.xpath("//input[@id='chkBox0']"));
		highlightElement(chckbox, driver);
		this.takeElementScreenShot(driver, "15.BeforeCheckClick");
		chckbox.click();
		this.takeElementScreenShot(driver, "16.AfterCheckClick");
		Thread.sleep(5000);

		// Search result check
		WebElement James = driver.findElement(By.xpath("//a[contains(text(),'James Chih-Hsin Yang')]"));
		highlightElement(James, driver);
		this.takeElementScreenShot(driver, "17.JamesData");
		James.click();
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		// 1 overview
		
	//Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500,true).withName("17.Overview1").save();
//		Screenshot screenshot=((Object) new AShot().shootingStrategy).viewportPastingStrategy(100).takeScreenshot(driver);
//		ImageIO.write(screenshot.getImage(), "PNG", new File(""));
		this.takeElementScreenShot(driver, "18.Overview");
		driver.switchTo().frame("myiframe");

		// WebElement JamesHome =
		// driver.findElement(By.xpath("//a[contains(text(),'chihyang@ntu.edu.tw')]"));

		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		// 2 roles
		WebElement roles = driver.findElement(By.xpath("//p[contains(text(),'Roles - 18')]"));
		roles.click();
		highlightElement(roles, driver);
		//Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500,true).withName("18.AfterRolesClick1").save();
		this.takeElementScreenShot(driver, "19.AfterRolesClick");
		Thread.sleep(5000);

		driver.switchTo().frame("myiframe");

		// WebElement AllRoles =
		// driver.findElement(By.xpath("//td[contains(text(),'Planning and
		// Organization')]"));
		this.takeElementScreenShot(driver, "20.AllRolesClick");
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Thread.sleep(5000);

		WebElement currentRoles = driver.findElement(By.id("currRoles"));
		highlightElement(currentRoles, driver);
		this.takeElementScreenShot(driver, "21.BeforeCurrentRolesClick");
		currentRoles.click();
		this.takeElementScreenShot(driver, "22.AftercurrentRolesClick");

		WebElement PreRoles = driver.findElement(By.xpath("//div[@id='prevRoles']"));
		highlightElement(PreRoles, driver);
		this.takeElementScreenShot(driver, "23.BeforePreRolesClick");
		PreRoles.click();
		this.takeElementScreenShot(driver, "24.AfterPreRolesClick");

		WebElement education = driver.findElement(By.xpath("//div[@id='education']"));
		highlightElement(education, driver);
		this.takeElementScreenShot(driver, "25.BeforeEducationClick");
		education.click();
		this.takeElementScreenShot(driver, "26.AfterEducationClick");

		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		// 3 affiliations
		WebElement affiliationsMain = driver.findElement(By.xpath("//p[contains(text(),'Affiliations - 4')]"));

		affiliationsMain.click();
		highlightElement(affiliationsMain, driver);
		this.takeElementScreenShot(driver, "27.AfterAffiliationsClick");
		Thread.sleep(5000);

		driver.switchTo().frame("myiframe");

		WebElement EditRespoMemb = driver
				.findElement(By.xpath("//td[contains(text(),'Asia Pacific Journal of Clinical Oncology')]"));
		EditRespoMemb.click();
		this.takeElementScreenShot(driver, "28.AfterEditRespoMembClick");
		Thread.sleep(5000);

		WebElement sctyMemb = driver.findElement(By.xpath("//div[@id='sctyMemb']"));
		highlightElement(sctyMemb, driver);
		this.takeElementScreenShot(driver, "29.BeforeSctyMembClick");
		sctyMemb.click();
		this.takeElementScreenShot(driver, "30.AfterSctyMembClick");
		Thread.sleep(5000);

		WebElement award = driver.findElement(By.xpath("//div[@id='award']"));
		highlightElement(award, driver);
		this.takeElementScreenShot(driver, "31.BeforeAwardClick");
		award.click();
		this.takeElementScreenShot(driver, "32.AfterAwardClick");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		// 4 publications
		WebElement publication = driver.findElement(By.xpath("//p[contains(text(),'Publications - 2')]"));
		publication.click();
		highlightElement(publication, driver);
		this.takeElementScreenShot(driver, "33.AfterPublicationClick");
		Thread.sleep(5000);

		// maximize window page
		// driver.findElement(By.xpath("//body/div[@id='leftnavstyle']/div[@id='listLeft']/img[1]")).click();

		driver.switchTo().frame("myiframe");

		// click table data

		WebElement tabledata = driver.findElement(
				By.cssSelector("div:nth-child(4) table:nth-child(1) tbody:nth-child(1) tr.records1 > td:nth-child(2)"));
		this.takeElementScreenShot(driver, "34.BeforeSelectingtabledata");
		highlightElement(tabledata, driver);
		tabledata.click();
		this.takeElementScreenShot(driver, "35.AfterSelectingtabledata");

		Thread.sleep(5000);

		WebElement title1 = driver.findElement(By.xpath("//tbody/tr[@id='abstractTable_row1']/td[3]/font[1]/font[1]"));
		highlightElement(title1, driver);

		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		// driver.navigate().back();

		// // 2nd table data selecting
		// driver.switchTo().frame("myiframe");
		// WebElement tabledata2 =
		// driver.findElement(By.xpath("//span[contains(text(),'23328549')]"));
		// highlightElement(tabledata2, driver);
		// tabledata2.click();
		//
		// Thread.sleep(5000);
		//
		// WebElement title2 =
		// driver.findElement(By.xpath("//*[@id=\"abstractTable_row1\"]/td[3]/font[1]"));
		// takeElementScreenShot(title2, "table2Element");
		// highlightElement(title2, driver);
		//
		// driver.switchTo().defaultContent();

	}

	public void takeElementScreenShot(WebDriver driver, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("E:/Arul/Automation/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void highlightElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("background");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(135,206,250)", element, js);
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
