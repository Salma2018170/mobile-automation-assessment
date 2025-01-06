package test.runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.utils.TestBase;
import web.pages.HomePage;
import web.pages.LoginPage;

import java.time.Duration;

public class TestCases {
    AppiumDriver driver;
    TestBase base = new TestBase();

    //Pages initialization

    LoginPage loginPage;
    HomePage homePage;


    @BeforeClass
    public void beforeClass() throws Exception {
        base.beforeTest();
        driver = base.getDriver();
        ((AndroidDriver)driver).activateApp("com.swaglabsmobileapp");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }

    @AfterClass
    public void afterClass() {
        /**
         * un-commit the below statement
         * then fix the error
         */
   //        ((InteractsWithApps) driver).terminateApp();
    }

  //
    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(e));
    }



    @Description("Validate the successful login and assert product page log in")
    @Test(priority = 3)
    public void successfulLogin() {
        /** this first test cases
         * you have to add your command to check positive scenario based on test case name(method name)
         * then verify the login success! here it's better to use  waitForVisibility method after login success
         * userName: standard_user
         * password: secret_sauce
         */
        // Perform actions specific to your test case, for example:

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        // Assertion example:
       Assert.assertEquals(homePage.getErrorMessageForLogIn(),"PRODUCTS");

    }
    @Description("Validate the error message when the user enters an invalid username and blank password")
    @Test(priority = 1)
    public void invalidUserName() {
        //By.id("com.swaglabsmobileapp:id/username");
        /** This second test cases
         * you have to fix the locators
         * then verify the error message
         */
        // Perform actions specific to your test case, for example:
        loginPage.enterUserName("invalidUsername");
        loginPage.clickOnLoginButton();

        // Assertion example:
     //   System.out.println( loginPage.getErrorMessageForLogIn());
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(),"Password is required");
    }


    @Test(priority = 2)
    public void invalidPassword() {
        /** this third test cases
         * you have to add your command to check negative scenario based on test case name()method
         * then verify the error message
         */
        // Perform actions specific to your test case, for example:
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickOnLoginButton();
        // Assertion example:
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(),"Username and password do not match any user in this service.");
    }

    /** This final part add your test case
     * only one test case to have 4th priority
     */
    @Test(priority = 4)
    public void blankUserNamed() {
        /** this fourth test cases
         * you have to add your command to check negative scenario based on test case name()method
         * then verify the error message
         */
        // Perform actions specific to your test case, for example:
       // loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        // Assertion example:
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(),"Username is required4");
    }

}
