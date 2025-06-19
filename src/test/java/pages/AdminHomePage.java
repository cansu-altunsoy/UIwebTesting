package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminHomePage {

    public AdminHomePage() {PageFactory.initElements(Driver.getDriver(), this);}

    //This webelement represents the user photo located at the top right of the admin homepage.
    @FindBy(xpath = "//*[@*='profile-dropdown-toggle']")
    public WebElement adminUserLogoDdm;

    @FindBy(xpath = "//a[text()='Learn More at Users']")
    public WebElement AdminLearnMoreAtUsers;

    @FindBy(xpath = "//a[text()='Learn More at Bed managers']")
    public WebElement AdminLearnMoreAtBedManagers;

    @FindBy(xpath = "//a[text()='Learn More at Roles']")
    public WebElement AdminLearnMoreAtRoles;

    @FindBy(xpath = "//a[text()='Learn More at Settings']")
    public WebElement AdminLearnMoreAtSettings;

    @FindBy(xpath = "//a[text()='Learn More at Messages']")
    public WebElement AdminLearnMoreAtMessages;

    @FindBy(xpath = "//a[text()='Learn More at Google Advertisement']")
    public WebElement AdminLearnMoreAtGoogleAds;

    @FindBy(xpath = "//a[text()='Learn More at Medicines']")
    public WebElement AdminLearnMoreAtMedicines;

    @FindBy(xpath = "//a[contains(@href, 'facebook.com')]")
    public WebElement AdminFacebookBtn;

    @FindBy(xpath = "//a[contains(@href, 'https://twitter.com')]")
    public WebElement AdminTwitterBtn;

    @FindBy(xpath = "//a[contains(@href,'https://www.pinterest.com')]")
    public WebElement AdminPinterestBtn;

    @FindBy(xpath = "//a[contains(@href,'https://www.instagram.com')]")
    public WebElement AdminInstagramBtn;

    @FindBy(xpath = "//a[contains(@href,'https://www.linkedin.com')]")
    public WebElement AdminLinkedinBtn;

    @FindBy(xpath = "//a[contains(@href,'https://www.tumblr.com')]")
    public WebElement AdminTumblrBtn;

    @FindBy(xpath = "//a[contains(@href,'https://github.com')]")
    public WebElement AdminGithubBtn;

    @FindBy(xpath = "//*[@*='sidebar-menu']")
    public WebElement AdminsidebarDashboardMenu;

}
