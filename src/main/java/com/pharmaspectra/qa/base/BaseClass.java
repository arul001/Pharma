package com.pharmaspectra.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.rules.Timeout;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.pharmaspectra.qa.utility.ReadConfig;
import com.pharmaspectra.qa.utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
 	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("chrome")) {
			 //WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "E:\\Arul\\Automation\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "E:\\Arul\\Automation\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	 @AfterClass
	 public void tearDown() {
	 driver.quit();
	 }

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot taken");
	}

}
