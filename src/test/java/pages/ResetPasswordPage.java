package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ResetPasswordPage {

    public ResetPasswordPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@id='logo']")
    public WebElement resetPasswordLogo;

    @FindBy(xpath = "//*[.='Reset Password']")
    public WebElement getResetPasswordText;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginButton;
}
