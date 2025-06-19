package tests.UI_FUNC_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Us_002 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();

    @Test
    public void testcase01() {
        extentTest = extentReports.createTest("Logo Islevsellik Testi", "Kullanici logoya tiklayinca ana sayfaya yonlendirilmeli");
        //1- Kullanıcı "https://qa.loyalfriendcare.com/en" url sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider");

        //2- Sayfa logosuna tıklar
        homePage.headerHomePageLogo.click();
        extentTest.info("Header bolumundeki logoya tiklar");

        //3- Tıkladıktan sonra ana sayfaya yönlendirildiğini doğrular
        String expectedUrl = ConfigReader.getProperty("lfcHomePageUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Ana sayfaya yonlendirildigini test eder");
        extentTest.info("Sayfayi kapatir");
    }

    @Test
    public void testcase02() {

        extentTest = extentReports.createTest("'Sign In' Butonu Islevsellik Testi", "Kullanici 'Sign In' butonuna tiklayinca login sayfasina yonlendirilmeli");

        //1- Kullanıcı "https://qa.loyalfriendcare.com/en" url sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider");

        //2- Kullanıcı ana sayfa üzerindeki 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Header bolumundeki 'Sign In' butonuna tiklar");

        //3- Açılan sayfanın kullanıcı giriş sayfası olduğunu doğrular
        Assert.assertTrue(loginPage.signInButton.isDisplayed());
        extentTest.pass("Login sayfasina yonlendirildigini test eder");
        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void testcase03() {
        extentTest = extentReports.createTest("'Sign Up' Butonu Islevsellik Testi", "Kullanici 'Sign Up' butonuna tiklayinca login sayfasina yonlendirilmeli");
        //1- Kullanıcı "https://qa.loyalfriendcare.com/en" url sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider");

        //2- Kullanıcı ana sayfa üzerindeki 'Sign Up' butonuna tıklar
        homePage.headerSignUpButton.click();
        extentTest.info("Header bolumundeki 'Sign Up' butonuna tiklar");


        //3- Açılan sayfanın kayıt olma sayfası olduğunu doğrular
        Assert.assertTrue(signUpPage.signUpButton.isDisplayed());
        extentTest.pass("Kayit sayfasina yonlendirildigini test eder");
        extentTest.info("Sayfayi kapatir");

    }
}