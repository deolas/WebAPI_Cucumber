package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.PageActions;

public class RegistrationPage {

    private WebDriver ldriver;
    PageActions pageActions;

    public RegistrationPage(WebDriver rdriver) {
        ldriver = rdriver;
        pageActions = new PageActions();
    }

    By loginLink = By.cssSelector("a[data-test*=\"login-link\"]");
    By txtName = By.id("firstName");
    By txtEmail = By.id("email");
    By txtPassword = By.id("password");
    By btnCreateAcnt = By.cssSelector("button[type='submit']");
    By userName = By.cssSelector("span.css-xooaem");

    
    public void clickLoginLink() {
        pageActions.click(loginLink);
        pageActions.waitForPageLoad(ldriver);
    }

    public void setUserName(String uname) {
        pageActions.setText(txtName, uname);
    }
    
    public void setEmail(String email) {
        pageActions.setText(txtEmail, email);
    }

    public void setPassword(String pwd) {
        pageActions.setText(txtPassword, pwd);
    }

    public void clickCreateAccount() throws InterruptedException {
    	Thread.sleep(5);
        pageActions.click(btnCreateAcnt);
        pageActions.waitForPageLoad(ldriver);
    }


    public void launchURL(String url) {
        pageActions.launchUrl(url);
    }

    public void verifyPageTitle(String expectedtitle) {
        Assert.assertEquals(expectedtitle, pageActions.getPageTitle());
    }
    
    public void verifyUserName(String expectedUsername) {
        Assert.assertEquals(expectedUsername, pageActions.getText(userName));
    }
}
