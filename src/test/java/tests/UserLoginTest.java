package tests;



import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class UserLoginTest extends TestBase
{
	String name="Albus Dumbledore";
	final String depositamount="1000";
	final String withdrawamout="400";
	
	LoginPage loginObject ; 

	@Test
	public void UserCanRegisterSuccssfully() throws InterruptedException 
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(name,depositamount,withdrawamout);
		Assert.assertTrue(loginObject.txtType.getText().contains("Debit"));
	}
	
	
}
