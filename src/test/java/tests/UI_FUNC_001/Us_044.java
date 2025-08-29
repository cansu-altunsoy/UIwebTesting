package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import pages.AdminExitPage;
import pages.AdminHomePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Us_044 extends TestBaseRapor {


    @Test
    public void TC_001() {


        extentTest = extentReports.createTest("US_044_TC_001", "Adminin güvenli bir şekilde çıkış yapabilmeli");

        //1) Admin anasayfaya gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Admin anasayfaya gider");

        //2) Geçerli email ve password ile giriş yapar.

        HomePage homePage = new HomePage();
        homePage.headerSignInButton.click();

        LoginPage loginPage = new LoginPage();

        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("005_validAdminEmail"));
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("partnerpassword"));
        loginPage.signInButton.click();
        extentTest.info("Geçerli email ve password ile giriş yapar.");

        //3) Admin isminin yazılı olduğu butona tıklar

        AdminHomePage adminHomePage = new AdminHomePage();

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Geçerli email ve password ile giriş yapar.");

        //Açılan dropdown menüden logout butonunun görünürlüğünü doğrular.

        AdminExitPage adminExitPage = new AdminExitPage();

        adminExitPage.adminDropdownMenu.click();

        adminExitPage.logoutImgButton.isDisplayed();
        extentTest.info("Açılan dropdown menüden logout butonunun görünürlüğünü doğrular.");

        //6) Logout butonuna tıklar
        adminExitPage.logoutLink.click();
        extentTest.info("Logout butonuna tıklar");

        //7) Sign out butonuna tıklar.
        adminExitPage.signOut.click();
        extentTest.info("Sign out butonuna tıklar");
        extentTest.info("sayfayı kapatır.");

    }


}
