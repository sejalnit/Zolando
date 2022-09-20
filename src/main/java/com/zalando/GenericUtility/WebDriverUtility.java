package com.zalando.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	WebDriver WebDriver;
	long longTimeout;

	/**
	 * this mthd is used for launch the browser
	 * 
	 * @param browser
	 * @return
	 */

	public WebDriver launchBrowser(String browser) {
		WebDriver driver = null;
		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.chromedriver().setup();

			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("you entered wrong browser");
			break;
		}
		return driver;

	}

	public String dropdown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
		return text;

	}

	/**
	 * this method used to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximisebrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this mthd is use to wait the controller implicitly till load
	 * 
	 * @param driver
	 * @param longTimeouts
	 */
	public void waitUntilPageLoad(WebDriver driver, long longTimeouts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 * this mthd is use to open the application
	 * 
	 * @param driver
	 * @param Url
	 */
	public void navigateTheApllication(WebDriver driver, String Url) {
		driver.get(Url);
	}

	/**
	 * this mthd use to open the browser
	 * 
	 * @param browser
	 * @param longTimeout
	 * @param url
	 * @return
	 */

	public WebDriver openBrowserwithApplication(String browser, long longTimeout, String url) {
		WebDriver driver = launchBrowser(browser);
		maximisebrowser(driver);

		waitUntilPageLoad(driver, longTimeout);
		navigateTheApllication(driver, url);
		return driver;
	}

	/**
	 * this mthd is use todo mouse hover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	/**
	 * this mthd is use to double click the data
	 * 
	 * @param driver
	 * @param element
	 */

	public void doubleClick(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	/**
	 * this mthd used to close the browser instance
	 * 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * 
	 * @param driver
	 * @param longTime
	 * @param element
	 */
	public void waitUntillElement(WebDriver driver, long longTime, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * @param driver
	 */
	public void switchWindow(WebDriver driver) {
		Set<String> windowId = driver.getWindowHandles();
		for (String string : windowId) {
			driver.switchTo().window(string);
			if (string.contains(""))
				break;

		}
	}
//	
//	 /**
//	 * used to wait for element to be clickable in GUI , & check for specific element for every 500
//	milli seconds
//	 * @param driver
//	 * @param element
//	 */
//	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) {
//	WebDriverWait wait = new WebDriverWait(driver, 20);
//	wait.until(ExpectedConditions.elementToBeClickable(element));
//	}

// used to wait for element to be clickable in GUI , & check for specific element for every 500
	// milli seconds
	// @param driver
	// * @param element
	// @param pollingTime in the form second
	// @throws Throwable
	//
//	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int
//	pollingTime) throws Throwable {
//	FluentWait wait = new FluentWait(driver);
//	wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
//	wait.wait(20);
//	wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
	/**
	 * used to Switch to Any Window based on Window Title
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
//	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
//	 Set<String> set = driver.getWindowHandles();
//	 Iterator <String>it = set.iterator();
//	 while (it.hasNext()) {
//	 String wID = it.next();
//	 driver.switchTo().window(wID);
//	 String currentWindowTitle = driver.getTitle();
//	 if(currentWindowTitle.contains(partialWindowTitle)) {
//	 break;
//	 }
//	 }
	// }

	/**
	 * used to Switch to Alert Window & click on OK button
	 * 
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * 
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to Switch to Frame Window based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from the dropDwon based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElemnet(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * used to right click on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 *
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}

	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * this mthd is use to take screenshot
	 * 
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String className, JavaUtility java) {
		String currentTime = java.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + className + "_" + currentTime + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}
