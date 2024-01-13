package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

public WebDriver driver;

@FindBy(xpath= "//h2[(contains(text(),'New Customer'))]")
private WebElement statusOfCheckoutOption;

@FindBy(xpath="//input[contains(@value,'register')]")
private WebElement registerAccountForCheckOut;


@FindBy(xpath="//input[@name='account' and @value='guest']")
private WebElement guestUserForCheckOut;

@FindBy(xpath="//input[@id='button-account']")
private WebElement continueButton;
@FindBy(xpath="//div[@class='col-sm-6']/h2[contains(text(), 'Returning Customer')]")
private WebElement getReturningCustomerOption;

@FindBy(id="input-email")
private WebElement enterEmailForLogin;

@FindBy(id="input-password")
private WebElement enterPasswordForLogin;

@FindBy(id="button-login")
private WebElement loginButton;

@FindBy(xpath="//input[@id='button-account']")
private WebElement continuRegisterButoon;



public CheckOutPage(WebDriver driver) {
	
	this.driver= driver;
	PageFactory.initElements(driver, this);
}


public boolean getStatusofCheckoutOptionsDisplayed() {
	boolean displayCheckoutStatus= statusOfCheckoutOption.isDisplayed();
	return displayCheckoutStatus;}

public boolean getStatusOfReturningOptionDisplayed() {
	boolean existingCustomerOption= getReturningCustomerOption.isDisplayed();
	return existingCustomerOption;
}
public void clickOnRegisterOptionforCheckout() {
	registerAccountForCheckOut.click();
}

public void clickOnContinueRegisterButton() {
	continuRegisterButoon.click();
}
public void clickOnGuestUserforCheckout() {
	guestUserForCheckOut.click();
}


public void enterEmailForLogin(String emailtext) {
	enterEmailForLogin.sendKeys(emailtext);
	
}
public void enterPasswordForLogin(String passwordtext) {
	enterPasswordForLogin.sendKeys(passwordtext);	
}

public CheckOut_LoginPage clickOnLoginForCheckOutButton() {
	loginButton.click();
	return new CheckOut_LoginPage(driver);
}

}