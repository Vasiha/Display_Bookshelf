package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os,String br) throws IOException
	{
		// loading properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

		// loading log4j file
		logger = LogManager.getLogger(this.getClass());
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) 
		{

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os

			if (os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);

			}
			else if (os.equalsIgnoreCase("mac")) 
			{
				capabilities.setPlatform(Platform.MAC);
			} 
			else 
			{
				System.out.println("No matching os..");
				return;
			}

			// browser

			switch (br.toLowerCase()) 
			{
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;

			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;

			default:

				System.out.println("No matching browser..");
				return;
			}

			driver = new RemoteWebDriver(new URL("http://10.203.182.229:4444"), capabilities);

		} 
		else if (p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			// launching browser based on condition - locally

			switch (br.toLowerCase()) 
			{
			case "chrome":
				driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:

				System.out.println("No matching browser..");
				return;

			}

		}

		/*
		 * //launching browser based on condition switch(br.toLowerCase()) {
		 * 
		 * case "chrome":driver=new ChromeDriver(); break; case "edge": driver= new
		 * EdgeDriver();break; default: System.out.println("No matching browser...");
		 * return; }
		 */

		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

	public void screenShot(String ss) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2303482\\eclipse-workspace\\Display_Bookshelves\\Screenshots\\" + ss + ".png");
		FileUtils.copyFile(src, trg);

	}

	public String captureScreen(String tname) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots_extentreports\\" + tname + "_"
				+ timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}
