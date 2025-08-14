package tests.UI_FUNC_001;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDoctorsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.util.List;

public class Us_032 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001_gorunurlukTesti() {
        extentTest = extentReports.createTest("'Doctors' ve 'Create Doctors' Linkleri Gorunurluk Testi",
                "'Doctors' 'Create Doctors' linkleri gorunur olmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menude 'Doctors' linkinin gorunur oldugunu dogrulayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        softAssert.assertTrue(adminDoctorsPage.doctorsLink.isDisplayed());
        extentTest.pass("Admin panelinde yer alan acilir menude 'Doctors' linkinin gorunur oldugunu dogrular");

        // Doctors linkine tiklayin
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Doctors linkine tiklar");

        // Admin panelinde yer alan acilir menude 'Create Doctors' linkinin gorunur oldugunu dogrulayin
        softAssert.assertTrue(adminDoctorsPage.createDoctorsLink.isDisplayed());
        extentTest.pass("Admin panelinde yer alan acilir menude 'Create Doctors' linkinin gorunur oldugunu dogrular");

        softAssert.assertAll();

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_002_linkErisilebilirlikTesti() {
        extentTest = extentReports.createTest("'Create Doctors' Linki Erisilebilirlik Testi",
                "'Create Doctors' linki doktor olusturma sayfasına yonlendirmeli");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign in butonuna tiklar");

        // Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklar");

        // 'Create Doctors' linkine tiklayin
        adminDoctorsPage.createDoctorsLink.click();
        extentTest.info("'Create Doctors' linkine tiklar");

        // Create Doctors sayfasina yonlendirildigini dogrulayin
        softAssert.assertTrue(adminDoctorsPage.createDoctorsText.isDisplayed());
        extentTest.pass("Doktor olusturma sayfasina yonlendirildigini dogrular");

        softAssert.assertAll();

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_003_formElemanlariGorunurlukTesti() {
        extentTest = extentReports.createTest("Form Elemanlari Gorunurluk Testi",
                "Doktor olusturma formunda yer alan tum alanlar erisilebilir olmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklar");

        // 'Create Doctors' linkine tiklayin
        adminDoctorsPage.createDoctorsLink.click();
        extentTest.info("'Create Doctors' linkine tiklar");

        // Acilan sayfada 'Doctors Title' textbox'inin gorunur oldugunu dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorsTitleTextbox.isDisplayed());
        extentTest.pass("Acilan sayfada 'Doctors Title' textbox'inin gorunur oldugunu dogrular");

        // 'Doctors Content English' textbox'inin gorunur oldugunu dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorsContentEnglishTextbox.isDisplayed());
        extentTest.pass("'Doctors Content English' textbox'inin gorunur oldugunu dogrular");

        // Dosya yukleme alaninin gorunur oldugunu dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorsImageDropzone.isDisplayed());
        extentTest.pass("Dosya yukleme alaninin gorunur oldugunu dogrular");

        // 'Doctors save' butonunun gorunur oldugunu dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorsImageDropzone.isDisplayed());
        extentTest.pass("'Doctors save' butonunun gorunur oldugunu dogrular");

        softAssert.assertAll();

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_004_zorunluAlanTesti() {
        extentTest = extentReports.createTest("Zorunlu Alan Testi",
                "Doktor olusturma formundaki tum zorunlu alanlar bos birakildiginda yeni bir doktor olusturulamamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign in butonuna tiklar");

        // Ana sayfa beader bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklar");

        // 'Create Doctors' linkine tiklayin
        adminDoctorsPage.createDoctorsLink.click();
        extentTest.info("'Create Doctors' linkine tiklar");

        // 'Doctors save' butonuna tiklayin
        adminDoctorsPage.doctorsSaveButton.click();
        extentTest.info("'Doctors save' butonuna tiklar");

        // Yeni bir doktor olusturulamadigini dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorsSaveButton.isDisplayed());
        extentTest.pass("Yeni bir doktor olusturulamadigini dogrular");

        softAssert.assertAll();

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }


    @Test
    public void TC_005_zorunluAlanTesti() {
        extentTest = extentReports.createTest("Zorunlu Alan Testi",
                "Doktor olusturma formundaki 'Doctor Title' zorunlu alani bos birakildiginda yeni bir doktor olusturulamamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklar");

        // 'Create Doctors' linkine tiklayin
        adminDoctorsPage.createDoctorsLink.click();
        extentTest.info("'Create Doctors' linkine tiklar");

        // Formda bulunan 'Doctor Content English' zorunlu textbox'ini gecerli bilgi ile doldurun
        adminDoctorsPage.doctorsContentEnglishTextbox.sendKeys(ConfigReader.getProperty("009_doctorsContentEnglish"));
        extentTest.info("Formda bulunan 'Doctor Content English' zorunlu textbox'ini gecerli bilgi ile doldurur");

        // 'Doctors save' butonuna tiklayin
        adminDoctorsPage.doctorsSaveButton.click();
        extentTest.info("'Doctors save' butonuna tiklar");

        // Yeni bir doktor olusturulamadigini dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorsSaveButton.isDisplayed());
        extentTest.pass("Yeni bir doktor olusturulamadigini dogrular");

        softAssert.assertAll();

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }


    @Test
    public void TC_006_zorunluAlanTesti() {
        extentTest = extentReports.createTest("Zorunlu Alan Testi", "Doktor olusturma formundaki 'Doctor Content English' zorunlu alani bos birakildiginda yeni bir doktor olusturulamamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign in butonuna tiklar");

        // Ana sayfa beader bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklar");

        // 'Create Doctors' linkine tiklayin
        adminDoctorsPage.createDoctorsLink.click();
        extentTest.info("'Create Doctors' linkine tiklar");

        // Formda bulunan 'Doctor Title' zorunlu textbox'ini gecerli bilgi ile doldurun
        adminDoctorsPage.doctorsTitleTextbox.sendKeys(ConfigReader.getProperty("009_doctorTitle"));
        extentTest.info("Formda bulunan 'Doctor Title' zorunlu textbox'ini gecerli bilgi ile doldurur");

        // 'Doctors save' butonuna tiklayin
        adminDoctorsPage.doctorsSaveButton.click();
        extentTest.info("'Doctors save' butonuna tiklar");

        // Yeni bir doktor olusturulamadigini dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorsSaveButton.isDisplayed());
        extentTest.pass("Yeni bir doktor olusturulamadigini dogrular");

        softAssert.assertAll();

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_007_pozitifDoktorOlusturmaTesti() throws AWTException {
        extentTest = extentReports.createTest("Gecerli Bilgilerle Doktor Olusturma Testi", "Doktor olusturma formundaki alanlar gecerli bilgilerle dolduruldugunda yeni bir doktor olusturulabilmeli");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa beader bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklar");

        // 'Create Doctors' linkine tiklayin
        adminDoctorsPage.createDoctorsLink.click();
        extentTest.info("'Create Doctors' linkine tiklar");

        // Formda bulunan 'Doctor Title' ve 'Doctors Content English' zorunlu textbox'larini gecerli bilgilerle doldurun
        adminDoctorsPage.doctorsTitleTextbox.sendKeys(ConfigReader.getProperty("009_doctorTitle"));
        extentTest.info("Formda bulunan 'Doctor Title' zorunlu textbox'ini gecerli bilgi ile doldurur");

        adminDoctorsPage.doctorsContentEnglishTextbox.sendKeys(ConfigReader.getProperty("009_doctorsContentEnglish"));
        extentTest.info("Formda bulunan 'Doctors Content English' zorunlu textbox'ini gecerli bilgi ile doldurur");

        // Dosya yukleme alanina bir fotograf yukleyin
        ReusableMethods.uploadDoctorImage(ConfigReader.getProperty("009_filePath"));
        extentTest.info("Dosya yukleme alanina bir fotograf yukler");

        // 'Doctors save' butonuna tiklayin
        adminDoctorsPage.doctorsSaveButton.click();
        extentTest.info("'Doctors save' butonuna tiklar");

        // 'Doctors Store successfully.' onay mesajinin gorunur oldugunu dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorConfirmMessage.isDisplayed());
        extentTest.pass("'Doctors Store successfully.' onay mesajinin gorunur oldugunu dogrular");
        softAssert.assertAll();

        // Mesaj kutusunu kapatin
        adminDoctorsPage.messageBoxCloseButton.click();
        extentTest.info("Mesaj kutusunu kapatir");

        // Yeni eklenen doktorun doktorlar listesinde oldugunu dogrulayin
        // Yeni eklenen doktoru 'Delete' butonuna tiklayarak silin
        ReusableMethods.doctorDelete();
        extentTest.pass("Yeni eklenen doktorun doktorlar listesinde oldugunu dogrular");
        extentTest.info("Yeni eklenen doktoru 'Delete' butonuna tiklayarak siler");

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }


    @Test
    public void TC_008_negatifGorselTesti() {
        extentTest = extentReports.createTest("Doktor Gorseli Gorunurluk Testi",
                "Doktor olusturulurken gorsel eklenilmezse doktorlar listesinde bu doktora ait bir gorsel bulunmamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validAdminEmail"));
        extentTest.info("Yonetici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa header bolumunden '*kullaniciadi' butonuna tiklayarak admin paneline gidin
        HomePage homePage = new HomePage();
        homePage.headerAdminNameButton.click();
        extentTest.info("Ana sayfa header bolumunden '*kullaniciAdi' butonuna tiklayarak admin paneline gider");

        // Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklayin
        ReusableMethods.dashbordSidebarMenu();

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();
        adminDoctorsPage.doctorsLink.click();
        extentTest.info("Admin panelinde yer alan acilir menudeki 'Doctors' linkine tiklar");

        // 'Create Doctors' linkine tiklayin
        adminDoctorsPage.createDoctorsLink.click();
        extentTest.info("'Create Doctors' linkine tiklar");

        // Formda bulunan 'Doctor Title' ve 'Doctors Content English' zorunlu textbox'larini gecerli bilgilerle doldurun
        adminDoctorsPage.doctorsTitleTextbox.sendKeys(ConfigReader.getProperty("009_doctorTitle"));
        extentTest.info("Formda bulunan 'Doctor Title' zorunlu textbox'ini gecerli bilgi ile doldurur");

        adminDoctorsPage.doctorsContentEnglishTextbox.sendKeys(ConfigReader.getProperty("009_doctorsContentEnglish"));
        extentTest.info("Formda bulunan 'Doctors Content English' zorunlu textbox'ini gecerli bilgi ile doldurur");

        // 'Doctors save' butonuna tiklayin
        adminDoctorsPage.doctorsSaveButton.click();
        extentTest.info("'Doctors save' butonuna tiklar");

        // 'Doctors Store successfully.' onay mesajinin gorundugunu dogrulayin
        softAssert.assertTrue(adminDoctorsPage.doctorConfirmMessage.isDisplayed());
        extentTest.pass("'Doctors Store successfully.' onay mesajinin gorundugunu dogrular");

        // Mesaj kutusunu kapatin
        adminDoctorsPage.messageBoxCloseButton.click();
        extentTest.info("Mesaj kutusunu kapatir");

        // Doktorlar listesinde yeni eklenen doktora ait bir gorsel bulunmadigini dogrulayin
        adminDoctorsPage.nextButtonDoctorsPage.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        List<WebElement> doctorImagesList = Driver.getDriver().findElements(By.xpath("//tbody//tr//td//img"));
        int imageIndex = doctorImagesList.size() - 1;

        softAssert.assertFalse(doctorImagesList.get(imageIndex).isDisplayed());
        extentTest.fail("Doktorlar listesinde yeni eklenen doktora ait bir gorsel bulunmadigini dogrular");

        // Yeni eklenen doktoru 'Delete' butonuna tiklayarak silin
        ReusableMethods.doctorDelete();
        extentTest.info("Yeni eklenen doktoru 'Delete' butonuna tiklayarak siler");

        softAssert.assertAll();

        // Header kismindaki profil menusune ve ardindan Logout linkine tiklayin
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kismindaki profil menusune ve ardindan Logout linkine tiklar");

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }


}





