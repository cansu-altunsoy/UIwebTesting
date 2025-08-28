package tests.UI_FUNC_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminExitPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_042 {
    HomePage homePage = new HomePage();
    AdminExitPage adminExitPage = new AdminExitPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void test01(){
        //1-https://qa.loyalfriendcare.com/en/login sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("010_loginUrl"));

        //2-Açılan giriş ekranında geçerli bir e-posta adresi girer
        //3-Şifre alanına geçerli bir şifre girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("010_validAdminEmail"));
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("010_password"));

        //4-"Sign in " butonuna tıklar
        loginPage.signInButton.click();

        //5-Yönetici ana sayfasının yüklendiğini doğrular
        Assert.assertTrue(homePage.headerAdminNameButton.isDisplayed());

        //6-Anasayfada sağda bulunan admin butonuna tıklar
        homePage.headerAdminNameButton.click();

        //7- admin anasayfasında olduğunu doğrular
        Assert.assertTrue(adminExitPage.adminDropdownMenu.isDisplayed());

        //8-Sayfayı kapatır
        Driver.quitDriver();
    }
    @Test
    public void test02(){
        //1-https://qa.loyalfriendcare.com/en/login sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("010_loginUrl"));

        //2-Açılan giriş ekranında geçerli bir e-posta adresi girer
        //3-Şifre alanına geçerli bir şifre girer
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("010_validAdminEmail"));
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("010_password"));

        //4-"Sign in " butonuna tıklar
        loginPage.signInButton.click();

        //5-Yönetici ana sayfasının yüklendiğini doğrular
        Assert.assertTrue(homePage.headerAdminNameButton.isDisplayed());

        //6-Anasayfada sağda bulunan admin butonuna tıklar
        homePage.headerAdminNameButton.click();

        //7- admin anasayfasında olduğunu doğrular
        Assert.assertTrue(adminExitPage.adminDropdownMenu.isDisplayed());


        //1-Yönetici panelinde sağ üstte bulunan yönetici   adının oldugu sekmeye tıklar
        adminExitPage.adminDropdownMenu.click();


        //2-Profil dropdawn menüden settin ,editprofile ,logout sekmelerinin açıldığını ve görünür olduğunu doğrular

        Assert.assertTrue(adminExitPage.logoutLink.isDisplayed());

        //3-Sayfayı kapatır.
        Driver.quitDriver();

    }

}
