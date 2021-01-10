package hw4.Base.Steps;

import hw4.Base.DriverUtils.WaitActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionTestSteps extends BaseActionTestSteps {

    public ActionTestSteps(WebDriver driver, WaitActions wait) {
        super(driver, wait);
    }

    @Step("Switch to Iframe")
    public void switchToIFrame() {
        homePage.switchToIFrame();
    }

    @Step("Switch to Home Page")
    public void switchToHomePage() {
        homePage.switchToHomePage();
    }

    @Step("Click on Service -> Diffrent Elements")
    public void clickOnServiceAndDifferentElements() {
        homePage.getServiceItem().click();
        homePage.getDiffElemsItem().click();
    }

    @Step("Click on Water and Wind checkboxes")
    public void clickOnCheckboxes(){
        WebElement waterCheckbox = diffElemPage.getWaterCheckBox();
        WebElement windCheckbox = diffElemPage.getWindCheckBox();
        waterCheckbox.click();
        windCheckbox.click();
    }

    @Step("Click on radio Selen")
    public void clickOnRadioSelen() {
        WebElement radioSelen = diffElemPage.getSelenRadio();
        radioSelen.click();
    }

    @Step("Click on Dropdown")
    public void clickOnDropdown() {
        WebElement dropdown = diffElemPage.getDropdown();
        dropdown.click();
    }
}
