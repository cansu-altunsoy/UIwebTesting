package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminExitPage {

   public AdminExitPage(){

       PageFactory.initElements(Driver.getDriver(), this);
   }

    @FindBy(xpath = "//*[@*='dropdown pull-right d-lg-block d-none']")
    public WebElement adminDropdownMenu;

    @FindBy(xpath = "//*[@class='thumbnail-wrapper d32 border-5  inline']")
    public WebElement logoutImgButton;
  
    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "(//*[@class='btn_add'])[2]")
    public WebElement signOut;
  

}
