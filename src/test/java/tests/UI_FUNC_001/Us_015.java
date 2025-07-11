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

public class Us_015 extends TestBaseRapor {


    HomePage homePage = new HomePage();
    DepartmentsPage departmentsPage = new DepartmentsPage();
    AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001NavigateToDepartments(){
        extentTest = extentReports.createTest("Departments text in the header section functionality test",
                "The Departments text in the header should be functional");

        //1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)“Departments” metninin Header bölümünde görünür oldugunu dogrular
        softAssert.assertTrue( homePage.headerDepartments.isDisplayed(), "Unable to display departments text");
        extentTest.info("Kullanici Departments metnini goruntuler");

        //3-)“Departments” metnine tıklar
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        ReusableMethods.singOut();
        softAssert.assertAll();

        //4-)Sayfayı kapat
        extentTest.info("Kullancici sistemi kapatir");
    }

    @Test
    public void TC_002DepartmentsPage(){

        extentTest = extentReports.createTest("Departments visibility test on the department page",
                "Departments should be visible on the department page");

        //1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)“Departments” metninin Header bölümünde görünür oldugunu dogrular
        softAssert.assertTrue( homePage.headerDepartments.isDisplayed(), "Unable to display departments text");
        extentTest.info("Kullanici Departments metnini goruntuler");

        //3-)“Departments” metinine tıklar
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //4-)Departments  sayfasında oldugunu dogrular
        softAssert.assertTrue( departmentsPage.departmentMenuTitle.isDisplayed(), "User could not access the department page");
        extentTest.pass("Kullanici Departments sayfasinda oldugunu dogrular");

        ReusableMethods.bekle(1);
        //5-)Departmanların görünürlügü dogrulanır
        List<WebElement> departmantList = Driver.getDriver().findElements(By.xpath("//*[@class='col-lg-9']"));

        for (WebElement eachdepartmant : departmantList) {

            softAssert.assertTrue(eachdepartmant.isDisplayed());

        }
        extentTest.pass("Kullanici Departments sayfasında deparmanlarin gorunur oldugunu dogrular");
        ReusableMethods.singOut();

        softAssert.assertAll();

        //6-)Sayfayı kapatır
        extentTest.info("Kullancici sistemi kapatir");
    }

    @Test
    public void TC_003DepartmentsPage(){
        extentTest = extentReports.createTest("Departments visibility test on the department page",
                "Departments should be visible on the department page");

        //1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
      //  extentTest.info("Kullanici sisteme giris yapar");

        //2-)“Departments” metninin Header bölümünde görünür oldugunu dogrular
        softAssert.assertTrue( homePage.headerDepartments.isDisplayed(), "Unable to display departments text");
        extentTest.info("Kullanici Departments metnini goruntuler");

        //3-)“Departments” metinine tıklar
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //4-)Departments  sayfasında oldugunu dogrular
        softAssert.assertTrue( departmentsPage.departmentMenuTitle.isDisplayed(),
                "User could not access the department page");
        extentTest.pass("Kullanici Departments sayfasinda oldugunu dogrular");

        //5-)Departmana tıklar
        departmentsPage.departmentFirst.click();
        extentTest.info("Kullanici Departmana tiklar");

        //6-)Departman sayfasında oldugunu doğrular
        softAssert.assertTrue( departmentsPage.deparmentFirstIcon.isDisplayed(),
                "unable to access the requested department page");
        extentTest.pass("Kullanici Departments sayfasinda oldugunu dogrular");

        //7-)Sistemi kapatır
        ReusableMethods.singOut();
        extentTest.info("Kullancici sistemi kapatir");

    }

