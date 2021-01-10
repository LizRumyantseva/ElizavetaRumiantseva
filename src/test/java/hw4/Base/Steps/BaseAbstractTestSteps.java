package hw4.Base.Steps;

import hw4.Base.DriverUtils.WaitActions;
import hw4.Base.Pages.DifferentElementsPage;
import hw4.Base.Pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseAbstractTestSteps {

    public HomePage homePage;
    public DifferentElementsPage diffElemPage;

    protected BaseAbstractTestSteps(WebDriver driver, WaitActions wait){
        homePage = new HomePage(driver,wait);
        diffElemPage = new DifferentElementsPage(driver, wait);
    }
}
