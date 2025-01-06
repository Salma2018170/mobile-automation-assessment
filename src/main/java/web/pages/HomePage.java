package web.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    // Driver Initialization
    AppiumDriver driver;
    //Locators
    By homePageTitleText= AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");//android.widget.TextView[@text="PRODUCTS"]');

    //Wait time initialization
    Duration DURATION = Duration.ofSeconds(20);
    Wait<WebDriver> wait;
    public HomePage(AppiumDriver driver){
        this.driver=driver;
    }
    //Methods
    public String getErrorMessageForLogIn() {
        wait = new WebDriverWait(driver, DURATION);
        wait.until(d -> {
            driver.findElement(homePageTitleText).isDisplayed();
            return true;
        });
        return driver.findElement(homePageTitleText).getText();
    }

}
