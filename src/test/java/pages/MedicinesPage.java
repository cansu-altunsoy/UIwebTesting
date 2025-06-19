package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedicinesPage {

    public MedicinesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[text()='Medicines'])[3]")
    public WebElement homePageHeaderMedicines;

    @FindBy(xpath = "(//*[@class='img-fluid'])[1]")
    public WebElement medicinesFirstMedicineImage;

    @FindBy(xpath = "(//h3[a])[1]")
    public WebElement medicinesFirstMedicinesName;

    //ilk ilaça ait sayfanin locateleri

    @FindBy(xpath = "//img[@class='img-fluid']")
    public WebElement firstMedicineImage;

    @FindBy(tagName = "h1")
    public WebElement firstMedicineName;

    @FindBy(tagName = "p")
    public WebElement firstMedicineText;

    @FindBy(xpath = "//*[@name='Contact']")
    public WebElement appoinmentBookingForm;
}
