package API;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetSteps {
    Response response;

    @Given("^the valid endpoint to return user data$")
    public void setupEndpoint()
    {
        RestAssured.baseURI="https://620e3da1585fbc3359db4edf.mockapi.io";
        RestAssured.basePath="/api/users";
    }


    @When("^the request is send to server with id as \"([^\"]*)\"$")
    public void sendRequest(int id)
    {
        response = given().
                queryParam("id",id).
                when().
                get().
                then().
                contentType(ContentType.JSON).
                extract().response();
    }


    @Then("^validate the response of this user record having first name as \"([^\"]*)\"$")
    public void validateUserData(String firstname)
    {
        String userEmail = response.path("data[10].firstName");
        Assert.assertEquals(userEmail, firstname);
    }
}
