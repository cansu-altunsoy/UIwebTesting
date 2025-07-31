package tests.UI_FUNC_001;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminHomePage;
import pages.AdminRolesPages;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_024 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    AdminHomePage adminHomePage = new AdminHomePage();
    AdminRolesPages adminRolesPages = new AdminRolesPages();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC024_01() {

        HomePage homePage = new HomePage();
        AdminHomePage adminHomePage = new AdminHomePage();
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        extentTest = extentReports.createTest("Yeni rol oluşturma testi","Admin gerekli alanları doldurarak yeni bir rol oluşturabilmeli");

        //1)Admin ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validAdminEmail"));
        extentTest.info("Admin LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de header bölümünde "yöneticiAdı" butonuna tıklayarak admin paneline erişir
        homePage.headerAdminNameButton.click();
        extentTest.info("Home Page'de header bölümünde yöneticiAdı butonuna tıklayarak admin paneline erişir");

        //5)Sol açılır dashboard menüde "Roles" başlığına tıklar
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        ReusableMethods.bekle(2);
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sol açılır dashboard menüde 'Roles' başlığına tıklar");

        //6)Roles başlığı altında açılan "Create Role" alt başlığına tıklar
        adminRolesPages.dashboardRolesCreateRoles.click();
        extentTest.info("Roles başlığı altında açılan 'Create Role' alt başlığına tıklar");

        //7)Create your role formunda "Name" textbox'ına name girer
        adminRolesPages.nameTextBox.sendKeys(ConfigReader.getProperty("004_RoleName"));
        extentTest.info("Create your role formunda 'Name' textbox'ına name girer");

        //8)Create your role formunda "Display Name" textbox'ına display name girer
        adminRolesPages.displayNameTextBox.sendKeys(ConfigReader.getProperty("004_RoleDisplayName"));
        extentTest.info("Create your role formunda 'Display Name' textbox'ına display name girer");

        //9)"Save" butonuna tıklar
        adminRolesPages.createRoleSaveButton.click();
        extentTest.info("Save butonuna tıklar");

        //10)Başarılı bir şekilde yeni rol oluşturulduğunu doğrular
        softAssert.assertTrue(adminRolesPages.roleStoreSuccessfullyMessage.isDisplayed(),"Role Store successfully. mesaji görüntülenemedi");
        extentTest.pass("Başarılı bir şekilde yeni rol oluşturulduğunu doğrular");

        //11)"Role Store succesfully." mesajını kapatır
        adminRolesPages.closeRoleStoreSuccessfullyMessage.click();
        extentTest.info("Role Store succesfully mesajını kapatır");

        //11)Profil dropdown butonuna tıklar
        //12)Dropdown menüden Log Out linkine tıklar
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Log Out linkine tıklar");

        //13)Home Page Header bölümünden Sign Out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tıklar");

        softAssert.assertAll();

        //14)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC024_02() {

        HomePage homePage = new HomePage();
        AdminHomePage adminHomePage = new AdminHomePage();
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        extentTest = extentReports.createTest("Tüm zorunlu alanlar boş bırakıldığında bir rol oluşturulamaması testi","Admin gerekli alanları doldurmadan yeni bir rol oluşturamamalı");

        //1)Admin ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validAdminEmail"));
        extentTest.info("Admin LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de header bölümünde "yöneticiAdı" butonuna tıklayarak admin paneline erişir
        homePage.headerAdminNameButton.click();
        extentTest.info("Home Page'de header bölümünde yöneticiAdı butonuna tıklayarak admin paneline erişir");

        //5)Sol açılır dashboard menüde "Roles" başlığına tıklar
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        ReusableMethods.bekle(2);
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sol açılır dashboard menüde 'Roles' başlığına tıklar");

        //6)Roles başlığı altında açılan "Create Role" alt başlığına tıklar
        adminRolesPages.dashboardRolesCreateRoles.click();
        extentTest.info("Roles başlığı altında açılan 'Create Role' alt başlığına tıklar");

        //7)"Create your role" formunda "Save" butonuna tıklar
        adminRolesPages.createRoleSaveButton.click();
        extentTest.info("Create your role formunda Save butonuna tıklar");

        //8)Yeni bir rol oluşturulamadığını doğrular
        String unExpectedUrl = "https://qa.loyalfriendcare.com/en/Dashboard/Roles";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(actualUrl,unExpectedUrl,"UnExpected URL");
        extentTest.pass("Yeni bir rol oluşturulamadığını doğrular");

        //9)Profil dropdown butonuna tıklar
        //10)Dropdown menüden Log Out linkine tıklar
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Log Out linkine tıklar");

        //11)Home Page Header bölümünden Sign Out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tıklar");

        softAssert.assertAll();

        //12)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC024_03() {

        HomePage homePage = new HomePage();
        AdminHomePage adminHomePage = new AdminHomePage();
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        extentTest = extentReports.createTest("'Name' zorunlu alanı doldurulmadan yeni rol oluşturulamaması testi","Admin zorunlu alan olan 'Name' kutusu boş olduğunda yeni bir rol oluşturamamalı");

        //1)Admin ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validAdminEmail"));
        extentTest.info("Admin LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de header bölümünde "yöneticiAdı" butonuna tıklayarak admin paneline erişir
        homePage.headerAdminNameButton.click();
        extentTest.info("Home Page'de header bölümünde yöneticiAdı butonuna tıklayarak admin paneline erişir");

        //5)Sol açılır dashboard menüde "Roles" başlığına tıklar
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        ReusableMethods.bekle(2);
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sol açılır dashboard menüde 'Roles' başlığına tıklar");

        //6)Roles başlığı altında açılan "Create Role" alt başlığına tıklar
        adminRolesPages.dashboardRolesCreateRoles.click();
        extentTest.info("Roles başlığı altında açılan 'Create Role' alt başlığına tıklar");

        //7) "Display Name" textbox'ına display name girer
        adminRolesPages.displayNameTextBox.sendKeys(ConfigReader.getProperty("004_RoleDisplayName"));
        extentTest.info("Create your role formunda 'Display Name' textbox'ına display name girer");

        //8)"Save" butonuna tıklar
        adminRolesPages.createRoleSaveButton.click();
        extentTest.info("Save butonuna tıklar");

        //9)Yeni bir rol oluşturulmadığını doğrular
        String unExpectedUrl = "https://qa.loyalfriendcare.com/en/Dashboard/Roles";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(actualUrl,unExpectedUrl,"UnExpected URL");
        extentTest.pass("Yeni bir rol oluşturulmadığını doğrular");

        //10)Profil dropdown butonuna tıklar
        //11)Dropdown menüden Log Out linkine tıklar
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Log Out linkine tıklar");

        //12)Home Page Header bölümünden Sign Out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tıklar");

        softAssert.assertAll();

        //13)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC024_04() {

        HomePage homePage = new HomePage();
        AdminHomePage adminHomePage = new AdminHomePage();
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        extentTest = extentReports.createTest("'Display Name' zorunlu alanı doldurulmadan yeni rol oluşturulamaması testi","Admin zorunlu alan olan 'Display Name' kutusu boş olduğunda yeni bir rol oluşturamamalı");

        //1)Admin ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validAdminEmail"));
        extentTest.info("Admin LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de header bölümünde "yöneticiAdı" butonuna tıklayarak admin paneline erişir
        homePage.headerAdminNameButton.click();
        extentTest.info("Home Page'de header bölümünde yöneticiAdı butonuna tıklayarak admin paneline erişir");

        //5)Sol açılır dashboard menüde "Roles" başlığına tıklar
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        ReusableMethods.bekle(2);
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sol açılır dashboard menüde 'Roles' başlığına tıklar");

        //6)Roles başlığı altında açılan "Create Role" alt başlığına tıklar
        adminRolesPages.dashboardRolesCreateRoles.click();
        extentTest.info("Roles başlığı altında açılan 'Create Role' alt başlığına tıklar");

        //7)"Name" textbox'ına name girer
        adminRolesPages.nameTextBox.sendKeys(ConfigReader.getProperty("004_RoleName"));
        extentTest.info("'Name' textbox'ına name girer");

        //8)"Save" butonuna tıklar
        adminRolesPages.createRoleSaveButton.click();
        extentTest.info("Save butonuna tıklar");

        //9)Yeni bir rol oluşturulmadığını doğrular
        String unExpectedUrl = "https://qa.loyalfriendcare.com/en/Dashboard/Roles";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(actualUrl,unExpectedUrl,"UnExpected URL");
        extentTest.pass("Yeni bir rol oluşturulmadığını doğrular");

        //10)Profil dropdown butonuna tıklar
        //11)Dropdown menüden Log Out linkine tıklar
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Log Out linkine tıklar");

        //12)Home Page Header bölümünden Sign Out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tıklar");

        softAssert.assertAll();

        //13)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC024_05() {

        HomePage homePage = new HomePage();
        AdminHomePage adminHomePage = new AdminHomePage();
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        extentTest = extentReports.createTest("Yeni oluşturulan rolü Roles listesinde görüntüleme testi","Admin yeni oluşturulan rolü Rols sayfasındaki arama kutusuna rol adını yazarak görüntüleyebilmeli");

        //1)Admin ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validAdminEmail"));
        extentTest.info("Admin LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de header bölümünde "yöneticiAdı" butonuna tıklayarak admin paneline erişir
        homePage.headerAdminNameButton.click();
        extentTest.info("Home Page'de header bölümünde yöneticiAdı butonuna tıklayarak admin paneline erişir");

        //5)Sol açılır dashboard menüde "Roles" başlığına tıklar
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        ReusableMethods.bekle(2);
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sol açılır dashboard menüde 'Roles' başlığına tıklar");

        //6)Roles başlığı altında açılan "Create Role" alt başlığına tıklar
        adminRolesPages.dashboardRolesCreateRoles.click();
        extentTest.info("Roles başlığı altında açılan 'Create Role' alt başlığına tıklar");

        //7)Yeni bir oluşturur
        adminRolesPages.nameTextBox.sendKeys(ConfigReader.getProperty("004_RoleName2"));
        adminRolesPages.displayNameTextBox.sendKeys(ConfigReader.getProperty("004_RoleDisplayName"));
        adminRolesPages.createRoleSaveButton.click();
        extentTest.info("Yeni bir oluşturur");

        //11)"Role Store succesfully." mesajını kapatır
        adminRolesPages.closeRoleStoreSuccessfullyMessage.click();
        extentTest.info("Role Store succesfully mesajını kapatır");
        
        //8)Roles sayfasında search box'a oluşturduğu rolün adını girer
        adminRolesPages.rolesSearchBox.sendKeys(ConfigReader.getProperty("004_RoleName"));
        extentTest.info("Roles sayfasında search box'a oluşturduğu rolün adını girer");

        //9)Girdiği adın Table Roles tablosunda görünür olduğunu doğrular
        softAssert.assertFalse(adminRolesPages.rolesSearchNoResultFound.isDisplayed(),"Oluşturulan rol tabloda görüntülenemedi");
        extentTest.fail("Girdiği adın Table Roles tablosunda görünür olduğunu doğrular");

        //10)Profil dropdown butonuna tıklar
        //11)Dropdown menüden Log Out linkine tıklar
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Log Out linkine tıklar");

        //12)Home Page Header bölümünden Sign Out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tıklar");

        softAssert.assertAll();

        //13)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }

    @Test
    public void TC024_06() {

        HomePage homePage = new HomePage();
        AdminHomePage adminHomePage = new AdminHomePage();
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        extentTest = extentReports.createTest("Aynı isimle birden fazla rol oluşturulamaması testi","Admin aynı isimle birden fazla rol oluşturamamalı");

        //1)Admin ilgili Url ile siteye giriş yapar
        //2)Header bölümünden "Sign In" butonuna basarak Login sayfasına gider
        //3)Geçerli email ve password ile login olur
        ReusableMethods.signIn(ConfigReader.getProperty("004_validAdminEmail"));
        extentTest.info("Admin LoyalFriendCare anasayfaya gider ve login olur");

        //4)Home Page'de header bölümünde "yöneticiAdı" butonuna tıklayarak admin paneline erişir
        homePage.headerAdminNameButton.click();
        extentTest.info("Home Page'de header bölümünde yöneticiAdı butonuna tıklayarak admin paneline erişir");

        //5)Sol açılır dashboard menüde "Roles" başlığına tıklar
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        ReusableMethods.bekle(2);
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sol açılır dashboard menüde 'Roles' başlığına tıklar");

        //6)Roles başlığı altında açılan "Create Role" alt başlığına tıklar
        adminRolesPages.dashboardRolesCreateRoles.click();
        extentTest.info("Roles başlığı altında açılan 'Create Role' alt başlığına tıklar");

        //7)Yeni bir rol oluşturur
        adminRolesPages.nameTextBox.sendKeys(ConfigReader.getProperty("004_RoleName3"));
        adminRolesPages.displayNameTextBox.sendKeys(ConfigReader.getProperty("004_RoleDisplayName"));
        adminRolesPages.createRoleSaveButton.click();
        extentTest.info("Yeni bir rol oluşturur");

        //8)Roles sayfasında "Add Role" butonuna tıklar
        adminRolesPages.addRoleButton.click();
        extentTest.info("Roles sayfasında 'Add Role' butonuna tıklar");

        //9)(7.adımda girmiş olduğu) aynı dataları girerek save butonuna tıklar
        adminRolesPages.nameTextBox.sendKeys(ConfigReader.getProperty("004_RoleName3"));
        adminRolesPages.displayNameTextBox.sendKeys(ConfigReader.getProperty("004_RoleDisplayName"));
        adminRolesPages.createRoleSaveButton.click();
        extentTest.info("(7.adımda girmiş olduğu) aynı dataları girerek save butonuna tıklar");

        //10)Aynı isimle birden fazla rol oluşturulamadığını doğrular
        softAssert.assertTrue(adminRolesPages.theNameHasAlreadyBeenTakenMessage.isDisplayed(),"The name has already been taken. mesajı görüntülenmedi");
        extentTest.pass("Aynı isimle birden fazla rol oluşturulamadığını doğrular");

        //11)Profil dropdown butonuna tıklar
        //12)Dropdown menüden Log Out linkine tıklar
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Log Out linkine tıklar");

        //13)Home Page Header bölümünden Sign Out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign Out butonuna tıklar");

        softAssert.assertAll();
        
        //14)Sayfayı kapatır
        extentTest.info("Sayfayı kapatır");
    }
}
