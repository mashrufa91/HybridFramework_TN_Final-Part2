package com.tn.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {
	public WebDriver driver;
	@FindBy(xpath= "//h1[contains(text(),'Your order')]")
	private WebElement getOrderSuccessStatus;

@FindBy(linkText="Continue")
private WebElement ContinueOrderSuccess;



public OrderSuccessPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

public String OrderSuccessStatus() {
String orderSuccessStatus=	getOrderSuccessStatus.getText();
return orderSuccessStatus;	
}
public HomePage clickOnContinueOrderSuccess() {
	ContinueOrderSuccess.click();
	return new HomePage(driver);
	
}

public boolean getStatusofOrderInfo(String expectedMessage) {
	boolean orderStatus= getOrderSuccessStatus.getText().contains(expectedMessage);
	return orderStatus;
}

}

