package tests.UI_FUNC_001;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_009 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_001NavigateToLogin(){
        extentTest = extentReports.createTest("Navigate to login test", "should be redirected to the login page with the correct url");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "User was unable to access the homepage");
        extentTest.pass("Kullanici anasyfada oldugunu dogrular");

        //3-)Header bölümende 'Sign In' butonunu görüntüler
        softAssert.assertTrue(homePage.headerSignInButton.isDisplayed(), "Unable to display the Sign button");
        extentTest.pass("Header bolumunde Sıgn In butonunu goruntuler");

        //4-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tıklar");

        //5-)Login sayfasına yönlendirildigini dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl,"User was unable to access the loginpage");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogrular");

        softAssert.assertAll();

        //6-)Sayfayı kapatır
        extentTest.info("sayfayi kapatir");


    }

    @Test
    public void  TC_002ValidateForgotPassword(){

        extentTest = extentReports.createTest("ForgotPassword link testi",
                "forgot password link should be visible");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "Kullanici anasayfaya erisim saglayamadi");
        extentTest.pass("Kullanici anasyfada oldugunu dogrular");

        //3-)Header bölümende 'Sign In' butonunu görüntüler
        softAssert.assertTrue(homePage.headerSignInButton.isDisplayed(), "Unable to display the Sign button");
        extentTest.pass("Header bolumunde Sıgn In butonunu goruntuler");

        //4-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tıklar");

        //5-)Kullanıcı login  sayfasında oldugunu dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "User was unable to access the loginpage");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");


        //6-)'Forgot Password' linkini görüntüler
        softAssert.assertTrue(loginPage.forgotPasswordLink.isDisplayed(), "Unable to display Forgot Password link");
        extentTest.pass("Kullanici forgotPassword linkini goruntuler");

        softAssert.assertAll();

        //7-)Sayfayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }

    @Test
    public void  TC_003ValidateForgotPassword(){

        extentTest = extentReports.createTest("ForgotPassword link functionality test",
                "forgot password link must be functional");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "Kullanici anasayfaya erisim saglayamadi");
        extentTest.pass("Kullanici anasyfada oldugunu dogrular");

        //3-)Header bölümende 'Sign In' butonunu görüntüler
        softAssert.assertTrue(homePage.headerSignInButton.isDisplayed(), "Unable to display the Sign button");
        extentTest.pass("Header bolumunde Sıgn In butonunu goruntuler");

        //4-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tıklar");

        //5-)Kullanıcı login sayfasında oldugunu dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "User was unable to access the loginpage");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //6-)'Forgot Password' linkini görüntüler
        softAssert.assertTrue(loginPage.forgotPasswordLink.isDisplayed(), "Unable to display Forgot Password link");
        extentTest.pass("Kullanici forgotPassword linkini goruntuler");

        //7-)'Forgot Password' linkine tıklar
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");

        //8-)Reset Password' sayfasına yölendirildigini dogrular
        String expectedResetPasswordUrl = ConfigReader.getProperty("001_lfcResetPasswordUrl");
        String actualResetPasswordUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualResetPasswordUrl, expectedResetPasswordUrl,"Unable to access the requested URL");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        softAssert.assertAll();

        //9-)Kullanıcı sayfayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");


    }

    @Test
    public void TC_004ResetPasswordPage(){
        extentTest = extentReports.createTest("Reset Password page functionality test",
                "Reset Password page must be functional");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "User was unable to access the homepage");
        extentTest.pass("Kullanici anasayfada oldugunu dogrular");

        //3-)Header bölümende 'Sign In' butonunu görüntüler
        softAssert.assertTrue(homePage.headerSignInButton.isDisplayed(), "Unable to display the Sign button");
        extentTest.pass("Header bolumunde Sıgn In butonunu goruntuler");

        //4-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tiklar");

        //5-)Kullanıcı login sayfasına yönlendirildigini dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "Unable to access login page");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //6-)'Forgot Password' linkine tıklar
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");

        //7-)Reset Password' sayfasına yölendirildigini dogrular
        String expectedResetPasswordUrl = ConfigReader.getProperty("001_lfcResetPasswordUrl");
        String actualResetPasswordUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualResetPasswordUrl, expectedResetPasswordUrl,"Unable to access the requested URL");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        //8-)Sol üst header menüde sitenin logosunu görüntüler
        softAssert.assertTrue(resetPasswordPage.resetPasswordLogo.isDisplayed(), "unable to view page logo");
        extentTest.pass("Kullanici sayfanin logosunu goruntuler");

        //9-)"Reset Password" formu metnini görüntüler
        softAssert.assertTrue(resetPasswordPage.getResetPasswordText.isDisplayed(),"Form text is not displayed");
        extentTest.pass("Kullanici formu goruntuler");

        //10-)"E-MailAddres" textbox'ını görüntüler
        softAssert.assertTrue( resetPasswordPage.emailBox.isDisplayed(), "unable to display emailaddress text box");
        extentTest.pass("Kullanici email texboxini goruntuler");

        //11-)" Send Password Reset Link " butonunu görüntüler
        softAssert.assertTrue(resetPasswordPage.resetPasswordButton.isDisplayed(),"unable to display button");
        extentTest.pass("Kullanici resetpassword butonunu goruntuler");

        softAssert.assertAll();
        //12-)Sayfayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }


    @Test
    public void TC_005ResetValidData(){
        extentTest = extentReports.createTest("Reset Password form functionality test",
                "Reset Password form must be functional");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(),
                "User was unable to access the homepage");
        extentTest.pass("Kullanici anasayfada oldugunu dogrular");

        //3-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tiklar");

        //4-)Kullanıcı login sayfasında oldugunu dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "Unable to access login page");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //5-)'Forgot Password' linkine tıklar
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");

        //6-)Kullanıcı resetpassword sayfasında oldugunu dogrular
        String expectedResetPasswordUrl = ConfigReader.getProperty("001_lfcResetPasswordUrl");
        String actualResetPasswordUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualResetPasswordUrl, expectedResetPasswordUrl,"Unable to access the requested URL");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        //7-)"E-MailAddres" textbox'ına sisteme kayıtlı bir e-posta adresi girer
        resetPasswordPage.emailBox.sendKeys(ConfigReader.getProperty("001_validDataEmail"));
        extentTest.pass("Kullanici email adresini email texbox'a girer");

        //8-)" Send Password Reset Link " butonuna tıklar
        resetPasswordPage.resetPasswordButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Kullanici butona tıklar");

        //9-)Şifrenin başarı ile sıfırlandıgı onay mesajını görüntüler(Contact the site administrator.)

        String expectedOnayMesaj = "Contact the site administrator";
        String actualOnayMesaj =  Driver.getDriver().switchTo().alert().getText();

        softAssert.assertEquals(actualOnayMesaj,expectedOnayMesaj,"unable to display message");
        extentTest.info("Kullanici mesaj sifirlama onay mesajini gorutuler");

        Driver.getDriver().switchTo().alert().accept();

        //10-)Sayafayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }

    @Test
    public void TC_006ResetInValidData(){
        extentTest = extentReports.createTest("reset password with invalid information test",
                "password should not be reset with invalid information");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "User could not access the homepage");
        extentTest.pass("Kullanici anasayfada oldugunu dogrular");

        //3-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tiklar");

        //4-)Kullanıcı login sayfasında oldugunu dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "Unable to access login page");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //5-)'Forgot Password' linkine tıklar
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");


        //6-)Kullanıcı resetpassword sayfasında oldugunu dogrular
        String expectedResetPasswordUrl = ConfigReader.getProperty("001_lfcResetPasswordUrl");
        String actualResetPasswordUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualResetPasswordUrl, expectedResetPasswordUrl,"Unable to access the requested URL");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        //7-)"E-MailAddres" textbox'ına sisteme kayıtlı olmayan bir e-posta adresi gir
        resetPasswordPage.emailBox.sendKeys(ConfigReader.getProperty("001_unRegisteredEmailAdress"));
        extentTest.pass("Kullanici email adresini girer");

        //8-)" Send Password Reset Link " butonuna tıkla
        resetPasswordPage.resetPasswordButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Kullanici butona tiklar");

        //9- "We can't find a user with that e-mail address." mesajını görüntüler
        String expectedMessage ="We can't find a user with that e-mail address.";
        String actualMessage = resetPasswordPage.invalidEmailMessage.getText();

        softAssert.assertEquals(actualMessage,expectedMessage,"unable to display message");
        extentTest.info("Kullanici sistem mesajini goruntuler");

        //10-)Sayafayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }

    @Test
    public void TC_007ResetInValidData(){
        extentTest = extentReports.createTest("Test that it does not accept non-standard email addresses ",
                "Test that it does not accept non-standard email addresses");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "User was unable to access the homepage");
        extentTest.pass("Kullanici anasayfada oldugunu dogrular");

        //3-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tiklar");

        //4-)Kullanıcı login sayfasında oldugunu dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "Unable to access login page");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //5-)'Forgot Password' linkine tıklar
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");

        //6-)Kullanıcı resetpassword sayfasında oldugunu dogrular
        String expectedResetPasswordUrl = ConfigReader.getProperty("001_lfcResetPasswordUrl");
        String actualResetPasswordUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualResetPasswordUrl, expectedResetPasswordUrl,"Unable to access the requested URL");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        //7-)"E-MailAddres" textbox'ına standart dışı e-posta adresi girer
        resetPasswordPage.emailBox.sendKeys(ConfigReader.getProperty("001_nonStandardEmailAdress"));
        extentTest.info("Kullanici standart dısı email adresini girer");

        //8-)" Send Password Reset Link " butonuna tıklar
        resetPasswordPage.resetPasswordButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Kullanici sifre sifirlamak icin butona tiklar");

        //9-)Sifre sıfırlama isleminin gercekleşmedigini dogrula
        softAssert.assertTrue(resetPasswordPage.resetPasswordButton.isDisplayed(), "unable to log in to the system");
        extentTest.info("Kullanici sifre sifirlama yapamadigini dogrular");

        //10-)Sayfayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }

    @Test
    public void TC_008ResetEmptData(){
        extentTest = extentReports.createTest("Test that it does not accept empty email addresses ",
                "Test that it does not accept empty email addresses");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Anasayfada oldugunu dogrular
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "User was unable to access the homepage");
        extentTest.pass("Kullanici anasayfada oldugunu dogrular");

        //3-)Kullanıcı 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tiklar");

        //4-)Kullanıcı login sayfasında oldugunu dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "Unable to access login page");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //5-)'Forgot Password' linkine tıklar
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");

        //6-)Kullanıcı resetpassword sayfasında oldugunu dogrular
        String expectedResetPasswordUrl = ConfigReader.getProperty("001_lfcResetPasswordUrl");
        String actualResetPasswordUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualResetPasswordUrl, expectedResetPasswordUrl,"Unable to access the requested URL");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        //7-)"E-MailAddres" textbox'ını boş bırakır
        resetPasswordPage.emailBox.sendKeys(ConfigReader.getProperty("001_emptyEmailAdress"));
        extentTest.info("Kullanici email kutusunu bos birakir");

        //8-)" Send Password Reset Link " butonuna tıklar
        resetPasswordPage.resetPasswordButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Kullanici sifre sifirlamak icin butona tiklar");

        //9-)Sifre sıfırlama isleminin gercekleşmedigini dogrula
        softAssert.assertTrue(resetPasswordPage.resetPasswordButton.isDisplayed(),"unable to reset password");
        extentTest.info("Kullanici sifre sifirlama yapamadigini dogrular");

        //10-)Sayfayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }

    @Test
    public void TC_009NavigateToLoginPage(){

        extentTest = extentReports.createTest(" login button redirects to login page ",
                " login button should redirect to login page");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");


        //2-)Anasayfada oldugunu dogrular
        softAssert.assertTrue(homePage.headerDepartments.isDisplayed(), "User was unable to access the homepage");
        extentTest.pass("Kullanici anasayfada oldugunu dogrular");

        //3-)Kullanıcı 'Sign In' butonuna tıkla
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tiklar");

        //4-)Kullanıcı login sayfasında oldugunu dogrular
        String expectedLoginUrl = ConfigReader.getProperty("001_lfcLoginUrl");
        String actualLoginUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualLoginUrl,expectedLoginUrl, "Unable to access login page");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //5-)'Forgot Password' linkine tıkla
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");

        //6-)Kullanıcı resetpassword sayfasında oldugunu dogrular
        String expectedResetPasswordUrl = ConfigReader.getProperty("001_lfcResetPasswordUrl");
        String actualResetPasswordUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualResetPasswordUrl, expectedResetPasswordUrl,"Unable to access the requested URL");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        //7-)Login butonunun görüntülendigini dogrular
        softAssert.assertTrue(resetPasswordPage.loginButton.isDisplayed(), "unable to display login button");
        extentTest.pass("Kullanici login butonunu gorutuledigini dogrular");

        //8-)Login butonuna tıklar
        resetPasswordPage.loginButton.click();
        extentTest.pass("Kullanici login butonuna tiklar");

        //9-)Sayfayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }

    @Test
    public void TC_010LoginNew_Password(){
        extentTest = extentReports.createTest(" Test to log into the system with a new password",
                "Should be able to log into the system with a new password");

        //1-)Kullanıcı ilgili Url ile sayfaya gider gider.
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));
        extentTest.info("Kullanici loyalfriendcare anasayfaya gider");

        //2-)Homepage sayfasında 'Sign In' butonuna tıklar
        homePage.headerSignInButton.click();
        extentTest.info("Kullanici Singn In butonuna tiklar");

        //3-)Kullanıcı login sayfasında oldugunu dogrular
        softAssert.assertTrue(loginPage.forgotPasswordLink.isDisplayed(), "Login page is not accessible");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //4-)'Forgot Password' linkine tıkla
        loginPage.forgotPasswordLink.click();
        extentTest.info("Kullanici ForgotPassword linkini tiklar");

        //5-)Kullanıcı resetpassword sayfasında oldugunu dogrular
        softAssert.assertTrue(resetPasswordPage.resetPasswordButton.isDisplayed(),
                "could not verify that the user was on the page");
        extentTest.pass("Kullanici reset password sayfasinda oldugunu dorular");

        //6-)Login butonuna tıkla
        resetPasswordPage.loginButton.click();
        extentTest.info("Kullanici login butonuna tiklar");

        //7-)Kullanıcı login sayfasında oldugunu dogrular
        softAssert.assertTrue(loginPage.signInButton.isDisplayed(),"could not verify that the user was on the page");
        extentTest.pass("Kullanici login sayfasinda oldugunu dogruladi");

        //8-)Mail textbox'ına kullanıcı e-posta adresini gir
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("001_userValidEmail"));
        extentTest.info("Kullanici epostasini sisteme girer");

        //9-)Şifre textbox'ına yeni şifreyi gir
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("001_userNewPassword"));
        extentTest.info("Kullanici yeni sifreyi sisteme girer");

        //10-)Sign In butonuna tıkla
        loginPage.signInButton.click();
        extentTest.info("Kullanici Sign In butonuna basar ");

        //11-)Sisteme giriş yapıldıgını dogrular
        softAssert.assertTrue( homePage.headerSignInButton.isDisplayed(), "unable to log in to the system");
        extentTest.pass("Kullanici yeni  sifre ile sisteme giris yapılamadigini dogrular");

        //12)Kullanıcı sayfayı kapatır
        extentTest.info("Kullanici sayfayi kapatir");

    }


}
