package com.mobizio.selenium.framework;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.jboss.netty.handler.timeout.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {
	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

	protected WebDriver driver;

	protected String title;
	protected static final int DEFAULT_WAIT_4_ELEMENT = 30;
	protected static final int DEFAULT_WAIT_4_PAGE = 30;
	protected static WebDriverWait ajaxWait;
	protected long timeout = 30;

	/*
	 * @Inject
	 * 
	 * @Named("framework.implicitTimeout") protected long timeout;
	 */

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}


	/*
	 * Click action performed and then wait 
	 */
	public void waitAndClick(WebElement element) {
		logger.info("Wait and Click");
		waitForElement(element);
		element.click();
	}

	public void clickOn(WebElement element) {
		logger.info("click");		
		element.click();
	}
	
	/*
	 * Click on element by webelement
	 */
	public void javascriptButtonClick(WebElement webElement) {
		waitForElement(webElement);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}

	/*
	 * Click on element by string locator
	 */
	public void waitAndClick(String locator) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
	}
	
	/*
	 * Click on element by string locator
	 */
	public void clickOn(String locator) {		
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
	}	
	
	public String returnTitle() {
		return title;
	}
	
	/*
	* Scroll page down 250 pixel 
	*/
	public void scrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	/* 
	 * Scroll page down pixel 
	 * @Param pixel
	 * 			pixel to scroll down
	*/
	public void scrollDown(String pixel)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+pixel+")", "");
	}
	
	/*
	* Scroll page up 250 pixel 
	*/
	public void scrollUp()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250, 0)", "");
	}

	/* 
	 * Scroll page up pixel 
	 * @Param pixel
	 * 			pixel to scroll down
	*/
	public void scrollUp(String pixel)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+pixel+", 0)", "");
	}
	
	private void setImplicitWait(int timeInSec) {
		logger.info("setImplicitWait, timeInSec={}", timeInSec);
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
	}

	private void resetImplicitWait() {
		logger.info("resetImplicitWait");
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void waitFor(ExpectedCondition<Boolean> expectedCondition) {
		setImplicitWait(0);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(expectedCondition);
		resetImplicitWait();
	}

	public void inputText(WebElement element, String text) {
		logger.info("inputText, text={}", text);
		element.clear();
		element.sendKeys(text);
	}

	public void waitForElement(WebElement element) {
		logger.info("waitForElement");
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElement(String locator) {
		logger.info("waitForElement");
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
	}

	public boolean _waitForJStoLoad() {
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for JavaScript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				Object rsltJs = ((JavascriptExecutor) driver).executeScript("return document.readyState");
				if (rsltJs == null) {
					rsltJs = "";
				}
				return rsltJs.toString().equals("complete") || rsltJs.toString().equals("loaded");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean waitDone = wait.until(jQueryLoad) && wait.until(jsLoad);
		return waitDone;
	}	

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;
		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.id(locator.replace("#", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.className(locator);
		}
		return result;
	}

	public static String generateRandomString(int lettersNum) {
		String finalString = "";

		int numberOfLetters = 25;
		long randomNumber;
		for (int i = 0; i < lettersNum; i++) {
			char letter = 97;
			randomNumber = Math.round(Math.random() * numberOfLetters);
			letter += randomNumber;
			finalString += String.valueOf(letter);
		}
		return finalString;
	}

	public boolean verifyURL(String url) {
		boolean value = false;
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains(url))
			return true;
		else
			return value;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement findElement(By by) {
		if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		WebElement foundElement = null;
		for (int milis = 0; milis < 3000; milis = milis + 200) {
			try {
				foundElement = driver.findElement(by);
				return foundElement;
			} catch (Exception e) {
				// Utils.hardWaitMilliSeconds(200);
			}
		}
		return null;
	}

	public void assertByPageTitle() {
		try {
			if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver
					|| driver instanceof FirefoxDriver) {
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(returnTitle().equals(driver.getTitle()));
	}

	public List<String> findAllLinksOnPage() {
		List<String> links = new ArrayList<String>();
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		for (WebElement each : linkElements) {
			String link = each.getAttribute("href");
			if (link == null || link.contains("mailto") || link.contains("javascript")) {
				continue;
			}
			links.add(link);
		}
		return links;
	}

	public boolean isResponseForLinkTwoHundredOrThreeOTwo(String link) {
		int code = 0;
		Reporter.log("Link: " + link);
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			code = connection.getResponseCode();
			Reporter.log("Code: " + code);
		} catch (Exception e) {
			Reporter.log(e.toString());
			return false;
		}
		if (link.contains("pager") || code == 403) {
			return true;
		}
		return code == 200 || code == 302;
	}

	public void setWaitTime(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void setWaitTimeToZero(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public void customizableCondition(WebDriver driver, int waitTime, final Boolean condition) {
		// setWaitTimeToZero(driver);
		new WebDriverWait(driver, waitTime).until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return condition;
			}
		});
		// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
	}

	public WebElement waitForElementClickable(WebElement webElement, int timeOutInSeconds) {
		WebElement element;
		try {
			// setWaitTimeToZero(driver);
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(webElement));

			// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
			return element;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement waitForElementPresent(final By by, int timeOutInSeconds) {
		WebElement element;
		try {

			// setWaitTimeToZero(driver);
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement waitForElementPresent(WebElement webElement, int timeOutInSeconds) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOf(webElement));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean waitForTextPresentInElement(WebElement webElement, String text, int timeOutInSeconds) {
		boolean notVisible;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		notVisible = wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));

		return notVisible;
	}

	public boolean waitForTextPresentInElement(By by, String text, int timeOutInSeconds) {
		boolean notVisible;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		notVisible = wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));

		return notVisible;
	}

	public Boolean isElementPresent(WebElement element) {
		waitForElement(element);
		return element.isDisplayed();
	}
	
	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	public void WaitForElementNotPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (!isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int findNumberOfSpecificElementsInContainer(By container, By element) {
		WebElement mainDiv = driver.findElement(container);
		List<WebElement> divs = mainDiv.findElements(element);
		return divs.size();
	}

	public WebDriver hoverOverElementAndClick(WebElement toBeHovered, WebElement toBeClicked) {
		Actions builder = new Actions(driver);
		builder.moveToElement(toBeHovered).build().perform();
		waitForElementPresent(toBeClicked, DEFAULT_WAIT_4_ELEMENT);
		toBeClicked.click();
		waitForPageLoaded(driver);
		return driver;
	}


	/*
	 * Select element by visible text
	 * @Param element
	 * @Patram targetValue: visible text
	 */
	public void selectDropDownByText(WebElement element, String targetValue) {
		waitForElement(element);
		new Select(element).selectByVisibleText(targetValue);
	}

	/*
	 * Select element by Index
	 * @Param element
	 * @Patram index
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		waitForElement(element);
		new Select(element).selectByIndex(index);
	}

	/*
	 * Select element by value
	 * @Param element
	 * @Patram targetValue: value
	 */
	public void selectDropDownByValue(WebElement element, String targetValue) {
		waitForElement(element);
		new Select(element).selectByValue(targetValue);
	}

	public void waitForElementToBecomeVisible(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementToBecomeInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForAjaxRequestsToComplete() {
		(new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) d;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}

	public void waitForPageLoaded(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		wait.until(expectation);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isTextPresentOnPage(String text) {
		return driver.findElement(By.tagName("body")).getText().contains(text);
	}

	public boolean isFileAvailableForDownload(WebElement webElement) throws Exception {
		int code = 0;
		String downloadUrl = webElement.getAttribute("href");
		URL url = new URL(downloadUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		code = connection.getResponseCode();
		Reporter.log("The response code for download is " + code);
		return code == 200;
	}



	public void takeRemoteWebDriverScreenShot(String fileName) {
		File screenshot = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(fileName));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void waitForTextNotToBeVisible(String text, int timeoutInSeconds) {
		int startWait = 0;
		while (isTextPresentOnPage(text)) {
			// Utils.hardWaitSeconds(1);
			startWait++;
			if (startWait == timeoutInSeconds) {
				throw new TimeoutException();
			}
		}
	}

	public void waitForWebElementPresent(WebElement element) {
		WebDriverWait ajaxWait = new WebDriverWait(driver, 30);
		ajaxWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectValueFromSearchSelectDropDown()
	{
		
	}
	
	
	public void dragAndDrop(WebElement drag,WebElement drop)
	{
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).release(drop).build();
		dragAndDrop.perform();
	}
}
