package com.qa.testCasesTn;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.SearchProductPage;

public class SearchProductTest extends TestBase {
public SearchProductTest() throws Exception {
		super();
			}

public WebDriver driver;
public HomePage homepage;
public SearchProductPage searchproductpage;
	
	@BeforeMethod
	public void registerSetup() {
		
		driver=initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
	
	}
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		homepage= new HomePage(driver);
		searchproductpage= homepage.navigateToSearchPage(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfValidProduct());
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		homepage= new HomePage(driver);
		searchproductpage= homepage.navigateToSearchPage(dataProp.getProperty("invalidProduct"));
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfInValidProduct());
				
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
