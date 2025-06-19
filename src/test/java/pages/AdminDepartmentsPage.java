package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDepartmentsPage {

    public  AdminDepartmentsPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//*[.='Departments'])[1]")
    public WebElement dbrdDepartments;

    @FindBy (xpath = "(//*[text()='Departments'])[2]")
    public WebElement Departments;

    @FindBy(xpath = "(//*[@class='card-body'])[1]")
    public WebElement depDogrulama;

    @FindBy(xpath = "//*[@*='form-control pull-right']")
    public WebElement dSearchBox;

    @FindBy (xpath = "(//td['v-align-middle semi-bold'] )[3]")
    public WebElement searchText;

    @FindBy(xpath = "//*[@class='dataTables_info']")
    public WebElement showingEntry;

    @FindBy(xpath = "//th[1]")
    public WebElement image;

    @FindBy(xpath = "//th[2]")
    public WebElement order;

    @FindBy(xpath = "//th[3]")
    public WebElement name;

    @FindBy(xpath = "//th[4]")
    public WebElement color;

    @FindBy(xpath = "//th[5]")
    public WebElement departmentsEdit;

    @FindBy (xpath = "//*[@class='breadcrumb-item active']")
    public WebElement editPage;

    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    public WebElement editButtononOnesRow;

    @FindBy (xpath = "//tbody/tr[1]/td[5]")
    public WebElement deleteButtonOnesRow;

    @FindBy (xpath = "//span[.='Departments deleted successfully']")
    public WebElement deletedmessage;

    @FindBy(xpath = "//th[6]")
    public WebElement departmentsAction;

    @FindBy(xpath = "//*[contains(text(),'Next »')]")
    public WebElement dNextButton;

    @FindBy (xpath = "//tbody/tr[1]/td[3]")
    public WebElement eklenenDep;

    //Create Departments locaterlari

    @FindBy(xpath = "//a[text()='Create Departments']")
    public WebElement DbrdCreateDepartments;

    @FindBy(xpath = "//h3[contains(text(),' New Depart')]")
    public WebElement newDepartments;

    @FindBy(xpath = "(//*[@type='number'])[1]")
    public WebElement parentBox;

    @FindBy(xpath = "(//*[@type='number'])[2]")
    public WebElement orderBox;

    @FindBy(xpath = "//input[@placeholder='ex: Title Departments']")
    public WebElement tittleBox;

    @FindBy(xpath = "//*[@class='selection']")
    public WebElement colorBox;

    @FindBy(xpath = "(//*[@class='select2-results__option'])[2]")
    public WebElement colorComplete;

    @FindBy(xpath = "//*[@class='dz-default dz-message']")
    public WebElement imgUpload;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement saveButton;

    @FindBy (xpath = "//span[text()='Departments Store successfully.']")
    public WebElement onayMesaji;

    @FindBy(xpath = "//*[@class='close']")
    public WebElement onayMesajiKapat;




}
