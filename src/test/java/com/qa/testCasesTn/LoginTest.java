package com.qa.testCasesTn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.tn.testData.Data_driven_excel;
import com.tn.qa.Utilities.Util;
import com.tn.qa.pages.AccountPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.LoginPage;


public class LoginTest extends TestBase {

	public LoginTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public ChromeOptions options;
	public LoginPage lp;
	AccountPage accountpage;
	@BeforeMethod
	public void loginSetup() {

		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropDownMenu();
		homepage.selectLoginOption();

	}

	@Test(priority = 1, dataProvider = "LN", dataProviderClass = Data_driven_excel.class)
	public void verifyLoginWithValidCredentials(String username, String password) {
	lp = new LoginPage(driver);
	lp.navigateToLoginPage(username, password);
    accountpage = new AccountPage(driver);
    Assert.assertTrue(accountpage.getDisplayStatusOfEditAccountInfo());

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		lp = new LoginPage(driver);
		lp.navigateToLoginPage(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(lp.retrieveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")));
	}
		

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
