package tests.UI_FUNC_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AppointmentBookingFormPage;
import pages.HomePage;
import pages.VaccinationsPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_013 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    VaccinationsPage vaccinationsPage = new VaccinationsPage();
    AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testcase01(){
        extentTest = extentReports.createTest("Ana Sayfa Body Bolumundeki 'Vaccinations' Menusu Gorunurluluk Testi", "Kullanici ana sayfa body bolumundeki 'Vaccinations' menusu gorebilmeli");

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Başarılı bir şekilde giriş yapabildiğini doğrular
        Assert.assertTrue(homePage.headerSignOutButton.isDisplayed());
        extentTest.pass("Basarili bir sekilde login oldugunu test eder");

        //3- Ana sayfada body bölümündeki 'Vaccinations' menüsünün görünür olduğunu doğrular
        Assert.assertTrue(homePage.bodyVaccinationsMenu.isDisplayed());
        extentTest.pass("Body bolumundeki 'Vaccinations' menusunun gorunur oldugunu test eder");

        //4- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");
    }

    @Test
    public void testcase02(){
        extentTest = extentReports.createTest("Gidilen Asiyla Tiklanan Asinin Ayni Asi Olma Testi", "Kullanicinin tikladigi asiyla gidilen sayfadaki asi ayni asi olmalidir");

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki 'Vaccinations' menüsünden ilk aşıya tıklar
        String actualFirstVaccinationName = homePage.bodyFirstVaccinations.getText();
        homePage.bodyFirstVaccinations.click();
        extentTest.info("Body bolumundeki asilardan ilk asiya tiklar");

        //3- Gidilen sayfadaki aşıyla tıklanan aşının aynı aşı olduğunu doğrular
        String expectedVaccinationName = vaccinationsPage.clickedVaccinationName.getText();
        Assert.assertEquals(actualFirstVaccinationName, expectedVaccinationName);
        extentTest.pass("Gidilen asiyla tiklanan asinin aynı asi oldugunu test eder");

        //4- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void testcase03(){
        extentTest = extentReports.createTest("Asi Sayfasinda Randevu Olusturma Bolumu Goruntuleme ve Randevu Olusturma Testi", "Kullanici asi sayfasinda randevu bolumunu gormeli ve randevu olusturabilmelidir");

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki 'Vaccinations' menüsünden ilk aşıya tıklar
        homePage.bodyFirstVaccinations.click();
        extentTest.info("Body bolumundeki asilardan ilk asiya tiklar");

        //3- Tıklanan aşı sayfasında "Appointment Booking" bölümünün görünür olduğunu test eder
        Assert.assertTrue(appointmentBookingFormPage.appointmentBookingText.isDisplayed());
        extentTest.pass("Tiklanan asi sayfasinda 'Appointment Booking' bolumunun gorunurlulugunu test eder");

        //4- "Appointment Booking" üzerindeki kutulara verilen bilgileri girer
        //   "Appointment Booking" butonuna tıklar
        ReusableMethods.creatinganAppointmentWithValidInformation();
        extentTest.info("'Appointment Booking' uzerindeki istenen bilgileri girer ve 'Appointment Booking' butonuna tiklar");

        //5- Randevunun oluşturulduğunu doğrular
        Assert.assertTrue(appointmentBookingFormPage.confirmationMessage.isDisplayed());
        extentTest.pass("Randevunun olusturuldugunu test eder");

        //6- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");
    }

    @Test
    public void testcase04(){
        extentTest = extentReports.createTest("Gecmis Tarihli Randevu Olusturma Testi", "Kullanici gecmis tarihli randevu olusturamamalidir");

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki 'Vaccinations' menüsünden ilk aşıya tıklar
        homePage.bodyFirstVaccinations.click();
        extentTest.info("Body bolumundeki asilardan ilk asiya tiklar");

        //3- "Appointment Booking" üzerindeki tarih kısmına geçmiş tarihli bir tarih girer ve verilen diğer bilgileri girer
        //   "Appointment Booking" butonuna tıklar
        ReusableMethods.createAppointmentWithPastDate();
        extentTest.info("'Appointment Booking' uzerindeki tarih kutusuna gecmis tarihli bir tarih girer ve istenen diger bilgileri girdikten sonra 'Appointment Booking' butonuna tiklar");

        //4- Randevunun oluşturulmadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(), "Randevu olusturulamadigi dogrulanamadi");
        extentTest.fail("Randevunun olusturulamadigini test eder");

        //5- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        softAssert.assertAll();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");


    }

    @Test
    public void testcase05(){
        extentTest = extentReports.createTest("Gecersiz Telefon Numarasi Ile Randevu Olusturma Testi", "Kullanici gecersiz telefon numarasi girerek randevu olusturamamalidir");

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki 'Vaccinations' menüsünden ilk aşıya tıklar
        homePage.bodyFirstVaccinations.click();
        extentTest.info("Body bolumundeki asilardan ilk asiya tiklar");

        //3- "Appointment Booking" üzerindeki telefon numarası kutusuna sadece harfler girer ve verilen diğer bilgileri girer
        //   "Appointment Booking" butonuna tıklar
        ReusableMethods.createAppointmentWithInvalidPhoneNumber();
        extentTest.info("'Appointment Booking' uzerindeki phone kutusuna sadece harf girer ve istenen diger bilgileri girdikten sonra 'Appointment Booking' butonuna tiklar");

        //4- Randevunun oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(), "Randevu olusturulamadigi dogrulanamadi");
        extentTest.fail("Randevunun olusturulamadigini test eder");

        //5- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        softAssert.assertAll();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void testcase06(){
        extentTest = extentReports.createTest("Bilgi Girilmeden Randevu Olusturma Testi", "Kullanici hicbir bilgi girmeden randevu olusturamamalidir");

        // 1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki 'Vaccinations' menüsünden ilk aşıya tıklar
        homePage.bodyFirstVaccinations.click();
        extentTest.info("Body bolumundeki asilardan ilk asiya tiklar");

        //3- "Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("'Appointment Booking' butonuna tiklar");

        //4- Randevunun oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(), "Randevu olusturulamadigi dogrulanamadi");
        extentTest.fail("Randevunun olusturulamadigini test eder");

        //5- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        softAssert.assertAll();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");

    }

}
