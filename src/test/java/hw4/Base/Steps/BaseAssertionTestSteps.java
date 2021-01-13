package hw4.Base.Steps;

import hw4.Base.DriverUtils.WaitActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BaseAssertionTestSteps extends BaseAbstractTestSteps {
    public SoftAssert softAssert;

    public BaseAssertionTestSteps(WebDriver driver, SoftAssert softAssert, WaitActions wait){
        super(driver,wait);
        this.softAssert = softAssert;
    }

    @Step("Home Page title should be '{0}'")
    public void assertBrowseTitle(String title) {
        softAssert.assertEquals(homePage.getTitle(), title);
        softAssert.assertAll();
    }

    @Step("Username on the Home Page should be '{0}'")
    public void assertUsernameIsLoggined(String username){
        softAssert.assertEquals(homePage.getUserName(), username);
        softAssert.assertAll();
    }

    public void assertAll(){
        softAssert.assertAll();
    }
}
