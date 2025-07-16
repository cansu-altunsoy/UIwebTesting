package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AppointmentBookingFormPage;
import pages.HomePage;
import pages.MedicinesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_018 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC018_01() {

        HomePage homePage = new HomePage();
        extentTest = extentReports.createTest("Home Page'den Medicines sayfasına erişim testi","Kullanıcı HomePage'den Medicines sayfasına erişebilmeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Medicines sayfasına erişmek için Home Page'de Header bölümünde bulunan "Medicines" linkine tıklar
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Medicines sayfasına erişebildiğini doğrular
        String expectedUrl = "https://qa.loyalfriendcare.com/en/Medicines";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Medicines sayfasına erişilemedi");
        extentTest.pass("Medicines sayfasına erişebildiğini doğrular");

        //6)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //7)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_02() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        extentTest = extentReports.createTest("Medicines sayfasında mevcut ilaç adlarını ve resimlerini görüntüleme testi","Kullanıcı Medicines sayfasında ilaç isimlerini ve resimlerini görüntüleyebilmeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Medicines sayfasına erişmek için Home Page'de Header bölümünde bulunan "Medicines" linkine tıklar
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");


        //5)Sayfada ilaç isimlerini görüntülendiğini doğrular
        softAssert.assertTrue(medicinesPage.medicinesFirstMedicinesName.isDisplayed(),"Ilk ilaç ismi görüntülenemedi");
        extentTest.pass("Sayfada ilaç isimlerini görüntülendiğini doğrular");

        //6)Sayfada ilaç görsellerinin görüntülendiğini doğrular
        softAssert.assertTrue(medicinesPage.medicinesFirstMedicineImage.isDisplayed(),"Ilk ilaç görseli görüntülenemedi");
        extentTest.pass("Sayfada ilaç görsellerinin görüntülendiğini doğrular");

        //7)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //8)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");

    }

    @Test
    public void TC018_03() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        extentTest = extentReports.createTest("Medicines sayfasından seçilen ilaç sayfasına erişim testi","Kullanıcı, İlaçlar sayfasında ilaç adına tıklayarak ilgili ilaç sayfasına erişebilmeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden ""Sign In"" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Medicines sayfasına erişmek için Home Page'de Header bölümünde bulunan "Medicines" linkine tıklar
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Medicines sayfasında seçilen ilaca tıklar
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Medicines sayfasında seçilen ilaca tıklar");

        //6)Tıklanan ilk ilaç ile açılan sayfadaki ilacın aynı isimde olduğunu doğrular
        softAssert.assertEquals(medicinesPage.medicinesFirstMedicinesName,medicinesPage.firstMedicineName,"Tıklanan ilaç ile açılan ilaç sayfası eşleşmiyor");
        extentTest.pass("Tıklanan ilk ilaç ile açılan sayfadaki ilacın aynı isimde olduğunu doğrular");

        //7)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //8)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");

    }

    @Test
    public void TC018_04() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        extentTest = extentReports.createTest("İlaç sayfasında ilaç resmi, bilgileri ve randevu formunu görüntüleme testi","Kullanıcı seçilen ilaç sayfasında ilaç resmi, metni ve 'Appointment Booking' formunu görüntüleyebilmeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Medicines sayfasında seçilen ilaca tıklar
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Medicines sayfasında seçilen ilaca tıklar");

        //6)İlgili ilaç sayfasında görsel bulunduğunu doğrular
        softAssert.assertTrue(medicinesPage.firstMedicineImage.isDisplayed(),"İlaç görseli görüntülenemedi");
        extentTest.pass("İlgili ilaç sayfasında görsel bulunduğunu doğrular");

        //7)İlgili ilaç sayfasında ilaç bilgi text'i bulunduğunu doğrular
        softAssert.assertTrue(medicinesPage.firstMedicineText.isDisplayed(),"İlaç metni görüntülenemedi");
        extentTest.pass("İlgili ilaç sayfasında ilaç bilgi text'i bulunduğunu doğrular");

        //8)İlgili ilaç sayfasında "Appointment Booking" formu bulunduğunu doğrular
        softAssert.assertTrue(medicinesPage.appoinmentBookingForm.isDisplayed(),"Appointment Booking formu görüntülenemedi");
        extentTest.pass("İlgili ilaç sayfasında Appointment Booking formu bulunduğunu doğrular");

        //9)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //10)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_05() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        extentTest = extentReports.createTest("Seçilen ilaç için geçerli verilerle randevu talebi oluşturma testi","Kullanıcı geçerli verilerle randevu oluşturabilmeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider");

        //6)"Appointment Booking" formunda takvimli tarih seçiciden geçerli tarih seçer
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("004_validDate"));
        extentTest.info("Appointment Booking formunda takvimli tarih seçiciden geçerli tarih seçer");

        //7)Phone Number textbox'ına geçerli telefon numarası girer
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("004_validPhoneNumber"));
        extentTest.info("Phone Number textbox'ına geçerli telefon numarası girer");

        //8)Wellnes dropdown menüsüne tıklayarak "Anaesthesia" seçim yapar
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.anaesthesiaDepartmentOption.click();
        extentTest.info("Wellnes dropdown menüsüne tıklayarak Anaesthesia seçim yapar");

        //9)Doktor dropdown menüsüne tıklayarak "Olivia Bennett" seçim yapar
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.oliviaBennettDoctorOption.click();
        extentTest.info("Doktor dropdown menüsüne tıklayarak Olivia Bennett seçim yapar");

        //10)Create Message textbox'ına text girer
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("004_AppointmentMessage"));
        extentTest.info("Create Message textbox'ına text girer");

        //11)"Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tıklar");

        //12)Başarılı bir şekilde randevu talebi oluştuabildiğini doğrular
        String expectedMessage = "Congratulations on your well-deserved success.";
        String actualMessage = appointmentBookingFormPage.confirmationMessage.getText();
        softAssert.assertEquals(actualMessage, expectedMessage,"Randevu onay mesajı görüntülenemedi");
        extentTest.pass("Başarılı bir şekilde randevu talebi oluştuabildiğini doğrular");

        //13)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //14)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_06() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        extentTest = extentReports.createTest("Appointment Booking formuna bilgi girilmediğinde randevu talebi oluşturulamaması testi","Kullanıcı 'Appointment Booking' formunu doldurmadan bir randevu talebi gönderememeli");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider");

        //6)"Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tıklar");

        //7)Randevu talebi oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(),"Veri girilmeden randevu oluşturuldu");
        extentTest.fail("Randevu talebi oluşturulamadığını doğrular");

        //8)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //9)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_07() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        extentTest = extentReports.createTest("Appointment Booking formunda geçersiz tarih seçimi ile randevu talebi oluşturulamaması testi","Geçersiz tarih seçildiğinde randevu talebi oluşturulmamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden ""Sign In"" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider");

        //6)"Appointment Booking" formunda takvimli tarih seçiciden geçersiz tarih seçer
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("004_invalidDate"));
        extentTest.info("Appointment Booking formunda takvimli tarih seçiciden geçersiz tarih seçer");

        //7)Phone Number textbox'ına geçerli telefon numarası girer
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("004_validPhoneNumber"));
        extentTest.info("Phone Number textbox'ına geçerli telefon numarası girer");

        //8)Wellnes dropdown menüsüne tıklayarak "Anaesthesia" seçim yapar
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.anaesthesiaDepartmentOption.click();
        extentTest.info("Wellnes dropdown menüsüne tıklayarak Anaesthesia seçim yapar");

        //9)Doktor dropdown menüsüne tıklayarak "Olivia Bennett" seçim yapar
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.oliviaBennettDoctorOption.click();
        extentTest.info("Doktor dropdown menüsüne tıklayarak Olivia Bennett seçim yapar");

        //10)Create Message textbox'ına text girer
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("004_AppointmentMessage"));
        extentTest.info("Create Message textbox'ına text girer");

        //11)"Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tıklar");

        //12)Randevu talebi oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(),"Geçersiz tarih ile randevu oluşturuldu");
        extentTest.fail("Randevu talebi oluşturulamadığını doğrular");

        //13)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //14)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_08() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        extentTest = extentReports.createTest("Appointment Booking formunda tarih seçilmediğinde randevu talebi oluşturulamaması testi","Kullanıcı 'Appointment Booking' formunda bir tarih seçmeden randevu talebi oluşturamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider");

        //6)Phone Number textbox'ına geçerli telefon numarası girer
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("004_validPhoneNumber"));
        extentTest.info("Phone Number textbox'ına geçerli telefon numarası girer");

        //7)Wellnes dropdown menüsüne tıklayarak "Anaesthesia" seçim yapar
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.anaesthesiaDepartmentOption.click();
        extentTest.info("Wellnes dropdown menüsüne tıklayarak Anaesthesia seçim yapar");

        //8)Doktor dropdown menüsüne tıklayarak "Olivia Bennett" seçim yapar
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.oliviaBennettDoctorOption.click();
        extentTest.info("Doktor dropdown menüsüne tıklayarak Olivia Bennett seçim yapar");

        //9)Create Message textbox'ına text girer
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("004_AppointmentMessage"));
        extentTest.info("Create Message textbox'ına text girer");

        //10)"Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tıklar");

        //11)Randevu talebi oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(),"Tarih seçilmeden randevu oluşturuldu");
        extentTest.fail("Randevu talebi oluşturulamadığını doğrular");

        //12)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //13)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_09() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        extentTest = extentReports.createTest("Appointment Booking formunda geçersiz telefon numarası ile randevu talebi oluşturulamaması testi","Kullanıcı 'Appointment Booking' formunda formata uymayan bir telefon numarası ile randevu talebi oluşturamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider");

        //6)"Appointment Booking" formunda takvimli tarih seçiden geçerli tarih seçer
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("004_validDate"));
        extentTest.info("Appointment Booking formunda takvimli tarih seçiciden geçerli tarih seçer");

        //7)Phone Number textbox'ına geçersiz telefon numarası girer
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("004_invalidPhoneNumber"));
        extentTest.info("Phone Number textbox'ına geçersiz telefon numarası girer");

        //8)Wellnes dropdown menüsüne tıklayarak "Anaesthesia" seçim yapar
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.anaesthesiaDepartmentOption.click();
        extentTest.info("Wellnes dropdown menüsüne tıklayarak Anaesthesia seçim yapar");

        //9)Doktor dropdown menüsüne tıklayarak "Olivia Bennett" seçim yapar
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.oliviaBennettDoctorOption.click();
        extentTest.info("Doktor dropdown menüsüne tıklayarak Olivia Bennett seçim yapar");

        //10)Create Message textbox'ına text girer
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("004_AppointmentMessage"));
        extentTest.info("Create Message textbox'ına text girer");

        //11)"Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tıklar");

        //12)Randevu talebi oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(),"Geçersiz telefon numarası ile randevu oluşturuldu");
        extentTest.fail("Randevu talebi oluşturulamadığını doğrular");

        //13)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //14)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_10() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        extentTest = extentReports.createTest("Appointment Booking formunda telefon numarası girilmeden randevu talebi oluşturulamaması testi","Kullanıcı 'Appointment Booking' formuna telefon numarası girmeden randevu talebi oluşturamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider");

        //6)"Appointment Booking" formunda takvimli tarih seçiden geçerli tarih seçer
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("004_validDate"));
        extentTest.info("Appointment Booking formunda takvimli tarih seçiciden geçerli tarih seçer");

        //6)Wellnes dropdown menüsüne tıklayarak "Anaesthesia" seçim yapar
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.anaesthesiaDepartmentOption.click();
        extentTest.info("Wellnes dropdown menüsüne tıklayarak Anaesthesia seçim yapar");

        //7)Doktor dropdown menüsüne tıklayarak "Olivia Bennett" seçim yapar
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.oliviaBennettDoctorOption.click();
        extentTest.info("Doktor dropdown menüsüne tıklayarak Olivia Bennett seçim yapar");

        //8)Create Message textbox'ına text girer
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("004_AppointmentMessage"));
        extentTest.info("Create Message textbox'ına text girer");

        //9)"Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tıklar");

        //10)Randevu talebi oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(),"Telefon numarası girilmeden randevu oluşturuldu");
        extentTest.fail("Randevu talebi oluşturulamadığını doğrular");

        //11)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //12)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC018_11() {

        HomePage homePage = new HomePage();
        MedicinesPage medicinesPage = new MedicinesPage();
        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
        extentTest = extentReports.createTest("Appointment Booking formunda randevu mesajı girilmeden randevu talebi oluşturulamaması testi","Kullanıcı 'Appointment Booking' formuna randevu mesajı girmeden randevu talebi oluşturamamalı");

        //1)Kullanıcı ilgili Url ile siteye giriş yapar
        //2)Header bölümünden ""Sign In"" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validUserEmail"));
        extentTest.info("Kullanici LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de Header bölümünde bulunan "Medicines" linkine tıklayarak Medicines sayfasına gider
        homePage.headerMedicines.click();
        extentTest.info("Header bölümünde bulunan Medicines linkine tıklar");

        //5)Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider
        medicinesPage.medicinesFirstMedicinesName.click();
        extentTest.info("Seçilen ilaç ismine tıklayarak ilgili ilaç sayfasına gider");

        //6)"Appointment Booking" formunda takvimli tarih seçiden geçerli tarih seçer
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("004_validDate"));
        extentTest.info("Appointment Booking formunda takvimli tarih seçiciden geçerli tarih seçer");

        //7)Phone Number textbox'ına geçerli telefon numarası girer
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("004_validPhoneNumber"));
        extentTest.info("Phone Number textbox'ına geçerli telefon numarası girer");

        //8)Wellnes dropdown menüsüne tıklayarak "Anaesthesia" seçim yapar
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.anaesthesiaDepartmentOption.click();
        extentTest.info("Wellnes dropdown menüsüne tıklayarak Anaesthesia seçim yapar");

        //9)Doktor dropdown menüsüne tıklayarak "Olivia Bennett" seçim yapar
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.oliviaBennettDoctorOption.click();
        extentTest.info("Doktor dropdown menüsüne tıklayarak Olivia Bennett seçim yapar");

        //10)"Appointment Booking" butonuna tıklar
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment Booking butonuna tıklar");

        //11)Randevu talebi oluşturulamadığını doğrular
        softAssert.assertFalse(appointmentBookingFormPage.confirmationMessage.isDisplayed(),"Randevu mesajı alanı doldurulmadan randevu oluşturuldu");
        extentTest.fail("Randevu talebi oluşturulamadığını doğrular");

        //12)Header bölümünden "Sign Out" butonuna basarak çıkış yapar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna basarak çıkış yapar");

        softAssert.assertAll();

        //13)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

}