package tests.UI_FUNC_001;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDepartmentsPage;
import pages.AdminHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.driver;

public class Us_29 extends TestBaseRapor {



    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();

        extentTest = extentReports.createTest("US_029_TC_001", "Yönetici panelinde sidebar'da Departments menüsü ve alt menülerini -Departments ve Create Departments-görüntüleyebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn("admin.esranur@loyalfriendcare.com");
        extentTest.info("Admin anasayfaya gider.ve Geçerli email ve password ile giriş yapar. ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar'da Departments menüsünün görüntülendiğini doğrular.

        ReusableMethods.dashbordSidebarMenu();

        Assert.assertTrue(adminDepartmentsPage.dbrdDepartments.isDisplayed());
        extentTest.pass("Sidebar'da Departments menüsünün görüntülendiğini doğrular.");

        //5) Departments menüsünün alt menülerinden Departments'ın görünürlüğünü doğrular.
        adminDepartmentsPage.dbrdDepartments.click();
        extentTest.info("sidebar Departments menüsüne tıklar");

        Assert.assertTrue(adminDepartmentsPage.Departments.isDisplayed());
        extentTest.pass("Departments menüsünün alt menülerinden Departments'ın görünürlüğünü doğrular.");

        //6) Departments menüsünün alt menülerinden Create Departments'ın görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.DbrdCreateDepartments.isDisplayed(), "Create departments görünür değil.");
        extentTest.pass("Departments menüsünün alt menülerinden Create Departments'ın görünürlüğünü doğrular.");

        //7) Admin profile tıklar.
        //8) Logout butonuna tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar.ve Logout butonuna tıklar ");

        //9) Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır.");

    }

    @Test
    public void TC_002() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_029_TC_002", "Yöneticinin sidebar'da Departments alt menüsünden departman listesini görebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn("admin.esranur@loyalfriendcare.com");
        extentTest.info("Admin anasayfaya gider ve  Geçerli email ve password ile giriş yapar.");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments alt menüsü Departments'a tıklar

        ReusableMethods.dashbordSidebarMenu();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.Departments.click();
        extentTest.info("Sidebar Departments alt menüsü Departments'a tıklar");

        //5)Departments yazısının görnürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.depDogrulama.isDisplayed(), "departman sayfasında olduğu doğrulanamadı");
        extentTest.pass("Departments yazısının görnürlüğünü doğrular.");


        //6) Listede departmanların göründüğünü doğrular.

        List<WebElement> birinciSatirDepartmanElementleriList = driver.findElements(By.xpath("//*[@id=\"tableWithSearch\"]/thead/tr"));

        // Tablodan verileri bir listeye ekleyin
        List<String> tabloVerileri = new ArrayList<>();

        for (WebElement satir : birinciSatirDepartmanElementleriList) {

            // Her satırdaki hücrelerden (td) verileri alıyoruz
            List<WebElement> hucreler = satir.findElements(By.xpath("(//tr[@role='row'])[1]"));

            for (WebElement hucre : hucreler) {

                tabloVerileri.add(hucre.getText());
            }
        }

        // Listenin boyutunun 0'dan büyük olduğuna dair bir test yazıyoruz
        Assert.assertTrue(tabloVerileri.size() > 0, "Tabloda veri yok!");

        // Listeyi yazdırmak isterseniz:
        for (String veri : tabloVerileri) {

            System.out.println(veri);
        }

        extentTest.pass("Listede departmanların göründüğünü doğrular");

        //7) Admin profile tıklar.
        //8) Logout butonuna tıklar.

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar ve  Logout butonuna tıklar");

        //9) Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır");


    }

    @Test
    public void TC_003() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_029_TC_003", "Departments sayfasında Table Departments tablosu görüntülenebilmeli");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider ve Geçerli email ve password ile giriş yapar. ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments alt menüsü Departments'a tıklar

        ReusableMethods.dashbordSidebarMenu();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.Departments.click();
        extentTest.info("Sidebar Departments alt menüsü Departments'a tıklar");

        //5) Acılan sayfada image butonunun görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.image.isDisplayed(), "image butonu görünür değil.");
        extentTest.pass("Acılan sayfada image butonunun görünürlüğünü doğrular.");

        //6) Acılan sayfada order butonunun görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.order.isDisplayed(), "order butonu görnür değil.");
        extentTest.pass("Acılan sayfada order butonunun görünürlüğünü doğrular.");

        //7) Acılan sayfada name butonunun görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.name.isDisplayed(), "name butonu görünür değil. ");
        extentTest.pass("Acılan sayfada name butonunun görünürlüğünü doğrular");

        //8) Acılan sayfada  colors butonunun  görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.color.isDisplayed(), "colors butonu görünür değil.");
        extentTest.pass(" Acılan sayfada  colors butonunun  görünürlüğünü doğrular.");

        //9)  Acılan sayfada  edit butonunun  görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.departmentsEdit.isDisplayed(), "edit butonu görünür değil.");
        extentTest.pass("Acılan sayfada  edit butonunun  görünürlüğünü doğrular.");

        //10) Acılan sayfada  action butonunun  görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.departmentsAction.isDisplayed(), "action butonu görünür değil.");
        extentTest.pass("Acılan sayfada  action butonunun  görünürlüğünü doğrular");

