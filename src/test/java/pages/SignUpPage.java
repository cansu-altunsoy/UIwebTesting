package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='name']")
    public WebElement signUpUserNameBox;

    @FindBy (xpath = "//*[@id='email']")
    public WebElement signUpEmailBox;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement signUpPasswordBox;

    @FindBy (xpath = "//*[@id='password-confirm']")
    public WebElement confirmPasswordBox;

    @FindBy (xpath = "//button[.='Sign Up']")
    public WebElement signUpButton;

    @FindBy (xpath = "//span[@class='invalid-feedback']")
    public WebElement errorMessage;
}
