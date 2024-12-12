package PaySky.QC.Pages;


import PaySky.QC.Utilites.Selenium.DriverFactory;
import PaySky.QC.Utilites.SharedComponent.SharedComponent;

import PaySky.QC.Utilites.TestData.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static PaySky.QC.ApiRequest.GenerateQrRequest.generateQrUrl;


public class LightBoxPage {

    private WebDriver driver;


    public LightBoxPage() {
        driver = DriverFactory.getDriver();
        SharedComponent.setImplicitWait(30);
    }

    // Methods to retrieve locators

    private WebElement AmountInputFiled(){
        return driver.findElement(By.id("Payment"));
    }

    private WebElement CardNumField(){
        return driver.findElement(By.id("cc-number"));
    }

    private WebElement Expiration(){
        return driver.findElement(By.id("inputExpiration"));
    }

    private WebElement Cvv(){
        return driver.findElement(By.id("inputCVV"));
    }

    private WebElement NameOnCard(){
        return driver.findElement(By.id("inputNameonCard"));
    }

    private WebElement PayBtn(){
        return driver.findElement(By.xpath("//div[@id='lightboxmodal']/div/div/div/section/div/app-pay-by-card/div[2]/form/div[5]"));
    }



    // Methods
    public void openLightBox() throws Exception{
        driver.get(generateQrUrl());
    }

    public void PayWithValidData() throws Exception{
        AmountInputFiled().clear();
        AmountInputFiled().sendKeys(Constant.ValidAmount);
        CardNumField().sendKeys(Constant.ValidCardNumber);
        Expiration().sendKeys(Constant.ValidExpiration);
        Cvv().sendKeys(Constant.ValidCvv);
        NameOnCard().sendKeys(Constant.NameOnCard);
        PayBtn().click();

    }


    public void payWithZeroAmount() throws Exception{
        CardNumField().sendKeys(Constant.ValidCardNumber);
        Expiration().sendKeys(Constant.ValidExpiration);
        Cvv().sendKeys(Constant.ValidCvv);
        NameOnCard().sendKeys(Constant.NameOnCard);
        PayBtn().click();

        //Assertion
        Boolean  ExpectedState = false;
        Boolean ActualState =  driver.findElement(By.xpath("//*[@id=\"pay-btn\"]")).isEnabled();
        Assert.assertEquals(ActualState,ExpectedState);
        String disabledAttribute = driver.findElement(By.xpath("//*[@id=\"pay-btn\"]")).getAttribute("disabled");
        if (disabledAttribute != null) {
            System.out.println("Button has 'disabled' attribute.");
        } else {
            System.out.println("Button does not have 'disabled' attribute.");
        }


    }

    public void payWithInvalidAmount() throws Exception{
        AmountInputFiled().clear();
        AmountInputFiled().sendKeys(Constant.InvalidAmount);
        CardNumField().sendKeys(Constant.ValidCardNumber);
        Expiration().sendKeys(Constant.ValidExpiration);
        Cvv().sendKeys(Constant.ValidCvv);
        NameOnCard().sendKeys(Constant.NameOnCard);
        PayBtn().click();

        //Assertion
        Boolean  ExpectedState = false;
        Boolean ActualState =  driver.findElement(By.xpath("//*[@id=\"pay-btn\"]")).isEnabled();
        Assert.assertEquals(ActualState,ExpectedState);

    }

    public void payWithEmptyAmountField() throws Exception{
        AmountInputFiled().clear();
        CardNumField().sendKeys(Constant.ValidCardNumber);
        Expiration().sendKeys(Constant.ValidExpiration);
        Cvv().sendKeys(Constant.ValidCvv);
        NameOnCard().sendKeys(Constant.NameOnCard);
        PayBtn().click();

        //Assertion
        Boolean  ExpectedState = false;
        Boolean ActualState =  driver.findElement(By.xpath("//*[@id=\"pay-btn\"]")).isEnabled();
        Assert.assertEquals(ActualState,ExpectedState);
    }

    public void payWithAmountMoreThanZero() throws Exception{
        AmountInputFiled().clear();
        AmountInputFiled().sendKeys(Constant.MinAmount);
        CardNumField().sendKeys(Constant.ValidCardNumber);
        Expiration().sendKeys(Constant.ValidExpiration);
        Cvv().sendKeys(Constant.ValidCvv);
        NameOnCard().sendKeys(Constant.NameOnCard);
        PayBtn().click();

    }






}
