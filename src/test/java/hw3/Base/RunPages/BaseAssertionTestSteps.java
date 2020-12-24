package hw3.Base.RunPages;

import hw3.Base.DriverUtils.WaitActions;
import org.openqa.selenium.WebDriver;
import hw3.Base.Pages.HomePage;
import org.testng.asserts.SoftAssert;

public class BaseAssertionTestSteps {
    public WebDriver driver;
    public WaitActions wait;
    public SoftAssert softAssert;

    public HomePage homePage;

    public BaseAssertionTestSteps(WebDriver driver, SoftAssert softAssert, WaitActions wait){
        this.softAssert = softAssert;
        this.driver = driver;
        homePage = new HomePage(driver,wait);
    }

    public void openMainPage() {
        homePage.open();
        homePage.waitForEpamLogo();
    }

    public void assertBrowseTitle() {
        softAssert.assertEquals(homePage.getTitle(), "Home Page");
    }

    public void performLogin(String username, String password) {
        homePage.login(username, password);
    }

    public void assertUsernameIsLoggined(){
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");
    }


    public void assertAll(){
        softAssert.assertAll();
    }

}
