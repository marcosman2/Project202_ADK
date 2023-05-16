package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base;
import Pages.ADKFormPage;
import Pages.ADKThanksPage;

public class ADKFormTestCases extends Base{
	
	private ADKFormPage pgADKForm;
	private ADKThanksPage pgADKThanks;
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		pgADKForm = new ADKFormPage();
		pgADKThanks = new ADKThanksPage();
	}	
	
	@DataProvider
	public static Object[][] getTestData(){		
		
		Object[][] data = loadExcelTable();		
		return data;
	}	
	
	public void fillOutAndClick(Object[][] testData, int row) {
		
		pgADKForm.setFormInformation(testData, row);
		pgADKForm.clicAcceptAllCookies();
		pgADKForm.clickSubmitButton();
	}
	
	@Test(priority = 1)
	public void requiredFirstName() {		
				
		fillOutAndClick(getTestData(), 0);		
		Assert.assertTrue(pgADKForm.isRequiredMessageDisplayed("firstname"), "Expected required field message not displayed");		
	}
	
	@Test(priority = 2)
	public void requiredLastName() {
		
		fillOutAndClick(getTestData(), 1);		
		Assert.assertTrue(pgADKForm.isRequiredMessageDisplayed("lastname"), "Expected required field message not displayed");		
	}
	
	@Test(priority = 3)
	public void requiredEmail() {
		
		fillOutAndClick(getTestData(), 2);		
		Assert.assertTrue(pgADKForm.isRequiredMessageDisplayed("email"), "Expected required field message not displayed");		
	}
	
	@Test(priority = 4)
	public void emailInvalidFormat() {
		
		fillOutAndClick(getTestData(), 3);		
		Assert.assertTrue(pgADKForm.isFormatMessageDisplayed(), "Expected incorrect format message not displayed");		
	}
	
	@Test(priority = 5)
	public void requiredCompany() {
		
		fillOutAndClick(getTestData(), 4);		
		Assert.assertTrue(pgADKForm.isRequiredMessageDisplayed("company"), "Expected required field message not displayed");		
	}
	
	@Test(priority = 6)
	public void phoneNotRequired() {
		
		fillOutAndClick(getTestData(), 5);		
		Assert.assertTrue(pgADKThanks.isThanksMessageDisplayed(), "Expected Thanks message not displayed");		
	}
	
	@Test(priority = 7)
	public void messageNotRequired() {
		
		fillOutAndClick(getTestData(), 6);		
		Assert.assertTrue(pgADKThanks.isThanksMessageDisplayed(), "Expected Thanks message not displayed");		
	}
	
	@Test(priority = 8)
	public void allFieldsFilledOut() {
		
		fillOutAndClick(getTestData(), 7);		
		Assert.assertTrue(pgADKThanks.isThanksMessageDisplayed(), "Expected Thanks message not displayed");		
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}	

}
