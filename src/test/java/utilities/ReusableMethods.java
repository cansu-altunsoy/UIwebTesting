package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {


    private static final Logger log = LoggerFactory.getLogger(ReusableMethods.class);

    public static void bekle(int saniye) {


        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep calismadi");
        }


    }

    public static List<String> stringListeyeDonustur(List<WebElement> webElementList) {


        List<String> tumListeStr = new ArrayList<>();

        for (WebElement eacBaslik : webElementList) {

            tumListeStr.add(eacBaslik.getText());
        }
        return tumListeStr;
    }


    public static void urlIleWindowDegistir(WebDriver driver, String hedefUrl) {

        Set<String> tumWindowWhdseti = driver.getWindowHandles();


        for (String each : tumWindowWhdseti) {

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().equals(hedefUrl)) {
                break;
            }
        }
    }


    public static void titleIleWindowDegistir(WebDriver driver, String hedefTitle) {

        Set<String> tumWindowWhdseti = driver.getWindowHandles();


        for (String each : tumWindowWhdseti) {

            driver.switchTo().window(each);

            if (driver.getTitle().equals(hedefTitle)) {
                break;
            }
        }
    }


    public static void tumSayfaScreenshotIsimli(WebDriver driver, String raporIsmi) {

        // 1. adim tss objesini olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + raporIsmi + ".jpg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilmedi");
        }


    }


    public static void tumSayfaScreenshotTarihli(WebDriver driver) {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim tss objesini olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/TumSayfaSS" + tarihEtiketi + ".jpg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilmedi");
        }


    }


    public static void tumSayfaScreenshotIsimVeTarihli(WebDriver driver, String isim) {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim tss objesini olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + isim + tarihEtiketi + ".jpg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilmedi");
        }


    }


    public static void webElementScreenshotIsimli(WebElement targetElement, String raporIsmi) {

        // 1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        // biz yukarda Logout butonunu locate ettik

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + raporIsmi + ".jpeg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Web elementin fotografı çekilemedi");
        }


    }


    public static void webElementScreenshotTarihli(WebElement targetElement) {


        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        // biz yukarda Logout butonunu locate ettik

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/Webelement" + tarihEtiketi + ".jpeg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Web elementin fotografı çekilemedi");
        }


    }


    public static void webElementScreenshotTarihliVeIsimliVeTarihli(WebElement targetElement, String raporIsmi) {


        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        // biz yukarda Logout butonunu locate ettik

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + raporIsmi + "_" + tarihEtiketi + ".jpeg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Web elementin fotografı çekilemedi");
        }


    }


    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
         TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
         File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
        
    }


    public static void signIn(String email){

        Driver.getDriver().get(ConfigReader.getProperty("lfcHomePageUrl"));

        ReusableMethods.bekle(1);
        HomePage homePage = new HomePage();

        homePage.headerSignInButton.click();

        ReusableMethods.bekle(1);

        LoginPage loginPage = new LoginPage();

        loginPage.loginEmailBox.sendKeys(email);
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("partnerpassword"));
        ReusableMethods.bekle(1);

        loginPage.signInButton.click();
        ReusableMethods.bekle(1);

    }


    public static void logout(WebDriver driver){

        AdminExitPage adminExitPage = new AdminExitPage();

        adminExitPage.logoutImgButton.click();
        adminExitPage.logoutLink.click();


    }


    public static void singOut(){

        HomePage homePage = new HomePage();
        homePage.headerSignOutButton.click();

    }


    public static void  dashbordSidebarMenu(){

        AdminHomePage adminHomePage = new AdminHomePage();

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();


    }

    public static void createDoctorAppointmentWithValidInformation(){

        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("003_dateTime"));
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("003_phoneNumber"));
        appointmentBookingFormPage.doctorsAppointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        appointmentBookingFormPage.doctorsAppointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("003_message"));

        appointmentBookingFormPage.appointmentBookingButton.click();

    }

    public static void createDoctorAppointmentWithPastDate(){

        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("003_pastAppointment"));
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("003_phoneNumber"));
        appointmentBookingFormPage.doctorsAppointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        appointmentBookingFormPage.doctorsAppointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("003_message"));

        appointmentBookingFormPage.appointmentBookingButton.click();


    }

    public static void createDoctorAppointmentWithInvalidPhoneNumber(){

        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("003_dateTime"));
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("003_invalidPhone"));
        appointmentBookingFormPage.doctorsAppointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        appointmentBookingFormPage.doctorsAppointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("003_message"));

        appointmentBookingFormPage.appointmentBookingButton.click();


    }

    public static void creatinganAppointmentWithValidInformation(){

        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("003_dateTime"));
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("003_phoneNumber"));
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("003_message"));

        appointmentBookingFormPage.appointmentBookingButton.click();
    }

    public static void createAppointmentWithPastDate(){

        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("003_pastAppointment"));
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("003_phoneNumber"));
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("003_message"));

        appointmentBookingFormPage.appointmentBookingButton.click();

    }

    public static void createAppointmentWithInvalidPhoneNumber(){

        AppointmentBookingFormPage appointmentBookingFormPage = new AppointmentBookingFormPage();

        appointmentBookingFormPage.dateDdm.sendKeys(ConfigReader.getProperty("003_dateTime"));
        appointmentBookingFormPage.phoneBox.sendKeys(ConfigReader.getProperty("003_invalidPhone"));
        appointmentBookingFormPage.appointmentDepartmentsDdm.click();
        appointmentBookingFormPage.wellnessDdm.click();
        appointmentBookingFormPage.appointmentDoctorsDdm.click();
        appointmentBookingFormPage.alejandroMartinezDdm.click();
        appointmentBookingFormPage.messageBox.sendKeys(ConfigReader.getProperty("003_message"));

        appointmentBookingFormPage.appointmentBookingButton.click();

    }



    public static void fillingTheFormOnTheEditPage(String phone,String password,String passwordConfirmation,String email){

        AdminUsersPage adminUsersPage = new AdminUsersPage();
        Actions actions = new Actions(Driver.getDriver());

        actions.click(adminUsersPage.editPagePhoneBox).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();

        adminUsersPage.editPagePhoneBox.sendKeys(phone); //phone kısmına verilen data girilir.
        adminUsersPage.editPagePasswordBox.sendKeys(password); //password kısmına verilen data girilir.
        adminUsersPage.editPagePasswordConfirmationBox.sendKeys(passwordConfirmation); //password confirmation kısmına verilen data girilir.

        // text alanı dolu olduğu için, önce text alanındaki eski maili silinir.
        actions.click(adminUsersPage.editPageEmailBox).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        adminUsersPage.editPageEmailBox.sendKeys(email); //email kısmına verilen data girilir.


    }

    public static void deleteTextBoxField(WebElement textBox){
        Actions actions = new Actions(Driver.getDriver());

        actions.click(textBox).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
    }


    public static void editNameAndListNameComparison(){

        AdminUsersPage adminUsersPage = new AdminUsersPage();

        String userNameInList = adminUsersPage.userNameText.getText(); // listedeki isimi kaydet.

        adminUsersPage.userEditButton.click();
        String userNameOnEditPage = adminUsersPage.editPageUserName.getText().substring(5); // kullanıcı ismini edit olmadan kaydet.

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userNameInList,userNameOnEditPage); // listedeki isim ile, edit sayfasındaki ismi karşılaştır.
    }

    public static void dropFilesToUploadField(String filePath) throws FileNotFoundException, AWTException {

        AdminUsersPage adminUsersPage = new AdminUsersPage();

        ReusableMethods.bekle(2); // Bekleme olmazsa dropzone acilmadan save ediyor
        adminUsersPage.editPageDropFilesToUpload.click();

        Robot robot = new Robot(); //Robot sınıfı, klavye ve fare olaylarını simüle etmek için kullanılır.

        StringSelection stringSelection = new StringSelection(filePath); // Dosya yolu, ConfigReader aracılığıyla alınır ve StringSelection sınıfına aktarılır.
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); // Dosya yolu, sistem panosuna (clipboard) kopyalanır.

        // CTRL+V ile yapistirilir
        robot.keyPress(KeyEvent.VK_CONTROL); //"CTRL" tuşuna basılır (kopyalanan dosya yolunun yapıştırılabilmesi için).
        ReusableMethods.bekle(1);

        robot.keyPress(KeyEvent.VK_V); // "V" tuşuna basılır; bu, "CTRL+V" kombinasyonu ile panodaki dosya yolunun yapıştırılmasını sağlar.
        robot.keyRelease(KeyEvent.VK_V); // "V" tuşu serbest bırakılır.

        ReusableMethods.bekle(1);
        robot.keyRelease(KeyEvent.VK_CONTROL); // "CTRL" tuşu serbest bırakılır.

        // 'Enter' tusuna basilir
        ReusableMethods.bekle(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        ReusableMethods.bekle(1);

    }

    public static WebElement getCellData(int row, int column) {

        String dynamicXpath = "//tbody/tr[" + row + "]/td[" + column + "]/form/button";

        WebElement targetCellElement = Driver.getDriver().findElement(By.xpath(dynamicXpath));

        return targetCellElement;
    }


    public static void uploadDoctorImage(String filePath) throws AWTException {

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();

        ReusableMethods.bekle(2); // Bekleme olmazsa dropzone acilmadan save ediyor
        adminDoctorsPage.doctorsImageDropzone.click();

        Robot robot = new Robot(); // Robot class'i ile dosya yolu girilir

        // Dosya yolu kopyalanir
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // CTRL+V ile yapistirilir
        robot.keyPress(KeyEvent.VK_CONTROL);
        ReusableMethods.bekle(1);

        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);

        ReusableMethods.bekle(1);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // 'Enter' tusuna basilir
        ReusableMethods.bekle(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        ReusableMethods.bekle(1);

    }

    public static void doctorDelete() {

        AdminDoctorsPage adminDoctorsPage = new AdminDoctorsPage();

        boolean continueFlag = true;

        while (continueFlag) {

            adminDoctorsPage.searchDoctorsBox.sendKeys(ConfigReader.getProperty("009_doctorTitle"));

            String expectedResultCount = "0";
            String actualResultText = adminDoctorsPage.numberOfShowingEntriesDoctorsPage.getText();

            String[] actualResultTextArr = actualResultText.split(" ");
            String firstNumber = actualResultTextArr[5];

            if (expectedResultCount.equals(firstNumber)) { // Sayfada cikan sonuc O ise sonraki sayfaya gec
                adminDoctorsPage.nextButtonDoctorsPage.click();

            } else { // Sayfada cıkan sonuc 0 degilse doktoru sil
                List<WebElement> columnCount = Driver.getDriver().findElements(By.xpath("//tbody/tr[1]/td")); // Delete butonunun bulundugu kolon
                int columnIndex = columnCount.size();

                List<WebElement> rowslist = Driver.getDriver().findElements(By.xpath("//tbody/tr[*]")); // Aynı isimde birden fazla doktor varsa sonuncu son eklenendir, sonuncuyu al
                int lastRowIndex = rowslist.size();

                ReusableMethods.getCellData(lastRowIndex, columnIndex).click();

                continueFlag = false;

            }

        }

    }

    public List<WebElement> getAtNameCollums(){
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        return  adminRolesPages.tableRoleNameCollumnAll;
    }

    public List<WebElement> getAtDisplayNameCollums(){
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        return  adminRolesPages.tableRoleDisplayNameCollumnAll;
    }

    public List<WebElement> getTableRoleCreateAtCollumnAll(){
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        return  adminRolesPages.tableRoleCreateAtCollumnAll;
    }
    public List<WebElement> getTableRoleActionsCollumnAll(){
        AdminRolesPages adminRolesPages = new AdminRolesPages();
        return  adminRolesPages.tableRoleActionsCollumnAll;
    }

    public List<WebElement> getAllTicketsCards(){
        AdminTicketsPage adminTicketsPage = new AdminTicketsPage();
        return  adminTicketsPage.ticketsCards;
    }
    public List<WebElement> getAllTicketCardHeader(){
        AdminTicketsPage adminTicketsPage = new AdminTicketsPage();
        return  adminTicketsPage.ticetsCardFirstHeader;
    }
    public List<WebElement> getAllTicketCardDescription(){
        AdminTicketsPage adminTicketsPage = new AdminTicketsPage();
        return  adminTicketsPage.ticetsCardFirstDescription;
    }

    public static void verifyURL(WebDriver driver, String expectedURL) {
        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        String actualURL = driver.getCurrentUrl();

        softAssert.assertEquals(actualURL, expectedURL);
        softAssert.assertAll();
    }

}

