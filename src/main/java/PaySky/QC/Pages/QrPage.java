package PaySky.QC.Pages;

import PaySky.QC.Utilites.Selenium.DriverFactory;
import PaySky.QC.Utilites.SharedComponent.SharedComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class QrPage {


    private WebDriver driver;


    public QrPage() {
        driver = DriverFactory.getDriver();
        SharedComponent.setImplicitWait(100);
    }

    private WebElement getDownloadBtn(){
        return driver.findElement(By.xpath("//button[contains(.,'Télécharger le code QR')]"));
    }

    private WebElement getPrintBtn(){
        return driver.findElement(By.xpath("//button[contains(.,'Imprimer le code QR')]"));
    }

    private WebElement getShareBtn(){
        return driver.findElement(By.xpath("//div[@id='root']/main/div/div/div[3]/div/button[2]"));
    }

    private WebElement getFbBtn(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[3]/div[2]/div/div[1]/button[1]"));
    }

    private WebElement getFbContent(){
        return driver.findElement(By.xpath("//div[@id='content']/div"));
    }

    private WebElement getTwitterBtn(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[3]/div[2]/div/div[1]/button[2]"));
    }

    private WebElement getRedditBtn(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[3]/div[2]/div/div[1]/button[3]"));
    }

    private WebElement getLinkedinBtn(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[3]/div[2]/div/div[1]/button[4]"));
    }


    public void downloadQr() throws Exception{
        getDownloadBtn().click();

        // Assertion
        Thread.sleep(2000);
        String ExpectedSuccessMsg = "success\n" +
                "Image de code QR téléchargée avec succès!!";
        String ActualSuccessMsg = driver.findElement(By.cssSelector(".ant-notification-notice-with-icon")).getText();
        Assert.assertEquals(ActualSuccessMsg,ExpectedSuccessMsg);

    }

    public void printQr() throws Exception{
        getPrintBtn().click();

        // Assertion
        Thread.sleep(2000);
        String ExpectedSuccessMsg = "success\n" +
                "PDF de code QR téléchargé avec succès!!";
        String ActualSuccessMsg = driver.findElement(By.cssSelector(".ant-notification-notice-with-icon")).getText();
        Assert.assertEquals(ActualSuccessMsg,ExpectedSuccessMsg);


    }

    public void shareWithFb() throws Exception{
        getShareBtn().click();
        SharedComponent.newWindow(driver, getFbBtn());

        //Assertion
        String ExpectedUrl = "https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fcube.gimpay.org%3A9006%2FUniversalQr%3Fmtoken%3DU1BEUin%252f88A4oP0e4Wg6eB5hWKIA5rqiOD4VF5gtB6qFingAvia%252b5nEudkCvWYnpLbOjUcKq";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);

    }

    public void shareWithTwitter() throws Exception{
        getShareBtn().click();
        SharedComponent.newWindow(driver , getTwitterBtn());

        // Assertion
        String ExpectedUrl = "https://x.com/intent/post?url=https%3A%2F%2Fcube.gimpay.org%3A9006%2FUniversalQr%3Fmtoken%3DU1BEUin%252f88A4oP0e4Wg6eB5hWKIA5rqiOD4VF5gtB6qFingAvia%252b5nEudkCvWYnpLbOjUcKq";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);


    }

    public void shareWithReddit() throws Exception{
        getShareBtn().click();
        SharedComponent.newWindow(driver , getRedditBtn());

        // Assertion
        String ExpectedUrl = "https://www.reddit.com/web/submit?url=https%3A%2F%2Fcube.gimpay.org%3A9006%2FUniversalQr%3Fmtoken%3DU1BEUin%252f88A4oP0e4Wg6eB5hWKIA5rqiOD4VF5gtB6qFingAvia%252b5nEudkCvWYnpLbOjUcKq";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);
    }


    public void shareWithLinkedin() throws Exception{
        getShareBtn().click();
        SharedComponent.newWindow(driver , getLinkedinBtn());

        // Assertion
        String ExpectedUrl = "https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww.linkedin.com%2FshareArticle%3Furl%3Dhttps%253A%252F%252Fcube.gimpay.org%253A9006%252FUniversalQr%253Fmtoken%253DU1BEUin%25252f88A4oP0e4Wg6eB5hWKIA5rqiOD4VF5gtB6qFingAvia%25252b5nEudkCvWYnpLbOjUcKq%26mini%3Dtrue";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl);

    }






}
