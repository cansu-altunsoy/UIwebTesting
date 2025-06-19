package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

  
    // Header menunun locater'laridir

    @FindBy(xpath = "(//a[text()='Home'])[2]")
    public WebElement headerHome;

    @FindBy(xpath = "(//a[text()='About Us'])[2]")
    public WebElement headerAboutUs;

    @FindBy(xpath = "(//a[text()='Departments '])[3]")
    public WebElement headerDepartments;

    @FindBy(xpath = "(//a[text()='Doctors'])[4]")
    public WebElement headerDoctors;

    @FindBy(xpath = "(//a[text()='Medicines'])[3]")
    public WebElement headerMedicines;

    @FindBy(xpath = "(//a[text()='Vaccinations'])[4]")
    public WebElement headerVaccinations;

    @FindBy (xpath = "//*[@id='logo']")
    public WebElement headerHomePageLogo;

    @FindBy (xpath = "//a[.=' Sign In']")
    public WebElement headerSignInButton;

    @FindBy (xpath = "//a[.=' Sign Up']")
    public WebElement headerSignUpButton;

    @FindBy(xpath = "(//*[@class='btn_add'])[1]")
    public WebElement headerAdminNameButton;

    @FindBy(xpath = "(//*[@class='btn_add'])[2]")
    public WebElement headerSignOutButton;

    @FindBy(xpath = "(//*[@class='btn_add'])[1]")
    public WebElement headerUserNameButton;





    // Body Locater'laridir

    @FindBy(xpath = "//h2[.='Popular Doctors']")
    public WebElement bodyPopularDoctorsTitle;

    @FindBy (xpath = "(//a[.='Doctors'])[3]")
    public WebElement bodyDoctorsMenu;

    @FindBy (xpath = "(//*[@class='row add_bottom_30'])[2]//*[@class='col-lg-3 col-sm-6'][1]")
    public WebElement bodyFirstDoctor;

    @FindBy (xpath = "(//a[.='Vaccinations'])[3]")
    public WebElement bodyVaccinationsMenu;

    @FindBy (xpath = "(//*[@class='row'])[1]//*[@class='col-lg-3 col-sm-6'][1]")
    public WebElement bodyFirstVaccinations;

    @FindBy(xpath = "//h2[.='Vaccinations for Pets']")
    public WebElement bodyVaccinationsForPetsTitle;
  
    @FindBy(xpath = "//*[@name='search']")
    public WebElement homePageSearchBox;

    @FindBy(xpath = "//h2[.='Departments']")
    public WebElement bodyDepartmentsTitle;

    @FindBy(xpath = "//a[.='Departments']")
    public WebElement bodyDepartmentsLink;

    @FindBy(xpath = "(//a[@class='grid_item small'])[1]")
    public WebElement bodyFirstDepartments;








  
  
    // Footer Locater'laridir

    @FindBy(xpath = "//ul[@class='links']//a[contains(.,'Wellness')]")
    public WebElement footerWellness;

    @FindBy(xpath = "//ul[@class='links']//a[contains(.,'Dental Care')]")
    public WebElement footerDentalCare;

    @FindBy(xpath = "//ul[@class='links']//a[contains(.,'Anaesthesia')]")
    public WebElement footerAnaesthesia;

    @FindBy(xpath = "//ul[@class='links']//a[contains(.,'Dermatology')]")
    public WebElement footerDermatology;

    @FindBy(xpath = "//ul[@class='links']//a[contains(.,'Diagnostics')]")
    public WebElement footerDiagnostics;

    @FindBy(xpath = "//i[@class='fab fa-facebook-square']")
    public WebElement footerFacebook;

    @FindBy(xpath = "//i[@class='fab fa-twitter-square']")
    public WebElement footerTwitter;

    @FindBy(xpath = "//i[@class='fab fa-youtube-square']")
    public WebElement footerYoutube;

    @FindBy(xpath = "//i[@class='fab fa-pinterest-square']")
    public WebElement footerPinterest;

    @FindBy(xpath = "//i[@class='fab fa-instagram']")
    public WebElement footerInstagram;

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-6 col-sm-6'])[4]")
    public WebElement footerContactUs;

    @FindBy(xpath = "//a[text()='Terms and conditions']")
    public WebElement footerTermsAndConditions;

    @FindBy(xpath = "//a[.='Faq']")
    public WebElement footerFaq;

    @FindBy(xpath = "//a[.='© 2023']")
    public WebElement footerCopyRight;

    @FindBy(xpath = "(//img[@class='logo_sticky'])[1]")
    public WebElement footerLogo;

    @FindBy(xpath = "( //*[text()=' Wellness'])[2]")
    public WebElement footerWellnessAppointments;






}
