package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_008 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC008_01() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Login sayfasındaki kullanıcı arayüzü (UI) öğelerinin varlığını doğrulama testi","Login sayfasındaki öğelerin görüntülenebilmeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici Loyal Friend Care sayfasına girer");

        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        homePage.headerSignInButton.click();
        extentTest.info("Sign In butonuna basarak login sayfasına gider");

        //3)Sayfada ilgili görselin görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.loginPageImage.isDisplayed(),"Login sayfasında ilgili görsel görüntülenemedi");
        extentTest.pass("Sayfada ilgili görselin görünür olduğunu doğrular");

        //4)Sayfada "LoyalFriendCare" başlığının görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.loyalFriendCareText.isDisplayed(),"Login sayfasında LoyalFriendCare başlığı görüntülenemedi");
        extentTest.pass("Sayfada LoyalFriendCare başlığının görünür olduğunu doğrular");

        //5)Sayfada login formunun görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.loginForm.isDisplayed(),"Login sayfasında login formu görüntülenemedi");
        extentTest.pass("Sayfada login formunun görünür olduğunu doğrular");

        //6)Sayfada logonun görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.loginPageLogo.isDisplayed(),"Login sayfasında logo görüntülenemedi");
        extentTest.pass("Sayfada logonun görünür olduğunu doğrular");

        //7)Login formunda email textbox'ının görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.loginEmailBox.isDisplayed(),"Login sayfasında emailBox görüntülenemedi");
        extentTest.pass("Sayfada email textbox'ın görünür olduğunu doğrular");

        //8)Login formunda password textbox'ının görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.loginPasswordBox.isDisplayed(),"Login sayfasında passwordBox görüntülenemedi");
        extentTest.pass("Sayfada password textbox'ın görünür olduğunu doğrular");

        //9)Login formunda "Remember Me" checkbox'ının görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.rememberMeCheckbox.isDisplayed(),"Login sayfasında Rememeber Me checkbox görüntülenemedi");
        extentTest.pass("Sayfada Remember Me checkbox'ın görünür olduğunu doğrular");

        //10)Login formunda "Forgot Password" linkinin görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.forgotPasswordLink.isDisplayed(),"Login sayfasında Forgot Password linki görüntülenemedi");
        extentTest.pass("Sayfada Forgot Password linkinin görünür olduğunu doğrular");

        //11)Login formunda "Sign In" butonunun görünür olduğunu doğrular
        softAssert.assertTrue(loginPage.signInButton.isDisplayed(),"Login sayfasında Sign In butonu görüntülenemedi");
        extentTest.pass("Login formunda Sign In butonunun görünür olduğunu doğrular");

        softAssert.assertAll();

        //12)Sayfayı kapatır
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void TC008_02() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Geçerli e-posta ve şifre ile pozitif login testi","Kullanıcı geçerli e-posta ve şifre ile giriş yapabilmeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanıcı ilgili Url ile siteye giriş yapar");

        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        homePage.headerSignInButton.click();
        extentTest.info("Sign In butonuna basarak Login sayfasına gider");

        //3)Email textbox'ına geçerli email girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Email textbox'ına geçerli email girer");

        //4)Password textbox'ına geçerli password girer
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("partnerpassword"));
        extentTest.info("Password textbox'ına geçerli password girer");

        //5)"Sign In" butonuna tıklar
        loginPage.signInButton.click();
        extentTest.info("Sign In butonuna tıklar");

        //6)Kullanıcı home page sayfasının açıldığını doğrular
        String expectedHomePageUrl = "https://qa.loyalfriendcare.com/en";
        String actualUrl = Driver.driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedHomePageUrl,"Url beklenen ile ayni degil");
        extentTest.pass("Home page sayfasının açıldığını doğrular");

        //7)Kullanıcı başarılı olarak login olabildiğini doğrular
        softAssert.assertTrue(homePage.headerUserNameButton.isDisplayed(),"Kullanıcı geçerli verilerle login olamadı");
        extentTest.pass("Basarili olarak login olabildiğini dogrular");

        //8)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        homePage.headerSignOutButton.click();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //9)Sayfayı kapatır
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void TC008_03() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Geçersiz e-posta ve geçersiz şifre ile negatif login testi","Kullanıcı geçersiz e-posta ve geçersiz şifre ile giriş yapamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanıcı ilgili Url ile siteye giriş yapar");

        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        homePage.headerSignInButton.click();
        extentTest.info("Sign In butonuna basarak Login sayfasına gider");

        //3)Email textbox'ına geçersiz email girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("004_invalidEmail"));
        ReusableMethods.bekle(2);
        extentTest.info("Email textbox'ına geçersiz email girer");

        //4)Password textbox'ına geçersiz password girer
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("004_invalidPassword"));
        extentTest.info("Password textbox'ına geçersiz password girer");

        //5)"Sign In" butonuna tıklar
        loginPage.signInButton.click();
        extentTest.info("Sign In butonuna tıklar");

        //6)Kullanıcı basarili olarak giris yapilamadigini dogrular
        ReusableMethods.bekle(2);
        softAssert.assertTrue(loginPage.missMatchedDataMessage.isDisplayed(),"Geçersiz veriler girildiğinde uyarı mesajı görüntülenemedi");
        extentTest.pass("Basarili olarak giris yapilamadigini dogrular");

        softAssert.assertAll();

        //7)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC008_04() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Geçerli e-posta ve geçersiz şifre ile negatif login testi","Kullanıcı geçerli e-posta ve geçersiz şifre ile giriş yapamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanıcı ilgili Url ile siteye giriş yapar");

        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        homePage.headerSignInButton.click();
        extentTest.info("Sign In butonuna basarak Login sayfasına gider");

        //3)Email textbox'ına geçerli email girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Email textbox'ına geçerli email girer");

        //4)Password textbox'ına geçersiz password girer
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("004_invalidPassword"));
        extentTest.info("Password textbox'ına geçersiz password girer");

        //5)"Sign In" butonuna tıklar
        loginPage.signInButton.click();
        extentTest.info("Sign In butonuna tıklar");

        //6)Kullanıcı basarili olarak giris yapilamadigini dogrular
        softAssert.assertTrue(loginPage.missMatchedDataMessage.isDisplayed(),"Geçersiz password girildiğinde uyarı mesajı görüntülenemedi");
        extentTest.pass("Basarili olarak giris yapilamadigini dogrular");

        softAssert.assertAll();

        //7)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC008_05() {

        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Geçersiz e-posta ve geçerli şifre ile negatif login testi","Kullanıcı geçersiz e-posta ve geçerli şifre ile giriş yapamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Email textbox'ına geçersiz email girer
        //4)Password textbox'ına geçerli password girer
        //5)"Sign In" butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("004_invalidEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //6)Kullanıcı basarili olarak giris yapilamadigini dogrular
        softAssert.assertTrue(loginPage.missMatchedDataMessage.isDisplayed(),"Geçersiz email girildiğinde uyarı mesajı görüntülenemedi");
        extentTest.pass("Basarili olarak giris yapilamadigini dogrular");

        softAssert.assertAll();

        //7)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC008_06() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("E-posta ve şifre textbox'ları boş bırakılarak negatif login testi","Kullanıcı e-posta ve şifre bilgilerini girmeden giriş yapamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanıcı ilgili Url ile siteye giriş yapar");

        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        homePage.headerSignInButton.click();
        extentTest.info("Sign In butonuna basarak Login sayfasına gider");

        //3)"Sign In" butonuna tıklar
        loginPage.signInButton.click();
        extentTest.info("Sign In butonuna tıklar");

        //4)Kullanıcı basarili olarak giris yapilamadigini dogrular
        String unExpectedUrl = "https://qa.loyalfriendcare.com/en";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(actualUrl,unExpectedUrl,"UnExpected URL");
        extentTest.pass("Basarili olarak giris yapilamadigini dogrular");

        softAssert.assertAll();

        //5)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC008_7() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Remember Me fonksiyon testi","Remember Me checkbox'ı işlevsel olmalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanıcı ilgili Url ile siteye giriş yapar");

        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        homePage.headerSignInButton.click();
        extentTest.info("Sign In butonuna basarak Login sayfasına gider");

        //3)Email textbox'ına geçerli email girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Email textbox'ına geçerli email girer");

        //4)Password textbox'ına geçerli password girer
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("partnerpassword"));
        extentTest.info("Password textbox'ına geçerli password girer");

        //5)"Remember Me" checkbox'ına tıklar
        loginPage.rememberMeCheckbox.click();
        extentTest.info("Remember Me checkbox'ına tıklar");

        //6)"Sign In" butonuna tıklar
        loginPage.signInButton.click();
        extentTest.info("Sign In butonuna tıklar");

        //7)Kullanıcı home page header bölümünden Sign out butonuna tıklar
        homePage.headerSignOutButton.click();
        extentTest.info("Sign out butonuna tıklar");

        //8)Kullanıcı home page header bölümünden Sign In butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Sign In butonuna tıklar");

        //9)Email textbox'ına geçerli email girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Email textbox'ına geçerli email girer");

        //10)Remember Me fonksiyonunun çalıştığını doğrular
        softAssert.assertFalse(loginPage.loginPasswordBox.getText().isEmpty(),"Remember Me fonksiyonu çalışmadı");
        extentTest.fail("Remember Me fonksiyonunun çalıştığını doğrular");

        softAssert.assertAll();

        //11)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }
}
