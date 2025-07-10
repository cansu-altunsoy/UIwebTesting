package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import pages.DepartmentsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class US_014 {


    @Test
    public void US_014_TC01_NavigateToDepartmentsFromHeader() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar
        HomePage homepage = new HomePage();
        homepage.headerDepartments.click();

        //departman sayfasına gittiğini doğrular
        ReusableMethods.verifyURL(driver,"https://qa.loyalfriendcare.com/en/Departments");

        //signout
        ReusableMethods.singOut();

    }

    @Test
    public void US_014_TC02_NavigateToDepartmentsFromBody() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //body'deki departmana tıklar
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //departman sayfasına gittiğini doğrular
        ReusableMethods.verifyURL(driver,"https://qa.loyalfriendcare.com/en/Departments");

        //signout
        ReusableMethods.singOut();


    }

    @Test
    public void US_014_TC03_ValidateDepartmentsList() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //departman sayfasına gittiğini doğrular
        ReusableMethods.verifyURL(driver,"https://qa.loyalfriendcare.com/en/Departments");

        //signout
        ReusableMethods.singOut();
    }

    @Test
    public void US_014_TC04_ValidateFirstDepartmentBeds() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //departman sayfasına gittiğini doğrular
        ReusableMethods.verifyURL(driver,"https://qa.loyalfriendcare.com/en/Departments");

        //ilk departmana tıklar
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        //departmanları görüntüler
        ReusableMethods.verifyURL(driver,"https://qa.loyalfriendcare.com/en/Departments/wellness");

        //signout
        ReusableMethods.singOut();
    }

    @Test
    public void US_014_TC05_ViewDepartmentDetails() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //departman sayfasına gittiğini doğrular
        ReusableMethods.verifyURL(driver,"https://qa.loyalfriendcare.com/en/Departments");

        //ilk departmana tıklar ve doğrular

        // yataklı departmanlara gider ve doğrular

        //signout
        ReusableMethods.singOut();

    }

    @Test
    public void US_014_TC06_CreateAppointmentWithValidData() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar ve doğrular
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //ilk departmana tıklar ve doğrular
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        // yataklı departmanlara gider ve doğrular
        departmentspage.firstBedDepartment.click();

        //form görüntülenir ve ilgili alanlar doldurulur

        //form doldurulur ve onay mesajı görüntülenir

        //signout
        ReusableMethods.singOut();

    }

    @Test
    public void US_014_TC07_CreateAppointmentWithEmptyFields() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar ve doğrular
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //ilk departmana tıklar ve doğrular
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        // yataklı departmanlara gider ve doğrular
        departmentspage.firstBedDepartment.click();

        //form görüntülenir ve ilgili alanlar boş bırakılır

        //form gönderilir ve hata mesajı görüntülenir

        //signout
        ReusableMethods.singOut();



    }

    @Test
    public void US_014_TC08_CreateAppointmentWithInvalidDate() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar ve doğrular
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //ilk departmana tıklar ve doğrular
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        // yataklı departmanlara gider ve doğrular
        departmentspage.firstBedDepartment.click();

        //form görüntülenir ve ilgili alanlar doldurulur

        //form gönderilir ve hata mesajı görüntülenir

        //signout
        ReusableMethods.singOut();

    }

    @Test
    public void US_014_TC09_CreateAppointmentWithoutDate() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar ve doğrular
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //ilk departmana tıklar ve doğrular
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        // yataklı departmanlara gider ve doğrular
        departmentspage.firstBedDepartment.click();

        //form görüntülenir ve ilgili alanlar doldurulur

        //form gönderilir ve hata mesajı görüntülenir

        //signout
        ReusableMethods.singOut();

    }

    @Test
    public void US_014_TC10_CreateAppointmentWithInvalidPhoneNumber() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar ve doğrular
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //ilk departmana tıklar ve doğrular
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        // yataklı departmanlara gider ve doğrular
        departmentspage.firstBedDepartment.click();

        //form görüntülenir ve ilgili alanlar doldurulur

        //form gönderilir ve hata mesajı görüntülenir

        //signout
        ReusableMethods.singOut();

    }

    @Test
    public void US_014_TC11_CreateAppointmentWithoutPhoneNumber() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar ve doğrular
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //ilk departmana tıklar ve doğrular
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        // yataklı departmanlara gider ve doğrular
        departmentspage.firstBedDepartment.click();

        //form görüntülenir ve ilgili alanlar doldurulur

        //form gönderilir ve hata mesajı görüntülenir

        //signout
        ReusableMethods.singOut();

    }

    @Test
    public void US_014_TC12_CreateAppointmentWithoutMessage() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validUserEmail"));

        //header'deki departmana tıklar ve doğrular
        HomePage homepage = new HomePage();
        homepage.bodyDepartmentsLink.click();

        //ilk departmana tıklar ve doğrular
        DepartmentsPage departmentspage = new DepartmentsPage();
        departmentspage.firstDepartmentImage.click();

        // yataklı departmanlara gider ve doğrular
        departmentspage.firstBedDepartment.click();

        //form görüntülenir ve ilgili alanlar doldurulur

        //form gönderilir ve hata mesajı görüntülenir

        //signout
        ReusableMethods.singOut();

    }
}