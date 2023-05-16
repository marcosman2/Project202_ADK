package Base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	protected static WebDriver driver;
	private WebDriverWait wait;
	static XLSReader reader;
	
	public static void initialization() {
		
		driver = WebDriverSingleton.getInstance();
		driver.manage().window().maximize();
		driver.get("https://adkgroup:mydevsite@adkcw-wp.adkalpha.com/contact/");		
	}
	
	 public void type(WebElement field, String text) {
		 
		 field.sendKeys(text);
	 }
	 
	 public void clickOnButton(WebElement button) {
		 
		 button.click();
	 }
	 
	 public String getElementText(WebElement element) {
		 
		 return element.getText();
	 }
	 
	 public boolean isElementDisplayed(WebElement element) {
		 
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 return element.isDisplayed();
	 }
	 
	 public void scrollDown(WebElement element) {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", element);
	 }
	 
	 public void waitForElementToBeClickable(WebElement element) {
		 
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 
	 public static Object[][] loadExcelTable() {
		 
		 		 
		 reader = new XLSReader("TestData/TestData.xlsx");		 
		 
		int totalRowCnt = reader.getRowCount("Test_Data");
		int totalColCnt = reader.getColumnCount("Test_Data");
		Object[][] data = new Object[totalRowCnt-1][1];
		
		ArrayList<String> colNames = new ArrayList<String>();
		
		for(int colCntr=0;colCntr<totalColCnt;colCntr++){
			colNames.add(reader.getCellData("Test_Data", colCntr, 1).trim());
		}
		
		for(int rCntr=0;rCntr<totalRowCnt-1; rCntr++){
			HashMap<String, String> inpRec = new HashMap<String, String>();
			
			for (int colCntr=0;colCntr<totalColCnt;colCntr++){				
				inpRec.put(colNames.get(colCntr), reader.getCellData("Test_Data", colNames.get(colCntr), rCntr+2));
			}				
			
			data[rCntr][0]=inpRec;
		}
		return data;
	 }

}
