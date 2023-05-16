package Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class ADKFormPage extends Base{
	
	@FindBy(id="firstname")
	private WebElement txtFirstName;
	
	@FindBy(id="lastname")
	private WebElement txtLastName;
	
	@FindBy(id="email")
	private WebElement txtEmail;
	
	@FindBy(id="company")
	private WebElement txtCompany;
	
	@FindBy(id="phone")
	private WebElement txtPhoneNumber;
	
	@FindBy(id="message")
	private WebElement txtMessage;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnSubmit;
	
	@FindBy(id="onetrust-accept-btn-handler")
	private WebElement btnAcceptCookies;
	
	@FindBy(xpath="//input[@id='email']/following-sibling::span[contains(text(), 'Incorrect format')]")
	private WebElement lblEmailFormat;
	
	
	public ADKFormPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void fillOutForm(HashMap<String, String> dataForm) {
		
		waitForElementToBeClickable(txtFirstName);
		type(txtFirstName, dataForm.get("FirstName"));
		type(txtLastName, dataForm.get("LastName"));
		type(txtEmail, dataForm.get("Email"));
		type(txtCompany, dataForm.get("Company"));
		type(txtPhoneNumber, dataForm.get("PhoneNumber"));
		type(txtMessage, dataForm.get("Message"));	
	}
	
	@SuppressWarnings("unchecked")
	public void setFormInformation(Object[][] dpForm, int row) {
		
		HashMap<String, String> dataForm = (HashMap<String, String>) dpForm[row][0];
		
		fillOutForm(dataForm);
	}
	
	public void clicAcceptAllCookies() {
		
		clickOnButton(btnAcceptCookies);
	}
	
	public void clickSubmitButton() {
		
		scrollDown(txtPhoneNumber);
		
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		clickOnButton(btnSubmit);
	}
	
	public boolean isRequiredMessageDisplayed(String field) {
		
		WebElement fieldRequiredMessage = driver.findElement(By.xpath("//input[@id='"+field+"']/following-sibling::span[contains(text(), 'This field is required')]"));
		
		return isElementDisplayed(fieldRequiredMessage);
	}
	
	public boolean isFormatMessageDisplayed() {		
		
		return isElementDisplayed(lblEmailFormat);
	}

}
