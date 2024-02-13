package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class search_results_page extends BasePage 
{
	
	public search_results_page(WebDriver driver)
	{
		
		super(driver);
	}
	
	
	//locators
	
	@FindBy(xpath="//a[@class=\"close-reveal-modal hide-mobile\"]")
	WebElement close_buttonElement;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]")
	WebElement category_Element;
	
	@FindBy(xpath="//input[@value=\"Kids Bookshelves\"]")
	WebElement Kids_shelf_Element;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]")
	WebElement price_Element;
	
	@FindBy(xpath="//*[@class=\"noUi-handle noUi-handle-upper\"]")
	WebElement slider_Element;
	
	@FindBy(xpath="//input[@value=\"In Stock Only\"]")
	WebElement out_of_stockElement;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]")
	WebElement recommended_Element;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[3]")
	WebElement h_to_l_Element;
	
	
	@FindBy(xpath="//*[@class='product  hovercard']")
	List<WebElement> products;
	
	@FindBy(xpath="//*[@class='product-title product-title-sofa-mattresses']")
	List<WebElement> product_title;
	
	@FindBy(xpath="//*[@class='price-number']")
	List<WebElement> product_price;
	
	@FindBy(xpath="//*[@class='price-text']")
	List<WebElement> product_text;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[1]/div/section[1]/a")
	WebElement home_Element;
	
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]")
	WebElement livingElement;
	//Actions
	
	
	
	public void click() throws InterruptedException
	{
		close_buttonElement.click();
		Thread.sleep(2000);
	}
	
	public void category_hover() throws InterruptedException 
	{
		Actions act= new Actions(driver);
		act.moveToElement(category_Element).perform();
		Thread.sleep(2000);
	}
	
	
	public void click_kids()
	{
		Kids_shelf_Element.click();	
	}

	
	public void price_hover() throws InterruptedException 
	{
		Actions act= new Actions(driver);
		act.moveToElement(price_Element).perform();
		Thread.sleep(2000);	
	}
	
	public void set_price() throws InterruptedException 
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider_Element,-215,0).perform();	
		Thread.sleep(3000);
	}
	
	public void exclude_out_of_stock() 
	{
		out_of_stockElement.click();
	}
	
	public void hover_recommended() throws InterruptedException 
	{
		Actions act= new Actions(driver);
		act.moveToElement(recommended_Element).perform();
		Thread.sleep(2000);	
	}
	
	
	public void click_high_to_low()
	{
		h_to_l_Element.click();
		
	}
	
	public void select_top_three_products()
	{
		for(int i=0; i<3; i++)
		{
				String product_name=product_title.get(i).getText();
				System.out.println("\nThe product name is: " + product_name);
				String price = product_price.get(i).getText();
				String[] actual_and_offer = price.split(" ");
				for(int j=0; j<1; j++)
					{
						String actual_price = actual_and_offer[j];
						System.out.println("The actual price is: " + actual_price);
						String offer_price = actual_and_offer[j+1];
						System.out.println("The offer price is: " + offer_price);
						System.out.println("\n--------------------------------------------------------------");
					}
	
		}
	}
	
	public void scroll_to_living() throws InterruptedException 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", livingElement);
		Thread.sleep(2000);
	}
	
	
	public void go_home() 
	{
		home_Element.click();
	}
	
	
}
