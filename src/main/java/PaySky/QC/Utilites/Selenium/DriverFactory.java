package PaySky.QC.Utilites.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    // Thread-safe WebDriver instance
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(chromeDriverConfig());
        }
        return driver.get();
    }

    // Quit the driver and remove it from ThreadLocal
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    // Configure ChromeDriver
    private static WebDriver chromeDriverConfig() {
        // Set up WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // Uncomment below for headless mode
        // options.addArguments("--headless");

        return new ChromeDriver(options);
    }
}
