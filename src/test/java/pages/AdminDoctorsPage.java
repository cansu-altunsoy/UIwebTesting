package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminDoctorsPage {

    public AdminDoctorsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // CreateDoctorsPage Locator'leri

    @FindBy(xpath = "//span[.='Doctors']")
    public WebElement doctorsLink;

    @FindBy(xpath = "(//*[text()='Doctors'])[2]")
    public WebElement subheadingDoctorsButton;

    @FindBy(xpath = "//a[.='Create Doctors']")
    public WebElement createDoctorsLink;

    @FindBy(xpath = "//li[.='Create Doctors']")
    public WebElement createDoctorsText;

    @FindBy(xpath = "//*[@id='Title_en']")
    public WebElement doctorsTitleTextbox;

    @FindBy(xpath = "//*[@id='body_en']")
    public WebElement doctorsContentEnglishTextbox;

    @FindBy(xpath = "//*[@id='dropzone']")
    public WebElement doctorsImageDropzone;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement doctorsSaveButton;

    @FindBy(xpath = "//div[@class='pgn-wrapper']")
    public WebElement doctorConfirmMessage;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement messageBoxCloseButton;


    //Doctors Page Locate'leri

    @FindBy(xpath = "//*[text()='Dashboard']")
    public WebElement dashboardButtonDoctorsPage;

    @FindBy(xpath = "//*[text()='Add Doctors']")
    public WebElement addDoctorsButton;

    @FindBy(xpath = "//*[@id='search-table']")
    public WebElement searchDoctorsBox;

    @FindBy(xpath = "//*[@class='relative inline-flex items-center px-4 py-2 text-sm font-medium text-gray-500 bg-white border border-gray-300 cursor-default leading-5 rounded-md']")
    public WebElement previousButtonDoctorsPage;

    @FindBy(xpath = "//*[@rel='next']")
    public WebElement nextButtonDoctorsPage;

    @FindBy(xpath = "//*[@id='tableWithSearch_info']")
    public WebElement numberOfShowingEntriesDoctorsPage;

    @FindBy(xpath = "(//*[@class='card card-transparent'])[2]")
    public WebElement tableDoctors; //kullanıcı tablosu

    @FindBy(xpath = "//*[@class='v-align-middle semi-bold']")
    public List<WebElement> doctorsNameList;

    @FindBy(xpath = "(//*[@class='v-align-middle semi-bold'])[1]")
    public WebElement searchedRegisterDoctor;

    @FindBy(xpath = "//*[text()='No matching records found']")
    public WebElement noMatchingRecordsFoundMessage; // aranan kelime bulunamadı mesajı

    @FindBy(xpath = "//*[@role='row'][1]//*[@class='v-align-middle text-right'][1]")
    public WebElement firstDoctorEditButton; // ilk doktorun edit butonu

    @FindBy(xpath = "//*[@role='row'][1]//*[@class='v-align-middle text-right'][2]")
    public WebElement firstDoctorDeleteButton; // ilk doktorun edit butonu


}