        //11) Açılan sayfada search box'ın görünürlüğünü doğrular.

        softAssert.assertTrue(adminDepartmentsPage.dSearchBox.isDisplayed(), "search butonu görünür değil.");
        extentTest.pass("Açılan sayfada search box'ın görünürlüğünü doğrular.");

        //12) Admin profile tıklar.
        //13) Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar ve Logout butonuna tıklar. ");

        //14)Sign out butonuna tıklar.

        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır.");


    }

    @Test
    public void TC_004() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_029_TC_004", "Departmanlar arasında arama yapabilmek için search box aktifliğini doğrulama");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider ve Geçerli email ve password ile giriş yapar ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments alt menüsü Departments'a tıklar.

        ReusableMethods.dashbordSidebarMenu();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.Departments.click();

        extentTest.info("Sidebar Departments alt menüsü Departments'a tıklar");

        //5)Search box'a metin girilebilmeli

        adminDepartmentsPage.dSearchBox.sendKeys(ConfigReader.getProperty("005_DepSearchBox"));
        extentTest.info("Search box'a metin girilebilmeli");

        //6)Admin profile tıklar.
        //7)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar ve Logout butonuna tıklar ");

        //8)Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır.");


    }

    @Test
    public void TC_005() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_029_TC_005", "Departmanlar arasında arama yapabilmek için search box filtreleme yapabilm");

        //1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider ve Geçerli email ve password ile giriş yapar ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();


        //4) Sidebar Departments alt menüsü Departments'a tıklar

        ReusableMethods.dashbordSidebarMenu();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.Departments.click();
        extentTest.info("Sidebar Departments alt menüsü Departments'a tıklar");

        //5)Search box'ta filtreleme yapar

        adminDepartmentsPage.dSearchBox.sendKeys(ConfigReader.getProperty("005_DepSearchBox"));
        extentTest.info("Admin paneline gider.");

        //6)Filtrelemenin yapıldığını doğrular
        Assert.assertTrue(adminDepartmentsPage.searchText.isDisplayed(), "filtreleme yapılamıyor.");
        extentTest.pass("Filtrelemenin yapıldığını doğrular");

        //7)Admin profile tıklar.
        //8)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar,Logout butonuna tıklar");

        //9)Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Sign out butonuna tıklar.");
        extentTest.info("sayfayı kapatır.");


    }

    @Test
    public void TC_006() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_029_TC_006", "Mevcut departmanlar üzerinde editleme yapabilme testi");

        // 1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider,Geçerli email ve password ile giriş yapar ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider");

        //4) Sidebar Departments alt menüsü Departments'a tıklar

        ReusableMethods.dashbordSidebarMenu();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.Departments.click();

        extentTest.info("Sidebar Departments alt menüsü Departments'a tıklar");

        //5)edit e basıp gerekli düzenlemeleri yapar.
        //6) Save butonuna tıklar.

        try {
            adminDepartmentsPage.editButtononOnesRow.click();

            softAssert.assertTrue(false, "edit button gorunur durumda değil");

        } catch (StaleElementReferenceException e) {

            softAssert.assertTrue(true);

        }

        softAssert.assertTrue(adminDepartmentsPage.editPage.isDisplayed(), "edit page görünür değil");
        extentTest.fail("edit e basıp gerekli düzenlemeleri yapar Save butonuna tıklar. ");

        //7)Admin profile tıklar.
        //8)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar Logout butonuna tıklar");

        //9)Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info(")Sign out butonuna tıklar");

        softAssert.assertAll();
        extentTest.info("sayfayı kapatır.");

    }

    @Test
    public void TC_007() {
        Actions actions = new Actions(Driver.getDriver());
        AdminDepartmentsPage adminDepartmentsPage = new AdminDepartmentsPage();
        AdminHomePage adminHomePage = new AdminHomePage();
        extentTest = extentReports.createTest("US_029_TC_007", "Mevcut departmanlar üzerinde delete yapabilme testi");

        // 1) Admin anasayfaya gider.
        //2) Geçerli email ve password ile giriş yapar.

        ReusableMethods.signIn(ConfigReader.getProperty("005_validAdminEmail"));
        extentTest.info("Admin anasayfaya gider , Geçerli email ve password ile giriş yapar. ");

        //3) Admin paneline gider.

        adminHomePage.adminUserLogoDdm.click();
        extentTest.info("Admin paneline gider.");

        //4) Sidebar Departments alt menüsü Departments'a tıklar

        ReusableMethods.dashbordSidebarMenu();

        adminDepartmentsPage.dbrdDepartments.click();
        adminDepartmentsPage.Departments.click();
        extentTest.info("Sidebar Departments alt menüsü Departments'a tıklar");

        //5) Departman satırındaki delete butonuna tıklar.
        //6)Silme işleminin gerceklestiğini doğrular

        try {
            adminDepartmentsPage.deleteButtonOnesRow.click();

            softAssert.assertTrue(false, "delete button gorunur durumda değil");

        } catch (StaleElementReferenceException e) {

            softAssert.assertTrue(true);

        }

        //7)Admin profile tıklar.
        //8)Logout butonuna tıklar

        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Admin profile tıklar Logout butonuna tıklar");

        //9)Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info(")Sign out butonuna tıklar");

        softAssert.assertAll();
        extentTest.info("sayfayı kapatır.");


    }
}
