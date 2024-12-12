package TestCases;

import PaySky.QC.Pages.GenerateQrPage;
import PaySky.QC.Pages.QrPage;
import PaySky.QC.Utilites.Selenium.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.AfterTest;

public class MerchantQr extends BaseTest {

    GenerateQrPage generateQrPage = new GenerateQrPage();
    QrPage qrPage = new PaySky.QC.Pages.QrPage();



    @org.testng.annotations.Test(priority = 1)
    @Description("Download The Qr")
    @Link ("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67065")
    public void downloadTheQr() throws Exception {
        generateQrPage.openPortal();
        generateQrPage.generateQrLinkWithValidData();
        Thread.sleep(2000);
        qrPage.downloadQr();
        Thread.sleep(2000);

    }

    @org.testng.annotations.Test(priority = 2)
    @Description("Print The Qr")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67067")
    public void printTheQr() throws Exception {

        generateQrPage.openPortal();
        generateQrPage.generateQrLinkWithValidData();
        Thread.sleep(2000);
        qrPage.printQr();
        Thread.sleep(2000);

    }

    @org.testng.annotations.Test(priority = 3)
    @Description("Share With Facebook")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67068")
    public void shareWithFb() throws Exception {

        generateQrPage.openPortal();
        generateQrPage.generateQrLinkWithValidData();
        Thread.sleep(2000);
        qrPage.shareWithFb();


    }

    @org.testng.annotations.Test(priority = 4)
    @Description("Share With Twitter")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67068")
    public void shareWithTwitter() throws Exception {

        generateQrPage.openPortal();
        generateQrPage.generateQrLinkWithValidData();
        Thread.sleep(2000);
        qrPage.shareWithTwitter();


    }


    @org.testng.annotations.Test(priority = 5)
    @Description("Share With Reddit")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67068")
    public void shareWithReddit() throws Exception {

        generateQrPage.openPortal();
        generateQrPage.generateQrLinkWithValidData();
        Thread.sleep(2000);
        qrPage.shareWithReddit();


    }

    @org.testng.annotations.Test(priority = 6)
    @Description("Share With Linkedin")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67068")
    public void shareWithLinkedin() throws Exception {

        generateQrPage.openPortal();
        generateQrPage.generateQrLinkWithValidData();
        Thread.sleep(2000);
        qrPage.shareWithLinkedin();


    }









    @AfterTest
    public void tearDown() {
        DriverFactory.quitDriver(); // Quit the driver after tests
    }


}