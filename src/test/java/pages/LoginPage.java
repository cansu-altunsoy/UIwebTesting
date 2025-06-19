package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath= "//*[@id='email']")
    public WebElement loginEmailBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement loginPasswordBox;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@alt='logo']")
    public WebElement loginPageLogo;

    @FindBy(xpath = "//*[@class='lazy']")
    public WebElement loginPageImage;

    @FindBy(xpath = "//*[@role='form']")
    public WebElement loginForm;

    @FindBy(xpath = "//label[@for='checkbox1']")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = "//*[text()='Forgot Password']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[.='These credentials do not match our records.']")
    public WebElement missMatchedDataMessage;

    @FindBy(xpath = "//*[@class='semi-bold']")
    public WebElement loyalFriendCareText;


}
