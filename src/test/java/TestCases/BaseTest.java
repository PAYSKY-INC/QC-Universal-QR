package TestCases;

import PaySky.QC.Utilites.GlobalProperties;
import PaySky.QC.Utilites.Selenium.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseTest {

    private DriverFactory driver;

    String propFileName = "Config.properties";

    @BeforeTest
    public void setUp() {
        driver = new DriverFactory();

        try {
            InputStream input = new FileInputStream("./src/main/resources/" + propFileName);
            GlobalProperties.global_propertoes.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
//    @AfterTest
//    public void tearDown() {
//        DriverFactory.quitDriver(); // Quit the driver after tests
//    }
}
