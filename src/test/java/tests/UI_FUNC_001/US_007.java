package tests.UI_FUNC_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_007 {

    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();

    @Test
    public void TC06_MemberRegisterAccess(){

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Assert.assertTrue(homePage.headerSignUpButton.isDisplayed());
        Assert.assertTrue(homePage.headerSignUpButton.isEnabled());

        homePage.headerSignUpButton.click();
        String expectedRegisterPageUrl = ConfigReader.getProperty("008_registerUrl");
        String actualRegisterPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualRegisterPageUrl, expectedRegisterPageUrl);

        signUpPage.signUpUserNameBox.click();
        Assert.assertTrue(signUpPage.signUpUserNameBox.isEnabled());

        signUpPage.signUpEmailBox.click();
        Assert.assertTrue(signUpPage.signUpEmailBox.isEnabled());

        signUpPage.signUpPasswordBox.click();
        Assert.assertTrue(signUpPage.signUpPasswordBox.isEnabled());

        signUpPage.confirmPasswordBox.click();
        Assert.assertTrue(signUpPage.confirmPasswordBox.isEnabled());

        signUpPage.signUpButton.click();
        Assert.assertTrue(signUpPage.signUpButton.isEnabled());


    }

    @Test
    public void TC07_registerWithValidEmailAndPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Assert.assertTrue(homePage.headerSignUpButton.isDisplayed());
        Assert.assertTrue(homePage.headerSignUpButton.isEnabled());

        homePage.headerSignUpButton.click();
        String expectedRegisterPageUrl = ConfigReader.getProperty("008_registerUrl");
        String actualRegisterPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualRegisterPageUrl, expectedRegisterPageUrl);

        signUpPage.signUpUserNameBox.sendKeys(ConfigReader.getProperty("008_validUserName"));
        signUpPage.signUpEmailBox.sendKeys(ConfigReader.getProperty("008_validEmail"));
        signUpPage.signUpPasswordBox.sendKeys(ConfigReader.getProperty("008_validPassword"));
        signUpPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("008_validPasswordConfirmation"));
        signUpPage.signUpButton.click();

        Assert.assertTrue(homePage.headerUserNameButton.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void TC08_createWithRegisteredEmail(){

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Assert.assertTrue(homePage.headerSignUpButton.isDisplayed());
        Assert.assertTrue(homePage.headerSignUpButton.isEnabled());

        homePage.headerSignUpButton.click();
        String expectedRegisterPageUrl = ConfigReader.getProperty("008_registerUrl");
        String actualRegisterPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualRegisterPageUrl, expectedRegisterPageUrl);

        signUpPage.signUpUserNameBox.sendKeys(ConfigReader.getProperty("008_registeredUserName"));
        signUpPage.signUpEmailBox.sendKeys(ConfigReader.getProperty("008_registeredEmail"));
        signUpPage.signUpPasswordBox.sendKeys(ConfigReader.getProperty("008_registeredPassword"));
        signUpPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("008_registeredPasswordConfirmation"));
        signUpPage.signUpButton.click();


        String expectedErrorMessage = ConfigReader.getProperty("008_registeredEmailErrorMessage");
        String actualErrorMessage = signUpPage.errorMessage.getText();


        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));

        Driver.quitDriver();



    }

    @Test
    public void TC09_registerWithInvalidEmailAndPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Assert.assertTrue(homePage.headerSignUpButton.isDisplayed());
        Assert.assertTrue(homePage.headerSignUpButton.isEnabled());

        homePage.headerSignUpButton.click();
        String expectedRegisterPageUrl = ConfigReader.getProperty("008_registerUrl");
        String actualRegisterPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualRegisterPageUrl, expectedRegisterPageUrl);

        signUpPage.signUpUserNameBox.sendKeys(ConfigReader.getProperty("008_invalidUserName"));
        signUpPage.signUpEmailBox.sendKeys(ConfigReader.getProperty("008_invalidEmail"));
        signUpPage.signUpPasswordBox.sendKeys(ConfigReader.getProperty("008_invalidPassword"));
        signUpPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("008_invalidPassword"));

        signUpPage.signUpButton.click();

        ReusableMethods.bekle(2);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(signUpPage.signUpButton.isDisplayed());

        softAssert.assertAll();

        Driver.quitDriver();


    }

    @Test
    public void TC10_requiredRegisterWithoutFillingTheField(){
        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Assert.assertTrue(homePage.headerSignUpButton.isDisplayed());
        Assert.assertTrue(homePage.headerSignUpButton.isEnabled());

        homePage.headerSignUpButton.click();
        String expectedRegisterPageUrl = ConfigReader.getProperty("008_registerUrl");
        String actualRegisterPageUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualRegisterPageUrl, expectedRegisterPageUrl);

        signUpPage.signUpUserNameBox.sendKeys(ConfigReader.getProperty("008_registeredUserName"));
        signUpPage.signUpButton.click();
        ReusableMethods.bekle(1);

        Assert.assertTrue(signUpPage.signUpEmailBox.isDisplayed());


    }
}
