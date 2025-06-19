package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentBookingFormPage {

    public AppointmentBookingFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Appointment Booking']")
    public WebElement appointmentBookingText;

    @FindBy (xpath = "//*[@id='Date']")
    public WebElement dateDdm;

    @FindBy (xpath = "//*[@id='serial']")
    public WebElement phoneBox;

    @FindBy (xpath = "(//div[@class='nice-select wide'])[1]")
    public WebElement appointmentDepartmentsDdm;

    @FindBy (xpath = "(//div[@class='nice-select wide'])[2]") // Doktor randevu oluşturma departments dropdown menüsü
    public WebElement doctorsAppointmentDepartmentsDdm;

    @FindBy (xpath = "(//div[@class='nice-select wide'])[3]") // Doktor randevu oluşturma Doctors dropdown menüsü
    public WebElement doctorsAppointmentDoctorsDdm;

    @FindBy (xpath = "(//div[@class='nice-select wide'])[2]")
    public WebElement appointmentDoctorsDdm;

    @FindBy (xpath = "//*[@name='problem']")
    public WebElement messageBox;

    @FindBy (xpath = "//*[@id='submit-contact-detail']")
    public WebElement appointmentBookingButton;

    @FindBy (xpath = "//*[@role='alert']")
    public WebElement confirmationMessage;

    @FindBy (xpath = "//li[@data-value='56']")
    public WebElement wellnessDdm;

    @FindBy (xpath = "//li[@data-value='21']")
    public WebElement alejandroMartinezDdm;

    @FindBy(xpath = "//li[.='Dental Care']")
    public WebElement dentalCareDepartmentOption;

    @FindBy(xpath = "//li[.='Anaesthesia']")
    public WebElement anaesthesiaDepartmentOption;

    @FindBy(xpath = "//li[@data-value='23']")
    public WebElement oliviaBennettDoctorOption;





}
