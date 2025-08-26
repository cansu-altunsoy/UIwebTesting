package tests.UI_FUNC_001;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminHomePage;
import pages.AdminTicketsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class Us_041 extends TestBaseRapor {

    SoftAssert softAssert = new SoftAssert();

    AdminHomePage adminHomePage = new AdminHomePage();

    HomePage homePage = new HomePage();

    AdminTicketsPage adminTicketsPage = new AdminTicketsPage();


    Actions actions = new Actions(Driver.getDriver());

    ReusableMethods reusableMethods = new ReusableMethods();


    @Test
    public void TC041_001() {
        extentTest = extentReports.createTest("Yöneticinin Sidebarda bulunan  Tickets ana menüsüne erişilebilirlik  ve Ticket sayfasına doğru  ve sorunsuz bir şekilde erişilebilirlik testi.\n",
                "Yönetici Sidebar'da Tickets menüsünün görüntülemeli, Tickets sayfasına doğru şekilde yönlendirilebilmeli.\n");
        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8- Sidebar'da Tickets menüsünün görüntülendiği doğrulanır.
        softAssert.assertTrue(adminTicketsPage.dashboardTickets.isDisplayed(), "Tickets basligi görüntülenemedi.");
        extentTest.pass("Sidebar'da Tickets menüsünün görüntülendiği doğrulanır.");

        //9-Sidebar'da bulunan Tickets menüsüne tıklar.
        adminTicketsPage.dashboardTickets.click();
        extentTest.info("Sidebar'da bulunan Tickets menüsüne tıklar.");

        //10- Yönetici Tickets sayfasına doğru şekilde yönlendirildiği "LoyalFriendCareTickets" basliginin görüntülenebilmesi ile doğrulanır.
        String expectedSecondArticle = "LoyalFriendCareTickets";
        String actualUrlSecondArticle = adminTicketsPage.loyalfriendcareticetsArticle.getText();
        softAssert.assertTrue(actualUrlSecondArticle.contains(expectedSecondArticle), "LoyalFriendCareTickets görüntülenemedi.");
        extentTest.pass("Yönetici Tickets sayfasına doğru şekilde yönlendirildiği \"LoyalFriendCareTickets\" basliginin görüntülenebilmesi ile doğrulanır.");

        //11- Header kısımda bulunan yönetici profili butonuna tıklar.
        //12- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //13-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //14-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC041_002() {
        extentTest = extentReports.createTest("Yöneticinin  Tickets sayfasında \" LoyalFriendCareTickets\" başlığı altında sayfadaki randevu kartların  görüntülenebilirlik testi.\n",
                "Yönetici  10 tane randevu kartının sorunsuz şekilde listelenmiş olduğu görüntülleyeb,ilmeli.\n");
        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Tickets menüsüne tıklar.
        adminTicketsPage.dashboardTickets.click();
        extentTest.info("Sidebar'da bulunan Tickets menüsüne tıklar.");

        //9-Yönetici  10 tane randevu kartının sorunsuz şekilde listelenmiş olduğu görüntülenebildiği doğrulanır.
        List<String> ticketsCardList = ReusableMethods.stringListeyeDonustur(reusableMethods.getAllTicketsCards());
        int actualTicketsCardListSize = ticketsCardList.size();
        softAssert.assertTrue(actualTicketsCardListSize == 10, "Tüm randevu kartları listelenemedi");
        extentTest.pass("Yönetici  10 tane randevu kartının sorunsuz şekilde listelenmiş olduğu görüntülenebildiği doğrulanır.");

        //10- Header kısımda bulunan yönetici profili butonuna tıklar.
        //11- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //12-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //13-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC041_003() {
        extentTest = extentReports.createTest("Yöneticinin Randevu kartlarında bulunan  Tarih,Seri numarası,Doktor ismi,Departmen ismi, iletilen mesaj ve mesajın iletilme tarihi cardlarda görüntüleblirliği testi.\n",
                "Randevu kartında randevu tarihi,Serial,Departments,Doctor,iletilen mesaj,iletilen mesaj tarihi  doğru ve eksiksiz bir  şekilde görüntülenmeli.\n");
        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Tickets menüsüne tıklar.
        adminTicketsPage.dashboardTickets.click();
        extentTest.info("Sidebar'da bulunan Tickets menüsüne tıklar.");

        //9- Randevu kartında randevu tarih: "2025-01-03"in doğru ve eksiksiz bir  şekilde görüntülenebildiği doğrulanır.

        //"Web elemanlarını bir liste olarak locate ettim. Bunları kullanabilmek için, reusable method sınıfımda bir metot oluşturdum
        // Ve bu metotla elemanları bir String listesine dönüştürdüm. Ardından, bu metodu test sınıfımda  asagidaki sekilde kullandım."
        List<String> ticketsCardHeaderList = ReusableMethods.stringListeyeDonustur(reusableMethods.getAllTicketCardHeader());

        String expectedAppointmentDate = "2025-01-03";
        String actualAppointmentDate = ticketsCardHeaderList.get(0);
        softAssert.assertTrue(actualAppointmentDate.contains(expectedAppointmentDate), "Randevu tarihi görüntülenemedi.");
        extentTest.pass("Randevu kartında randevu tarih: \"2025-01-03\"in doğru ve eksiksiz bir  şekilde görüntülenebildiği doğrulanır.");

        //10-Randevu kartında  "Serial 23654789652 "in doğru ve eksiksiz bir şekilde göründüğü doğrulanır.
        String expectedAppointmentSerial = "Serial 23654789652";
        String actualAppointmentSerial = ticketsCardHeaderList.get(0);
        softAssert.assertTrue(actualAppointmentSerial.contains(expectedAppointmentSerial), "Randevu Serial'i görüntülenemedi.");
        extentTest.pass("Randevu kartında  \"Serial 23654789652 \"in doğru ve eksiksiz bir şekilde göründüğü doğrulanır.");

        //11-Randevu kartında "Departments Wellness ismi"'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır
        String expectedAppointmentDepartments = "Departments Wellness";
        String actualAppointmentDepartments = ticketsCardHeaderList.get(0);
        softAssert.assertTrue(actualAppointmentDepartments.contains(expectedAppointmentDepartments), "Randevu Departmani görüntülenemedi.");
        extentTest.pass("Randevu kartında \"Departments Wellness ismi\"'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır");

        //12-Randevu kartında"Doctor Dr. Alejandro Martinez ismi"'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır
        String expectedAppointmentDoctor = "Doctor Dr. Alejandro Martinez";
        String actualAppointmentDoctor = ticketsCardHeaderList.get(0);
        softAssert.assertTrue(actualAppointmentDoctor.contains(expectedAppointmentDoctor), "Randevu Doktor'u görüntülenemedi.");
        extentTest.pass("Randevu kartında\"Doctor Dr. Alejandro Martinez ismi\"'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır");

        //13-Randevu kartında  iletilen mesaj: "abc"'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır

        //"Web elemanlarını bir liste olarak locate ettim. Bunları kullanabilmek için, reusable method sınıfımda bir metot oluşturdum
        // Ve bu metotla elemanları bir String listesine dönüştürdüm. Ardından, bu metodu test sınıfımda  asagidaki sekilde kullandım."
        List<String> ticketsCardDescriptionList = ReusableMethods.stringListeyeDonustur(reusableMethods.getAllTicketCardDescription());

        String expectedAppointmentMessage = "abc";
        String actualAppointmentMessage = ticketsCardDescriptionList.get(0);
        softAssert.assertTrue(actualAppointmentMessage.contains(expectedAppointmentMessage), "İletilen mesaj görüntülenemedi.");
        extentTest.pass("Randevu kartında  iletilen mesaj: \"abc\"'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır");

        //14-Randevu kartında "iletilme tarih: Jan 3, 2025 "'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır
        String expectedAppointmentMessagedDate = "Jan 3, 2025";
        String actualAppointmentMessagedDate = ticketsCardDescriptionList.get(0);
        softAssert.assertTrue(actualAppointmentMessagedDate.contains(expectedAppointmentMessagedDate), "İletilme tarihi görüntülenemedi.");
        extentTest.pass("Randevu kartında \"iletilme tarih: Jan 3, 2025 \"'in doğru ve eksiksiz bir  şekilde göründüğü doğrulanır");

        //15- Header kısımda bulunan yönetici profili butonuna tıklar.
        //16- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //17-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //18-Window kapatılır.
        extentTest.info("Window kapatılır.");


    }

    @Test
    public void TC041_004() {
        extentTest = extentReports.createTest("Yöneticinin  \" Next »\"  butonunu erişilebilirlik testi.\n",
                "Yönetici Ticket page body'de \" Next »\" butonunun  görüntülenebilmeli ,\"Second tickets page \" sayfasına sorunsuz bir şekilde yönlendirilmeli.\n");
        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Tickets menüsüne tıklar.
        adminTicketsPage.dashboardTickets.click();
        extentTest.info("Sidebar'da bulunan Tickets menüsüne tıklar.");

        //"9- Yönetici Ticket page body'de " Next »" butonunun  görüntülenebildiği doğrulanır.
        softAssert.assertTrue(adminTicketsPage.ticketpageNextButton.isDisplayed(), "Next butonu görüntülenemedi.");
        extentTest.pass("Yönetici Ticket page body'de \" Next »\" butonunun  görüntülenebildiği doğrulanır.");

        //10- "Next »" butonununa  tıklar.
        adminTicketsPage.ticketpageNextButton.click();
        extentTest.info("\"Next »\" butonununa  tıklar.");

        //11- "https://qa.loyalfriendcare.com/en/Dashboard/Messages?page=2 " sayfasına sorunsuz bir şekilde yönlendirildiği doğrulanır.
        String expectedUrl = "https://qa.loyalfriendcare.com/en/Dashboard/Messages?page=2";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "Url'ler uyuşmadı.");
        extentTest.pass("\"https://qa.loyalfriendcare.com/en/Dashboard/Messages?page=2 \" sayfasına sorunsuz bir şekilde yönlendirildiği doğrulanır.");

        //12- Header kısımda bulunan yönetici profili butonuna tıklar.
        //13- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //14-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //15-Window kapatılır.
        extentTest.info("Window kapatılır.");
    }

    @Test
    public void TC041_005() {
        extentTest = extentReports.createTest("Yöneticinin  \"« Previous \" butonunu erişilebilirlik testi..\n",
                "Yönetici Ticket page body'de  \"« Previous \" butonunun  görüntülenebilmeli ,\"First tickets page \" sayfasına sorunsuz bir şekilde  yönlendirilmeli.\n");
        //1-Yönetici url' e gider
        //2-"Sign in" butonuna tıklayarak "Log in " sayfasına gider.
        //3-Email textbox' a "Email" i girer .
        //4-Password textbox' a "Password" girer.
        //5"Sign in " butonuna tıklar
        ReusableMethods.signIn(ConfigReader.getProperty("006_validAdminEmail"));
        extentTest.info("Yönetici anasayfaya gider,Geçerli email ve password ile giriş yapar.");

        //6-HomePage sayfasinın Header kısmında bulunan " yönetici.adı"' butonuna tıklar.
        homePage.headerAdminNameButton.click();
        extentTest.info("HomePage sayfasinın Header kısmında bulunan \" Sign Out\"' butonuna  tıklar.");

        //7-Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.
        actions.moveToElement(adminHomePage.AdminsidebarDashboardMenu).perform();
        extentTest.info("Yönetici kontrol sayfasında bulunan sidebar'ın üzerine  fare ile gelir.");

        //8-Sidebar'da bulunan Tickets menüsüne tıklar.
        adminTicketsPage.dashboardTickets.click();
        extentTest.info("Sidebar'da bulunan Tickets menüsüne tıklar.");

        //"9-Yönetici Ticket page body'de "« Previous " butonunun  görüntülenebildiği doğrulanır.
        softAssert.assertTrue(adminTicketsPage.ticketpagePreviousButton.isDisplayed(), " Previous butonu görüntülenemedi.");
        extentTest.pass("Yönetici Ticket page body'de \"« Previous \" butonunun  görüntülenebildiği doğrulanır.");

        //10- "Next »" butonununa  tıklar.
        adminTicketsPage.ticketpageNextButton.click();
        extentTest.info("\"Next »\" butonununa  tıklar.");

        //11- "« Previous " butonununa  tıklar.
        adminTicketsPage.ticketpagePreviousButton.click();
        extentTest.info("\"« Previous \" butonununa  tıklar.");

        //12-" https://qa.loyalfriendcare.com/en/Dashboard/Messages?page=1 " sayfasına sorunsuz bir şekilde yönlendirildiği doğrulanır.
        String expectedUrl = "https://qa.loyalfriendcare.com/en/Dashboard/Messages?page=1";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "Url'ler uyuşmadı.");
        extentTest.pass("\" https://qa.loyalfriendcare.com/en/Dashboard/Messages?page=1 \" sayfasına sorunsuz bir şekilde yönlendirildiği doğrulanır.");

        //13- Header kısımda bulunan yönetici profili butonuna tıklar.
        //14- Yönetici profil sidebar'ında bulunan  Log out option'a tıklar.
        ReusableMethods.logout(Driver.getDriver());
        extentTest.info("Header kısımda bulunan yönetici profili butonuna tıklar, sidebardan Log out option'a tıklar.");

        //15-Homepage Header bölümündeki  Sign out butonuna tıklar
        ReusableMethods.singOut();
        extentTest.info("Homepage Header bölümündeki Sign out butonuna tıklar.");

        softAssert.assertAll();

        //16-Window kapatılır.
        extentTest.info("Window kapatılır.");

    }
}
