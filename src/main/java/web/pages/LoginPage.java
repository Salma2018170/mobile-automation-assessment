package web.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    //Driver initialization
    AppiumDriver driver;

    //Locators
    private By userNameFailed = AppiumBy.accessibilityId("test-Username");
    private By passwordFailed = AppiumBy.accessibilityId("test-Password");
    private By loginButton = AppiumBy.accessibilityId("test-LOGIN");

    private By errorMessageBox = AppiumBy.accessibilityId("test-Error message");

    private  By errorMessageText = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView");

    //Wait time initialization
    Duration DURATION = Duration.ofSeconds(20);
    Wait<WebDriver> wait;


    //constructor
   public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void enterUserName(String userName) {
        wait = new WebDriverWait(driver, DURATION);
        wait.until(d -> {
            driver.findElement(userNameFailed)
                    .sendKeys(userName);
            return true;
        });
    }

    public void enterPassword(String password) {
        wait = new WebDriverWait(driver, DURATION);
        wait.until(d -> {
            driver.findElement(passwordFailed)
                    .sendKeys(password);
            return true;
        });
    }

    public void clickOnLoginButton() {
        wait = new WebDriverWait(driver, DURATION);
        wait.until(d -> {
            driver.findElement(loginButton).click();
            return true;
        });
    }

    public String getErrorMessageForLogIn() {
        wait = new WebDriverWait(driver, DURATION);
        wait.until(d -> {
            driver.findElement(errorMessageBox).isDisplayed();
            return true;
        });
        return driver.findElement(errorMessageText).getText();
    }
}
