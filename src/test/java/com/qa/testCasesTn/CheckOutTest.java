package com.qa.testCasesTn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.testBase.TestBase;
import com.tn.qa.pages.AddtoCartPage;
import com.tn.qa.pages.CheckOutPage;
import com.tn.qa.pages.CheckOut_LoginPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.OrderSuccessPage;
import com.tn.qa.pages.ProductInfoPage;
import com.tn.qa.pages.SearchProductPage;

public class CheckOutTest extends TestBase {

	public CheckOutTest() throws Exception {
		super();		
	}

	public WebDriver driver;
    public HomePage homepage;
    SearchProductPage searchproductpage;
    ProductInfoPage  productinfopage;
    CheckOutPage checkoutpage;
   
    OrderSuccessPage ordersuccesspage;
    CheckOut_LoginPage checkoutloginpage;
    
	@BeforeMethod
	public void setup() throws Exception {
		driver=initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage= new HomePage(driver);
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));
		Thread.sleep(1000);
		searchproductpage= homepage.clickOnSearchIcon();
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfValidProduct());
		productinfopage= searchproductpage.clickOnAddtoCart(); 
		productinfopage.clickOnAddtoCartinProductInfopage();
		Thread.sleep(2000);
		AddtoCartPage addtocartpage = new AddtoCartPage(driver);
		Assert.assertTrue(addtocartpage.varifyMessageofProductAddedDisplayed());
		Thread.sleep(2000);
		addtocartpage.clickOnCheckout();
		
	}
		
	
	@Test
	public void checkOutAsExistingUser() throws Exception {
		 checkoutpage= new CheckOutPage(driver);
		 Thread.sleep(2000);
		 Assert.assertTrue(checkoutpage.getStatusOfReturningOptionDisplayed());
		 checkoutpage.enterEmailForLogin(prop.getProperty("validEmail"));
		 checkoutpage.enterPasswordForLogin(prop.getProperty("validPassword"));
		 Thread.sleep(1000);
		 CheckOut_LoginPage checkoutloginpage=  checkoutpage.clickOnLoginForCheckOutButton();
		 checkoutloginpage.getBillingDetailsDisplayed();
		 checkoutloginpage.clickOnNewBillingAddressOption();
		 Thread.sleep(2000);
		 checkoutloginpage.clickOnBillingAddressContinue();
		 Thread.sleep(3000);
         checkoutloginpage.enterBasicDetails(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),
         dataProp.getProperty("address1"),dataProp.getProperty("address2"),dataProp.getProperty ("city"),dataProp.getProperty ("postcode"));
		 Select select = new Select(checkoutloginpage.enterCountry());
		 select.selectByVisibleText(dataProp.getProperty ("country"));
		 Select select1 = new Select(checkoutloginpage.enterZone());
		 select1.selectByVisibleText(dataProp.getProperty ("zone"));
		 Thread.sleep(2000);
		 checkoutloginpage.navigateToOrderInfoSection();
		 Thread.sleep(2000);
		 Assert.assertTrue(checkoutloginpage.getStatusofOrderInfoDisplayed());
		 Thread.sleep(2000);
		 ordersuccesspage =	checkoutloginpage.clickOnConfirmOrder();
		 Thread.sleep(2000);
		 ordersuccesspage.getStatusofOrderInfo(dataProp.getProperty("orderSuccessMessage"));
		 Thread.sleep(2000);
		 homepage = ordersuccesspage.clickOnContinueOrderSuccess();
		 
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}