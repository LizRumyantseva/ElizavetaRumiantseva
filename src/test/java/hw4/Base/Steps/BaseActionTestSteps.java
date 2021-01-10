package hw4.Base.Steps;

import hw4.Base.DriverUtils.WaitActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BaseActionTestSteps extends BaseAbstractTestSteps {

    public BaseActionTestSteps(WebDriver driver, WaitActions wait){
       super(driver,wait);
    }

    @Step("Open Epam Home Page (https://jdi-testing.github.io/jdi-light/index.html)")
    public void openMainPage() {
        homePage.open();
        homePage.waitForEpamLogo();
    }

    @Step("Login as user '{0}' with password '{1}' ")
    public void performLogin(String username, String password) {
        homePage.login(username, password);
    }

}
