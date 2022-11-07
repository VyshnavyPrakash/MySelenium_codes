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
    
     public void BrowserCommants() {
    	 String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    	 String title = driver.getTitle(); //used to get web page title
    	 if(expectedTitle.equals(title)) {
    		 System.out.println("Titles are equal");
    	 }
    	 else {
    		 System.out.println("Titles are not equal");
    	 }
    	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
    }
     
     public void BrowserClose() {
    	 driver.close();
     }
     
     public void BrowserQuit() {
    	 driver.quit();
     }
     
     public void getUrl() {
    	
    	 String url = driver.getCurrentUrl();
    	 
     }
     
     public void getPageSource() {
    	 String pageSource = driver.getPageSource();
    	 
     }
     
  public static void main (String []args) {
	Base object = new Base();
	object.InitializeBrowser();
	object.BrowserCommants();
	//object.BrowserClose();
	
	object.getUrl();
	object.getPageSource();
	object.BrowserQuit();

	
	
	
	
}

}
