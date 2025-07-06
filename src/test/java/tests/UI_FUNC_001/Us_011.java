package tests.UI_FUNC_001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AppointmentBookingFormPage;
import pages.DepartmentsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class Us_011 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001_departmentsGorunurlukTesti() {
        extentTest = extentReports.createTest("'Departments' Basligi ve 'Departments' Linki Gorunurluk Testi",
                "Home page body bolumunde 'Departments' basligi ve 'Departments' linki gorunur olmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumunde 'Departments' basliginin gorunur oldugunu dogrulayin
        HomePage homePage = new HomePage();

        softAssert.assertTrue(homePage.bodyDepartmentsTitle.isDisplayed());
        extentTest.pass("Ana sayfa body bolumunde 'Departments' basliginin gorunur oldugunu dogrular");

        // Ana sayfa body bolumunde 'Departments' linkinin erisilebilir oldugunu dogrulavin
        softAssert.assertTrue(homePage.bodyDepartmentsLink.isEnabled());
        extentTest.pass("Ana sayfa body bolumunde 'Departments' linkinin erisilebilir oldugunu dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklayin");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_002_departmanImagesGorunurlukTesti() {
        extentTest = extentReports.createTest("Departmanlara Ait Gorsellerin Gorunurluk Testi",
                "Home page body bolumunde 'Departments' basligi altinda departmanlara ait gorseller gorunur olmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumunde 'Departments' basligi altinda
        // departman gorsellerinin gorunur oldugunu dogrulavin
        List<WebElement> allDepartmentImages = Driver.getDriver().findElements(By.xpath("(//div[@*='row add_bottom_30'])[1]"));
        for (WebElement eachImage : allDepartmentImages) {
            softAssert.assertTrue(eachImage.isDisplayed());
            extentTest.pass("Ana sayfa body bolumunde 'Departments' basligi altinda departman gorsellerinin gorunur oldugunu dogrular");

            softAssert.assertAll();
        }

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_003_departmanImagesErisilebilirlikTesti() {
        extentTest = extentReports.createTest("Departman Gorsellerinin Erisilebilirlik Testi",
                "Home page body bolumunde 'Departments' basligi altindaki departmanlara ait gorseller ilgili departman sayfasina yönlendirmeli");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklavin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Ilk departmanin sayfasina yonlendirildigini dogrulayin
        DepartmentsPage departmentsPage = new DepartmentsPage();

        softAssert.assertTrue(departmentsPage.firstDepartmentName.isDisplayed());
        extentTest.pass("Ilk departmanin sayfasina yonlendirildigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_004_departmanBilgileriGorunurlukTesti() {
        extentTest = extentReports.createTest("Departman Sayfalarindaki Bilgilerin Gorunurluk Testi",
                "Departman sayfasindaki bilgiler dogru bir sekilde goruntulenmeli");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));

        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklayin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Acilan departman sayfasinda departman adi, gorseli, eklenme tarihi ve
        // Appointment Booking formunun gorunur oldugunu dogrulavin
        DepartmentsPage departmentsPage = new DepartmentsPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        softAssert.assertTrue(departmentsPage.firstDepartmentName.isDisplayed());
        extentTest.pass("Acilan departman sayfasinda departman adinin gorunur oldugunu dogrular");

        softAssert.assertTrue(departmentsPage.firstDepartmentImage.isDisplayed());
        extentTest.pass("Acilan departman sayfasinda departman gorselinin gorunur oldugunu dogrular");

        softAssert.assertTrue(departmentsPage.firstDepartmentAddedDate.isDisplayed());
        extentTest.pass("Acilan departman sayfasinda departman eklenme tarihinin gorunur oldugunu dogrular");

        softAssert.assertTrue(appointmentBookingFormPage.appointmentBookingText.isDisplayed());
        extentTest.pass("Acilan departman sayfasinda Appointment Booking formunun gorunur oldugunu dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_005_formElemanlariErisilebilirlikTesti() {
        extentTest = extentReports.createTest("Form Elemanlari Erisilebilirlik Testi",
                "'Appointment Booking' formunda yer alan tum alanlar erisilebilir olmali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign in butonuna tiklayin
        // Gecerli email ve password girerek Sign in butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign in butonuna tiklar, gecerli email ve password girerek Sign in butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklayin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Appointment Booking formunda takvimli tarih butonu, 'Phone Number' textbox'i
        // departman ve doktor dropdown menuleri, 'Create Message' textbox'i ve
        // 'Appointment Booking' butonunun erisilebilir oldugunu dogrulavin
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        softAssert.assertTrue(appointmentBookingFormPage.dateDdm.isEnabled());
        extentTest.pass("Form icerisindeki takvimli tarih butonunun erisilebilir oldugunu dogrular");

        softAssert.assertTrue(appointmentBookingFormPage.phoneBox.isEnabled());
        extentTest.pass("Form icerisindeki 'Phone Number' textbox'in erisilebilir oldugunu dogrular");

        softAssert.assertTrue(appointmentBookingFormPage.appointmentDepartmentsDdm.isEnabled());
        extentTest.pass("Form icerisindeki departman dropdown menunun erisilebilir oldugunu dogrular");

        softAssert.assertTrue(appointmentBookingFormPage.appointmentDoctorsDdm.isEnabled());
        extentTest.pass("Form icerisindeki doktor dropdown menunun erisilebilir oldugunu dogrular");

        softAssert.assertTrue(appointmentBookingFormPage.messageBox.isEnabled());
        extentTest.pass("Form icerisindeki 'Create Message' textbox'in erisilebilir oldugunu dogrular");

        softAssert.assertTrue(appointmentBookingFormPage.appointmentBookingButton.isEnabled());
        extentTest.pass("Formda 'Appointment Booking' butonun erisilebilir oldugunu dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_006_pozitifRandevuTalebiTesti() {
        extentTest = extentReports.createTest("Gecerli Bilgilerle Randevu Talebi Testi",
                "Gecerli bilgilerle randevu talebi olusturulabilmeli");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklayin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Appointment Booking formunda bulunan tarih, telefon no,
        // departman, doktor ve mesaj alanlarini gecerli bilgilerle doldurun
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("009_validDate"));
        extentTest.info("Appointment Booking formunda bulunan tarih alanini gecerli bilgilerle doldurur");

        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("009_validPhoneNumber"));
        extentTest.info("Appointment Booking formunda bulunan telefon no alanini gecerli bilgilerle doldurur");

        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.dentalCareDepartmentOption.click();
        extentTest.info("Appointment Booking formunda bulunan departman alanini gecerli bilgilerle doldurur");

        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.info("Appointment Booking formunda bulunan doktor alanini gecerli bilgilerle doldurur");

        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("009_AppointmentMessage"));
        extentTest.info("Appointment Booking formunda bulunan mesaj alanini gecerli bilgilerle doldurur");

        // Appointment Booking butonuna tiklayin
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tiklar");

        // 'Congratulations on your well-deserved success.' mesajinin goruntulendigini dogrulavin
        String expectedMessage = "Congratulations on your well-deserved success.";
        String actualMessage = appointmentBookingFormPage.confirmationMessage.getText();

        softAssert.assertEquals(actualMessage, expectedMessage);
        extentTest.pass("'Congratulations on your well-deserved success.' mesajinin goruntulendigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_007_negatifRandevuTalebiTesti() {
        extentTest = extentReports.createTest("Bos Form lle Randevu Talebi Testi",
                "Forma bilgi girisi yapilmadiginda randevu talebi olusturulamamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklavin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Formda bulunan alanlari bos birakin ve
        // Appointment Booking butonuna tiklayin
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Formda bulunan alanlari bos birakir ve Appointment Booking butonuna tiklar");

        // Randevu talebi olusturulamadigini dogrulavin
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed());
        extentTest.fail("Randevu talebi olusturulamadigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_008_negatifRandevuTalebiTesti() {
        extentTest = extentReports.createTest("Gecmis Tarihli Randevu Talebi Testi",
                "Gecmis tarih bilgisi ile randevu talebi olusturulamamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklayin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Appointment Booking formunda bulunan tarih alanini gecmis bir tarih bilgisi ile doldurun
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("009_invalidDate"));
        extentTest.info("Appointment Booking formunda bulunan tarih alanini gecmis bir tarih bilgisi ile doldurur");

        // Formda bulunan telefon no, departman
        // doktor ve mesaj alanlarini gecerli bilgilerle doldurun
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("009_validPhoneNumber"));
        extentTest.info("Formda bulunan telefon no alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.dentalCareDepartmentOption.click();
        extentTest.info("Formda bulunan departman alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.info("Formda bulunan doktor alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("009_AppointmentMessage"));
        extentTest.info("Formda bulunan mesaj alanini gecerli bilgi ile doldurur");

        // Appointment Booking butonuna tiklayin
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tiklar");

        // Randevu talebi olusturulamadigini dogrulayin
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed());
        extentTest.fail("Randevu talebi olusturulamadigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void TC_009_negatifRandevuTalebiTesti() {
        extentTest = extentReports.createTest("Telefon Numarasi Alani Karakter Siniri Testi",
                "Telefon numarasi alanina 11'den fazla sayida numerik karakter girildiginde randevu talebi olusturulamamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign In butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklayin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Appointment Booking formunda bulunan
        // telefon numarasi alanina 11'den fazla sayida numerik karakter girin
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("009_invalidPhoneNumber1"));
        extentTest.info("Appointment Booking formunda bulunan telefon numarasi alanina 11'den fazla savida numerik karakter girer");

        // Formda bulunan tarih, departman
        // doktor ve mesaj alanlarini gecerli bilgilerle doldurun
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("009_validDate"));
        extentTest.info("Formda bulunan tarih alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.dentalCareDepartmentOption.click();
        extentTest.info("Formda bulunan departman alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.info("Formda bulunan doktor alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("009_AppointmentMessage"));
        extentTest.info("Formda bulunan mesaj alanini gecerli bilgi ile doldurur");

        // Appointment Booking butonuna tiklayin
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tiklar");

        // Randevu talebi olusturulamadigini dogrulavin
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed());
        extentTest.fail("Randevu talebi olusturulamadigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfavi kapatir");

    }

    @Test
    public void TC_010_negatifRandevuTalebiTesti() {
        extentTest = extentReports.createTest("Telefon Numarasi Alani Numerik Olmayan Karakter Testi",
                "Telefon numarasi alanina numerik olmayan karakter girildiginde randevu talebi olusturulamamali");

        // loyalfriendcare ana sayfaya gidin
        // Header bolumunden Sign in butonuna tiklayin
        // Gecerli email ve password girerek Sign In butonuna tiklayin
        ReusableMethods.signIn(ConfigReader.getProperty("009_validUserEmail"));
        extentTest.info("Kullanici loyalfriendcare ana sayfaya giderek Sign In butonuna tiklar, gecerli email ve password girerek Sign In butonuna tiklar");

        // Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklayin
        HomePage homePage = new HomePage();
        homePage.bodyFirstDepartments.click();
        extentTest.info("Ana sayfa body bolumundeki departmanlardan ilk departman gorseline tiklar");

        // Appointment Booking formunda bulunan
        // telefon numarasi alanina numerik olmayan karakterler girin
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("009_invalidPhoneNumber2"));
        extentTest.info("Appointment Booking formunda bulunan telefon numarasi alanina numerik olmayan karakterler girer");

        // Formda bulunan tarih, departman
        // doktor ve mesaj alanlarini gecerli bilgilerle doldurun
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("009_validDate"));
        extentTest.info("Formda bulunan tarih alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.dentalCareDepartmentOption.click();
        extentTest.info("Formda bulunan departman alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.info("Formda bulunan doktor alanini gecerli bilgi ile doldurur");

        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("009_AppointmentMessage"));
        extentTest.info("Formda bulunan mesaj alanini gecerli bilgi ile doldurur");

        // Appointment Booking butonuna tiklayin
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tiklar");

        // Randevu talebi olusturulamadigini dogrulayin
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed());
        extentTest.fail("Randevu talebi olusturulamadigini dogrular");

        softAssert.assertAll();

        // Sign Out butonuna tiklayin
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tiklar");

        extentTest.info("Sayfayi kapatir");

    }

}
