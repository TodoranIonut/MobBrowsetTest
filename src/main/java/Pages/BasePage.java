package Pages;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasePage {

	public String app;
	public String platform;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String username;
	public static String password;
	public static String url;
	public static String id;
	public static String xp;
	public static String cs;
	public static String login_button;
	public static String urlSv;

	public void setData()
	{
		Constants.getPropValues();
		username = Constants.getUsername();
		password = Constants.getPassword();
		url = Constants.getUrl();
		cs = Constants.getCS();
		id = Constants.getID();
		xp = Constants.getXP();
		login_button = Constants.getLOGIN_BUTTON();
		urlSv = Constants.getUrlSv();
	}

	public void navigate(String url)
	{
		driver.navigate().to(url);
	}

	public void initSetB()
	{

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		wait =  new WebDriverWait(driver, 30);
		setData();
		navigate(url);
	}

	public void initSetM()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Nexus 5");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		driver = new ChromeDriver(chromeOptions);
		wait =  new WebDriverWait(driver, 30);
		setData();
		navigate(urlSv);
	}
	
	public void initSetDivice() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
        //driver = new AndroidDriver<WebElement>(url, capabilities);
		this.driver = driver;
        wait =  new WebDriverWait(driver, 30);
		setData();
		navigate(urlSv);
        
	}
	
	public WebElement findObject(String elementName,String elementLocatorType, boolean mandatory)
	{
		By findBy = null;
		WebElement element=null;

		if(elementLocatorType == "id")
		{
			findBy = By.id(elementName);
		}
		if(elementLocatorType == "xpath")
		{
			findBy = By.xpath(elementName);
		}
		if(elementLocatorType == "cssSelector")
		{
			findBy = By.cssSelector(elementName);
		}
		if(elementLocatorType == "class")
		{
			findBy = By.className(elementName);
		}
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
			element = driver.findElement(findBy);
		} catch(Exception e) {
			System.out.println("Element    "+elementName+"  NOT FIND");				
		}
		if(mandatory && element != null)
			System.out.println("Element    "+elementName+"  FIND");
		return element;
	}

	public void clickObject(String elementName,String elementLocatorType, boolean mandatory)
	{
		WebElement element = null;
		element = findObject(elementName,elementLocatorType,mandatory);
		if(element !=null && element.isDisplayed())
		{	try {
			element.click();
		} catch(Exception e){ }
		}
		else	
			System.out.println("Element is not displayed or can not be clicked");	
	}

	public void sendKeys(String elementName,String elementLocatorType, boolean mandatory, String newValue)
	{
		WebElement element = null;
		element = findObject(elementName,elementLocatorType,mandatory);
		if(element !=null && element.isDisplayed())
		{
			try {
				element.clear();
				element.sendKeys(newValue);
			} catch(Exception e) {}
		}
		else
		{
			System.out.println("Can't send keys!");
		}

	}

	public String getValue(String elementName,String elementLocatorType,boolean mandatory, String typeValue)
	{

		WebElement element = null;
		element = findObject(elementName,elementLocatorType,mandatory);
		String value = null;
		if(element != null)
		{
			try {
				switch (typeValue) {
				case "attribute":
					value = element.getAttribute(elementName).toString();
					break;
				case "location":
					value =  element.getLocation().toString();
					break;
				case "class":
					value =  element.getClass().toString();
					break;
				case "size":
					value =  element.getSize().toString();
					break;
				case "text":
					value =  element.getText();
					break;
				case "tagname":
					value =  element.getTagName();
					break;
				case "displayed":
					value =  String.valueOf(element.isDisplayed());
					break;
				}
			} catch(Exception e) {}
		}

		else
		{
			System.out.println("No value!");
		}
		return value;
	}

	public void tearDownP()
	{
		driver.close();
		if(!driver.equals(null))
			driver.quit();
	}


	//TODO
}
