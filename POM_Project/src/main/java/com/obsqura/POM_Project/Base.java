 package com.obsqura.pom_project;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;
	@BeforeMethod
    public void InitializeBrowser(){
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\TestNGProject\\src\\main\\java\\Resources\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    @AfterMethod
    public void BrowserClose() {
      	driver.close();
        }
     
    public void BrowserQuit() {
      	driver.quit();
        } 
}
