package tests.UI_FUNC_001;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_005 {

    public HomePage homePage = new HomePage();

    @Test
    public void TC01_HomePageBodyTitle() {

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        String expectedUrl = ConfigReader.getProperty("lfcHomePageUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);

        actions.moveToElement(homePage.bodyDepartmentsTitle).perform();
        Assert.assertTrue(homePage.bodyDepartmentsTitle.isDisplayed());

        actions.moveToElement(homePage.bodyPopularDoctorsTitle).perform();
        Assert.assertTrue(homePage.bodyPopularDoctorsTitle.isDisplayed());

        actions.moveToElement(homePage.bodyVaccinationsForPetsTitle).perform();
        Assert.assertTrue(homePage.bodyVaccinationsForPetsTitle.isDisplayed());

        Driver.quitDriver();



    }

    @Test
    public void TC02_HomePageBodyDepatmentsServices(){

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);

        actions.moveToElement(homePage.bodyDepartmentsTitle).perform();
        Assert.assertTrue(homePage.bodyDepartmentsTitle.isDisplayed());



        List<String> departmentsList = ReusableMethods.stringListeyeDonustur(Driver.getDriver().findElements(By.className("col-md-6")));

        Assert.assertTrue(departmentsList.size() > 0);

        Driver.getDriver().navigate().back();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(homePage.bodyFirstDepartments.isEnabled());

        homePage.bodyFirstDepartments.click();

        String expectedUrl = ConfigReader.getProperty("008_departmentsWellnesAppointmentUrl");

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();




    }

    @Test
    public void TC03_HomePageBodyPopularDoctors(){

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);

        actions.moveToElement(homePage.bodyPopularDoctorsTitle).perform();
        Assert.assertTrue(homePage.bodyPopularDoctorsTitle.isDisplayed());

        homePage.bodyDoctorsMenu.click();

        List<String> popularDoctorList = ReusableMethods.stringListeyeDonustur(Driver.getDriver().findElements(By.className("col-md-6")));

        Assert.assertTrue(popularDoctorList.size() > 0);

        Driver.getDriver().navigate().back();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(homePage.bodyFirstDoctor.isEnabled());

        homePage.bodyFirstDoctor.click();

        String expectedUrl = ConfigReader.getProperty("008_popularDoctorsAppointmentUrl");

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();


    }

    @Test
    public void TC04_HomePageBodyVaccinationsForPets() {

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);

        actions.moveToElement(homePage.bodyVaccinationsForPetsTitle).perform();
        Assert.assertTrue(homePage.bodyVaccinationsForPetsTitle.isDisplayed());

        homePage.bodyVaccinationsMenu.click();

        List<String> vaccinationsList = ReusableMethods.stringListeyeDonustur(Driver.getDriver().findElements(By.className("col-md-6")));

        Assert.assertTrue(vaccinationsList.size() > 0);

        Driver.getDriver().navigate().back();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(homePage.bodyFirstVaccinations.isEnabled());

        homePage.bodyFirstVaccinations.click();

        String expectedUrl = ConfigReader.getProperty("008_VaccinationsForPetsAppointmentUrl");

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();

    }
}
