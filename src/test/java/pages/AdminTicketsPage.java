package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminTicketsPage {

    public AdminTicketsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Tickets']")
    public WebElement dashboardTickets;
    @FindBy(xpath = "(//*[@class='text-white no-margin'])[1]")
    public WebElement ourTicetsArticle;
    @FindBy(xpath = "(//*[@class='text-white no-margin'])[2]")
    public WebElement loyalfriendcareticetsArticle;

    @FindBy(xpath = "//*[@class='card social-card share col2 m-t-30 m-b-30 m-r-30']")
    public List<WebElement> ticketsCards;
    @FindBy(xpath = "(//*[@class='card-header clearfix'])[1]")
    public List<WebElement> ticetsCardFirstHeader;
    @FindBy(xpath = "(//*[@class='card-description '])[1]")
    public List<WebElement> ticetsCardFirstDescription;


    @FindBy(xpath = "//*[contains(text(),'Next »')]")
    public WebElement ticketpageNextButton;
    @FindBy(xpath = "//*[contains(text(),'« Previous')]")
    public WebElement ticketpagePreviousButton;


}



