package tests.UI_FUNC_001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminUsersPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.io.FileNotFoundException;


public class Us_25 extends TestBaseRapor {

    AdminUsersPage adminUsersPage = new AdminUsersPage();
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01(){

        //US25_TC01
        extentTest = extentReports.createTest("Admin sayfasındaki açılır menüdeki 'Users' başlığı ve alt başlıklarının görünürlüğünü sorgulama testi", "Başlık ve alt başlıklarının görünürlüğünü sorgular");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click(); //kullanıcı adı butonuna tıkla.
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();  //mouse ile dashboard'ın üzerine git.
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminUsersPage.dashboardUsersButtonu.click(); //User başlığına tıkla
        extentTest.info("User başlığına tıklar");

        softAssert.assertTrue(adminUsersPage.dashboardSubUsersButton.isDisplayed(),"Users alt başlığı görünür değil."); // 'Users' alt başlığının görünürlülüğünü sorgula
        extentTest.pass("'Users' alt başlığının görünürlüğünü test eder");

        softAssert.assertTrue(adminUsersPage.dashboardCreateUsersButton.isDisplayed()); // 'Create User' alt başlığının görünürlülüğünü sorgula
        extentTest.pass("'Create Users' alt başlığının görünürlüğünü test eder");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test02(){

        //US25_TC02
        extentTest = extentReports.createTest("'Users' sayfasındaki tablo ve tablodaki bilgilerin görünürlüğünü testi", "Kullanıcı tablosu ve bilgilerinin görünürlüğünü sorgular.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click(); //kullanıcı adı butonuna tıkla.
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();  //mouse ile dashboard'ın üzerine git.
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminUsersPage.dashboardUsersButtonu.click(); //User başlığına tıkla.
        extentTest.info("Users başlığına tıklar");

        adminUsersPage.dashboardSubUsersButton.click(); // Users alt başlığına tıkla.
        extentTest.info("Users alt başlığına tıklar");

        softAssert.assertTrue(adminUsersPage.tableUsers.isDisplayed()); // tabloyunun görünür olduğunu sorgula.
        extentTest.pass("Tablonun görünürlüğünü test eder");

        softAssert.assertEquals(30,adminUsersPage.usersInfoList.size(),"Tablodaki bilgi sayısı doğru değil."); // tablodaki bilgi sayısını 30 olduğunu doğrula.
        extentTest.pass("'Tablodaki bilgi sayısının 30 olduğunu test eder");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test03(){

        //US25_TC03
        extentTest = extentReports.createTest("'Users' sayfasında kayıtlı kullanıcı bilgisi ile kullanıcı filtreleme testi", "Admin, Users sayfasındaki arama kutusuna kayıtlı bilgileri girerek filtrelemeyi test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click(); //kullanıcı adı butonuna tıkla.
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();  //mouse ile dashboard'ın üzerine git.
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminUsersPage.dashboardUsersButtonu.click(); //Users başlığına tıkla.
        extentTest.info("Users başlığına tıklar");

        adminUsersPage.dashboardSubUsersButton.click(); // Users alt başlığına tıkla.
        extentTest.info("Users alt başlığına tıklar");

        adminUsersPage.searchUserBox.sendKeys(ConfigReader.getProperty("011_registerUser"));
        extentTest.info("SearchBox'a kayıtlı kullanıcı bilgisi girer.");

        softAssert.assertTrue(adminUsersPage.searchedRegisterUser.getText().equals(ConfigReader.getProperty("011_registerUser")),"Aranan kayıtlı kelime, filtrelemede görünmüyor.");
        extentTest.pass("Filtrelenen değer, searchBox'a girilen değeri kapsadığını test eder.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();

    }

    @Test
    public void test04(){

        //US25_TC04
        extentTest = extentReports.createTest("'Users' sayfasında kayıtlı olmayan kullanıcı bilgisi ile kullanıcı filtreleme testi", "Admin, Users sayfasındaki arama kutusuna kayıtlı olmayan bilgileri girerek filtrelemeyi test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click(); //kullanıcı adı butonuna tıkla.
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();  //mouse ile dashboard'ın üzerine git.
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminUsersPage.dashboardUsersButtonu.click(); //User başlığına tıkla.
        extentTest.info("Users başlığına tıklar");

        adminUsersPage.dashboardSubUsersButton.click(); // Users alt başlığına tıkla.
        extentTest.info("Users alt başlığına tıklar");

        adminUsersPage.searchUserBox.sendKeys(ConfigReader.getProperty("011_unregisteredUser"));
        extentTest.info("SearchBox'a kayıtlı olmayan kullanıcı bilgisi girer.");

        softAssert.assertTrue(adminUsersPage.userNotFoundMessage.isDisplayed(),"Aranan kayıtlı olmayan kelime, tabloda görünmekte.");
        extentTest.pass("Tabloda kullanıcı bulunamadığını test eder.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test05(){

        //US25_TC05
        extentTest = extentReports.createTest("'Users' sayfasındaki 'Edit' ve 'Delete' butonlarının görünürlüğü testi", "Admin, Users sayfasındaki Users listesinde düzenleme ve silme butonlarının varlığını sorgular.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        homePage.headerAdminNameButton.click(); //kullanıcı adı butonuna tıkla.
        extentTest.info("KullanıcıAdi butonuna tıklar");

        ReusableMethods.dashbordSidebarMenu();  //mouse ile dashboard'ın üzerine git.
        extentTest.info("Dashboard'un üzerine mouse ile gider");

        adminUsersPage.dashboardUsersButtonu.click(); //User başlığına tıkla.
        extentTest.info("Users başlığına tıklar");

        adminUsersPage.dashboardSubUsersButton.click(); // Users alt başlığına tıkla.
        extentTest.info("Users alt başlığına tıklar");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform(); //sayfaı aşağı kaydır.
        extentTest.info("Sayfayı aşağıya kaydır.");

        adminUsersPage.nextButtonUsersPage.click();
        extentTest.info("Next butonuna basar.");

        softAssert.assertEquals(adminUsersPage.usersEditButtonsList.size(),10,"Edit buton sayısı 10 değildir.");
        extentTest.pass("Tablodaki 'edit' butonu sayısının 10 olduğunu test eder.");

        softAssert.assertEquals(adminUsersPage.usersDeleteButtons.size(),10,"Delete buton sayısı 10 değildir.");
        extentTest.pass("Tablodaki 'delete' butonu sayısının 10 olduğunu test eder.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test06(){

        //US25_TC06
        extentTest = extentReports.createTest("Kullanıcı editleme testi", "Admin, kullanıcı edit sayfasında gerekli alanları geçerli bilgilerle doldurur ve güncelleme işleminin başarılı olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        //bilgileri metoda gönder.
        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageValidPhone"),
                                                    ConfigReader.getProperty("011_userEditPageValidPassword"),
                                                    ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"),
                                                    ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Verilen dataları text box'lara girer.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.editConfirmationMessage.isDisplayed(),"Doğrulama mesajı görünmedi.");
        extentTest.pass("Doğrulama mesajının görünürlüğünü sorgular.");

        adminUsersPage.closeConfirmationMessage.click();
        extentTest.info("Doğrulama mesajını kapatır.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test07(){

        //US25_TC07
        extentTest = extentReports.createTest("Eksik Bilgiler ile kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında 'phone' alanını boş bırakır ve güncelleme işleminin başarısız olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri sil.");

        adminUsersPage.editPagePasswordBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPassword"));
        extentTest.info("Password'a data bilgisi girilir.");

        adminUsersPage.editPagePasswordConfirmationBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"));
        extentTest.info("Password Conf.'a data bilgisi girilir.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri sil.");

        adminUsersPage.editPageEmailBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Email box'a data bilgisi girilir.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");
        ReusableMethods.bekle(1);

        softAssert.assertTrue(adminUsersPage.editPageUserName.isDisplayed(),"Edit sayfasında kalmadı.");
        extentTest.pass("Edit sayfasında kaldığını doğrular.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test08(){

        //US25_TC08
        extentTest = extentReports.createTest("Eksik Bilgiler ile kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasındaki 'phone' alanına sayısal olmayan karakterler girer ve güncelleme işleminin başarısız olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        //bilgileri metoda gönder.
        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageInvalidPhone"),
                ConfigReader.getProperty("011_userEditPageValidPassword"),
                ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"),
                ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Verilen dataları text box'lara girer.");

        adminUsersPage.editPageSaveButton.click(); // save butonuna tıkla.
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertFalse(adminUsersPage.editConfirmationMessage.isDisplayed(),"Edit onay mesajı göründü.");
        extentTest.fail("Onay mesajının görünmediğini doğrular.");

        if(adminUsersPage.editConfirmationMessage.isDisplayed()){
            adminUsersPage.closeConfirmationMessage.click();
            extentTest.info("Doğrulama mesajını kapatır.");
        }

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test09(){

        //US25_TC09
        extentTest = extentReports.createTest("Eksik Bilgiler ile kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında 'password' alanını boş bırakır ve güncelleme işleminin başarısız olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail")); // metot sayesinde siteye git ve login ol.
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl")); // tablodaki x.sayfaya git
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");

        adminUsersPage.editPagePhoneBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPhone"));
        extentTest.info("Phone box'a data bilgisi girilir.");

        adminUsersPage.editPagePasswordConfirmationBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"));
        extentTest.info("Password Conf. box'a data bilgisi girilir.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        adminUsersPage.editPageEmailBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidEmail")); // email box'a bilgi gir.
        extentTest.info("Email box'a data bilgisi girilir.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertFalse(adminUsersPage.editConfirmationMessage.isDisplayed(),"Edit onay mesajı göründü.");
        extentTest.fail("Onay mesajının görünmediğini doğrular.");

        if(adminUsersPage.editConfirmationMessage.isDisplayed()){
            adminUsersPage.closeConfirmationMessage.click();
            extentTest.info("Doğrulama mesajını kapatır.");
        }

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test10(){

        //US25_TC10
        extentTest = extentReports.createTest("Eksik Bilgiler ile kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında 'password confirmation' alanını boş bırakır ve güncelleme işleminin başarısız olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");

        adminUsersPage.editPagePhoneBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPhone"));
        extentTest.info("Phone box'a data bilgisi girilir.");

        adminUsersPage.editPagePasswordBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPassword"));
        extentTest.info("Password box'a data bilgisi girilir.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        adminUsersPage.editPageEmailBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Email box'a data bilgisi girilir.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertFalse(adminUsersPage.editConfirmationMessage.isDisplayed(),"Edit onay mesajı göründü.");
        extentTest.fail("Onay mesajının görünmediğini doğrular.");

        if(adminUsersPage.editConfirmationMessage.isDisplayed()){
            adminUsersPage.closeConfirmationMessage.click();
            extentTest.info("Doğrulama mesajını kapatır.");
        }

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test11(){

        //US25_TC11
        extentTest = extentReports.createTest("Eksik Bilgiler ile kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında 'Email' alanını boş bırakır ve güncelleme işleminin başarısız olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");

        adminUsersPage.editPagePhoneBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPhone"));
        extentTest.info("Phone box'a data bilgisi girilir.");

        adminUsersPage.editPagePasswordBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPassword"));
        extentTest.info("Password box'a data bilgisi girilir.");

        adminUsersPage.editPagePasswordConfirmationBox.sendKeys(ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"));
        extentTest.info("Password Conf. box'a data bilgisi girilir.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.editPageSaveButton.isDisplayed());
        extentTest.pass("Edit sayfasında kaldığını doğrular.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test12(){

        //US25_TC12
        extentTest = extentReports.createTest("Geçersiz Bilgiler ile kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında 'Email' alanına geçersiz bilgi girer ve güncelleme işleminin başarısız olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");
        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageValidPhone"),
                ConfigReader.getProperty("011_userEditPageValidPassword"),
                ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"),
                ConfigReader.getProperty("011_userEditPageEmailEndWith@"));
        extentTest.info("Verilen dataları text box'lara girer.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.editPageSaveButton.isDisplayed());
        extentTest.pass("Edit sayfasında kaldığını doğrular.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test13(){

        //US25_TC13
        extentTest = extentReports.createTest("Geçersiz Bilgiler ile kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında 'Email' alanına geçersiz bilgi girer ve güncelleme işleminin başarısız olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl")); // tablodaki x.sayfaya git
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison(); //metot kullanarak edit name ile listedeki name'i karşılaştır.
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");
        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        //bilgileri metoda gönder.
        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageValidPhone"),
                ConfigReader.getProperty("011_userEditPageValidPassword"),
                ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"),
                ConfigReader.getProperty("011_userEditPageEmailEndWith."));
        extentTest.info("Verilen dataları text box'lara girer.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.editPageSaveButton.isDisplayed());
        extentTest.pass("Edit sayfasında kaldığını doğrular.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test14() throws FileNotFoundException, AWTException {

        //US25_TC14
        extentTest = extentReports.createTest("Fotoğraf yükleyerek kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında geçerli bilgileri girer, fotoğraf yükler ve güncelleme işleminin başarılı olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");
        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageValidPhone"),
                ConfigReader.getProperty("011_userEditPageValidPassword"),
                ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"),
                ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Verilen dataları text box'lara girer.");

        ReusableMethods.dropFilesToUploadField(ConfigReader.getProperty("firstFilePath"));
        extentTest.info("Verilen datadan fotoğraf yüklenir.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.editConfirmationMessage.isDisplayed());
        extentTest.pass("Doğrulama mesajının görünürlüğünü sorgular.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");
        ReusableMethods.bekle(3);

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test15() throws FileNotFoundException, AWTException {

        //US25_TC15
        extentTest = extentReports.createTest("Fotoğraf yüklemeyi iptal etme testi", "Admin, kullanıcı düzenlemen sayfasındaki gerekli bilgileri girer, 'Dont change Image' butonuna tıklar ve fotoğrafın değişmediğini test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");
        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageValidPhone"),
                ConfigReader.getProperty("011_userEditPageValidPassword"),
                ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"),
                ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Verilen dataları text box'lara girer.");

        ReusableMethods.dropFilesToUploadField(ConfigReader.getProperty("secondFilePath"));
        extentTest.info("Verilen datadan fotoğraf yüklenir.");

        adminUsersPage.editPageDontChangeImageButton.click();
        extentTest.info("Don't Change Image butonuna tıklar.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.editConfirmationMessage.isDisplayed());
        extentTest.pass("Doğrulama mesajının görünürlüğünü sorgular.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");
        ReusableMethods.bekle(3);

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test16() throws FileNotFoundException, AWTException {

        //US25_TC16
        extentTest = extentReports.createTest("Fotoğraf yükleyerek kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında geçerli bilgileri girer, birden fazla fotoğraf yükler ve güncelleme işleminin başarılı olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        ReusableMethods.deleteTextBoxField(adminUsersPage.editPagePhoneBox);
        extentTest.info("Phone box'taki değeri siler.");
        ReusableMethods.deleteTextBoxField(adminUsersPage.editPageEmailBox);
        extentTest.info("Email box'taki değeri siler.");

        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageValidPhone"),
                ConfigReader.getProperty("011_userEditPageValidPassword"),
                ConfigReader.getProperty("011_userEditPageValidPasswordConfirmation"),
                ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Verilen dataları text box'lara girer.");

        ReusableMethods.dropFilesToUploadField(ConfigReader.getProperty("secondFilePath"));
        extentTest.info("Verilen datadan fotoğraf yüklenir.");
        ReusableMethods.dropFilesToUploadField(ConfigReader.getProperty("firstFilePath"));
        extentTest.info("Verilen datadan fotoğraf yüklenir.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.editConfirmationMessage.isDisplayed());
        extentTest.fail("Doğrulama mesajının görünürlüğünü sorgular.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");
        ReusableMethods.bekle(3);

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test17(){

        //US25_TC17
        extentTest = extentReports.createTest("'Password' ve 'Password Conf.' alanına farklı değerler girerek kullanıcı editleme testi", "Admin, kullanıcı düzenleme sayfasında geçerli bilgileri girer, birden fazla fotoğraf yükler ve güncelleme işleminin başarılı olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        ReusableMethods.editNameAndListNameComparison();
        extentTest.info("Edit sayfasındaki name ile listedeki name'i karşılaştır ve kullanıcı edit sayfasına gider.");

        //bilgileri metoda gönder.
        ReusableMethods.fillingTheFormOnTheEditPage(ConfigReader.getProperty("011_userEditPageValidPhone"),
                ConfigReader.getProperty("011_userEditPageValidPassword"),
                ConfigReader.getProperty("011_userEditPageInvalidPasswordConfirmation"),
                ConfigReader.getProperty("011_userEditPageValidEmail"));
        extentTest.info("Verilen dataları text box'lara girer.");

        adminUsersPage.editPageSaveButton.click();
        extentTest.info("Save butonuna tıklar.");

        softAssert.assertFalse(adminUsersPage.editConfirmationMessage.isDisplayed(),"Edit onay mesajı göründü.");
        extentTest.fail("Onay mesajının görünmediğini doğrular.");

        if(adminUsersPage.editConfirmationMessage.isDisplayed()){
            adminUsersPage.closeConfirmationMessage.click();
            extentTest.info("Doğrulama mesajını kapatır.");
        }

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }

    @Test
    public void test18(){

        //US25_TC18
        extentTest = extentReports.createTest("Kullanıcı silme testi", "Admin, kullanıcının delete butonuna tıklar ve silme işleminin başarılı olduğunu test eder.");

        ReusableMethods.signIn(ConfigReader.getProperty("011_validAdminEmail"));
        extentTest.info("Admin, loyal friend care anasayfaya gider ve sign in işlemlerini yapar.");

        Driver.getDriver().get(ConfigReader.getProperty("toUsersUrl"));
        extentTest.info("Verilen datadaki linke gider.");

        adminUsersPage.deleteUserButton.click();
        extentTest.info("Delete butonuna tıklar.");

        softAssert.assertTrue(adminUsersPage.userDeletedMessage.isDisplayed());
        extentTest.pass("Doğrulama mesajının görünürlüğünü sorgular.");

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin hesabından çıkış yapar.");

        extentTest.info("Sayfayı kapatır.");
        softAssert.assertAll();
    }
}
