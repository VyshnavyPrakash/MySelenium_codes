package com.obsqura.Automationcourse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
    public void InitializeBrowser(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Automationcourse\\src\\main\\java\\Resources\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://www.amazon.in");
    }
    
    public void BrowserClose() {
      	 driver.close();
       }
    
       
       public void BrowserQuit() {
      	 driver.quit();
       } 
}
