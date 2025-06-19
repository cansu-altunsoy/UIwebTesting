package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DepartmentsPage {

    public DepartmentsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "( //h1[.=' Wellness'])[2]")
    public WebElement firstDepartmentName;

    @FindBy(xpath = "//*[@class='img-fluid']")
    public WebElement firstDepartmentImage;

    @FindBy(xpath = "//*[@class='detail_title_1']")
    public WebElement firstDepartmentAddedDate;

    @FindBy(xpath = "//img[@alt='Wellness Room']")
    public WebElement firstBedDepartment;

    @FindBy(id = "filters_col_bt")
    public WebElement departmentMenuTitle;

    @FindBy(xpath = "(//h1[.=' Wellness'])[1]")
    public WebElement deparmentFirstIcon;

    @FindBy(xpath = "//*[.='Wellness']")
    public WebElement departmentFirst;



}
