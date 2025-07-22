package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminHomePage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_021 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    AdminHomePage adminHomePage = new AdminHomePage();

    HomePage homePage = new HomePage();


    @Test
    public void TC021_001() {

        extentTest = extentReports.createTest("Yönetici'nin HomPage sayfasına erişebilirlik testi.",
                "Yöneticinin Sign in olarak HomePage sayfasina erisibilmeli ve  Header kısmında \"yöneticiAdi\" butonunu görüntüyebilmeli.");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        // 6-Yöneticinin Sign in olarak HomePage sayfasina erisibilmesi,
        // Header kısmında "yöneticiAdi" butonu görünürlüğü kontrol edilerek doğrulanır.
        softAssert.assertTrue(homePage.headerAdminNameButton.isDisplayed(), "Yönetici sign in olamadı ve 'yöneticiAdi'nı sorunsuz ve dogru bir sekilde görüntüleyemedi.  ");
        extentTest.pass("Yöneticinin Sign in olarak HomePage sayfasina erisibilmesi,Header kısmında \"yöneticiAdi\" butonu görünürlüğü kontrol edilerek doğrulanır. ");

        //7-Homepage Header bölümündeki Sign out butonuna tıklar.
        ReusableMethods.singOut();
        //extentTest.info()
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //8-Window kapatılır.

        extentTest.info("Window kapatılır.");

    }

    @Test
    public void TC021_002() {
        extentTest = extentReports.createTest("Yönetici'nin HomPage sayfasına Header bolumunde ‘Logo’, ‘yönetici.Adı’ ve ‘Sign Out’ görüntülünebilirlik  testi.\n",
                "Yönetici 'Logo', 'yönetici.Adi' butonunu ve 'Sign Out' butonunun  sorunsuz ve başarılı bir şekilde görüntüleyebilmeli. \n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6- HomePage Header kısmında "Logo"'nun  görünürlüğü kontrol edilerek doğrulanır.
        softAssert.assertTrue(homePage.headerHomePageLogo.isDisplayed(), "Yönetici sign in olamadı ve 'Logo'yu sorunsuz ve dogru bir sekilde görüntülenemedi.");
        extentTest.pass("HomePage Header kısmında \"Logo\"'nun  görünürlüğü kontrol edilerek doğrulanır.");

        //7-HomePage Header kısmında "yöneticiAdi" butonunun görünürlüğü kontrol edilerek doğrulanır.
        softAssert.assertTrue(homePage.headerAdminNameButton.isDisplayed(), "Yönetici sign in olamadı ve 'yöneticiAdi'nı sorunsuz ve dogru bir sekilde görüntülenemedi.  ");
        extentTest.pass("HomePage Header kısmında \"yöneticiAdi\" butonunun görünürlüğü kontrol edilerek doğrulanır.");

        //8-HomePage Header kısmında "Sign Out" butonunu görünürlüğü kontrol edilerek  doğrulanır.
        softAssert.assertTrue(homePage.headerSignOutButton.isDisplayed(), "Yönetici sign in olamadı ve 'Sign out' butonunun sorunsuz ve dogru bir sekilde görüntülenemedi.  ");
        extentTest.pass("HomePage Header kısmında \"Sign Out\" butonunu görünürlüğü kontrol edilerek  doğrulanır.");
        //9-Homepage Header bölümündeki  Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //10-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }

    @Test
    public void TC021_003() {
        extentTest = extentReports.createTest("Yönetici olarak Logo’nun fonksiyonellik testi.\n",
                "Yönetici Logo tıklayabilmeli ve  HomePage Url'ine u sorunsuz ve başarılı bir şekilde yönlendirilebilmeli.\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6- HomePage sayfasinın Header kısmında bulunan "Logo"'ya tıklar.
        homePage.headerHomePageLogo.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \"Logo\"'ya tıklar.");

        //7-Yöneticinin "https://qa.loyalfriendcare.com/en"url'deki  HomePage sayfasına  doğru şekilde tekrar yönlendirildiği doğrulanır.
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.loyalfriendcare.com/en";
        softAssert.assertEquals(actualUrl, expectedUrl, "Url'ler uyuşmadı.");
        extentTest.pass("Yöneticinin \"https://qa.loyalfriendcare.com/en\"url'deki  HomePage sayfasına  doğru şekilde tekrar yönlendirildiği doğrulanır.");

        //8-Homepage Header bölümündeki  Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //9-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }

    @Test
    public void TC021_004() {
        extentTest = extentReports.createTest("Yönetici olarak \" yönetici.adı\"  butonunun fonksiyonellik  testi.\n",
                "Yönetici buttonuna tıklayabilmeli ve Yönetici sayfasına sorunsuz ve başarılı bir şekilde yönlendirilerek  sidebar' görüntüleyebilmeli.\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" yönetici.adı\"' butonuna tıklar.");

        //7-Yöneticinin kontrol sayfasına doğru şekilde yönlendirildiği  sidebar'ı görünürlüğü kontrol edilerek doğrulanır.
        softAssert.assertTrue(adminHomePage.AdminsidebarDashboardMenu.isDisplayed(), "Yönetici kontrol sayfasındaki sidebar menüyü görüntüleyemedi.");
        extentTest.pass("Yöneticinin kontrol sayfasına doğru şekilde yönlendirildiği  sidebar'ı görünürlüğü kontrol edilerek doğrulanır.");

        //8- Header kısımda bulunan yönetici profili butonuna tıklar.
        //9- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //10- Homepage Header bölümündeki  Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //11-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }

    @Test
    public void TC021_005() {
        extentTest = extentReports.createTest("\"Yönetici 'nin \"Sign out \" butonunun fonksiyonellik testi.\n",
                "Yönetici sorunsuz bir şekilde SignOut olarak  Sign butonu görüntüleyebilmeli.\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6- HomePage sayfasinın Header kısmında bulunan " Sign Out"' butonuna  tıklar.
        homePage.headerSignOutButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7- “Sign In” butonunun görünürlüğü kontrol edilerek oturumun sorunsuz bir şekilde kapandığı doğrulanır.
        softAssert.assertTrue(homePage.headerSignInButton.isDisplayed(), "Sign in butonu  sorunsuz ve dogru bir sekilde görüntülenemedi.");
        extentTest.pass("“Sign In” butonunun görünürlüğü kontrol edilerek oturumun sorunsuz bir şekilde kapandığı doğrulanır.");

        softAssert.assertAll();

        //8-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }

}
