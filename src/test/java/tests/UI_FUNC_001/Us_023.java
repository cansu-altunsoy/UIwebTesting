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

import java.util.List;

public class Us_023 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    AdminRolesPages adminRolesPages = new AdminRolesPages();

    AdminHomePage adminHomePage = new AdminHomePage();

    HomePage homePage = new HomePage();

    Actions actions = new Actions(Driver.getDriver());

    ReusableMethods reusableMethods = new ReusableMethods();


    @Test
    public void TC023_001() {
        extentTest = extentReports.createTest("Yönetici sayfasında Sidebar’ın \"Roles\" menüsü ve ve alt alt menü Role ve Created role görüntülünebilirlik testi.\n",
                "Yönetici sayfasında Sidebar’ın \"Roles\" menüsü ve alt menü Role ve Created role görüntülünebilmeli .\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Yönetici Sidebar'da bulunan "Roles" menüsünün görünürlüğü kontrol edilerek doğrulanır.
        softAssert.assertTrue(adminRolesPages.dashboardRoles.isDisplayed(), "Roles ana menüsü görüntülenemedi.");
        extentTest.pass("Yönetici Sidebar'da bulunan \"Roles\" menüsünün görünürlüğü kontrol edilerek doğrulanır.");

        //9-Sidebar'da bulunan  Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");

        //10-Yönetici Roles menüsüde bulunan " Role " alt menüsünün sorunsuz ve doğru şekilde görünürlüğü kontrol edilerek doğrulanır.
        softAssert.assertTrue(adminRolesPages.dashboardRolesRoles.isDisplayed(), "Roles alt menüsü görüntülenemedi.");
        extentTest.pass("Yönetici Roles menüsüde bulunan \" Role \" alt menüsünün sorunsuz ve doğru şekilde görünürlüğü kontrol edilerek doğrulanır.");

        //11-Yönetici Roles menüsüde bulunan "Create role  " alt menüsünün sorunsuz ve doğru şekilde görünürlüğü kontrol edilerek doğrulanır.
        softAssert.assertTrue(adminRolesPages.dashboardRolesCreateRoles.isDisplayed(), "Create Role alt menüsü görüntülenemedi.");
        extentTest.pass("Yönetici Roles menüsüde bulunan \"Create role  \" alt menüsünün sorunsuz ve doğru şekilde görünürlüğü kontrol edilerek doğrulanır.");

        //12- Header kısımda bulunan yönetici profili butonuna tıklar.
        //13- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //14-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //15-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC023_002() {
        extentTest = extentReports.createTest("Yönetici Roles ana menüsünde bulunan  alt menüsündeki \"Created Roles\" un fonksiyonellik testi.\n",
                "Yönetici Created Role Page 'e  sorunsuz ve başarılı bir şekilde yönlendirilerek 'add role' başlığını göruntüleyebilmeli.\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan  Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");

        //9-Roles ana menüsündeki Create Roles alt menüsüne tıklar.
        adminRolesPages.dashboardRolesCreateRoles.click();
        extentTest.info("Roles ana menüsündeki Create Roles alt menüsüne tıklar.");

        //10- Yönetici'nin Created role sayfasına sorunsuz bir şekilde  yönlendirebildiği  'add role' başlığını görüntülenebilmesi ile doğrulanır.
        softAssert.assertTrue(adminRolesPages.creatRolePageAddRoleTitle.isDisplayed(), " 'add role' basligi görüntülenemedi. ");
        extentTest.pass("Yönetici'nin Created role sayfasına sorunsuz bir şekilde  yönlendirebildiği  'add role' başlığını görüntülenebilmesi ile doğrulanır.");

        //11- Header kısımda bulunan yönetici profili butonuna tıklar.
        //12- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        //13-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");


        softAssert.assertAll();

        //14-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC023_003() {
        extentTest = extentReports.createTest("Yönetici Roles ana menüsünde bulunan alt menüsündeki \"Roles\"  un fonksiyonellik  testi.\n",
                "Yönetici'nin Roles sayfasına sorunsuz bir şekilde  yönlendirilerek  'add role' butonunu görüntüleyebilmeli\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan  Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");

        //9-Roles ana menüsündeki Roles alt menüsüne tıklar.
        adminRolesPages.dashboardRolesRoles.click();
        extentTest.info("Roles ana menüsündeki Roles alt menüsüne tıklar.");

        //10-Yönetici'nin Roles sayfasına sorunsuz bir şekilde  yönlendirebildiği  'add role' butonunu görüntülenebilmesi ile doğrulanır.
        softAssert.assertTrue(adminRolesPages.addRoleButton.isDisplayed(), "'add role' butonu görüntülenemedi.");
        extentTest.pass("Yönetici'nin Roles sayfasına sorunsuz bir şekilde  yönlendirebildiği  'add role' butonunu görüntülenebilmesi ile doğrulanır.");

        //11- Header kısımda bulunan yönetici profili butonuna tıklar.
        //12- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        //13-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");


        softAssert.assertAll();

        //14-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC023_004() {
        extentTest = extentReports.createTest("Yönetici Roles sayfasında bulunan Table Roles tablosundaki  \"Name\",\"Displayname\" ,\"Create At\",\"action\"  sütunlarında rollerin filitrenilebilirlik  testi.\n",
                "Yönetici Roles sayfasında bulunan Table Roles tablosundaki  \"Name\",\"Displayname\" ,\"Create At\" ,\"action\"  sütunlarında roller filitrenek görüntülenmeli ");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");

        //9-Roles ana menüsündeki Roles alt menüsüne tıklar.
        adminRolesPages.dashboardRolesRoles.click();
        extentTest.info("Roles ana menüsündeki Roles alt menüsüne tıklar.");


        //10- Mevcut Rollerin Table roles tablosunda "Name" sütunu altında listelenmiş olduğu doğrulanır.

        List<String> nameWordsList = ReusableMethods.stringListeyeDonustur(reusableMethods.getAtNameCollums());
        int actualNameWordListSize = nameWordsList.size();
        softAssert.assertTrue(actualNameWordListSize > 0, "Tüm Name'ler listelenemedi");
        extentTest.pass("Mevcut Rollerin Table roles tablosunda \"Name\" sütunu altında listelenmiş olduğu doğrulanır.");


        //11- Rollerin Table roles tablosunda "Displayname" sütunu altında listelenmiş olduğu doğrulanır.
        List<String> displayNameWordsList = ReusableMethods.stringListeyeDonustur(reusableMethods.getAtDisplayNameCollums());
        int actualDisplayNameWordListSize = nameWordsList.size();
        softAssert.assertTrue(actualDisplayNameWordListSize > 0, "Tüm Display Name'ler listelenemedi");
        extentTest.pass("Rollerin Table roles tablosunda \"Displayname\" sütunu altında listelenmiş olduğu doğrulanır.");


        //12- Rollerin Table roles tablosunda "Created At " sütunu altında listelenmiş olduğu doğrulanır.
        List<String> createdAtWordsList = ReusableMethods.stringListeyeDonustur(reusableMethods.getTableRoleCreateAtCollumnAll());
        int actualCreatedAtWordListSize = nameWordsList.size();
        softAssert.assertTrue(actualCreatedAtWordListSize > 0, "Tüm Created At'ler listelenemedi");
        extentTest.pass("Rollerin Table roles tablosunda \"Created At \" sütunu altında listelenmiş olduğu doğrulanır.");


        //13- Rollerin Table roles tablosunda "Action "  sütunu altında listelenmiş olduğu doğrulanır.
        List<String> actionsWordsList = ReusableMethods.stringListeyeDonustur(reusableMethods.getTableRoleActionsCollumnAll());
        int actualActionsWordListSize = nameWordsList.size();
        softAssert.assertTrue(actualActionsWordListSize > 0, "Tüm Actions'lar listelenemedi");
        extentTest.pass("Rollerin Table roles tablosunda \"Action \"  sütunu altında listelenmiş olduğu doğrulanır.");


        //14- Header kısımda bulunan yönetici profili butonuna tıklar.
        //15- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //16-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");


        softAssert.assertAll();

        //17-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }

    @Test
    public void TC023_005() {
        extentTest = extentReports.createTest("Yöneticinin Roles sayfası body’sinde bulunan \"search box \" erişilebilirlik testi.\n",
                "Yönetici Roles sayfasının body bölümünde bulunan \"search box  erişilebilmeli .\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");

        //9-Roles ana menüsündeki Roles alt menüsüne tıklar.
        adminRolesPages.dashboardRolesRoles.click();
        extentTest.info("Roles ana menüsündeki Roles alt menüsüne tıklar.");


        //10-Roles sayfasının body bölümünde bulunan "search box "a tıklar
        adminRolesPages.rolesSearchBox.click();
        extentTest.info("Roles sayfasının body bölümünde bulunan \"search box \"a tıklar");


        //11- Yöneticinin Roles sayfasının body bölümünde bulunan "search box " ın  görüntülenebilir ve tiklanılabilir  olduğu doğrulanır.
        softAssert.assertTrue(adminRolesPages.rolesSearchBox.isEnabled(), "Search box 'a erişilemedi.");
        extentTest.pass("Yöneticinin Roles sayfasının body bölümünde bulunan \"search box \" ın  görüntülenebilir ve tiklanılabilir  olduğu doğrulanır.");

        //12- Yönetici Header kısımda bulunan yönetici ikonuna tıklar.
        //13- Açılan menüde Log out yazısına tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //14-Yönetici Header bölümündeki  Sign out butonuna tıklar.
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //15-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }

    @Test
    public void TC023_006() {
        extentTest = extentReports.createTest("Yöneticinin Search box’ta  mevcut roller arasında geçerli data arandığında  ilgili sonuçları filtreleyerek listelendiği görüntüleme testi.\n",
                "Yönetici Search boxta mevcut roller geçerli data arandığında  bulunan sonuçları görüntülenebilmeli.\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");

        //9-Roles ana menüsündeki Roles alt menüsüne tıklar.
        adminRolesPages.dashboardRolesRoles.click();
        extentTest.info("Roles ana menüsündeki Roles alt menüsüne tıklar.");

        //10- Roles sayfasının body bölümünde bulunan "search box " a tıklar.
        adminRolesPages.rolesSearchBox.click();
        extentTest.info("Roles sayfasının body bölümünde bulunan \"search box \" a tıklar.");

        //11- "search box "a aranacak kelimeyi yazar.
        adminRolesPages.rolesSearchBox.sendKeys(ConfigReader.getProperty("006_validRoleSearchWord"));
        extentTest.info("\"search box \"a aranacak kelimeyi yazar.");

        //12-Yönetici "Showing 1 to 'bulunan entrie sayısı"  of 10 entries" yazısını  görüntülediğini "0 entries" yazmadıgını kontrol edilerek doğrular.
        String expectedFiltredResult = "0 entries";
        String actualFiltredResult = adminRolesPages.rolesSearchFiltredResult.getText();
        softAssert.assertFalse(actualFiltredResult.contains(expectedFiltredResult), "mevcut roller arasında  bulunması gereken roller bulunamadı.");
        extentTest.pass("Yönetici \"Showing 1 to 'bulunan entrie sayısı\"  of 10 entries\" yazısını  görüntülediğini \"0 entries\" yazmadıgını kontrol edilerek doğrular.");

        //13- Header kısımda bulunan yönetici profili butonuna tıklar.
        //14- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //15-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");


        softAssert.assertAll();

        //16-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC023_007() {
        extentTest = extentReports.createTest("Yöneticinin Search box’ta  mevcut roller arasında geçersiz  data arandığında  \"Showing 0 to 0 of 0 entries (filtered from 8 total entries)\" ve \"No matching records found\" mesajı görüntülenme testi.\n",
                "Yönetici \" No matching records found\" mesajını \"Showing 0 to 0 of 0 entries (filtered from 10 total entries)\" yazısının görüntülenebilmeli.\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");

        //9-Roles ana menüsündeki Roles alt menüsüne tıklar.
        adminRolesPages.dashboardRolesRoles.click();
        extentTest.info("Roles ana menüsündeki Roles alt menüsüne tıklar.");


        //10-Roles sayfasının body bölümünde bulunan "search box " a tıklar.
        adminRolesPages.rolesSearchBox.click();
        extentTest.info("Roles sayfasının body bölümünde bulunan \"search box \" a tıklar.");


        //11- "search box "a aranacak kelimeyi yazar.
        adminRolesPages.rolesSearchBox.sendKeys(ConfigReader.getProperty("006_invalideRoleSearchWord"));
        extentTest.info("\"search box \"a aranacak kelimeyi yazar.");


        //12- Yönetici " No matching records found" yazısını görüntülediği doğrulanır.
        String expectedNoResultFound = "No matching records found";
        String actualNoResultFound = adminRolesPages.rolesSearchNoResultFound.getText();
        softAssert.assertEquals(actualNoResultFound, expectedNoResultFound, "No matching records found yazisi görüntülenemedi.");
        extentTest.pass("Yönetici \" No matching records found\" yazısını görüntülediği doğrulanır.");


        //13- "Showing 0 to 0 of 0 entries (filtered from 10 total entries)" yazısının görüntülenebilmesi ile doğrulanır.
        String expectedFiltredResult = "Showing 0 to 0 of 0 entries (filtered from 10 total entries)";
        String actualFiltredResult = adminRolesPages.rolesSearchFiltredResult.getText();
        softAssert.assertEquals(actualFiltredResult, expectedFiltredResult, " Mevcut bulunması gereken roller bulunamadı.");
        extentTest.pass("\"Showing 0 to 0 of 0 entries (filtered from 10 total entries)\" yazısının görüntülenebilmesi ile doğrulanır.");

        //14- Header kısımda bulunan yönetici profili butonuna tıklar.
        //15- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //16-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");


        softAssert.assertAll();

        //17-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC023_008() {
        extentTest = extentReports.createTest("Yöneticinin  Roles sayfasında bulunan Delete butonuna  erişilebilirlik ve \"Role deleted successfully\" mesajnın  görüntülenebilirlik testi.\n",
                "Yönetici \"Delete butonuna  erişilebilmeli  ve \"Role deleted successfully\" mesajnın  görüntülenebilmeli.\n");

        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Roles menüsüne tıklar.
        adminRolesPages.dashboardRoles.click();
        extentTest.info("Sidebar'da bulunan  Roles menüsüne tıklar.");


        //9-Roles ana menüsündeki Roles alt menüsüne tıklar.
        adminRolesPages.dashboardRolesRoles.click();
        extentTest.info("Roles ana menüsündeki Roles alt menüsüne tıklar.");

        //10-Test için oluşturulan Role Datalarının oldugu "https://qa.loyalfriendcare.com/en/Dashboard/Roles?page=4" sayfasina gider.
        Driver.getDriver().get(ConfigReader.getProperty("006_fourthRolesTestPage"));
        extentTest.info("Test için oluşturulan Role Datalarının oldugu \"https://qa.loyalfriendcare.com/en/Dashboard/Roles?page=4\" sayfasina gider.");

        //11- Roles sayfasında bulunan Table Roles tablosundaki action sutununun altında bulunan Delete butonu görüntülenebildiği  doğrulanır.
        softAssert.assertTrue(adminRolesPages.rolesActionsAllDeleteButton.isDisplayed(), "Delete butonu görüntülenemedi.");
        extentTest.pass("Roles sayfasında bulunan Table Roles tablosundaki action sutununun altında bulunan Delete butonu görüntülenebildiği  doğrulanır.");

        //12- Yönetici "Delete" butonuna tıklar.
        adminRolesPages.rolesActionsAllDeleteButton.click();
        extentTest.info("Yönetici \"Delete\" butonuna tıklar");

        //13-Delete butonuna tıklandığında "Role deleted successfully" mesajı görüntülendiği doğrulanır.
        String expectedRolesSuccessfullyDeletedMesagge = "Role deleted successfully";
        String actualRolesSuccessfullyDeletedMesagge = adminRolesPages.rolesSuccessfullyDeletedMesagge.getText();
        softAssert.assertTrue(actualRolesSuccessfullyDeletedMesagge.contains(expectedRolesSuccessfullyDeletedMesagge), "Role deleted successfully mesajı görüntülenemedi");
        extentTest.pass("Delete butonuna tıklandığında \"Role deleted successfully\" mesajı görüntülendiği doğrulanır.");

        //14- Header kısımda bulunan yönetici profili butonuna tıklar.
        //15- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //16-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //17-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }
}
