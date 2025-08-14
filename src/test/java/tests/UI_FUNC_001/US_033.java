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

import java.util.List;

public class US_033  extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();


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
