package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_Living_Submenu extends BaseClass
{
	@Test(priority=3)
	public void retrieve_submenu() throws InterruptedException, IOException
	{
		
		//search_results_page sc= new search_results_page(driver);
		//sc.scroll_to_living();
		//sc.go_home();
		//logger.info("Navigated back to the home page");
		
		logger.info("Starting TC_002_Living_Submenu");
		HomePage hPage = new HomePage(driver);
		
		hPage.hover_living();
		screenShot("submenu");
		Thread.sleep(2000);
		logger.info(" Hovered on living and captured a screenshot");
		
		hPage.display_items();
		logger.info("Submenu items are printed in the console");
		
	}
	
	
	
	

}
