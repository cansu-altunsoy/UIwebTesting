package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminBedManagersPage {

    public AdminBedManagersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Bed Managers Locates

    @FindBy(xpath = "(//*[.='Bed managers'])[1]")
    public WebElement dashboardBedManagersButton; // sol açılır menüde bulunan bed managers başlığı

    @FindBy(xpath = "(//*[.='Bed managers'])[2]")
    public WebElement dashboardSubBedManagersButton; // sol açılır menüde bulunan bed managers altındaki bed managers başlığı

    @FindBy(xpath = "//*[.='Create Bed managers']")
    public WebElement dashboardSubCreateBedManagersButton; // sol açılır menüde bulunan create bed manager alt başlığı

    @FindBy(xpath = "//*[@*='card-title']")
    public WebElement tableBedManagersElement; // bed managers sayfasına gidildiğini görmek için bunu kullan

    @FindBy(xpath = "(//*[@*='card-title'])[1]")
    public WebElement createYourBedManagersElement; // create bed managers sayfasına gidildiğini görmek için kullan

    @FindBy(xpath = "(//*[@*='tableWithSearch_info'])[2]")
    public WebElement bedSizeListTextElement; // sayfanın en altında bulunan showing entries kısmına ait yazı

    @FindBy(xpath = "//*[.='Vaccinations Room']")
    public WebElement vaccinationsRoomTextElement; // vaccinations gözüktü mü doğrulama yaparken kullan

    @FindBy(id = "search-table")
    public WebElement bedManagersSearchBox; // bed managersde bulunan search kutusu

    @FindBy(xpath = "//span[.='Edit']")
    public WebElement bedManagersEditButonu; // herhangi bir yatağa gelip edit yapmak için kullan

    @FindBy(xpath = "//*[@*='form-control ']")
    public WebElement editBedManagersTitleBox; // edit sayfasındaki bed managers title kutusu

    @FindBy(xpath = "//*[@*='note-editable']")
    public WebElement editBedManagersContentBox; // edit sayfasındaki content bölümüne yazı yazacagın kutu

    @FindBy(xpath = "(//*[@*='select2-selection__rendered'])[2]")
    public WebElement editCreatedDropdownButton; // edit sayfasında doktora,medicine gb tıkla

    @FindBy(xpath = "(//*[@*='select2-results__option'])[3]")
    public WebElement editBedDoctorAndMedicineSub; // edit sayfasındaki doktor ve diğer bölümlerde açılır menüdeki kullanmak istenilen !!

    @FindBy(xpath = "//*[@*='Bed Price']")
    public WebElement editBedPriceBox; // edit sayfasındaki fiyat kutusu

    @FindBy(xpath = "//*[@*='submit']")
    public WebElement editSubmitButton; // edit sayfasındaki kaydet butonu ve table bed managers sayfasında delete butonu

    @FindBy(xpath = "//*[.='Care Room']")
    public WebElement firstBedManagersTitle; // editten sonraki ilk kullanıcının title ismi

    @FindBy(xpath = "//*[.='Dental Care Room']")
    public WebElement searchFirstBedManagersTitle; // editten sonra care siliniyor aramada olmadığını gösteren locate

    @FindBy(xpath = "//*[.='Tracks Updated successfully.']")
    public WebElement editNextAlertTextElement; // editleme yaptıktan sonraki uyarı yazısı

    // olmayan birşeyi doğrulama yapmak istenmiş o yüzden bedManagersSearchBox ile yatagı aratıp olmadığını dair yazıyı gösterebilirim

    @FindBy(xpath = "//td[.='No matching records found']")
    public WebElement bedManagersNoMatchTextElement; // eşlesme olmadığına dair uyarı yazısı

    @FindBy(xpath = "//*[.='Tracks Store successfully.']")
    public WebElement editNextAlertTextElementStore; // create bed managers sayfasında yeni yatak olustuktan sonraki uyarı yazısı



}
