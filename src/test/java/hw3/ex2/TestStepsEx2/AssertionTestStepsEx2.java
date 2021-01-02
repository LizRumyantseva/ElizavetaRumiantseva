package hw3.ex2.TestStepsEx2;

import hw3.Base.DriverUtils.WaitActions;
import hw3.Base.RunPages.BaseAssertionTestSteps;
import hw3.ex2.Pages.DifferentElementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionTestStepsEx2 extends BaseAssertionTestSteps {
    private static DifferentElementsPage diffElemPage;

    public AssertionTestStepsEx2(WebDriver driver, SoftAssert softAssert, WaitActions wait) {
        super(driver, softAssert, wait);
        diffElemPage = new DifferentElementsPage(driver, wait);
    }

    public void assertOpenDifferentElementsPage() {
        homePage.getServiceItem().click();
        homePage.getDiffElemsItem().click();
        Assert.assertEquals(diffElemPage.getTitle(), "Different Elements");
    }

    public void assertSelectedCheckboxes() {
        WebElement waterCheckbox = diffElemPage.getWaterCheckBox();
        WebElement windCheckbox = diffElemPage.getWindCheckBox();
        waterCheckbox.click();
        windCheckbox.click();
        Assert.assertTrue(waterCheckbox.isSelected());
        Assert.assertTrue(windCheckbox.isSelected());
    }

    public void assertSelectedRadio() {
        WebElement radioSelen = diffElemPage.getSelenRadio();
        radioSelen.click();
        Assert.assertTrue(radioSelen.isSelected());
    }

    public void assertSelectedInDropdown() {
        WebElement dropdown = diffElemPage.getDropdown();
        dropdown.click();
        WebElement dropdownYellow = diffElemPage.selectYellow();
        Assert.assertTrue(dropdownYellow.isSelected());
    }

    public void assertCorrespondedLogForCheckbox() {
        Assert.assertEquals(diffElemPage.getWaterCheckBox().isSelected(), diffElemPage.getWaterLog().contains("Water: condition changed to true"));
        Assert.assertEquals(diffElemPage.getWindCheckBox().isSelected(), diffElemPage.getWindLog().contains("Wind: condition changed to true"));
    }

    public void assertCorrespondedLogForRadioBtn() {
        Assert.assertEquals(diffElemPage.getSelenRadio().isSelected(), diffElemPage.getRadioSelenLog().contains("metal: value changed to Selen"));
    }

    public void assertCorrespondedLogForDropdown() {
        Assert.assertEquals(diffElemPage.selectYellow().isSelected(), diffElemPage.getDropdownYellowLog().contains("Colors: value changed to Yellow"));
    }
}
