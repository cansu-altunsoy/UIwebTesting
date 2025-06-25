package tests.UI_FUNC_001;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_006 {


  
    HomePage homePage = new HomePage();

    @Test
    public void TC05_HomePageFooterAccessAndRead(){
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.footerTermsAndConditions).perform();

        Assert.assertTrue(homePage.footerLogo.isDisplayed());

        homePage.footerWellness.click();
        Assert.assertTrue(homePage.footerWellnessAppointments.isDisplayed());

        Driver.getDriver().navigate().back();

        actions.moveToElement(homePage.footerTermsAndConditions).perform();

        Assert.assertTrue(homePage.footerFacebook.isEnabled());

        homePage.footerFacebook.click();

        SoftAssert softAssert = new SoftAssert();

        String expectedUrlFacebook = ConfigReader.getProperty("008_facebookUrl");
        String actualUrlFacebook = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrlFacebook,expectedUrlFacebook);
        Driver.getDriver().navigate().back();


        Assert.assertTrue(homePage.footerInstagram.isEnabled());

        homePage.footerInstagram.click();

        softAssert = new SoftAssert();

        String expectedUrlInstagram = ConfigReader.getProperty("008_instagramUrl");
        String actualUrlInstagram = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrlInstagram ,expectedUrlInstagram);

        Driver.getDriver().navigate().back();


        Assert.assertTrue(homePage.footerTwitter.isEnabled());

        homePage.footerTwitter.click();

        softAssert = new SoftAssert();

        String expectedUrlTwitter = ConfigReader.getProperty("008_twitterUrl");
        String actualUrlTwitter = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrlTwitter ,expectedUrlTwitter);

        Driver.getDriver().navigate().back();


        Assert.assertTrue(homePage.footerYoutube.isEnabled());

        homePage.footerYoutube.click();

        softAssert = new SoftAssert();

        String expectedUrlYouTube = ConfigReader.getProperty("008_YouTubeUrl");
        String actualUrlYouTube = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrlYouTube ,expectedUrlYouTube);

        Driver.getDriver().navigate().back();


        Assert.assertTrue(homePage.footerPinterest.isEnabled());

        homePage.footerPinterest.click();

        softAssert = new SoftAssert();

        String expectedUrlPinterest = ConfigReader.getProperty("008_PinterestUrl");
        String actualUrlPinterest = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrlPinterest,expectedUrlPinterest);

        Driver.getDriver().navigate().back();


        Assert.assertTrue(homePage.footerContactUs.isDisplayed());

        Assert.assertTrue(homePage.footerTermsAndConditions.isEnabled());

        homePage.footerTermsAndConditions.click();

        String expectedUrlTerms = ConfigReader.getProperty("008_termsOfUseUrl");
        String actualUrlTerms = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrlTerms,expectedUrlTerms);
        Driver.getDriver().navigate().back();

        Assert.assertTrue(homePage.footerFaq.isEnabled());

        homePage.footerFaq.click();

        String expectedUrlFaq = ConfigReader.getProperty("008_FaqUrl");
        String actualUrlFaq = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrlFaq,expectedUrlFaq);


        softAssert.assertAll();
        Driver.quitDriver();


    }


}
