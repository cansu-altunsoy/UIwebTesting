package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AboutUsPage {

    //this is

    public AboutUsPage() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//div[1]/a[@pathname='/Contact']")
    public WebElement BudgetFriendlyVetCareBtn;

    @FindBy(xpath = "//div[2]/a[@pathname='/Contact']")
    public WebElement PetShelterFacilitiesBtn;

    @FindBy(xpath = "//div[3]/a[@pathname='/Contact']")
    public WebElement TopQualityAndCertifiedVetBtn;

    @FindBy(xpath = "//div[4]/a[@pathname='/Contact']")
    public WebElement OneStopPetNutritionShopBtn;

}
