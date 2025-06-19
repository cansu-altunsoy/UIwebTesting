package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Us_01 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01(){
        //US01_TC01
        extentTest = extentReports.createTest("Sayfaya erişme testi.", "Sayfaya erişilebildiği test edilir.");

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider.");

        softAssert.assertTrue(homePage.homePageSearchBox.isDisplayed(),"Search box görünür değil.");
        extentTest.pass("Ana sayfada olduğunu search box ile test eder.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

}
