package com.obsqura.TestNGProject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScript extends Base {
     @Test
	public void verifyUrl() {
		String expectedURL = "https://www.amazon.in/";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);	
		}
     @Test
    public void titleVerify() {
    	String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actualTitle = driver.getTitle();
    	Assert.assertEquals(expectedTitle,actualTitle );
        }
     @Test
    public void softAssetSample() {
    	String expectedURL = "https://www.amazon.in/";
 	    String actualURL = driver.getCurrentUrl();
    	String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    	String actualTitle = driver.getTitle();
    	SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualURL, expectedURL);
    	softassert.assertEquals(actualTitle, expectedTitle);
    	softassert.assertAll(); 
        }
     @Test
     public void hardAssert() {
    	 
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
     	String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        String expectedURL = "https://www.amazon.in/";
 	    String actualURL = driver.getCurrentUrl();
 	   Assert.assertEquals(expectedURL,actualURL );
        }
     
}

