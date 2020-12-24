package hw3.ex2.RunPagesTest;


import hw3.Base.Pages.HomePage;
import hw3.Base.RunPages.BaseTest;
import hw3.ex2.Pages.DifferentElementsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    private static HomePage homePage;
    private static DifferentElementsPage diffElemPage;

    @Test
    public void exercise2Test() {

        homePage = new HomePage(driver, wait);
        diffElemPage = new DifferentElementsPage(driver, wait);

        //1. Open test site by URL
        homePage.open();
        homePage.waitForEpamLogo();

        //2. Assert Browser title
        Assert.assertEquals(homePage.getTitle(), "Home Page");

        //3. Perform login
        homePage.login(username, password);

        //4. Assert Username is loggined
        Assert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        homePage.getServiceItem().click();
        homePage.getDiffElemsItem().click();
        Assert.assertEquals(diffElemPage.getTitle(), "Different Elements");

        //6. Select checkboxes
        WebElement waterCheckbox = diffElemPage.getWaterCheckBox();
        WebElement windCheckbox = diffElemPage.getWindCheckBox();
        waterCheckbox.click();
        windCheckbox.click();
        Assert.assertTrue(waterCheckbox.isSelected());
        Assert.assertTrue(windCheckbox.isSelected());

        //7. Select radio
        WebElement radioSelen = diffElemPage.getSelenRadio();
        radioSelen.click();
        Assert.assertTrue(radioSelen.isSelected());

        //8. Select in dropdown
        WebElement dropdown = diffElemPage.getDropdown();
        dropdown.click();
        WebElement dropdownYellow = diffElemPage.selectYellow();
        Assert.assertTrue(dropdownYellow.isSelected());

        //9.1 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        Assert.assertEquals(diffElemPage.getWaterCheckBox().isSelected(), diffElemPage.getWaterLog().contains("Water: condition changed to true"));
        Assert.assertEquals(diffElemPage.getWindCheckBox().isSelected(), diffElemPage.getWindLog().contains("Wind: condition changed to true"));

        //9.2. Assert that for radio button there is a log row and value is corresponded to the status of radio button
        Assert.assertEquals(diffElemPage.getSelenRadio().isSelected(), diffElemPage.getRadioSelenLog().contains("metal: value changed to Selen"));

        //9.3. Assert that for dropdown there is a log row and value is corresponded to the selected value
        Assert.assertEquals(diffElemPage.selectYellow().isSelected(), diffElemPage.getDropdownYellowLog().contains("Colors: value changed to Yellow"));
    }
}
