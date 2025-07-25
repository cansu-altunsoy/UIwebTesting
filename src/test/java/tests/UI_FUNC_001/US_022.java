package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import pages.AdminHomePage;
import pages.AdminRolesPages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class US_022 {

    @Test
    public void US_022_TC01_AdminAccessDashboard() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC02_ValidateDashboardSummaryData() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC03_DashboardLinksLearnMoreAtUsers() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard learnmore at users'a gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLearnMoreAtUsers.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC04_DashboardLinksLearnMoreAtBedManagers() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider

        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLearnMoreAtBedManagers.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC05_DashboardLinksLearnMoreAtRoles() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider

        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLearnMoreAtRoles.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC06_DashboardLinksLearnMoreAtMessages() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular


        //dashboard'da ilgili sayfaya gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLearnMoreAtMessages.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC07_DashboardLinksLearnMoreAtGoogleAdvertisement() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider

        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLearnMoreAtGoogleAds.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC08_DashboardLinksLearnMoreAtMedicines() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider

        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLearnMoreAtMedicines.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();


    }

    @Test
    public void US_022_TC09_DashboardLinksLearnMoreAtSettings() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider

        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLearnMoreAtSettings.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC10_DashboardButtonsFacebook() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminFacebookBtn.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC11_DashboardButtonsPinterest() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminPinterestBtn.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC12_DashboardButtonsInstagram() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminInstagramBtn.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC13_DashboardButtonsLinkedIn() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminLinkedinBtn.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC14_DashboardButtonsTumblr() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminTumblrBtn.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC15_DashboardButtonsGithub() {

        //pre condition. kullanıcı sign in olur
        LoginPage loginpage = new LoginPage();
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular

        //dashboard'da ilgili sayfaya gider
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.AdminGithubBtn.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

    @Test
    public void US_022_TC16_SideMenuDashboard() {

        //pre condition. kullanıcı sign in olur
        ReusableMethods.signIn(ConfigReader.getProperty("002_validAdminEmail"));

        //header'da ayarlar butonuna tıklar
        HomePage homepage = new HomePage();
        homepage.headerAdminNameButton.click();

        //admin panelinde olduğunu doğrular
        //ReusableMethods.verifyURL(driver,"https://qa.loyalfriendcare.com/en/admin");

        //dashboard'da ilgili sayfaya gider
        ReusableMethods.dashbordSidebarMenu();
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        adminRolesPages.dashboardRoles.click();
        adminRolesPages.dashboardRolesRoles.click();

        //sayfada olduğunu kontrol eder


        //logout ve signout
        ReusableMethods.logout(driver);
        ReusableMethods.singOut();

    }

}
