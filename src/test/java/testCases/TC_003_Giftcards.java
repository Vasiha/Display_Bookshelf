package testCases;

import java.io.IOException;
 
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
 
import pageObjects.GiftCards_Page;

import pageObjects.confirmdetails_Page;

import testBase.BaseClass;
import utilities.DataProviders;

 
public class TC_003_Giftcards extends BaseClass

{

	@Test(priority=4)
	public void gift_card_selection() throws InterruptedException
	{
		logger.info("******************8Starting TC_003************************* ");
		GiftCards_Page gPage=new GiftCards_Page(driver);
		gPage.clickon_giftCards();
		logger.info("Clicked on gift cards");
		gPage.scrollto_birthday();
		logger.info("Scrolled down for gift card selection");
		Thread.sleep(1000);
		gPage.hover_birthday();
		gPage.clickon_choosethis();
		logger.info("Hovered on birthday and clicked choose this");
	}

	@Test(priority=5)
	public void set_amount_and_date() throws InterruptedException 
	{
		GiftCards_Page gPage=new GiftCards_Page(driver);
		gPage.amount_Element.sendKeys(p.getProperty("amount"));
		logger.info("Amount is selected");
		gPage.set_month();
		Thread.sleep(3000);
		logger.info("Month is selected");
		gPage.click_next();
	}

	@Test(priority=6,dataProvider="dp",dataProviderClass=DataProviders.class)
	public void invalid_details(String rec_name,String rec_inv_email,String rec_mobile,String from_name,String from_email,String from_phno,String from_address,String from_pincode,String message,String rec_valid_email) throws InterruptedException, IOException 
	{
		GiftCards_Page gPage=new GiftCards_Page(driver);
		//gPage.set_invalid_rec_details(rec_name,rec_inv_email,rec_mobile);
		gPage.recname_Element.sendKeys(rec_name);
		gPage.recemail_Element.sendKeys(rec_inv_email);
		gPage.recmobile_Element.sendKeys(rec_mobile);		
		Thread.sleep(2000);
		logger.info("Invalid recipient details is passed ");
		//gPage.set_from_details(from_name,from_email,from_phno,from_address,from_pincode,message);
		gPage.from_namElement.sendKeys(from_name);
		gPage.from_emailElement.sendKeys(from_email);
		gPage.from_phnoElement.sendKeys(from_phno);
		gPage.from_addresElement.sendKeys(from_address);
		gPage.from_pincodElement.sendKeys(from_pincode);
		gPage.msg_boxElement.sendKeys(message);
		logger.info("from details is passed ");
		gPage.capture_error();
		screenShot("invalid details");
		logger.info("confirm button is clicked and the error message is captured");
	}

	@Test(priority=7,dataProvider ="dp",dataProviderClass=DataProviders.class)

	public void valid_details(String rec_name,String rec_inv_email,String rec_mobile,String from_name,String from_email,String from_phno,String from_address,String from_pincode,String message,String rec_valid_email) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		GiftCards_Page gPage=new GiftCards_Page(driver);
		gPage.valid_rec_detail(rec_valid_email);
		//gPage.recemail_Element.clear();
		//gPage.recemail_Element.sendKeys(p.getProperty("rec_valid_mail"));
		logger.info("valid recipient details is set");
		Thread.sleep(2000);
		screenShot("valid details");
		logger.info("Screenshot taken");
	}

	@Test(priority=8,dataProvider ="dp",dataProviderClass=DataProviders.class)
	public void confirm_details(String rec_name,String rec_inv_email,String rec_mobile,String from_name,String from_email,String from_phno,String from_address,String from_pincode,String message,String rec_valid_email) throws InterruptedException, IOException 
	{
		GiftCards_Page gPage=new GiftCards_Page(driver);
		SoftAssert sa = new SoftAssert();
		gPage.click_on_confirm();
		Thread.sleep(2000);
		screenShot("Final details");
		logger.info("provided all the valid details and clicked on the confirm button");
		confirmdetails_Page cpg=new confirmdetails_Page(driver);
		String to_name= cpg.to_namElement.getText();
		sa.assertEquals(rec_name,to_name,"recipient names are not equal");
		String to_email=cpg.to_emailElement.getText();
		sa.assertEquals(rec_valid_email,to_email,"recipient emails are not matching");
		String to_ph =cpg.to_phElement.getText();
		sa.assertEquals(rec_mobile,to_ph,"recipient contact number is not matching");
		String f_name = cpg.fr_name.getText();
		sa.assertEquals(from_name, f_name,"From names are not matching");
		String f_email = cpg.fr_email.getText();
		sa.assertEquals(from_email, f_email,"From email are not matching");
		String f_ph = cpg.fr_ph.getText();
		sa.assertEquals(from_phno, f_ph,"From contact numbers are not matching");
		String f_add =cpg.fr_add.getText();
		sa.assertEquals(from_address,f_add,"From address is not matching");
		//String f_p =cpg.fr_pin.getText();
		//sa.assertEquals(from_pincode,f_p,"From pincode is not matching");
		String f_msg =cpg.msg.getText();
		sa.assertEquals(message,f_msg,"Message is not matching");
		sa.assertAll();
	}

}
