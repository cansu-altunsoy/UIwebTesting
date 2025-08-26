package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDoctorsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_031 extends TestBaseRapor {

    AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01(){

        //US31_TC01
        extentTest = extentReports.createTest("Admin sayfasındaki açılır menüdeki 'Doctors' başlığı ve alt başlıklarının görünürlüğünü sorgulama testi", "Başlık ve alt başlıklarının görünürlüğünü sorgular");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click();
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();  //mouse ile dashboard'ın üzerine git.
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Doctors başlığına tıklar");

        ReusableMethods.bekle(1);

        softAssert.assertTrue(adminDoctorsPage.subheadingDoctorsButton.isDisplayed()); // 'Doctors' alt başlığının görünürlülüğünü sorgula
        extentTest.pass("'Doctors' alt başlığının görünürlüğünü test eder");

        softAssert.assertTrue(adminDoctorsPage.createDoctorsLink.isDisplayed()); // 'Create Doctors' alt başlığının görünürlülüğünü sorgula
        extentTest.pass("'Create Doctors' alt başlığının görünürlüğünü test eder");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test02(){

        //US31_TC02
        extentTest = extentReports.createTest("'Doctors' sayfasındaki tablo ve tablodaki bilgilerin görünürlüğünü testi", "Doktor tablosu ve bilgilerinin görünürlüğünü sorgular.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click();
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Doctors başlığına tıklar");

        adminDoctorsPage.subheadingDoctorsButton.click();
        extentTest.info("Doctors alt başlığına tıklar");

        softAssert.assertTrue(adminDoctorsPage.tableDoctors.isDisplayed());
        extentTest.pass("Tablonun görünürlüğünü test eder");

        softAssert.assertTrue(!adminDoctorsPage.doctorsNameList.isEmpty());
        extentTest.pass("İsimler listesinin boş olmadığı doğrulanır. ");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test03(){

        //US31_TC03
        extentTest = extentReports.createTest("'Doctors' sayfasında kayıtlı kullanıcı bilgisi ile kullanıcı filtreleme testi", "Admin, Doctors sayfasındaki arama kutusuna kayıtlı bilgileri girerek filtrelemeyi test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click();
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Doctors başlığına tıklar");

        adminDoctorsPage.subheadingDoctorsButton.click();
        extentTest.info("Doctors alt başlığına tıklar");

        adminDoctorsPage.searchDoctorsBox.sendKeys(ConfigReader.getProperty("011_registerDoctor"));
        extentTest.info("SearchBox'a kayıtlı doktor bilgisi girer.");

        ReusableMethods.bekle(1);

        softAssert.assertTrue(adminDoctorsPage.searchedRegisterDoctor.getText().contains(ConfigReader.getProperty("011_registerDoctor")));
        extentTest.pass("Filtrelenen değer, searchBox'a girilen değeri kapsadığını test eder.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }



    @Test
    public void test04(){

        //US31_TC04
        extentTest = extentReports.createTest("'Doctors' sayfasında kayıtlı olmayan kullanıcı bilgisi ile kullanıcı filtreleme testi", "Admin, Doctors sayfasındaki arama kutusuna kayıtlı olmayan bilgileri girerek filtrelemeyi test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click();
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminDoctorsPage.doctorsLink.click(); // Doctors başlığına tıkla.
        extentTest.info("Doctors başlığına tıklar");

        adminDoctorsPage.subheadingDoctorsButton.click(); // Doctors alt başlığına tıkla.
        extentTest.info("Doctors alt başlığına tıklar");

        adminDoctorsPage.searchDoctorsBox.sendKeys(ConfigReader.getProperty("011_unregisteredDoctor"));
        extentTest.info("SearchBox'a kayıtlı olmayan doktor bilgisi girer.");
        ReusableMethods.bekle(1);

        softAssert.assertTrue(adminDoctorsPage.noMatchingRecordsFoundMessage.isDisplayed());
        extentTest.pass("Tabloda doktor bulunamadığını test eder.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test05(){

        //US31_TC05
        extentTest = extentReports.createTest("'Doctors' sayfasındaki 'Edit' tuşlarının görünürlüğü testi", "Admin, Doctors sayfasındaki doktor listesinde düzenleme butonlarının varlığını sorgular.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click();
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminDoctorsPage.doctorsLink.click(); // Doctors başlığına tıkla.
        extentTest.info("Doctors başlığına tıklar");

        adminDoctorsPage.subheadingDoctorsButton.click(); // Doctors alt başlığına tıkla.
        extentTest.info("Doctors alt başlığına tıklar");

        softAssert.assertTrue(adminDoctorsPage.firstDoctorEditButton.isSelected(),"Edit butonuna tıklanamadı.");
        extentTest.fail("Listedeki ilk doktorun Edit butonunun tıklanabilir olduğunu doğrular.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }


    @Test
    public void test06(){

        //US31_TC06
        extentTest = extentReports.createTest("'Doctors' sayfasındaki 'Delete' tuşlarının görünürlüğü testi", "Admin, Doctors sayfasındaki doktor listesinde silme butonlarının varlığını sorgular.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click();
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Doctors başlığına tıklar");

        adminDoctorsPage.subheadingDoctorsButton.click(); // Doctors alt başlığına tıkla.
        extentTest.info("Doctors alt başlığına tıklar");

        softAssert.assertTrue(adminDoctorsPage.firstDoctorDeleteButton.isSelected(),"Delete butonuna tıklanılamadı.");
        extentTest.fail("Listedeki ilk doktorun Delete butonunun tıklanabilir olduğunu doğrular.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }
}
