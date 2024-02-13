package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class confirmdetails_Page extends BasePage
{
		public confirmdetails_Page(WebDriver driver)
		{
			super(driver);
		}
		
	//locators
		
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div[1]")
	public WebElement to_namElement;
		
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div[2]")
	public WebElement to_emailElement;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div[3]")
	public WebElement to_phElement;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[1]")
	public WebElement fr_name;
		
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[2]")
	public WebElement fr_email;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[3]")
	public WebElement fr_ph;
		
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[4]")
	public WebElement fr_add;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[5]/text()[1]")
	public WebElement fr_pin;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[3]/div[2]")
	public WebElement msg;
}


