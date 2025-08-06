package tests.UI_FUNC_001;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDepartmentsPage;
import pages.AdminHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Us_30 extends TestBaseRapor {


    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_30_TC_001", "Sidebar Departments alt menüsü Ctreate Departments erişebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar. ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments alt menüsü Departments'a tıklar

        ReusableMethods.dashbordSidebarMenu();

        adminDepartmentsPage.dbrdDepartments.click();
        extentTest.info(" Sidebar Departments alt menüsü Departments'a tıklar");

        //4)  Sidebar Departments alt menüsü Create Departments'a tıklar.

        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar.");

        //5)Admin profile tıklar.
        //6) Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar, Logout butonuna tıklar");

        //7) Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır");

    }

    @Test
    public void TC_002() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_002", "İlgili sayfaya gidildiğinde sayfada New Departments yazısı görüntülenebilme");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar. ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider");

        //4) Sidebar Departments menüsüne ve  alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();

        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5) "New Departments" yazısının görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.newDepartments.isDisplayed(), "New Departments yazsısı görünür değil.");
        extentTest.pass("New Departments yazısının görünürlüğünü doğrular.");


        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar, Logout butonuna tıklar");

        //8) Logout butonuna tıklar

        ReusableMethods.singOut();
        extentTest.info("Logout butonuna tıklar");
        extentTest.info("sayfayı kapatır.");


    }

    @Test
    public void TC_003() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_30_TC_003", "Create Departments bölümündeki Parent departments box görünür olmalı");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));

        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar ");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider");

        //4) Sidebar Departments menüsüne ve alt menüsü Create Departments'a tıklar

        ReusableMethods.dashbordSidebarMenu();

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();

        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");


        //5) Parent box kutusunun görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.parentBox.isDisplayed(), "Parent box görünür değil.");
        extentTest.pass("Parent box kutusunun görünürlüğünü doğrular.");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar Logout butonuna tıklar");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");

    }

    @Test
    public void TC_004() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_004", "Create Departments bölümündeki Parent departments box'a data girebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();

        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        // 5) Parent Departments box'a data girer.

        adminDepartmentsPage.parentBox.sendKeys(ConfigReader.getProperty("005_ParentDep"));
        extentTest.info("Parent Departments box'a data girer");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar, Sign out butonuna tıklar.");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır.");

    }

    @Test
    public void TC_005() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_005", "Create Departments bölümündeki Order departments box'ın görünür olmalı");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info(" Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsüne ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5)Order departments box görünürlüğünü doğrular

        softAssert.assertTrue(adminDepartmentsPage.orderBox.isDisplayed(), "order box görünür değil");
        extentTest.pass("Order departments box görünürlüğünü doğrular.");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar.

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar.");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");

        softAssert.assertAll("order box görünürlüğü doğrulandı");
        extentTest.pass("order box görnürlüğü doğrulandı");
        extentTest.info("sayfayı kapatır.");

    }

    @Test
    public void TC_006() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_006", "Create Departments bölümündeki Order departments box'a data girebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info(" Admin anasayfaya gider,Geçerli email ve password ile giriş yapar");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5)Order departments box'a data girer

        adminDepartmentsPage.orderBox.sendKeys(ConfigReader.getProperty("005_OrderDep"));

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Order departments box'a data girer.");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");

        softAssert.assertAll("order box'a data girişi yapılabildi");
        extentTest.pass("order box'a data girişi yapılabildi.");
        extentTest.info("sayfayı kapatır.");

    }

    @Test
    public void TC_007() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_007", "Create Departments bölümündeki Tittle departments box'ın görüntülenebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info(" Admin anasayfaya gider,Geçerli email ve password ile giriş yapar");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5) Tittle departmens box görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.tittleBox.isDisplayed(), "title departments görünür değil");
        extentTest.pass("Tittle departmens box görünürlüğünü doğrular.");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");

        softAssert.assertAll("Title departments box'ın görünürlüğü doğrulandı.");
        extentTest.pass("Title departments box'ın görünürlüğü doğrulandı");
        extentTest.info("sayfayı kapatır.");
    }

    @Test
    public void TC_008() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_008", "Create Departments bölümündeki Tittle departments box'a data girebilme");


        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5) Tittle departmens box'a data girer.

        adminDepartmentsPage.tittleBox.sendKeys(ConfigReader.getProperty("005_TittleDep"));
        extentTest.info("Tittle departmens box'a data girer.");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");


        softAssert.assertAll("Title box'a data girişi yapılabildi");
        extentTest.pass("Title box'a data girişi yapılabildi");
        extentTest.info("sayfayı kapatır.");
    }

    @Test
    public void TC_009() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_009", "Create Departments bölümündeki Departments color dropdown menüsünün görüntülenebilmeli");


        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5) Color box görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.colorBox.isDisplayed(), "color box is not dısplayed");
        extentTest.info("Color box görünürlüğünü doğrular.");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");

        softAssert.assertAll("color box  görünürlüğü doğrulandı");
        extentTest.info("color box  görünürlüğü doğrulandı\"");
        extentTest.info("sayfayı kapatır.");


    }

    @Test
    public void TC_010() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_010", "Create Departments bölümündeki Departments color dropdown menüsünden secim yapılabilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");


        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info(" Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5)Color box'a tıklayarak renk seçimi yapar.

        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("Color box'a tıklayarak renk seçimi yapar.");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar.");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");

        softAssert.assertAll("Renk seçimi yapılabildi.");
        extentTest.pass("Renk seçimi yapılabildi.");
        extentTest.info("Sign out butonuna tıklar.");
    }

    @Test
    public void TC_011() throws AWTException {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_011", "Create Departments bölümündeki Departments color dropdown menüsünden secim yapılabilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info(" Admin anasayfaya gider.Geçerli email ve password ile giriş yapar");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsüne ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");


        // 5) Departmana ait bir foto yükler
        adminDepartmentsPage.imgUpload.click();

        Robot robot = new Robot(); // Robot class'i ile dosya yolu girilir
        String filePath = System.getProperty("user.home") + "\\Desktop\\cicek.png";

        // Dosya yolu kopyalanir
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // CTRL+V ile yapistirilir
        robot.keyPress(KeyEvent.VK_CONTROL);
        ReusableMethods.bekle(1);

        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);

        ReusableMethods.bekle(1);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // 'Enter' tusuna basilir
        ReusableMethods.bekle(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        ReusableMethods.bekle(3);
        extentTest.info("Departmana ait bir foto yükler");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();
        softAssert.assertAll("fotoğraf yüklenebildi");
        extentTest.pass("fotoğraf yüklenebildi");
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır.");


    }

    @Test
    public void TC_012() throws AWTException {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_30_TC_012", "Departman olusturabilme testi");

        //1) Admin anasayfaya gider
        //2) Geçerli email ve password ile giriş yapar

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        ReusableMethods.bekle(2);

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5)Parent departments box'a sayi girer
        adminDepartmentsPage.parentBox.sendKeys(ConfigReader.getProperty("005_ParentDep"));
        extentTest.info("Parent departments box'a sayi girer");

        //6) Order departments boxa sayı girer.
        adminDepartmentsPage.orderBox.sendKeys(ConfigReader.getProperty("005_OrderDep"));
        extentTest.info("Order departments boxa sayı girer.");

        //7) Title Departments boxa text girer.
        adminDepartmentsPage.tittleBox.sendKeys(ConfigReader.getProperty("005_TittleDep"));
        extentTest.info("Title Departments boxa text girer.");

        //8) color box'a tıklayarak renk secer.
        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("color box'a tıklayarak renk secer.");

        //9) Departmana ait bir foto yükler
        adminDepartmentsPage.imgUpload.click();

        Robot robot = new Robot(); // Robot class'i ile dosya yolu girilir
        String filePath = System.getProperty("user.home") + "\\Desktop\\cicek.png";


        // Dosya yolu kopyalanir
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // CTRL+V ile yapistirilir
        robot.keyPress(KeyEvent.VK_CONTROL);
        ReusableMethods.bekle(1);

        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);

        ReusableMethods.bekle(1);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // 'Enter' tusuna basilir
        ReusableMethods.bekle(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        ReusableMethods.bekle(3);

        extentTest.info("Departmana ait bir foto yükler");

        //10) save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info(" save butonuna tıklar.");

        //11) "Departments added successfully" mesajının göründüğünü doğrular.
        softAssert.assertTrue(adminDepartmentsPage.onayMesaji.isDisplayed());
        extentTest.pass("\"Departments added successfully\" mesajının göründüğünü doğrular.");

        //12) "Departments added successfully" mesajını kapatır
        adminDepartmentsPage.onayMesajiKapat.click();
        extentTest.info("\"Departments added successfully\" mesajını kapatır");

        //13)Admin profile tıklar.
        //14)Logout butonuna tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar.Logout butonuna tıklar.");

        //15)Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar");

        softAssert.assertAll("departman olusturuldu");
        extentTest.pass("departman olusturuldu");
        extentTest.info("sayfayı kapatır.");
    }

    @Test
    public void TC_013() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_013", "Olusturulan departman Departments sayfasında görüntülenebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info(" Admin anasayfaya gider,Geçerli email ve password ile giriş yapar");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();

        adminDepartmentsPage.Departments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //6) Aranılan departmanın görüntülendiğini listenin ikinci sayfasına gecerek doğrular

        adminDepartmentsPage.dNextButton.click();
        adminDepartmentsPage.dSearchBox.sendKeys(ConfigReader.getProperty("005_TittleDep"));

        String expectedYazi = "New Departments";
        String actualYazi = adminDepartmentsPage.eklenenDep.getText();

        extentTest.info("Aranılan departmanın görüntülendiğini listenin ikinci sayfasına gecerek  doğrular");
        softAssert.assertEquals(actualYazi,expectedYazi, "yazilar uyusmuyor");
        extentTest.pass("Aranılan departmanın görüntülendi");


        //13)Admin profile tıklar.
        //14)Logout butonuna tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar");

        //15)Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar");

        softAssert.assertAll("departman görüntülendi");
        extentTest.pass("\"departman görüntülendi\"");


    }

    @Test
    public void TC_014() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_014", "Zorunlu alanları boş bırakarak Departman oluşturamamalı");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5) Save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info(" Save butonuna tıklar.");


        // 6)Departman sayfasına yönlendirilmediğini doğrular.

        String expectedURL = ConfigReader.getProperty("005_DepURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(expectedURL, actualURL, "beklenilen sayfaya gecilemedi.");

        ReusableMethods.bekle(2);
        extentTest.pass("Departman sayfasına yönlendirilmediğini doğrular.");

        //13)Admin profile tıklar.
        //14)Logout butonuna tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar.");

        //15)Sign out butonuna tıklar
        ReusableMethods.singOut();

        softAssert.assertAll("departman olusturulamadı");
        extentTest.info("Sign out butonuna tıklar");
        extentTest.info("Sign out butonuna tıklar");

    }

    @Test
    public void TC_015() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_30_TC_015", "Sadece parent departments box boş bırakılarak departman olusturamama");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5) Order departments boxa sayı girer.
        adminDepartmentsPage.orderBox.sendKeys(ConfigReader.getProperty("005_OrderDep"));
        extentTest.info("Order departments boxa sayı girer.");

        //6) Title Departments boxa text girer.
        adminDepartmentsPage.tittleBox.sendKeys(ConfigReader.getProperty("005_TittleDep"));
        extentTest.info(" Title Departments boxa text girer.");

        //7) color Departments ddm'den renk secer.
        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("color Departments ddm'den renk secer.");

        //8) Save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info("Save butonuna tıklar.");


        //9)Departman sayfasına yönlendirilmediğini doğrular.

        String expectedURL = ConfigReader.getProperty("005_DepURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        softAssert.assertNotEquals(actualURL,expectedURL,"yönlendirildi");

        ReusableMethods.bekle(2);
        extentTest.pass("Departman sayfasına yönlendirilmediğini doğrular.");


        //10)Admin profile tıklar.
        //11)Logout butonuna tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar.");

        //12)Sign out butonuna tıklar
        ReusableMethods.singOut();

        softAssert.assertAll("departman olusturulamadı");
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır.");


    }

    @Test
    public void TC_016() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_016", "Sadece order departments box bos bırakılarak deparman olusturamamalı");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5)Parent departments box'a sayi girer
        adminDepartmentsPage.parentBox.sendKeys(ConfigReader.getProperty("005_ParentDep"));
        extentTest.info("Parent departments box'a sayi girer");

        //6) Title Departments boxa text girer.
        adminDepartmentsPage.tittleBox.sendKeys(ConfigReader.getProperty("005_TittleDep"));
        extentTest.info("Title Departments boxa text girer.");

        //7) color box'a tıklayarakrenk secer.
        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("color box'a tıklayarak renk secer");

        //10) save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info("save butonuna tıklar");


        // 6)Departman sayfasına yönlendirilmediğini doğrular.

        String expectedURL = ConfigReader.getProperty("005_DepURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        softAssert.assertNotEquals(expectedURL,actualURL,"yönlendirildi");

        ReusableMethods.bekle(2);
        extentTest.fail("Departman sayfasına yönlendirilmediğini doğrular.");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar.");


        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();

        softAssert.assertAll("departman olusturulamadı");
        extentTest.pass("Sign out butonuna tıklar.");


    }

    @Test
    public void TC_017() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_017", "Sadece Tittle departments box bos bırakılarak departman olusturamama testi");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments menüsünü ve alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5)Parent departments box'a sayi girer
        adminDepartmentsPage.parentBox.sendKeys(ConfigReader.getProperty("005_ParentDep"));
        extentTest.info("Parent departments box'a sayi girer");

        //6) Order departments boxa sayı girer.
        adminDepartmentsPage.orderBox.sendKeys(ConfigReader.getProperty("005_OrderDep"));
        extentTest.info("Order departments boxa sayı girer.");

        //7) color box'a tıklayarak  renk secer.
        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("color Departments ddm'den renk secer.");

        //10) save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info(" save butonuna tıklar.");


        // 6)Departman sayfasına yönlendirilmediğini doğrular.

        String expectedURL = ConfigReader.getProperty("005_DepURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        softAssert.assertNotEquals(actualURL,expectedURL,"yönlendirildi.");
        extentTest.fail("Departman sayfasına yönlendirilmediğini doğrular.");

        ReusableMethods.bekle(2);

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar");

        //8) Sign out butonuna tıklar.

        ReusableMethods.singOut();

        softAssert.assertAll("departman olusturulamadı");
        extentTest.pass("Sign out butonuna tıklar.");

    }

    @Test
    public void TC_018() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC018", "Parent departments ve order departments box bos bırakılarak departman olusturamamalı");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar. ");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider");

        //4) Sidebar Departments alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");


        //5) Title Departments boxa text girer.
        adminDepartmentsPage.tittleBox.sendKeys(ConfigReader.getProperty("005_TittleDep"));
        extentTest.info("Title Departments boxa text girer.");

        //6) color box'a tıklayarak renk secer.
        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("color box'a tıklayarak renk secer.");

        //7) save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info("save butonuna tıklar.");

        // 8)Departman sayfasına yönlendirilmediğini doğrular.

        String expectedURL = ConfigReader.getProperty("005_DepURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        softAssert.assertNotEquals(actualURL,expectedURL,"yönlendirildi");

        ReusableMethods.bekle(2);
        extentTest.fail("Departman sayfasına yönlendirilmediğini doğrular");

        //9)Admin profile tıklar.
        //10)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar ");

        //11) Sign out butonuna tıklar.

        ReusableMethods.singOut();

        softAssert.assertAll("departman olusturulamadı");
        extentTest.pass("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır");
    }

    @Test
    public void TC_019() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_019", "Order ve tittle departments box bos bırakılarak departman olusturamamalı");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5)Parent departments box'a sayi girer
        adminDepartmentsPage.parentBox.sendKeys(ConfigReader.getProperty("005_ParentDep"));
        extentTest.info("Parent departments box'a sayi girer");

        //6) color Departments ddm'den renk secer.
        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("color Departments ddm'den renk secer.");

        //7) save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info("save butonuna tıklar.");


        //8)Departman sayfasına yönlendirilmediğini doğrular.

        String expectedURL = ConfigReader.getProperty("005_DepURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        softAssert.assertNotEquals(actualURL,expectedURL,"yönlendirildi");

        ReusableMethods.bekle(2);
        extentTest.fail("Departman sayfasına yönlendirilmediğini doğrular");

        //9)Admin profile tıklar.
        //10)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar");

        //11) Sign out butonuna tıklar.

        ReusableMethods.singOut();

        softAssert.assertAll("departman olusturulamadı");
        extentTest.pass("Sign out butonuna tıklar");

    }

    @Test
    public void TC_020() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_030_TC_020", "Parent departments ve tittle departments box bos bırakılarak departman olusturamama");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //3)Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info(")Admin paneline gider");

        //4) Sidebar Departments alt menüsü Create Departments'a tıklar

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.DbrdCreateDepartments.click();
        extentTest.info("Sidebar Departments alt menüsü Create Departments'a tıklar");

        //5) Order departments boxa sayı girer.
        adminDepartmentsPage.orderBox.sendKeys(ConfigReader.getProperty("005_OrderDep"));
        extentTest.info("Order departments boxa sayı girer");

        //6) color box'a tıklayarak renk secer.
        adminDepartmentsPage.colorBox.click();
        adminDepartmentsPage.colorComplete.click();
        extentTest.info("color box'a tıklayaralrenk secer.");

        //7) save butonuna tıklar.
        adminDepartmentsPage.saveButton.click();
        extentTest.info("save butonuna tıklar.");

        //8)Departman sayfasına yönlendirilmediğini doğrular.

        String expectedURL = ConfigReader.getProperty("005_DepURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        softAssert.assertNotEquals(actualURL,expectedURL,"yönlendirildi");

        ReusableMethods.bekle(2);
        extentTest.fail("Departman sayfasına yönlendirilmediğini doğrular.");


        //9)Admin profile tıklar.
        //10)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,)Logout butonuna tıklar");

        //11) Sign out butonuna tıklar.

        ReusableMethods.singOut();

        softAssert.assertAll("departman olusturulamadı");
        extentTest.info("Sign out butonuna tıklar.");
    }

}
