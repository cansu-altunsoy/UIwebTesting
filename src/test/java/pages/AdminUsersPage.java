package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminUsersPage {

    public AdminUsersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Users Page Locate'leri

    @FindBy(xpath = "//*[text()='Dashboard']")
    public WebElement dashboardButtonUserPage;

    @FindBy(xpath = "//*[text()='Add User']")
    public WebElement addUserButton;

    @FindBy(xpath = "//*[@id='search-table']")
    public WebElement searchUserBox;

    @FindBy(xpath = "//*[@class='relative inline-flex items-center px-4 py-2 text-sm font-medium text-gray-500 bg-white border border-gray-300 cursor-default leading-5 rounded-md']")
    public WebElement previousButtonUsersPage;

    @FindBy(xpath = "//*[@rel='next']")
    public WebElement nextButtonUsersPage;

    @FindBy(xpath = "//*[@id='tableWithSearch_info']")
    public WebElement numberOfShowingEntriesUsersPage;

  

    // Create Users Locate'leri

    @FindBy(xpath = "//*[@*='sidebar-menu']")
    public WebElement sideDashboardMenu;  // admin sayfasında sol açılır menü üzerine gelip gerekli bölümlere tıklama yapılabilir

    @FindBy(xpath = "(//span[.='Users'])[1]")
    public WebElement dashboardUsersButtonu; // sol açılır menüde Users başlığına tıklayıp alt başlıkları görebilmek

    @FindBy(xpath = "//*[.='Create User']")
    public WebElement dashboardCreateUsersButton; // sol açılır menüdeki Create Users alt başlığına tıklamak

    @FindBy(tagName = "h3" )
    public WebElement createUsersPageAddUserTag; // create users sayfasında "add User" başlık yazı elementi

    @FindBy(xpath = "(//*[@*='form-control '])[1]")
    public WebElement nameBox; // create users sayfasında name kutusu

    @FindBy(xpath = "(//*[@*='form-control '])[2]")
    public WebElement phoneBox; // create users sayfasında phone kutusu

    @FindBy(xpath = "(//*[@*='form-control '])[3]")
    public WebElement passwordBox; // create users sayfasında password kutusu

    @FindBy(xpath = "(//*[@*='form-control '])[4]")
    public WebElement passwordConfirmationBox; // create users sayfasında password doğrulama kutusu

    @FindBy(xpath = "(//*[@*='form-control '])[5]")
    public WebElement emailBox; // create users sayfasında mail kutusu

    @FindBy(xpath = "//*[@*='checkbox']")
    public WebElement usersRadioButton; // create users sayfasında user kutucuğunu işaretlemek

    @FindBy(id = "dropzone")
    public WebElement photoButton; // create users sayfasında fotoğraf yükleme butonu

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement saveButton; // create users sayfasında kaydetme butonu

    @FindBy(xpath = "//*[.='User Store successfully.']")
    public WebElement alertText; // kullanıcı oluşturduktan sonra çıkan uyarı yazısı

    @FindBy(xpath = "//a[.='Users']")
    public WebElement dashboardSubUsersButton; // dashboard panelinde Users başlığı altındaki users alt başlığı

    @FindBy(xpath = "//*[@*='card-title']")
    public WebElement tableUsersElement; // kullanıcı listesinin gelip gelmediğini kontrol etmek için kullan

    @FindBy(id = "search-table")
    public WebElement usersSearchBox; // search kutusundan aratma yapmak için kullan

    @FindBy(xpath = "//td[.='No matching records found']")
    public WebElement noMatch; // search ile aratma yapıldığında kullanıcı bulunamayınca kullan

    @FindBy(xpath = "(//*[@class='card card-transparent'])[2]")
    public WebElement tableUsers; //kullanıcı tablosu

    @FindBy(xpath = "//*[@role='row']//*[@class='v-align-middle semi-bold']")
    public List<WebElement> usersInfoList; //kullanıcı bilgileri

    @FindBy(xpath = "//*[@class='v-align-middle semi-bold'][1]")
    public WebElement searchedRegisterUser; //aranan kullanıcı ismi

    @FindBy(xpath = "//*[text()='No matching records found']")
    public WebElement userNotFoundMessage; // aranan kullanıcının bulunamadı mesajı

    @FindBy(xpath = "//*[@role='row']//*[@class='v-align-middle text-right'][1]")
    public List<WebElement> usersEditButtonsList; // tablodaki satırdaki tüm edit butonları

    @FindBy(xpath = "//*[@role='row']//*[@class='v-align-middle text-right'][2]")
    public List<WebElement> usersDeleteButtons; // tablodaki satırdaki tüm delete butonları

    @FindBy(xpath = "//*[@role='row'][1]//*[@class='v-align-middle text-right'][1]")
    public WebElement userEditButton; // tablodaki kullanıcının edit butonu

    @FindBy(xpath = "//*[@role='row'][1]//*[@class='v-align-middle semi-bold'][1]")
    public WebElement userNameText; // tablodaki kullanıcı ismi



    //User Edit Page sayfasındaki locate'ler

    @FindBy(tagName = "h3")
    public WebElement editPageUserName; // edit sayfasındaki kullanıcı ismi

    @FindBy(xpath = "//*[@id='Phone']")
    public WebElement editPagePhoneBox; // edit sayfasındaki phone alanı

    @FindBy(xpath = "//*[@id='password']")
    public WebElement editPagePasswordBox; // edit sayfasındaki password alanı

    @FindBy(xpath = "//*[@id='password_confirmation']")
    public WebElement editPagePasswordConfirmationBox; // edit sayfasındaki password confirmation alanı

    @FindBy(xpath = "//*[@id='email']")
    public WebElement editPageEmailBox; // edit sayfasındaki email alanı

    @FindBy(xpath = "//*[@id='button']")
    public WebElement editPageDontChangeImageButton; // edit sayfasındaki Dont Cahenge Image butonu

    @FindBy(xpath = "//*[text()='save']")
    public WebElement editPageSaveButton;

    @FindBy(xpath = "//*[@method='post']")
    public WebElement editPageDropFilesToUpload;

    @FindBy(xpath = "//*[text()='User Updated successfully.']")
    public WebElement editConfirmationMessage;

    @FindBy(xpath = "//*[text()='User deleted successfully']")
    public WebElement userDeletedMessage;

    @FindBy(xpath = "(//*[text()='Delete'])[2]")
    public WebElement deleteUserButton;

    @FindBy(xpath = "//*[@class='close']")
    public WebElement closeConfirmationMessage;



}
