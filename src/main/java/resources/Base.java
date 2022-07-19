package resources;

import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser"); // to invoke from properties file
		// mvn test -Dbrowser=chrome
		//String browserName= System.getProperty("browser");// to invoke direclty from  maven command
	
		if (browserName.contains("chrome")) 
		{
			// then execute in chrome browser
		
			System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe"));
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
					{
		
			options.addArguments("headless");// for headless mode
					}
			
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			// execute in edge browser
			System.setProperty("webdriver.gecko.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe"));
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\msedgedriver.exe"));
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
