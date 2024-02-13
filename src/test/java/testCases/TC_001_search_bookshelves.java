package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.search_results_page;
import testBase.BaseClass;

public class TC_001_search_bookshelves extends BaseClass
{
	
	@Test(priority=1)
	public void search_Bookshelves() throws InterruptedException, IOException
	{
		logger.info("***********Starting TC_001_search_booksheloves");
		HomePage hp = new HomePage(driver);
		
		
		hp.search_bookshelves();
		screenShot("search_bookshelves");;
		logger.info("Searched for bookshelves and captured the screenshot successfully");
		
	}
	
	@Test(priority=2)
	public void applying_filters() throws InterruptedException, IOException 
	{
		HomePage hp = new HomePage(driver);
		hp.click_on_search();
		Thread.sleep(5000);
		logger.info("Clicked on the search button");
		
		
		search_results_page sc= new search_results_page(driver);
		sc.click();
		logger.info("Closed the ad successfully");
		
		
		screenShot("search_results");
		logger.info("Captured the search results successfully");
		
		
		logger.info("Aplying filters");
		sc.category_hover();
		sc.click_kids();
		sc.price_hover();
		sc.set_price();
		Thread.sleep(2000);
		screenShot("price");
		sc.exclude_out_of_stock();
		sc.hover_recommended();
		sc.click_high_to_low();
		Thread.sleep(3000);
		screenShot("after filter");
		logger.info("Applied the filters and captured the screenshots");
		
		
		sc.select_top_three_products();
		logger.info("Top three products selected");
		
		
	}

}
