package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminExitPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_19 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    AdminExitPage adminExitPage = new AdminExitPage();

    @Test
    public void test01(){

        //US19_TC01
        extentTest = extentReports.createTest("Kullanıcı hesabından çıkış yapma testi", "Kullanıcı olarak hesaptan çıkış yapabilmeli");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validUserEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        adminExitPage.signOut.click();  //hesaptan çıkış yap.
        extentTest.info("Kullanıcı signOut butonuna basar.");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(homePage.headerSignInButton.isDisplayed()); // SoftAssert ile Sign In butonunun görünürlüğünü sorgula
        extentTest.pass("Çıkış yapabildiğini kontrol eder.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }
    @Test
    public void test02(){

        //US19_TC02
        extentTest = extentReports.createTest("Admin hesabından çıkış yapma testi", "Admin olarak hesaptan çıkış yapabilmeli");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Admin loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        adminExitPage.signOut.click();  //hesaptan çıkış yap.
        extentTest.info("Admin signOut butonuna basar.");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(homePage.headerSignInButton.isDisplayed()); // SoftAssert ile Sign In butonunun görünürlüğünü sorgula
        extentTest.pass("Çıkış yapabildiğini kontrol eder.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

}
