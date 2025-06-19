package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminRolesPages {

    public AdminRolesPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Dashboard Role'e ait locate'ler

    @FindBy(xpath ="(//*[@class='title'])[2]")
    public WebElement dashboardRoles;

    @FindBy(xpath ="(//a[.='Roles'])[1] ")
    public WebElement dashboardRolesRoles;

    @FindBy(xpath = "(//a[.='Create Role'])[1]")
    public WebElement dashboardRolesCreateRoles;


    //  Roles Sayfası Locate'leri
    @FindBy(xpath = "//h3[contains(text(),'Roles')]")
    public WebElement rolesPageRolesTitle;

    @FindBy (xpath = "//*[@class='card-title']")
    public WebElement rolesTableRoles;

    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> tableRoleNameCollumnAll;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement>  tableRoleDisplayNameCollumnAll;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement>  tableRoleCreateAtCollumnAll;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement>  tableRoleActionsCollumnAll;



    @FindBy(xpath = "//tbody//tr")
    public WebElement tableRoleAllRows;

    @FindBy (id="search-table")
    public WebElement rolesSearchBox;

    @FindBy (xpath = "//*[@class='dataTables_info']")
    public WebElement rolesSearchFiltredResult;

    @FindBy (xpath = "//tbody//tr")
    public WebElement rolesSearchNoResultFound;

    @FindBy (xpath = "//span[.='Delete']")
    public WebElement rolesActionsAllDeleteButton;
    @FindBy (xpath = "//span[.='Role deleted successfully']")
    public WebElement rolesSuccessfullyDeletedMesagge;

    @FindBy (xpath = "//a[.='Add Role']")
    public WebElement addRoleButton;

    @FindBy (xpath = "(//*[@class='alert alert-danger'])[1]")
    public WebElement theNameHasAlreadyBeenTakenMessage;


    // Create Roles Sayfası Locate'leri

    @FindBy (xpath = "//h3[contains(text(),'add role')]")
    public  WebElement creatRolePageAddRoleTitle;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//*[@id='guard_name']")
    public WebElement displayNameTextBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement createRoleSaveButton;

    @FindBy(xpath = "//*[.='Role Store successfully.']")
    public WebElement roleStoreSuccessfullyMessage;

    @FindBy(xpath = "//*[@class='close']")
    public WebElement closeRoleStoreSuccessfullyMessage;
}
