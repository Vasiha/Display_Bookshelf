package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GiftCards_Page extends BasePage
{	
	public GiftCards_Page(WebDriver driver) 
	{
		super(driver);
	}
	
	
	//locators
	
	@FindBy(xpath="//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")
	WebElement giftcardsElement;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")
	WebElement birthday_Element;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]/div/div/button")
	WebElement choose_thisElement;
	
	@FindBy(xpath="//input[@id='ip_2251506436']")
	public WebElement amount_Element;
	
	@FindBy(xpath="//div[@class='_3PNvG']//select[1]")
	WebElement monthdrpdwn_Element;
	
	@FindBy(xpath="//button[@class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")
	WebElement next_buttonElement;
	
	@FindBy(xpath="//input[@id='ip_4036288348']")
	public WebElement recname_Element;
	
	@FindBy(xpath="//input[@id='ip_137656023']")
	public WebElement recemail_Element;
	
	@FindBy(xpath="//input[@id='ip_3177473671']")
	public WebElement recmobile_Element;
	
	@FindBy(xpath="//input[@id='ip_1082986083']")
	public WebElement from_namElement;
	
	@FindBy(xpath="//input[@id='ip_4081352456']")
	public WebElement from_emailElement;
	
	
	@FindBy(xpath="//input[@id='ip_2121573464']")
	public WebElement from_phnoElement;
	
	
	@FindBy(xpath="//input[@id='ip_2194351474']")
	public WebElement from_addresElement;
	
	
	@FindBy(xpath="//input[@id='ip_567727260']")
	public WebElement from_pincodElement;
	
	@FindBy(tagName ="textarea")
	public WebElement msg_boxElement;
	
	@FindBy(xpath="//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']")
	WebElement confirm_button;
	
	@FindBy(xpath="//input[@id='ip_137656023']")
	WebElement eroor_msgElement;
	//Actions

	
	public void clickon_giftCards()
	{
		giftcardsElement.click();
	}

	
	
	public void scrollto_birthday() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", birthday_Element);
		Thread.sleep(2000);
	}
	
	
	public void hover_birthday() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(birthday_Element).perform();
		Thread.sleep(2000);
	}
	
	
	
	public void clickon_choosethis()
	{
		choose_thisElement.click();
	}
	
	
	/*public WebElement set_amount() 
	{

		return amount_Element;
	}*/
	
	
	public void set_month()
	{
		Select month=new Select(monthdrpdwn_Element);
		month.selectByIndex(1);
	}
	
	
	
	public void click_next()
	{
		next_buttonElement.click();
	}
	
	
	public void set_invalid_rec_details(String rec_name,String rec_inv_email,String rec_mobile) throws InterruptedException
	{
		recname_Element.sendKeys(rec_name);
		Thread.sleep(2000);
		recemail_Element.sendKeys(rec_inv_email);
		Thread.sleep(2000);
		recmobile_Element.sendKeys(rec_mobile);
		Thread.sleep(2000);
	}
	
	public void set_from_details(String from_name,String from_email,String from_phno,String from_address,String from_pincode,String message) throws InterruptedException
	{
		from_namElement.sendKeys(from_name);
		Thread.sleep(2000);
		from_emailElement.sendKeys(from_email);
		Thread.sleep(2000);
		from_phnoElement.sendKeys(from_phno);
		Thread.sleep(2000);
		from_addresElement.sendKeys(from_address);
		from_pincodElement.sendKeys(from_pincode);
		msg_boxElement.sendKeys(message);
		Thread.sleep(2000);
		
	}
	
	public void capture_error() throws InterruptedException 
	{
		confirm_button.click();
		Thread.sleep(2000);
		String err_msgString=eroor_msgElement.getAttribute("validationMessage");
		System.out.println("\n");
		System.out.println(err_msgString);
	}
	
	public void valid_rec_detail(String Rec_Valid_email) throws InterruptedException 
	{
		recemail_Element.clear();
		recemail_Element.sendKeys(Rec_Valid_email);
		Thread.sleep(2000);
	}
	
	
	public void click_on_confirm() 
	{
		confirm_button.click();
	}
	
}




