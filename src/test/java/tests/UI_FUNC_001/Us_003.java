package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.VaccinationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Us_003 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001_headerMenuGorunurlukTesti() {
        extentTest = extentReports.createTest("Home Page Header Menu Ogelerinin Gorunurluk Testi",
                "Home page header bolumunde Home, About Us, Departments, Doctors, Medicines ve Vaccinations menu ogeleri gorunur olmali");

        // loyalfriendcare ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Ziyaretci loyalfriendcare ana sayfaya gider");

        // Header bolumunde yer alan Home menu ogesinin gorunur oldugunu dogrulayin
        HomePage homePage = new HomePage();

        softAssert.assertTrue(homePage.headerHome.isDisplayed());
        extentTest.pass("Header bolumunde Home menu ogesinin gorunur oldugunu dogrular");

        // About Us menu ogesinin gorunur oldugunu dogrulayin
        softAssert.assertTrue(homePage.headerAboutUs.isDisplayed());
        extentTest.pass("Header bolumunde yer alan About Us menu ogesinin gorunur oldugunu dogrular");

        // Departments menu ogesinin gorunur oldugunu dogrulayin
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed());
        extentTest.pass("Header bolumunde yer alan Departments menu ogesinin gorunur oldugunu dogrular");

        // Doctors menu ogesinin gorunur oldugunu dogrulayin
        softAssert.assertTrue(homePage.headerDoctors.isDisplayed());
        extentTest.pass("Header bolumunde yer alan Doctors menu ogesinin gorunur oldugunu dogrular");

        // Medicines menu ogesinin gorunur oldugunu dogrulayin
        softAssert.assertTrue(homePage.headerMedicines.isDisplayed());
        extentTest.pass("Header bolumunde yer alan Medicines menu ogesinin gorunur oldugunu dogrular");

        // Vaccinations menu ogesinin gorunur oldugunu dogrulayin
        softAssert.assertTrue(homePage.headerVaccinations.isDisplayed());
        extentTest.pass("Header bolumunde yer alan Vaccinations menu ogesinin gorunur oldugunu dogrular");

        softAssert.assertAll();

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_002_homeErisilebilirlikTesti() {
        extentTest = extentReports.createTest("Home Menu Ogesinin Erisilebilirlik Testi",
                "Home Page Header Home menu ogesi ana sayfaya yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Ziyaretci loyalfriendcare ana sayfaya gider");

        // Header bolumunden Home menu ogesine tiklayin
        String expectedUrl = Driver.getDriver().getCurrentUrl();

        HomePage homePage = new HomePage();
        homePage.headerHome.click();
        extentTest.info("Header bolumunden Home menu ogesine tiklar");

        // Ana sayfanin yenilendigini dogrulayin
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(expectedUrl, actualUrl);
        extentTest.pass("Ana sayfanin yenilendigini dogrular");

        // Header bolumunden About Us menu ogesine tiklayin
        homePage.headerAboutUs.click();
        extentTest.info("Header bolumunden About Us menu ogesine tiklar");

        // Home menu ōgesine tiklayin
        homePage.headerHome.click();
        extentTest.info("Home menu ogesine tiklar");

        // Ana sayfaya yonlendirildigini dogrulayin
        actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(expectedUrl, actualUrl);
        extentTest.pass("Ana sayfaya yonlendirildigini dogrular");

        softAssert.assertAll();

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_003_aboutUsErisilebilirlikTesti() {
        extentTest = extentReports.createTest("About Us Menu Ogesinin Erisilebilirlik Testi",
                "Home Page Header About Us menu ogesi About Us sayfasina yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Ziyaretci loyalfriendcare ana sayfaya gider");

        // Header bolumunden About Us menu ogesine tiklayin
        HomePage homePage = new HomePage();
        homePage.headerAboutUs.click();
        extentTest.info("Header bolumunden About Us menu ogesine tiklar");

        // About Us sayfasina yonlendirildiginizi dogrulayin
        String expectedUrllcerik = "about";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrllcerik));
        extentTest.pass("About Us sayfasina yonlendirildigini dogrular");

        softAssert.assertAll();

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_004_departmentsErisilebilirlikTesti() {
        extentTest = extentReports.createTest("Departments Menu Ogesinin Erisilebilirlik Testi",
                "Home Page Header Departments menu ogesi Departments sayfasina yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Ziyaretci loyalfriendcare ana sayfaya gider");

        // Header bolumunden Departments menu ogesine tiklayin
        HomePage homePage = new HomePage();
        homePage.headerDepartments.click();
        extentTest.info("Header bolumunden Departments menu ogesine tiklar");

        // Departments sayfasina yonlendirildiginizi dogrulayin
        String expectedUrlicerik = "Departments";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlicerik));
        extentTest.pass("Departments sayfasina yonlendirildigini dogrular");

        softAssert.assertAll();

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_005_doctorsErisilebilirlikTesti() {
        extentTest = extentReports.createTest("Doctors Menu Ogesinin Erisilebilirlik Testi",
                "Home Page Header Doctors menu ogesi Doctors sayfasina yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Ziyaretci loyalfriendcare ana sayfaya gider");

        // Header bolumunden Doctors menu ogesine tiklayin
        HomePage homePage = new HomePage();
        homePage.headerDoctors.click();
        extentTest.info("Header bolumunden Doctors menu ogesine tiklar");

        // Doctors sayfasina yonlendirildiginizi dogrulayin
        String expectedUrlicerik = "Doctors";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlicerik));
        extentTest.pass("Doctors sayfasina yonlendirildigini dogrular");

        softAssert.assertAll();

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_006_medicinesErisilebilirlikTesti() {
        extentTest = extentReports.createTest("Medicines Menu Ogesinin Erisilebilirlik Testi",
                "Home Page Header Medicines menu ogesi Medicines sayfasina yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Ziyaretci loyalfriendcare ana sayfaya gider");

        // Header bolumunden Medicines menu ogesine tiklayin
        HomePage homePage = new HomePage();
        homePage.headerMedicines.click();
        extentTest.info("Header bolumunden Medicines menu ogesine tiklar");

        // Medicines sayfasina yonlendirildiginizi dogrulayin
        String expectedUrllcerik = "Medicines";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrllcerik));
        extentTest.pass("Medicines sayfasina yonlendirildigini dogrular");

        softAssert.assertAll();

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_007_vaccinationsErisilebilirlikTesti() {
        extentTest = extentReports.createTest("Vaccinations Menu Ogesinin Erisilebilirlik Testi",
                "Home Page Header Vaccinations menu ogesi Vaccinations sayfasina yonlendirme yapmali");

        // loyalfriendcare ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Ziyaretci loyalfriendcare ana sayfaya gider");

        // Header bolumunden Vaccinations menu ogesine tiklayin
        HomePage homePage = new HomePage();
        homePage.headerVaccinations.click();
        extentTest.info("Header bolumunden Medicines menu ogesine tiklar");

        // Vaccinations sayfasina yonlendirildiginizi dogrulayin
        VaccinationsPage vaccinationsPage = new VaccinationsPage();

        softAssert.assertTrue(vaccinationsPage.bodyVaccinationName.isDisplayed());
        extentTest.pass("Vaccinations sayfasina yonlendirildigini dogrular");

        softAssert.assertAll();

        extentTest.info("Sayfayi kapatir");

    }

}