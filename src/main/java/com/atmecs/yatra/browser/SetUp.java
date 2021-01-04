package com.atmecs.yatra.browser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.atmecs.yatra.constants.FilePathClass;
import com.atmecs.yatra.util.PropertyReader;

public class SetUp {
	public WebDriver driver;
	public static PropertyReader reader;

	@BeforeMethod
	@Parameters("browser")
	public void browserSetUp(String browser) throws FileNotFoundException, IOException {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", FilePathClass.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			reader = new PropertyReader(FilePathClass.CONFIGURATION_HOME);

			String url = reader.get("url");
			driver.get(url);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FilePathClass.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			reader = new PropertyReader(FilePathClass.CONFIGURATION_HOME);

			String url = reader.get("url");
			driver.get(url);

			driver.manage().window().maximize();

		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		;
	}
}
