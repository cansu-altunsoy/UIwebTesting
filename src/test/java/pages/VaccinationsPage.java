package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VaccinationsPage {

    public VaccinationsPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='img-fluid'])[1]")
    public WebElement firstVaccinationImage;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement firstVaccinationName;

    @FindBy(xpath = "(//small)[1]")
    public WebElement firstVaccinationDate;

    @FindBy(xpath = "//h1[.='Vaccinations']")
    public WebElement bodyVaccinationName;

    @FindBy(xpath = "detail_title_1")
    public WebElement bodyVaccinationDate;

    @FindBy(xpath = "(//h1)[2]")
    public WebElement clickedVaccinationName;

}
