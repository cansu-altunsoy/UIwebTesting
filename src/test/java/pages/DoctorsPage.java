package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DoctorsPage {

    public DoctorsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='col-md-6'])[1]")
    public WebElement doctorsPageFirstDoctor;

    @FindBy(xpath = "(//div[@class='container'])[1]")
    public WebElement clickedDoctorName;

    @FindBy(xpath = "//*[@id='filters_col_bt']")
    public WebElement doctorsMenu;

}
