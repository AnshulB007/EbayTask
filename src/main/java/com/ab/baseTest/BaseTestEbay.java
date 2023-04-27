package com.ab.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ab.pageLayer.HomePage;
import com.ab.pageLayer.ProductPage;
import com.ab.pageLayer.SearchedProductPage;

public class BaseTestEbay {

	Properties prop;
	public WebDriver driver;
	public HomePage hp_obj;
	public ProductPage pp_obj;
	public SearchedProductPage spp_obj;

	public WebDriver initialiseBrowser() {

		String configPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties";
		String browserName = null;
		try {
			FileInputStream fis = new FileInputStream(configPath);
			prop = new Properties();
			prop.load(fis);
			browserName = prop.getProperty("browser");
			System.out.println(browserName);

		} catch (Exception e) {

			e.printStackTrace();
		}

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.addArguments("-remote-allow-origins=*");
			driver = new ChromeDriver(op);

		}

		if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		}

		if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		}

		pp_obj = new ProductPage(driver);
		hp_obj = new HomePage(driver);
		spp_obj = new SearchedProductPage(driver);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		return driver;

	}

	@BeforeMethod
	public void launchApplication() {

		driver = initialiseBrowser();
		driver.get(prop.getProperty("url"));

	}

//	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.close();
			driver.quit();
		}

	}

	public String getScreenShot(WebDriver driver, String testCase) {

		String desPath = System.getProperty("user.dir") + "\\outputs\\ScreenShots\\" + testCase + Math.random()
				+ ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(desPath);

		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return desPath;

	}

}
