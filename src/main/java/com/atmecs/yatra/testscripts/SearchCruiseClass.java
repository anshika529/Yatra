package com.atmecs.yatra.testscripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.yatra.browser.SetUp;
import com.atmecs.yatra.constants.FilePathClass;
import com.atmecs.yatra.helper.HelperClass;
import com.atmecs.yatra.util.PropertyReader;


public class SearchCruiseClass extends SetUp {

	PropertyReader locators;

	@Test
	public void searchCruise() throws InterruptedException

	{
		Reporter.log("Opening Home Page");
		locators = new PropertyReader(FilePathClass.LOCATORS_HOME);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (HelperClass.checkIfDisplayed(driver, locators.get("iFrameXpath"))) {
			driver.switchTo().frame(driver.findElement(By.xpath(locators.get("iFrameXpath"))));
			HelperClass.PerformClick(driver, locators.get("iFrameCloseXpath"));
			driver.switchTo().parentFrame();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (HelperClass.checkIfDisplayed(driver, locators.get("iFrameXpath"))) {
			driver.switchTo().frame(driver.findElement(By.xpath(locators.get("iFrameXpath"))));
			HelperClass.PerformClick(driver, locators.get("iFrameCloseXpath"));
			driver.switchTo().parentFrame();			

		}
		HelperClass.PerformClick(driver, locators.get("moreLinkXpath"));
		HelperClass.PerformClick(driver, locators.get("cruiseLinkXpath"));

		Reporter.log("Selecting Destination/River ");
		Thread.sleep(10000);

		HelperClass.waitAndSelect(driver, locators.get("destinationXpath"));
		HelperClass.waitAndSelect(driver, locators.get("destinationValueXpath"));
		Reporter.log("Selecting Dates ");
		HelperClass.waitAndSelect(driver, locators.get("dateXpath"));
		HelperClass.waitAndSelect(driver, locators.get("dateValueXpath"));
		Reporter.log("Selecting Days ");
		HelperClass.waitAndSelect(driver, locators.get("daysXpath"));
		HelperClass.waitAndSelect(driver, locators.get("daysValueXpath"));
		Reporter.log("Selecting Cruise Lines ");
		HelperClass.waitAndSelect(driver, locators.get("cruiselineXpath"));
		HelperClass.waitAndSelect(driver, locators.get("cruiselineValueXpath"));

		HelperClass.PerformClick(driver, locators.get("searchButtonXpath"));

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				Reporter.log("Switched to Child Window");
				driver.switchTo().window(child_window);

			}

		}

		String expectedDestination = "South Africa";
		String actualDestination = driver.findElement(By.xpath(locators.get("destinationVerifyXpath"))).getText();
		Assert.assertEquals(expectedDestination, actualDestination);
		Reporter.log("Destination Verified");
		String expectedDays = "5";
		String actualDays = driver.findElement(By.xpath(locators.get("daysVerifyXpath"))).getText();
		Assert.assertEquals(expectedDays, actualDays);
		Reporter.log("Number of days Verified");
		HelperClass.PerformClick(driver, locators.get("bookXpath"));
		HelperClass.PerformClick(driver, locators.get("itineraryXpath"));

	}
}