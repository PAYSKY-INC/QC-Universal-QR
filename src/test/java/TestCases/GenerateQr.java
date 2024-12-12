package TestCases;

import PaySky.QC.Pages.GenerateQrPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;

public class GenerateQr extends BaseTest {


    GenerateQrPage generate = new GenerateQrPage();

    @org.testng.annotations.Test(priority = 1)
    @Description("Generate Merchant Qr link")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67062")
    public void generateQrLinkWithValidData()throws InterruptedException{
        generate.openPortal();
        generate.generateQrLinkWithValidData();
    }

    @org.testng.annotations.Test(priority = 2)
    @Description("Generate Merchant Qr link with merchant not enabled for universal qr" )
    @Link ("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67064")
    public void generateQrWithMerchantNotEnabledForUniversalQr() throws InterruptedException{
        generate.openPortal();
        generate.generateQrLinkWithMerchantDataNotEnabledForUniversalQr();
    }

    @org.testng.annotations.Test(priority = 3)
    @Description("Generate Merchant Qr link with merchant enabled for universal qr but not have web terminals" )
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/70685")
    public void generateQrWithMerchantEnabledForUniversalQrButNotHaveWebTerminals() throws InterruptedException{
        generate.openPortal();
        generate.generateQrWithMerchantEnabledForUniversalQrButNotHaveWebTerminals();
    }

    @org.testng.annotations.Test(priority = 4)
    @Description("Generate Merchant Qr link with valid merchant and invalid mobile number" )
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67061")
    public void generateQrWithValidMerchantAndInvalidMobileNumber() throws InterruptedException{
        generate.openPortal();
        generate.generateQrWithInvalidMerchantMobile();
    }

    @org.testng.annotations.Test(priority = 5)
    @Description ("Enter characters and special characters in Merchant Mobile Field")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/70684")
    public void EnterCharactersAndSpecialCharacters() throws InterruptedException{
        generate.openPortal();
        generate.enterCharactersAndSpecialCharactersInMobileField();
    }

    @org.testng.annotations.Test(priority = 6)
    @Description("Generate Merchant Qr link with empty field" )
    @Link ("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/70683")
    public void generateQrWithEmptyField() throws InterruptedException{
        generate.openPortal();
        generate.generateQrWithEmptyFields();
    }







}
