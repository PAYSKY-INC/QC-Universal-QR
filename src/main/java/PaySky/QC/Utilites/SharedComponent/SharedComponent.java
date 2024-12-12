package PaySky.QC.Utilites.SharedComponent;
import PaySky.QC.ApiRequest.GenerateQrRequest;
import PaySky.QC.Utilites.Selenium.DriverFactory;
import PaySky.QC.Utilites.TestData.Constant;
import io.restassured.response.Response;

import java.time.Duration;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class SharedComponent {





    // Method to set implicit wait
    public static void setImplicitWait(long timeInSeconds) {
        WebDriver driver = DriverFactory.getDriver(); // Ensure driver is retrieved
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }


    public static void newWindow(WebDriver driver, WebElement elementToClick) {
        // Capture the original window handle
        String originalWindow = driver.getWindowHandle();

        // Get all current window handles
        Set<String> oldWindows = driver.getWindowHandles();

        // Perform the click action
        elementToClick.click();

        // Wait for the new window to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(oldWindows.size() + 1));

        // Get the updated window handles
        Set<String> newWindows = driver.getWindowHandles();

        // Identify the new window handle
        String newWindow = newWindows.stream()
                .filter(handle -> !oldWindows.contains(handle))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("New window did not open"));

        // Switch to the new window
        driver.switchTo().window(newWindow);



    }


}
