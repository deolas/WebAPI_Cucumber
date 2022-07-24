package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.PageActions;

public class LoginPage {

    private WebDriver ldriver;
    PageActions pageActions;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        pageActions = new PageActions();
    }

    By loginLink = By.cssSelector("a[data-test*=\"login-link\"]");
    By tabCreateAccount = By.xpath("//li[text()='Create Account']");
    By txtEmail1 = By.id("email");
    By txtPassword1 = By.id("password");
    By btnLogin1 = By.xpath("//button[text()='Login']");
    By userName = By.cssSelector("span.css-xooaem");

    
    public void clickLoginLink() {
        pageActions.click(loginLink);
        pageActions.waitForPageLoad(ldriver);
    }
    
    public void clickCreateAccountTab() {
        pageActions.click(tabCreateAccount);
        pageActions.waitForPageLoad(ldriver);
    }

    public void setUserName(String uname) {
        pageActions.setText(txtEmail1, uname);
    }

    public void setPassword(String pwd) {
        pageActions.setText(txtPassword1, pwd);
    }

    public void clickLogin() {
        pageActions.click(btnLogin1);
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
