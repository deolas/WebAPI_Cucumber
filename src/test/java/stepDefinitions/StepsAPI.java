package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.auto.core.helpers.ConfigReader;
import org.hamcrest.Matchers;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepsAPI {
	private static final String BASE_URL = "https://vmos2.vmos-demo.com";
	
    Response res;
    ConfigReader cr = new ConfigReader();
    

    @Given("^application is up and reachable$")
    public void initialize_comment_api_spec() {
        given()
                .get(cr.get_base_uri())
                .then()
                .assertThat().statusCode(200);
    }

    @And("Register user with name as \"([^\"]*)\"$")
    public void create_user(String name) {
    	
        HashMap<String, Object> test_data = new HashMap<>();
        HashMap<String, Object> profile = new HashMap<>();
        profile.put("firstName", name);
   
        String email = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
        test_data.put("profile", profile);
        test_data.put("email", email);
        test_data.put("password", cr.get_password());
        test_data.put("storeUUID", cr.get_storeUUID());
        test_data.put("locale", cr.get_locale());
        
        HashMap<String, String> header = new HashMap<String, String>();
        
        header.put("tenant", cr.get_tenant_token());
        header.put("content-type", "application/json");
        
        RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.headers(header);
		res = request.body(test_data)
				.post("/user/v1/user");
    }

    
    @When("Login with username as \"([^\"]*)\"  and password as \\\"([^\\\"]*)\\\"$")
    public void login_user(String email, String password) {
        HashMap<String, Object> test_data = new HashMap<>();

        test_data.put("email", email);
        test_data.put("password", cr.get_password());
        
        HashMap<String, String> header = new HashMap<String, String>();
        
        header.put("tenant", cr.get_tenant_token());
        header.put("content-type", "application/json");
        
        RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.headers(header);
		res = request.body(test_data)
				.post("/user/v1/user");
        
    }
    
    @Then("^verify the response code is (\\d+)$")
    public void verify_response_code(int response_code) {
    	res.then().assertThat().statusCode(response_code);
    }
    
    @Then("^verify response time is within configured value$")
    public void verify_response_time() {
    	res.then()
        .assertThat()
        .time(Matchers.lessThan(cr.get_max_response_time()));
    }
    
    @Then("^verify the user is created successfully$")
    public void verify_the_user_is_created_successfully() {
    	String jsonString = res.asString();
		String token = JsonPath.from(jsonString).get("payload.token.value");
        Assert.assertTrue("User Registration is NOT successful", token.length()>0);
    }
    
}
