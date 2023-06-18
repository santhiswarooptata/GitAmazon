package Automation;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAutomation  {

	public static WebDriver driver;
	public static Properties loc = new Properties();
	public static Properties config = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	@BeforeTest
	public void SetUp () throws IOException
	{
		if(driver==null) {
		 fr = new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\src\\test\\java\\Automation\\location.properties");
		 fr1 = new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\src\\test\\java\\Automation\\config.properties");
		
		 loc.load(fr);
		 config.load(fr1);
		 
		}
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(config.getProperty("testurl"));
		}
		
		else if(config.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.get(config.getProperty("testurl"));
		}
		
		else
		{
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.get(config.getProperty("testurl"));
			driver.manage().deleteAllCookies();
		}
		
	}
	
	@Test(priority = 0)
	
	public void SignIn()
	{
		
		Actions action = new Actions(driver);
		
		WebElement SignIn = driver.findElement(By.cssSelector(loc.getProperty("SignIn")));
		WebElement SignInClick = driver.findElement(By.cssSelector(loc.getProperty("SignInClick")));
		action.moveToElement(SignIn).moveToElement(SignInClick).click().perform();
		WebElement email = driver.findElement(By.cssSelector(loc.getProperty("email")));
		email.sendKeys("8886937988");
		WebElement contnue = driver.findElement(By.cssSelector(loc.getProperty("continue")));    
		contnue.click();
		WebElement password = driver.findElement(By.cssSelector(loc.getProperty("password")));
		password.sendKeys("8886937988");
		WebElement sign_submit = driver.findElement(By.cssSelector(loc.getProperty("sign_submit")));
		sign_submit.click();
//		WebElement frgt_pswd = driver.findElement(By.cssSelector(loc.getProperty("frgt_pswd")));
//		frgt_pswd.click();
//		WebElement contnue1 = driver.findElement(By.cssSelector(loc.getProperty("continue1")));    
//		contnue1.click();
//		WebElement puzzle = driver.findElement(By.cssSelector(loc.getProperty("puzzle"))); 
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc.getProperty("puzzle"))));
	}
	
	@Test(priority = 1)
	public void setLocation()
	{
		WebElement setLocation = driver.findElement(By.cssSelector(loc.getProperty("setLocation")));
		Actions actions = new Actions(driver);
		actions.moveToElement(setLocation).doubleClick().perform();
		
	}
	
}
