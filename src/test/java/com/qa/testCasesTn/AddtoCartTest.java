package com.qa.testCasesTn;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.tn.qa.pages.AddtoCartPage;
import com.tn.qa.pages.CheckOutPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.ProductInfoPage;
import com.tn.qa.pages.SearchProductPage;

public class AddtoCartTest extends TestBase {
	public AddtoCartTest() throws Exception {
		super();

	}

	public WebDriver driver;
	HomePage homepage;
	SearchProductPage searchproductpage;
	ProductInfoPage productinfopage;
	CheckOutPage checkoutpage;
	AddtoCartPage addtocartpage;
	
	@BeforeMethod
	public void setup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
	}

	@Test
	public void checkingOutValidProduct() throws Exception {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));

		searchproductpage = homepage.clickOnSearchIcon();

		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfValidProduct());
		searchproductpage.clickOnAddtoCart();
		Thread.sleep(3000);
		productinfopage = new ProductInfoPage(driver);
		Assert.assertTrue(productinfopage.statusValidProductCodeDisplayed());
		productinfopage.clickOnAddtoCartinProductInfopage();
		addtocartpage = new AddtoCartPage(driver);
		Assert.assertTrue(addtocartpage.varifyMessageofProductAddedDisplayed());
		Thread.sleep(3000);
		addtocartpage.clickOnAddForCheckout();
		addtocartpage.clickOnCheckout();
		checkoutpage = new CheckOutPage(driver);
		Assert.assertTrue(checkoutpage.getStatusofCheckoutOptionsDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
