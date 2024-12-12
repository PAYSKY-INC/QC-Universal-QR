package PaySky.QC.Pages;

import PaySky.QC.Utilites.GlobalProperties;
import PaySky.QC.Utilites.Selenium.DriverFactory;
import PaySky.QC.Utilites.SharedComponent.SharedComponent;
import PaySky.QC.Utilites.TestData.Constant;
import PaySky.QC.Utilites.TestData.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GenerateQrPage {

    private WebDriver driver;
    DataFaker faker = new DataFaker();

    public GenerateQrPage() {
        driver = DriverFactory.getDriver();
        SharedComponent.setImplicitWait(100);
    }

    // Methods to retrieve locators
    private WebElement getMerchantName() {
        return driver.findElement(By.id("merchant-name"));
    }

    private WebElement selectCountryCodeDDL(){
        return driver.findElement(By.xpath("//div[2]/div/div/div/div"));
    }

    private WebElement getMerchantMobile() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/section/form/div/div[2]/div/div[2]/input"));
    }

    private WebElement getGenerateQrBtn() {
        return driver.findElement(By.xpath("//button[contains(.,'Générer un code QR')]"));
    }

    private WebElement getNotUniversalQrValidation(){
        return driver.findElement(By.xpath("//*[text()='Universal QR Generator service not allowed to this merchant']"));


    }

    private WebElement getNotHaveWebTerminalValidation(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/section/form/div/div[2]/div/div[2]/span"));


    }



    // Methods

    public void openPortal() {
        driver.get(GlobalProperties.getProperty("UniversalQrPortal"));
    }

    public void generateQrLinkWithValidData() throws InterruptedException {
        getMerchantName().sendKeys(Constant.MerchantName);
        getMerchantMobile().sendKeys(Constant.MerchantMobileNumber);
        Thread.sleep(2000);
        getGenerateQrBtn().click();
        Thread.sleep(2000);

        // Assertion
        String ExpectedUrl = "https://cube.gimpay.org:6025/qr/show";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);
    }

    public void generateQrLinkWithMerchantDataNotEnabledForUniversalQr() throws InterruptedException{
        getMerchantName().sendKeys(Constant.MerchantNotEnabledForUniversalQr);
        getMerchantMobile().sendKeys(Constant.MobileMerchantNotEnabledForUniversalQr);
        getGenerateQrBtn().click();
        Thread.sleep(500);

        // Assertion
        String ExpectedValidation = "Universal QR Generator service not allowed to this merchant";
        String ActualValidation = getNotUniversalQrValidation().getText();
        Assert.assertEquals(ActualValidation,ExpectedValidation);

        String ExpectedUrl = "https://cube.gimpay.org:6025/qr";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);


    }

    public void generateQrWithMerchantEnabledForUniversalQrButNotHaveWebTerminals() throws InterruptedException{
        getMerchantName().sendKeys(Constant.MerchantNotHaveWebTerminals);
        getMerchantMobile().sendKeys(Constant.MobileMerchantNotHaveWebTerminals);
        selectCountryCodeDDL().click();
        driver.findElement(By.xpath("//label[contains(.,'221')]")).click();
        getGenerateQrBtn().click();
        Thread.sleep(1000);

        // Assertion
        String ExpectedValidation = "Terminal doesn't exist";
        String ActualValidation = getNotHaveWebTerminalValidation().getText();
        Assert.assertEquals(ActualValidation,ExpectedValidation);

        String ExpectedUrl = "https://cube.gimpay.org:6025/qr";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);
    }


    public void generateQrWithInvalidMerchantMobile() throws InterruptedException{
        getMerchantName().sendKeys(Constant.MerchantName);
        getMerchantMobile().sendKeys(faker.MobileNumber());
        getGenerateQrBtn().click();
        Thread.sleep(1000);

        //Assertion
        String ExpectedValidation = "Invalid Mobile Number";
        String ActualValidation = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/section/form/div/div[2]/div/div[2]/span")).getText();
        Assert.assertEquals(ActualValidation,ExpectedValidation);



    }

    public void enterCharactersAndSpecialCharactersInMobileField() throws InterruptedException{
        getMerchantMobile().sendKeys("asgqhs%$");

        //Assertion
        String ExpectedValidation = "Le format du mobile du marchand est incorrect";
        String ActualValidation = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/section/form/div/div[2]/div/div[2]/span")).getText();
        Assert.assertEquals(ActualValidation,ExpectedValidation);
    }

    public void generateQrWithEmptyFields() throws InterruptedException{
        Thread.sleep(1000);
        getGenerateQrBtn().click();
        Thread.sleep(1000);

        //Assertion
        String ExpectedMissingNameValidation = "Le nom du marchand est requis";
        String ActualMissingNameValidation = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/section/form/div/div[1]/span")).getText();
        Assert.assertEquals(ActualMissingNameValidation,ExpectedMissingNameValidation);


        String ExpectedMissingMobileValidation = "Mobile du marchand requis";
        String ActualMissingMobileValidation =driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/section/form/div/div[2]/div/div[2]/span")).getText();
        Assert.assertEquals(ActualMissingMobileValidation,ExpectedMissingMobileValidation);
    }




}

