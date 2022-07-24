package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utilities.DriverManager;
import utilities.PageActions;

public class BaseClass {

    // public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
    public static WebDriver driver;
    public LoginPage lp;
    public RegistrationPage regPage;
    public static Logger logger;
    public Properties configProp;
    public long maximumTimeout = 40;
    public PageActions pageActions;
    public DriverManager driverManager;
    public static Scenario scenario;
    public static String screenshotname;

}
