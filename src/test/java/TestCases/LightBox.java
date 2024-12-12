package TestCases;

import PaySky.QC.Pages.LightBoxPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;

public class LightBox extends BaseTest{

    LightBoxPage lightbox = new LightBoxPage();

    @org.testng.annotations.Test(priority = 1)
    @Description("Pay With Valid Data")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67104")
    public void PayWithValidData() throws Exception {
        lightbox.openLightBox();
       lightbox.PayWithValidData();
    }

    @org.testng.annotations.Test(priority = 2)
    @Description("Pay With zero Amount")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67078")
    public void payWithZeroAmount() throws Exception{
        lightbox.openLightBox();
        lightbox.payWithZeroAmount();
    }

    @org.testng.annotations.Test(priority = 3)
    @Description("Pay With Invalid Amount like (-1)")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67079")
    public void payWithInvalidAmount() throws Exception{
        lightbox.openLightBox();
        lightbox.payWithInvalidAmount();
    }

    @org.testng.annotations.Test(priority = 4)
    @Description("Pay With Empty Amount Field")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67083")
    public void payWithEmptyAmountField() throws Exception{
        lightbox.openLightBox();
        lightbox.payWithEmptyAmountField();
    }

    @org.testng.annotations.Test(priority = 5)
    @Description("Pay With Amount More than Zero like (1)")
    @Link("https://devops.paysky.io/DefaultCollection/Next/_workitems/edit/67082")
    public void payWithAmountMoreThanZero() throws Exception{
        lightbox.openLightBox();
        lightbox.payWithAmountMoreThanZero();
    }









}
