package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class ADKThanksPage extends Base {
	
	@FindBy(xpath="//h2[contains(text(), 'Thanks for throwing us a bone.')]")
	private WebElement lblThaksMessage;
	
	
	public ADKThanksPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean isThanksMessageDisplayed() {		
		
		return isElementDisplayed(lblThaksMessage);
	}

}
