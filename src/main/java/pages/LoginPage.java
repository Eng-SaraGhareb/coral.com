package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//button[normalize-space()='Customer Login']")
	WebElement btnlogin; 

	@FindBy(id="userSelect")
	WebElement ddlName; 

	@FindBy(xpath ="//button[@type='submit']")
	WebElement btnSubmit; 
	
	@FindBy(xpath ="//button[normalize-space()='Deposit']")
	WebElement btnDeposit; 
	
	@FindBy(xpath ="//input[@placeholder='amount']")
	WebElement txtAmount;
	
	
	@FindBy(xpath ="//button[normalize-space()='Withdrawl']")
	WebElement btnWithdraw;
	
	
	@FindBy(xpath ="//button[normalize-space()='Transactions']")
	WebElement btnTran;
	
	@FindBy(xpath ="//td[normalize-space()='Debit']")
	public WebElement txtType;
	
	
	
	public void UserLogin(String name,String depositamount,String withdrawamout) throws InterruptedException 
	{
		
		clickButton(btnlogin);
		select = new Select(ddlName);
		select.selectByVisibleText(name);
		clickButton(btnSubmit);
		clickButton(btnDeposit);
		setTextElementText(txtAmount,depositamount);
		clickButton(btnSubmit);
		clickButton(btnWithdraw);
		setTextElementText(txtAmount,withdrawamout);
		clickButton(btnSubmit);
		clickButton(btnTran);	
		
	}

}
