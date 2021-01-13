package hw5.Steps;


import hw5.Services.Drivers.WebDriverSingleton;
import hw5.Services.Pages.HomePage;
import hw5.Services.Pages.DifferentElementsPage;
import hw5.Services.Utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class AbstractBaseStepDef {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage diffElemPage;
    protected SoftAssert softAssert;

    protected AbstractBaseStepDef(){
        driver = WebDriverSingleton.getDriver();
        WaitActions wait = new WaitActions(driver);

        homePage = new HomePage(driver,wait);
        diffElemPage = new DifferentElementsPage(driver, wait);

        softAssert = new SoftAssert();
    }
}
