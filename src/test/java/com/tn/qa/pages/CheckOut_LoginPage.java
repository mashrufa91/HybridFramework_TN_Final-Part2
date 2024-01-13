package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_LoginPage {
public WebDriver driver;


@FindBy(linkText= "Step 2: Billing Details")
private WebElement billingDetailDisplayed;

@FindBy(xpath="//div[@class='radio']/label/input[@name='payment_address' and @value='new']")
private WebElement newBillingAddressOption;
@FindBy(xpath="//div[@id='payment-new']/following::div[@class='pull-right']/input[@id='button-payment-address'and @value='Continue']")
private WebElement billingAddressContinue;

@FindBy(id="input-payment-firstname")
private WebElement checkoutFirstname;

@FindBy(id="input-payment-lastname")
private WebElement checkoutLastname;
@FindBy(id="input-payment-email")
private WebElement checkoutEmail;

@FindBy(id="input-payment-telephone")
private WebElement checkoutTelephone;

@FindBy(id="input-payment-password")
private WebElement checkOutPassword;

@FindBy(id="input-payment-confirm")
private WebElement checkoutConfirmPassword;

@FindBy(id="input-payment-address-1")
private WebElement address1TextBox;

@FindBy(id="input-payment-address-2")
private WebElement address2TextBox;
@FindBy(id="input-payment-city")
private WebElement cityTextBox;
@FindBy(id="input-payment-postcode")
private WebElement postcodeTextBox;
@FindBy(id="input-payment-country")
private WebElement countryTextBox;

@FindBy(id="input-payment-zone")
private WebElement zoneTextBox;

@FindBy(xpath="//input[@id='button-payment-address' and @value='Continue']")
private WebElement continueReturningUser;
@FindBy(xpath="//input[@id ='button-shipping-method'and @value='Continue']")
private WebElement continueDeliverymethod;

@FindBy(partialLinkText="Payment Method")
private WebElement getStatusofPaymentmethod;

@FindBy(xpath="//input[@name='payment_method']")
private WebElement paymentMethod;

@FindBy(xpath="//input[@name='agree']")
private WebElement paymentMethodTandCAgree;

@FindBy(xpath="//input[@id='button-payment-method']")
private WebElement paymentMethodContinue;

@FindBy(partialLinkText="Confirm Order")
private WebElement Confirmorderstatus;

@FindBy(xpath="//div[@class='table-responsive']")
private WebElement statusOfOrderInfo;

@FindBy(xpath="//input[@id='button-confirm']")
private WebElement confirmOrder;

@FindBy(xpath="//input[@id='button-shipping-address']")
private WebElement continueDeliveryDetail;

public CheckOut_LoginPage(WebDriver driver) {
	
	this.driver= driver;
	PageFactory.initElements(driver, this);
}

public boolean getBillingDetailsDisplayed() {
	
	boolean BillingDetailsDisplayed=billingDetailDisplayed.isDisplayed();
	return BillingDetailsDisplayed;
	}

public void clickOnNewBillingAddressOption() {
	newBillingAddressOption.click();
}

public void clickOnBillingAddressContinue() {
	newBillingAddressOption.click();
}

public void enterFirstName(String firstnametext) {
	checkoutFirstname.sendKeys(firstnametext);
}

public void enterLastName(String lastnametext) {
	checkoutLastname.sendKeys(lastnametext);
}

public void enterEmail(String emailtext) {
	checkoutEmail.sendKeys(emailtext);
}

public void enterTelephone(String telephonetext) {
	checkoutTelephone.sendKeys(telephonetext);
}

public void enterPassword(String passwordtext) {
	checkOutPassword.sendKeys(passwordtext);
}

public void enterConfirmPassword(String confirmpasswordtext) {
	checkoutConfirmPassword.sendKeys(confirmpasswordtext);
}
	
	

public void enterAddress1(String address1text) {
	address1TextBox.sendKeys(address1text);
}	
public void enterAddress2(String address2text) {
	address2TextBox.sendKeys(address2text);
}	
public void enterCity(String cityText) {
	cityTextBox.sendKeys(cityText);
}	
public void enterPostCode(String postCodeText) {
	postcodeTextBox.sendKeys(postCodeText);
}	
public WebElement enterCountry() {
WebElement countryNames= countryTextBox;
	return countryNames;
	
}	
public WebElement enterZone() {
WebElement zoneNames= zoneTextBox;
	return zoneNames;	
}	


public void clickOnContinueAsReturningUser() {
	
	continueReturningUser.click();
}
public void clickOnContinueDeliverydetail() {
continueDeliveryDetail.click();
}

public void clickOnContinueDeliveryMethod() {
continueDeliverymethod.click();
}

public String getStatusofPaymentMethodText() {
	String displayPaymentMethodStatus= getStatusofPaymentmethod.getText();
	return displayPaymentMethodStatus;}
	

public void clickOnpaymentMethodTandCAgree() {

	paymentMethodTandCAgree.click();
}
public void clickOnPaymentMethodContinue() {
	paymentMethodContinue.click();
	
}
public String getStatusofConfirmOrderText() {
	String ConfirmOrderStatus= Confirmorderstatus.getText();
	return ConfirmOrderStatus;}

public boolean getStatusofOrderInfoDisplayed() {
	boolean displayOrderInfoStatus= statusOfOrderInfo.isDisplayed();
	return displayOrderInfoStatus;}

public OrderSuccessPage clickOnConfirmOrder() {
	confirmOrder.click();
	return new OrderSuccessPage(driver);
}
public void enterBasicDetails(String firstnametext,String lastnametext,String address1text, String address2text, 
		String cityText,String postCodeText) {
		checkoutFirstname.sendKeys(firstnametext);
	
		checkoutLastname.sendKeys(lastnametext);
		
		address1TextBox.sendKeys(address1text);
	
		address2TextBox.sendKeys(address2text);
	
		cityTextBox.sendKeys(cityText);
	
		postcodeTextBox.sendKeys(postCodeText);
		}
	
public void navigateToOrderInfoSection() {
	
	continueReturningUser.click();
	continueDeliveryDetail.click();

	continueDeliverymethod.click();

	paymentMethodTandCAgree.click();

	paymentMethodContinue.click();
		
	}

}

