package API;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

public class PostSteps {
	Response response;
	public HashMap<Object,Object> map=new HashMap<Object,Object>();
	   
	    @Given("^the valid endpoint to create user$")
	    public void setupEndpointAndPostData()
	    {
	  RestAssured.baseURI="https://620e3da1585fbc3359db4edf.mockapi.io";
	    RestAssured.basePath="/api/users";
	 
	    map.put("name","engineer");
	    map.put("username", "test");
	    map.put("firstName","sara");
	    map.put("lastName", "ghareb");
	    map.put("orders","100");

	    }
	   
	   
	    @When("^the request is send to server$")
	    public void sendRequest()
	    {
	    response = given()
	    .contentType(ContentType.JSON)
	    .body(map)   
	    .when()
	    .post()
	    .then()
	    .statusCode(201).contentType(ContentType.JSON).
	    extract().response();
	    }
	   
	   
	    @Then("^the new user created with status code as \"([^\"]*)\"$")
	    public void validateResponse(String name)
	    {
	      String userName = response.path("name");
	      Assert.assertEquals(userName, name);
	    }

}
