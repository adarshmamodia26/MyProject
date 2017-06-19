package com.mobizio.selenium.framework;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.mobizio.pages.BranchPage;
import com.mobizio.pages.CaseListPage;
import com.mobizio.pages.ConfigurationPage;
import com.mobizio.pages.CustomerPage;
import com.mobizio.pages.DashboardPage;
import com.mobizio.pages.FormPage;
import com.mobizio.pages.GroupPage;
import com.mobizio.pages.LoginPage;
import com.mobizio.pages.RolePage;
import com.mobizio.pages.SectionPage;
import com.mobizio.pages.ServicesPage;
import com.mobizio.pages.TaskPage;
import com.mobizio.pages.TaskTypePage;

public abstract class BaseTest {

	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static final String BREAK_LINE = "<\br>";
	protected String userName;
	protected String password;
	protected String browserType;
	private WebDriver driver;
	protected String applicationUrl;

	// pages object initialization
	protected LoginPage loginPage;
	protected DashboardPage dashBoardPage;
	protected CustomerPage customerPage;
	protected SectionPage sectionPage;
	protected GroupPage groupPage;
	protected TaskTypePage taskTypePage;
	protected RolePage rolePage;
	protected ConfigurationPage configurationPage;
	protected ServicesPage servicesPage;
	protected CaseListPage caseListPage;
	protected FormPage formPage;
	protected TaskPage taskPage;
	protected BranchPage branchPage;

	enum DriverType {
		Firefox, IE, Chrome
	}

	public BaseTest(String browser) {
		this.browserType = browser;
	}

	@BeforeClass
	public void setUp() throws Exception {
		if (browserType == null) {
			browserType = Configuration.readApplicationFile("Browser");
		}

		userName = Configuration.readApplicationFile("Tenant_Username");
		password = Configuration.readApplicationFile("Tenant_Password");

		this.applicationUrl = Configuration.readApplicationFile("URL");

		if (DriverType.Firefox.toString().toLowerCase().equals(browserType.toLowerCase())) {
			driver = new FirefoxDriver();
		} 
		else if (DriverType.IE.toString().toLowerCase().equals(browserType.toLowerCase())) {
			System.setProperty("webdriver.ie.driver",
					getPath() + "//src//test//resources//webdriver/IEDriverServer.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(capabilities);
		}
		

		else if (DriverType.Chrome.toString().toLowerCase().equals(browserType.toLowerCase())) {
			System.setProperty("webdriver.chrome.driver",
					getPath() + "/src//test//resources//webdriver/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new Exception("Please pass valiedbrowser type value");
		}

		// Maximize window
		driver.manage().window().maximize();

		// Delete cookies
		driver.manage().deleteAllCookies();

		// open application URL
		getWebDriver().navigate().to(applicationUrl);

		loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	@AfterClass
	public void afterMainMethod() {
		//driver.quit();
	}

	@AfterSuite
	public void tearDownSuite() {
		// reporter.endReport();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	// Handle child windows
	public String switchPreviewWindow() {
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		getWebDriver().switchTo().window(iter.next());
		return parent;
	}

	// Get absolute path
	public String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	// Get absolute path
	public String getPathUpload() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");
		return path;
	}

	// capturing screenshot
	public void captureScreenshot(String fileName) {
		try {
			String screenshotName = this.getFileName(fileName);
			FileOutputStream out = new FileOutputStream("screenshots//" + screenshotName + ".jpg");
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			String path = getPath();
			String screen = "file://" + path + "/screenshots/" + screenshotName + ".jpg";
			Reporter.log("<a href= '" + screen + "'target='_blank' >" + screenshotName + "</a>");
		} catch (Exception e) {

		}
	}

	public void reportLog(String message) {
		message = BREAK_LINE + message;
		logger.info("Message: " + message);
		Reporter.log(message);
	}

	// Creating file name
	public String getFileName(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String fileName = file + dateFormat.format(cal.getTime());
		return fileName;
	}

}