    @Test
    public void TC_004DepartmentAppointmentForm(){

        extentTest = extentReports.createTest("Departments Appointment Booking visibility test department page",
                "Departments should be visible on the department page");

        //1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)Header bölümünde “Departments” metnine tıkla
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //3-)Departman sayfasında oldugunu dogrular
        softAssert.assertTrue( departmentsPage.departmentMenuTitle.isDisplayed(),
                "User could not access the department page");
        extentTest.pass("Kullanici Departments sayfasinda oldugunu dogrular");

        //4-)Departmana tıklar
        departmentsPage.departmentFirst.click();
        extentTest.info("Kullanici Departmana tiklar");

        //5-)Appointment Booking formunu görüntüle
        softAssert.assertTrue( appointmentBookingFormPage.appointmentBookingText.isDisplayed(),
                "Unable to access Appointment Booking form");
        extentTest.pass("Kullanici appointment booking formunu goruntuler");

        //6-)Tarih input Textbox'ının fonksiyonel oldugunu dogrular
        softAssert.assertTrue(appointmentBookingFormPage.dateDdm.isEnabled(),
                "web element is not functional");
        extentTest.pass("Tarih textboxinin fonksiyonel oldugunu dogrular");

        //7-)Telefon input Textbox'ının fonksiyonel oldugunu dogrular
        softAssert.assertTrue(appointmentBookingFormPage.phoneBox.isEnabled(),
                "web element is not functional");
        extentTest.pass("Telefon textboxinin fonksiyonel oldugunu dogrular");

        //8-)Departman input Checkbox'ının fonksiyonel oldugunu dogrular
        softAssert.assertTrue(appointmentBookingFormPage.appointmentDepartmentsDdm.isEnabled(),
                "web element is not functional");
        extentTest.pass("Depatman checkbox fonksiyonel oldugunu dogrular");

        //9-)Doktor input CheckBox'ının fonksiyonel oldugunu dogrular
        softAssert.assertTrue(appointmentBookingFormPage.appointmentDoctorsDdm.isEnabled(),
                "web element is not functional");
        extentTest.pass("Doktor checkbox fonksiyonel oldugunu dogrular");

        //10-)Mesaj texbox'ının fonksiyonel oldugunu dogrular
        softAssert.assertTrue(appointmentBookingFormPage.messageBox.isEnabled(),
                "web element is not functional");
        extentTest.pass("Mesaj textboxinin fonksiyonel oldugunu dogrular");

        //11-)"Appointment Booking" butonuna fonksiyonel oldugunu dogrular
        softAssert.assertTrue(appointmentBookingFormPage.appointmentBookingButton.isEnabled(),
                "web element is not functional");
        extentTest.pass("Appointment booking butonunun fonksiyonel oldugunu dogrular");

        ReusableMethods.singOut();

        //12-)Sistemi kapatır
        extentTest.info("Kullancici sistemi kapatir");

    }

    @Test
    public void TC_005DepartmentAppointBookingFormCreateValidData(){

        extentTest = extentReports.createTest("Departments Appointment Booking create valid data ",
                "Departments should be visible on the department page");

        //1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)Header bölümünde “Departments” metnine tıkla
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //3-)Departmana tıklar
        departmentsPage.departmentFirst.click();
        extentTest.info("Kullanici Departmana tiklar");

        //4-)Appointment Booking formunu görüntüle
        softAssert.assertTrue( appointmentBookingFormPage.appointmentBookingText.isDisplayed(),
                "Unable to access Appointment Booking form");
        extentTest.pass("Kullanici appointment booking formunu goruntuler");

        //5-)Tarih input Textbox'ında tarih seç
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("001_validDate"));
        extentTest.pass("Tarih textboxinin gecerli tarih bilgisi girer");

