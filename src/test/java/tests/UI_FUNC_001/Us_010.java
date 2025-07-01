package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_010 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001_headerButonlariGorunurlukTesti() {
        extentTest = extentReports.createTest("Header Bolumundeki Butonlarin Gorunurluk Testi",
                "Home page header bolumunde 'Logo', '*kullaniciAdi' ve 'Sign Out' butonlari gorunur olmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Header bolumunde 'Logo' butonunun gorundugunu dogrulayin
        HomePage homePage = new HomePage();

        softAssert.assertTrue(homePage.headerHomePageLogo.isDisplayed());
        extentTest.pass("Header bolumunde 'Logo' butonunun gorundugunu dogrular");

        // Header bolumunde '*kullaniciAdi' butonunun gorundugunu dogrulayin
        softAssert.assertTrue(homePage.headerUserNameButton.isDisplayed());
        extentTest.pass("Header bolumunde '*kullaniciAdi' butonunun gorundugunu dogrular");

        // Header bolumunde 'Sign Out' butonunun gorundugunu dogrulayin
        softAssert.assertTrue(homePage.headerSignOutButton.isDisplayed());
        extentTest.pass("Header bolumunde 'Sign Out' butonunun gorundugunu dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_002_kullaniciIsmiGorunurlukTesti() {
        extentTest = extentReports.createTest(" '*kullaniciAdi' Butonu Uzerinde Kullanici Isminin Gorunurluk Testi",
                "Home page header bolumundeki '*kullaniciAdi' butonu uzerinde kullanici ismi gorunur olmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Header bolumunde '*kullaniciAdi' butonu uzerinde kullanici isminin bulundugunu dogrulayin
        HomePage homePage = new HomePage();

        String userEmail = ConfigReader.getProperty("009_validUserEmail");
        int index = userEmail.indexOf("@");

        String expectedUserName = userEmail.substring(0, index);
        String actualUserName = homePage.headerUserNameButton.getText();

        softAssert.assertEquals(actualUserName, expectedUserName);
        extentTest.pass("Header bolumunde '*kullaniciAdi' butonu uzerinde kullanici isminin bulundugunu dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");
    }

    @Test
    public void TC_003_LogoButonuErisilebilirlikTesti() {
        extentTest = extentReports.createTest("'Logo' Butonu Erisilebilirlik Testi",
                "Home Page sayfasi Header bolumunde yer alan 'Logo' butonu ana sayfaya yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Header bolumunden 'Logo' butonuna tiklayin
        String expectedUrl = Driver.getDriver().getCurrentUrl();

        HomePage homePage = new HomePage();
        homePage.headerHomePageLogo.click();
        extentTest.info("Header bolumunden 'Logo' butonuna tiklar");

        // Ana sayfanin yenilendigini dogrulayin
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Ana sayfanin yenilendigini dogrular");

        // About Us menu ogesine tiklayin
        homePage.headerAboutUs.click();
        extentTest.info("About Us menu ogesine tiklar");

        // Header bolumunden 'Logo' butonuna tiklayin
        homePage.headerHomePageLogo.click();
        extentTest.info("Header bolumunden 'Logo' butonuna tiklar");

        // Ana sayfaya yonlendirildigini dogrulayin
        actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Ana sayfaya yonlendirildigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_004_kullaniciAdiButonuErisilebilirlikTesti() {
        extentTest = extentReports.createTest("*kullaniciAdi' Butonu Erisilebilirlik Testi",
                "Home Page sayfasi Header bolumunde yer alan '*kullaniciAdi' butonu kullanici paneline yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Header bolumunden '*kullaniciAdi' butonuna tiklayin
        HomePage homePage = new HomePage();
        homePage.headerUserNameButton.click();
        extentTest.info("Header bolumunden '*kullaniciAdi' butonuna tiklar");

        // Kullanici paneline yonlendirildigini dogrulayin
        String unExpectedUrl = ConfigReader.getProperty("lfcHomePageUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertNotEquals(actualUrl, unExpectedUrl);
        extentTest.fail("Kullanici paneline yonlendirildigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_005_signOutButonuErisilebilirlikTesti() {
        extentTest = extentReports.createTest("'Sign Out' Butonu Erisilebilirlik Testi",
                "Home Page sayfasi Header bolumunde yer alan 'Sign Out' butonu kullanici oturumunu sonlandirmali ve ana sayfaya yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Header bolumunden 'Sign Out' butonuna tiklayin
        HomePage homePage = new HomePage();
        homePage.headerSignOutButton.click();
        extentTest.info("Header bolumunden 'Sign Out' butonuna tiklar");

        // Oturumdan cikis yapildigini dogrulayin
        String userEmail = ConfigReader.getProperty("009_validUserEmail");
        int index = userEmail.indexOf("@");

        String expectedUserNameButtonText = userEmail.substring(0, index);
        String actualUserNameButtonText = homePage.headerSignInButton.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(actualUserNameButtonText, expectedUserNameButtonText);
        extentTest.pass("Oturumdan cikis yapildigini dogrular");

        // Ana sayfaya yonlendirildigini dogrulayin
        String expectedUrl = ConfigReader.getProperty("lfcHomePageUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Ana sayfaya yonlendirildigini dogrular");
        softAssert.assertAll();

        // Sign Out butonuna tiklayin ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

}
