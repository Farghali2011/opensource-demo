package test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TPRO {

	  private WebDriver driver;
	  
	  @BeforeClass
	  public void setUp() throws Exception {
		    WebDriverManager.chromedriver().driverVersion("94.0.4606.81").setup();
		    driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		  }
	
	  @Test
	 public void TCase() throws Exception {
		  //open the website:
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			
			//Enter Cred (Username and Pass)
		    driver.findElement(By.id("txtUsername")).click();
		    driver.findElement(By.id("txtUsername")).clear();
		    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		    driver.findElement(By.id("txtPassword")).click();
		    driver.findElement(By.id("txtPassword")).clear();
		    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		    driver.findElement(By.id("btnLogin")).click();
		    driver.findElement(By.cssSelector("b")).click();
		    
		    //Click on Login Button
		    driver.findElement(By.id("btnAdd")).click();
		    
		    //Add user
		    driver.findElement(By.id("systemUser_employeeName_empName")).click();
		    driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		    driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("A");
		    driver.findElement(By.cssSelector("li.ac_even.ac_over")).click();
		    driver.findElement(By.id("systemUser_userName")).click();
		    driver.findElement(By.id("systemUser_userName")).clear();
		    driver.findElement(By.id("systemUser_userName")).sendKeys("MFarghl123");
		    driver.findElement(By.id("systemUser_password")).click();
		    driver.findElement(By.id("systemUser_password")).clear();
		    driver.findElement(By.id("systemUser_password")).sendKeys("20117452011");
		    driver.findElement(By.id("systemUser_confirmPassword")).click();
		    driver.findElement(By.id("systemUser_confirmPassword")).clear();
		    driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("20117452011");
		    driver.findElement(By.xpath("//input[@class=\"addbutton\"]")).click();
		    //driver.findElement(By.xpath("//input[@class=\"addbutton\"]")).click();

		    //Serach about Username
		    driver.findElement(By.id("searchSystemUser_userName")).clear();
		    driver.findElement(By.id("searchSystemUser_userName")).sendKeys("MFarghl123");
		    driver.findElement(By.id("searchBtn")).click();
		    driver.findElement(By.linkText("MFarghl123")).click();
		    
		    //Chech if username is righ or not
		    WebElement ele=driver.findElement(By.xpath("//input[@class=\"formInputText\"]"));
		    String ExpectedTitle="MFarghl123";
		    Assert.assertEquals(ExpectedTitle, ele.getAttribute("value"));
		    
		    }

}
