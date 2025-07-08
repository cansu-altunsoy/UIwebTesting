package tests.UI_FUNC_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AppointmentBookingFormPage;
import pages.DoctorsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_012 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    DoctorsPage doctorsPage = new DoctorsPage();
    AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void testcase01(){
        extentTest = extentReports.createTest("Ana Sayfa Body Bolumundeki 'Doctors' Menusu Gorunurluluk Testi", "Kullanici ana sayfa body bolumundeki 'Doctors' menusu gorebilmeli");

        // 1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Başarılı bir şekilde giriş yapabildiğini doğrular
        Assert.assertTrue(homePage.headerSignOutButton.isDisplayed());
        extentTest.pass("Basarili bir sekilde login oldugunu test eder");

        //3- Ana sayfada body bölümündeki doktorlar menüsünün görünür olduğunu doğrular
        Assert.assertTrue(homePage.bodyDoctorsMenu.isDisplayed());
        extentTest.pass("Body bolumundeki 'Doctors' menusunun gorunur oldugunu test eder");

        //4- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");


    }

    @Test
    public void testcase02(){
        extentTest = extentReports.createTest("Gidilen Doktorla Tiklanan Doktorun Ayni Doktor Olma Testi", "Kullanicinin tikladigi doktorla gidilen sayfadaki doktor ayni doktor olmalidir");

        // 1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki doktorlar menüsünden ilk doktora tıklar
        String actualFirstDoctorName = homePage.bodyFirstDoctor.getText();
        homePage.bodyFirstDoctor.click();
        extentTest.info("Body bolumundeki doktorlardan ilk doktora tiklar");

        //3- Gidilen sayfadaki doktorla tıklanan doktorun aynı doktor olduğunu doğrular
        String expectedFirstDoctorName = doctorsPage.clickedDoctorName.getText();
        Assert.assertEquals(actualFirstDoctorName, expectedFirstDoctorName);
        extentTest.pass("Gidilen doktorla tiklanan doktorun aynı doktor oldugunu test eder");

        //4- Method kullanilarak logout islemi yapar
        ReusableMethods.singOut();
        extentTest.info("'Sign Out' butonuna tiklar ve logout olur");
        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void testcase03(){
        extentTest = extentReports.createTest("Doktor Sayfasinda Randevu Olusturma Bolumu Goruntuleme ve Randevu Olusturma Testi", "Kullanici doktor sayfasinda randevu bolumunu gormeli ve randevu olusturabilmelidir");

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki doktorlar menüsünden ilk doktora tıklar
        homePage.bodyFirstDoctor.click();
        extentTest.info("Body bolumundeki doktorlardan ilk doktora tiklar");

        //3- Tıklanan doktor sayfasında "Appointment Booking" bölümünün görünür olduğunu test eder
        Assert.assertTrue(appointmentBookingFormPage.appointmentBookingText.isDisplayed());
        extentTest.pass("Tiklanan doktor sayfasinda 'Appointment Booking' bolumunun gorunurlulugunu test eder");


        //4- Tıklanan doktor sayfasında "Appointment Booking" üzerindeki kutulara verilen bilgileri girer
        //   "Appointment Booking" butonuna tiklar
        ReusableMethods.createDoctorAppointmentWithValidInformation();
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

        //2- Ana sayfada body bölümündeki doktorlar menüsünden ilk doktora tıklar
        homePage.bodyFirstDoctor.click();
        extentTest.info("Body bolumundeki doktorlardan ilk doktora tiklar");

        //3- Tıklanan doktor sayfasında "Appointment Booking" üzerindeki tarih kısmına geçmiş tarihli bir tarih girer ve verilen diğer bilgileri girer
        //   "Appointment Booking" butonuna tiklar
        ReusableMethods.createDoctorAppointmentWithPastDate();
        extentTest.info("'Appointment Booking' uzerindeki tarih kutusuna gecmis tarihli bir tarih girer ve istenen diger bilgileri girdikten sonra 'Appointment Booking' butonuna tiklar");

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
    public void testcase05(){
        extentTest = extentReports.createTest("Gecersiz Telefon Numarasi Ile Randevu Olusturma Testi", "Kullanici gecersiz telefon numarasi girerek randevu olusturamamalidir");

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki doktorlar menüsünden ilk doktora tıklar
        homePage.bodyFirstDoctor.click();
        extentTest.info("Body bolumundeki doktorlardan ilk doktora tiklar");

        //3- Tıklanan doktor sayfasında "Appointment Booking" üzerindeki telefon numarası kutusuna sadece harfler girer ve verilen diğer bilgileri girer
        //   "Appointment Booking" butonuna tiklar
        ReusableMethods.createDoctorAppointmentWithInvalidPhoneNumber();
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

        //1- Method kullanilarak url'e gider ve login islemlerini yapar
        ReusableMethods.signIn(ConfigReader.getProperty("003_userEmail"));
        extentTest.info("Kullanici loyal friend care anasayfaya gider ve login olur");

        //2- Ana sayfada body bölümündeki doktorlar menüsünden ilk doktora tıklar
        homePage.bodyFirstDoctor.click();
        extentTest.info("Body bolumundeki doktorlardan ilk doktora tiklar");

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

