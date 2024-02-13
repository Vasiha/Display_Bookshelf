package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage 
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id=\"search\"]")
	WebElement searchbarElement;
	
	@FindBy(xpath="//button[@id=\"search_button\"]")
	WebElement searchbuttonElement;
	
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]")
	WebElement livingElement;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[1]/ul/li/a")
	List<WebElement> seating_and_chairs;

	
	//Actions
	
	
	public void search_bookshelves() throws InterruptedException
	{
		searchbarElement.sendKeys("Bookshelves");
		Thread.sleep(2000);
		
	}
	
	public void click_on_search()
	{
		searchbuttonElement.click();
	}
	
	
	public void hover_living() throws InterruptedException 
	{
		Actions actions= new Actions(driver);
		actions.moveToElement(livingElement).perform();
		Thread.sleep(2000);
	}
	
	public void display_items() throws IOException
	{
		System.out.println("Seating and chairs: ");
		for(WebElement seatingChairs:seating_and_chairs) 
		{
			System.out.println(seatingChairs.getText());
			
		}
	}
}
