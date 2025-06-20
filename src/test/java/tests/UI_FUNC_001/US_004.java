package tests.UI_FUNC_001;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_004 {
    HomePage homePage= new HomePage();

    LoginPage loginPage = new LoginPage();

    @Test
    public void test01(){
        //Ziyaretçi web tarayıcı kullanarak ilgili 'Url' gider
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        //Ana sayfada “search box” kutusunun ve “search” butonunun gorunur olduğunu kontrol eder.

        Assert.assertTrue(homePage.homePageSearchBox.isDisplayed());

        //Ana sayfada arama çubuğunu tıklar
        homePage.homePageSearchBox.click();

        //İhtiyaç duyduğu hizmet, ilaç veya aşı bilgilerini doğru girer entera tiklar
        homePage.homePageSearchBox.sendKeys(ConfigReader.getProperty("010_validWord")+ Keys.ENTER);

        //Sayfayı kapatır
        Driver.quitDriver();

    }
    @Test
    public void test02(){
        //1-Ziyaretçi web tarayıcı kullanarak ilgili 'Url' gider
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        //2-Ana sayfada arama çubuğunun gorunur oldugunu kontrol eder
        Assert.assertTrue(homePage.homePageSearchBox.isDisplayed());

        //Ana sayfada arama çubuğunu tıklar
        homePage.homePageSearchBox.click();

        //3-İhtiyaç duyduğu hizmet, ilaç veya aşı bilgilerini yanlış girer ve tikler
        homePage.homePageSearchBox.sendKeys(ConfigReader.getProperty("010_invalidWord")+ Keys.ENTER);

        //4-Sayfayı kapatır
        Driver.quitDriver();
    }
    @Test
    public void test03() {
        //1- Kullanıcı "https://qa.loyalfriendcare.com/en" url sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        //2- Ana sayfa üzerindeki 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();

        //3- Gecerli E-mail ve Password girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("010_validUserEmail"));
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("010_password"));

        //5)"Sign In" butonuna tıklar
        loginPage.signInButton.click();

        //5- Başarılı bir şekilde giriş yapabildiğini doğrular
        Assert.assertTrue(homePage.headerUserNameButton.isDisplayed());

        //6- Ana sayfada bulunan arama çubuğunun görünür olduğunu doğrular
        Assert.assertTrue(homePage.homePageSearchBox.isDisplayed());

        //8-İhtiyaç duyduğu hizmet, ilaç veya aşı bilgilerini doğru girer  enterlar
        homePage.homePageSearchBox.sendKeys(ConfigReader.getProperty("010_validWordforsearchBox") + Keys.ENTER);

        //10-Sayfayı kapatır
        Driver.quitDriver();
    }
    @Test
    public void test04(){
        //1- Kullanıcı "https://qa.loyalfriendcare.com/en" url sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        //2- Ana sayfa üzerindeki 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();

        //3- Gecerli E-mail ve Password girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("010_validAdminEmail"));
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("010_password"));

        //4- 'Sign In' butonuna tıklar
        loginPage.signInButton.click();

        //5- Başarılı bir şekilde giriş yapabildiğini doğrular
        Assert.assertTrue(homePage.headerAdminNameButton.isDisplayed(),"Kullanıcı login olamadı");

        //6- Ana sayfada bulunan arama çubuğunun görünür olduğunu doğrular
        Assert.assertTrue(homePage.homePageSearchBox.isDisplayed());

        //7-Ana sayfada arama çubuğunu tıklar
        homePage.homePageSearchBox.click();

        //8-İhtiyaç duyduğu hizmet, ilaç veya aşı bilgilerini doğru girerve enterlar
        homePage.homePageSearchBox
                .sendKeys(ConfigReader.getProperty("010_validWordforsearchBox") + Keys.ENTER);

        //9-Sayfayı kapatır
        Driver.quitDriver();

    }
}
