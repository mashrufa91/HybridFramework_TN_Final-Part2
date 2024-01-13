package com.qa.testCasesTn;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.tn.qa.pages.RegisterPage;
import SpecialClass.Util;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public com.tn.qa.pages.HomePage homepage;
	public RegisterPage registerpage;
	public com.tn.qa.pages.AccountSuccessPage accountsuccesspage;

	@BeforeMethod
	public void setup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new com.tn.qa.pages.HomePage(driver);
		homepage.clickOnMyAccountDropDownMenu();
		registerpage = homepage.selectRegisterOption(); // system will be re-directed to RegisterPage

	}

	@Test(priority = 1)
	public void verifyingRegisterWithMandatoryFields() {
		accountsuccesspage = registerpage.registerPageMandatoryDetails(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("mobile"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		Assert.assertEquals(accountsuccesspage.retrieveAccountSuccessMessage(),
				dataProp.getProperty("accountSuccessMessage"));

	}

	

	@Test(priority = 2)
	public void verifyingRegisterWithExistingEmail() {
		registerpage.registerPageAllDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("mobile"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));
		Assert.assertTrue(registerpage.retrieveDuplicateEmailWarning()
				.contains(dataProp.getProperty("duplicateEmailWarningMessage")));
	}

	

	@Test(priority = 3)
	public void verifyingRegisterWithNoFields() {
		registerpage.clickOnContinueButton();

		Assert.assertTrue(registerpage.retrieveAllWarningMessageStatus(
				dataProp.getProperty("privacyPolicyWarningMessage"), dataProp.getProperty("firstNameWarningMessage"),
				dataProp.getProperty("lastNameWarningMessage"), dataProp.getProperty("emailWarningMessage"),
				dataProp.getProperty("telephoneWarningMessage"), dataProp.getProperty("passwordWarningMessage")));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