        //6-)Telefon input Textbox'ına telefon numarası gir
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("001_validPhoneNumber"));
        extentTest.pass("Telefon textboxinin gecerli telefon bilgisi girer");

        //7-)Departman input Checkbox'ından department seç
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        extentTest.pass("Departman checkboxindan departman secer");

        //8-)Doktor input CheckBox'ından doktor seç
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.pass("Doktor checkboxindan doktor secer");

        //9-)Mesaj texbox'ına randevu mesajını mesaj yaz
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("001_AppointmentMessage"));
        extentTest.pass("Mesaj textboxina mesajini girer");

        //10-)"Appointment Booking" butonuna tıkla
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.pass("Appointment booking butonunun tiklar");

        //11-)Randevu onay mesajını görüntüle
        softAssert.assertTrue(appointmentBookingFormPage.confirmationMessage.isEnabled(),
                "appointment confirmation message not displayed");
        extentTest.pass("Kullanici randevu onay mesajini goruntuler");

        ReusableMethods.singOut();

        //12-)Sistemi kapat
        extentTest.info("Kullancici sistemi kapatir");
    }

    @Test
    public void TC_006AppointBookingFormCreateHistoryDate(){

        extentTest = extentReports.createTest("Departments Appointment Booking create history date ",
                "Departments should be visible on the department page");

        //1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)Header bölümünde “Departments” metnine tıkla
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //3-)Departmana tıklar
        departmentsPage.departmentFirst.click();
        extentTest.info("Kullanici Departmana tiklar");

        //4-)Appointment Booking formunu görüntüle
        softAssert.assertTrue( appointmentBookingFormPage.appointmentBookingText.isDisplayed(),
                "Unable to access Appointment Booking form");
        extentTest.pass("Kullanici appointment booking formunu goruntuler");

        //5-)Tarih input Textbox'ında geçmiş tarih seç
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("001_InvalidDate"));
        extentTest.fail("Tarih textboxina gecmis tarih bilgisi girer");

        //6-)Telefon input Textbox'ına telefon numarası gir
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("001_validPhoneNumber"));
        extentTest.pass("Telefon textboxinin gecerli telefon bilgisi girer");

        //7-)Departman input Checkbox'ından department seç
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        extentTest.pass("Departman checkboxindan departman secer");

        //8-)Doktor input CheckBox'ından doktor seç
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.pass("Doktor checkboxindan doktor secer");

        //9-)Mesaj texbox'ına mesaj yaz
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("001_AppointmentMessage"));
        extentTest.pass("Mesaj textboxina mesajini girer");

        //10-)"AppointBooking" butonuna tıkla
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.pass("Appointment booking butonunun tiklar");

        //11-)Randevu oluşturalamadıgı uyarı mesajını görüntüle
        String expectedUyariMesaj = "appointment not available";
        String actualUyariMesaj;
        actualUyariMesaj = Driver.getDriver().switchTo().alert().getText();

        softAssert.assertEquals(actualUyariMesaj,expectedUyariMesaj);
        extentTest.pass("Kullanici randevu red mesajini goruntuler");

        //12-)Sistemi kapat
        ReusableMethods.singOut();
        extentTest.info("Kullancici sistemi kapatir");


    }


    @Test
    public void TC_007AppointBookingForm_CretaNonSdandartPhoneNumber(){

        extentTest = extentReports.createTest("Departments Appointment Booking create NonSdandartPhoneNumber ",
                "Departments should be visible on the department page");

        //1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)Header bölümünde “Departments” metnine tıkla
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //3-)Departmana tıklar
        departmentsPage.departmentFirst.click();
        extentTest.info("Kullanici Departmana tiklar");

        //4-)Appointment Booking formunu görüntüle
        softAssert.assertTrue( appointmentBookingFormPage.appointmentBookingText.isDisplayed(),
                "Unable to access Appointment Booking form");
        extentTest.pass("Kullanici appointment booking formunu goruntuler");

        //5-)Tarih input Textbox'ında seç
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("001_validDate"));
        extentTest.pass("Tarih textboxinin gecerli tarih bilgisi girer");

        //6-)Telefon input Textbox'ına standart dısı telefon numarası gir
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("001_InvalidPhoneNumber"));
        extentTest.fail("Telefon textboxinin standart dısı telefon numarası girer");

        //7-)Departman input Checkbox'ından department seç
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        extentTest.pass("Departman checkboxindan departman secer");

        //8-)Doktor input CheckBox'ından doktor seç
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.pass("Doktor checkboxindan doktor secer");

        //9-)Mesaj texbox'ına mesaj yaz
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("001_AppointmentMessage"));
        extentTest.pass("Mesaj textboxina mesajini girer");

        //10-)"AppointBooking" butonuna tıkla
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.pass("Appointment booking butonunun tiklar");

        //11-)Randevu oluşturalamadıgı uyarı mesajını görüntüle
        String expectedUyariMesaj = "appointment not available";
        String actualUyariMesaj;
        actualUyariMesaj = Driver.getDriver().switchTo().alert().getText();

        softAssert.assertEquals(actualUyariMesaj,expectedUyariMesaj);
        extentTest.pass("Kullanici randevu red mesajini goruntuler");

        //12-)Sistemi kapat
        ReusableMethods.singOut();
        extentTest.info("Kullancici sistemi kapatir");

    }

    @Test
    public void TC_008AppointBookingFormCretaNonSdandartPhoneNumber(){

        extentTest = extentReports.createTest("Departments Appointment Booking create alphaNumericPhoneNumber ",
                "Departments should be visible on the department page");

        // 1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)Header bölümünde “Departments” metnine tıkla
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //3-)Departmana tıklar
        departmentsPage.departmentFirst.click();
        extentTest.info("Kullanici Departmana tiklar");

        //4-)Appointment Booking formunu görüntüle
        softAssert.assertTrue( appointmentBookingFormPage.appointmentBookingText.isDisplayed(),
                "Unable to access Appointment Booking form");
        extentTest.pass("Kullanici appointment booking formunu goruntuler");

        //5-)Tarih input Textbox'ında  tarih bilgisi gir
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("001_validDate"));
        extentTest.info("Tarih textboxinin gecerli tarih bilgisi girer");

        //6-)Telefon input Textbox'ına alfanümerik karekterler gir
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("001_alphaNumericNumber"));
        extentTest.info("Telefon textboxinin alfanümerik numara girer");

        //7-)Departman input Checkbox'ından department seç
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
           ReusableMethods.bekle(1);
        extentTest.info("Departman checkboxindan departman secer");

        //8-)Doktor input CheckBox'ından doktor seç
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.pass("Doktor checkboxindan doktor secer");

        //9-)Mesaj texbox'ına mesaj yaz
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("001_AppointmentMessage"));
        extentTest.info("Mesaj textboxina mesajini girer");

        //10-)"AppointBooking" butonuna tıkla
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment booking butonunun tiklar");

        //11-)Randevu oluşturalamadıgı uyarı mesajını görüntüle
        String expectedUyariMesaj = "appointment not available";
        String actualUyariMesaj;
        actualUyariMesaj = Driver.getDriver().switchTo().alert().getText();

        softAssert.assertEquals(actualUyariMesaj,expectedUyariMesaj);
        extentTest.pass("Kullanici randevu red mesajini goruntuler");

        //12-)Sistemi kapat
        ReusableMethods.singOut();
        extentTest.info("Kullancici sistemi kapatir");

    }

    @Test
    public void TC_009AppointBookingFormCretaEmptyMessage(){

        extentTest = extentReports.createTest("Departments Appointment Booking create EmptyData ",
                "Departments should be visible on the department page");

        // 1-)Kullanıcı sisteme giriş yapar
        ReusableMethods.signIn(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici sisteme giris yapar");

        //2-)Header bölümünde “Departments” metnine tıkla
        homePage.headerDepartments.click();
        extentTest.info("Kullanici Departments metnine tiklar");

        //3-)Departmana tıklar
        departmentsPage.departmentFirst.click();
        extentTest.info("Kullanici Departmana tiklar");

        //4-)Appointment Booking formunu görüntüle
        softAssert.assertTrue( appointmentBookingFormPage.appointmentBookingText.isDisplayed(),
                "Unable to access Appointment Booking form");
        extentTest.pass("Kullanici appointment booking formunu goruntuler");

        //5-)Tarih input Textbox'ında tarih boş bırak
        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("001_emptyDate"));
        extentTest.pass("Tarih textboxinin tarih bilgisini bos birakir");

        //6-)Telefon input Textbox'ına telefon numarası boş bırak
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("001_emptyPhoneNumber"));
        extentTest.pass("Telefon textboxini bos birakir");

        //7-)Departman input  Checkbox'ından department seç
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        ReusableMethods.bekle(1);
        extentTest.pass("Departman checkboxindan departmani bos secer");

        //8-)Doktor input CheckBox'ından doktor seç
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        extentTest.pass("Doktor checkboxindan doktor secmez");

        //9-)Mesaj texbox'ını boş bırak
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("001_emptyMessage"));
        extentTest.pass("Mesaj textboxina mesajini bos birakir");

        //10-)"AppointBooking" butonuna tıkla
        appointmentBookingFormPage.appointmentBookingButton.click();
        extentTest.info("Appointment booking butonunun tiklar");

        //11-)Randevu oluşturalamadıgı uyarı mesajını görüntüle
        String expectedUyariMesaj = "appointment not available";
        String actualUyariMesaj;
        actualUyariMesaj = Driver.getDriver().switchTo().alert().getText();

        softAssert.assertEquals(actualUyariMesaj,expectedUyariMesaj);
        extentTest.pass("Kullanici randevu red mesajini goruntuler");

        //12-)Sistemi kapat
        ReusableMethods.singOut();
        extentTest.info("Kullancici sistemi kapatir");

    }



}
