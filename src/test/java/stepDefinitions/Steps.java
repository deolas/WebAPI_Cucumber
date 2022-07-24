package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utilities.JsonReader;
import utilities.PageActions;

public class Steps extends BaseClass {
    public PageActions pageActions = new PageActions();
    public String jsonPath = null;

    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser() throws IOException {
        //lp = new LoginPage(BaseClass.driver);
        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) {
        lp.launchURL(url);
    }
    
    @When("Click on Login link")
    public void click_on_Login_link() {
        lp.clickLoginLink();
    }
    
    @When("Click on Create Account tab")
    public void click_on_create_account_tab() {
        lp.clickCreateAccountTab();
        regPage = new RegistrationPage(driver);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @And("user enters the login credentials from {string} file")
    public void userEntersTheLoginCredentialsFromFile(String filename) {
        jsonPath = "./src/test/java/Resources/" + filename;
        lp.setUserName(JsonReader.getValueByJPath(jsonPath, "/validLoginUsername"));
        lp.setPassword(JsonReader.getValueByJPath(jsonPath, "/validLoginPassword"));
    }

    @When("Click on Login")
    public void click_on_Login() {
        lp.clickLogin();
    }
    
    @Then("Page Title should be {string}")
    public void page_Title_should_be(String pagetitle) {
        lp.verifyPageTitle(pagetitle);
    }
    
    @Then("Username should be {string}")
    public void user_name_should_be(String user_name) {
        lp.verifyUserName(user_name);
    }


    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }


    @When("User enters customer info")
    public void user_enter_customer_info() throws InterruptedException {
        jsonPath = "./src/test/java/Resources/test.json";
        String email = pageActions.generateRamdomString() + "@gmail.com";
        regPage.setEmail(email);
        regPage.setPassword(JsonReader.getValueByJPath(jsonPath, "/validLoginPassword"));
        regPage.setUserName(JsonReader.getValueByJPath(jsonPath, "/name"));
    }

    @When("Click on Create Account Button")
    public void click_on_create_button() throws InterruptedException {
        regPage.clickCreateAccount();
    }
}
