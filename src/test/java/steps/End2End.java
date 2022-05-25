package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import tests.TestBase;

public class End2End extends TestBase {

	LoginPage loginObject ; 
	 

	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() throws Throwable {
		
		
	}

	@When("^user click on customer login$")
	public void user_click_on_customer_login(String name,String depositamount,String withdrawamout) throws InterruptedException  
	{
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(name,depositamount,withdrawamout);
	}


	@Then("^user can view the transaction type$")
	public void user_can_view_the_transaction_type()  {
		Assert.assertTrue(loginObject.txtType.getText().contains("Debit"));
	}
}
