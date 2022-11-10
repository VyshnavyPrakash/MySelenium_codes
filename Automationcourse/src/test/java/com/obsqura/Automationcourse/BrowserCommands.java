package com.obsqura.Automationcourse;

import org.junit.Assert;

public class BrowserCommands extends Base {
	
	public void browserCommands() {
		
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String title = driver.getTitle(); // used to get web page title
		
		/*if (expectedTitle.equals(title)) {
			System.out.println("Titles are equal");
		} else {
			System.out.println("Titles are not equal");
		}*/
		
		Assert.assertEquals(expectedTitle, title);
		
	}

	public void getUrl() {

		String url = driver.getCurrentUrl();

	}

	public void getPageSource() {
		String pageSource = driver.getPageSource();

	}
	public void navigate() {
		driver.navigate().to("https://www.amazon.in/b?ie=UTF8&node=5257472031&pf_rd_r=CRQ7NNPNP7DVHTSZKWFK&pf_rd_p=9a550fc0-8297-4eb9-97d3-f062ba784e95&pd_rd_r=ef0b8089-4acc-4ce9-bad3-427a2ab71cd4&pd_rd_w=KJrB7&pd_rd_wg=uVzN6&ref_=pd_gw_unk");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void main(String[] args) {
		BrowserCommands object = new BrowserCommands();
		object.InitializeBrowser();
		object.browserCommands();
		// object.BrowserClose();

		object.getUrl();
		object.getPageSource();
		object.navigate();
		object.BrowserQuit();

	}
}
