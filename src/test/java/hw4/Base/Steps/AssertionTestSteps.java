package hw4.Base.Steps;

import hw4.Base.DriverUtils.WaitActions;
import hw4.Base.Pages.DifferentElementsPage;
import hw4.ex1.ExpectedTextsUnderImages;
import hw4.Base.Pages.FramePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AssertionTestSteps extends BaseAssertionTestSteps {
    private FramePage framePage;

    public AssertionTestSteps(WebDriver driver, SoftAssert softAssert, WaitActions wait) {
        super(driver, softAssert, wait);
        framePage = new FramePage(driver,wait);
    }

    @Step("There should be 4 items on the header section: '{0}' with expected texts")
    public void assert4ItemsHeaderSectionWithTexts(String items){
        softAssert.assertEquals(homePage.getHeaderItemsText(), Arrays.asList(items));
        softAssert.assertAll();
    }

    @Step("There should be 4 images on the Index Page")
    public void assert4ImagesIndexPage() {
        List<WebElement> images = homePage.getIndexItems();
        softAssert.assertEquals(homePage.getIndexItems().size(), 4);
        for (WebElement element : images) {
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("There should be 4 texts on the Index Page under icons with expected texts")
    public void assert4TextsIndexPage() {
        List<String> imagesTexts = homePage.getIndexItemsText();
        softAssert.assertEquals(imagesTexts.size(), 4);
        List<String> expectedTexts = Stream.of(ExpectedTextsUnderImages.values())
                .map(ExpectedTextsUnderImages::getText)
                .collect(Collectors.toList());
        softAssert.assertEquals(imagesTexts, expectedTexts);
        softAssert.assertAll();
    }

    @Step("There should be iframe with 'Frame Button' ")
    public void assertIFrameExists(){
    softAssert.assertTrue(homePage.getIframe().isDisplayed());
        softAssert.assertAll();
    }

    @Step("There should be 'Frame Button' in the iframe")
    public void assertFrameBtnExists() {
        softAssert.assertTrue(framePage.getIFrameBtn().isDisplayed());
        softAssert.assertAll();
    }

    @Step("There should be 5 items in the Left Section with expected text")
    public void LeftSectionWithTexts(String expectedText){
    List<WebElement> leftItems = homePage.getLeftItems();
        for (WebElement element : leftItems) {
        softAssert.assertTrue(element.isDisplayed());
            softAssert.assertAll();
    }
    List<String> leftItemsTexts = leftItems.stream().map(WebElement::getText).collect(Collectors.toList());
    String expectedLeftItemsText = (expectedText);
        softAssert.assertEquals(leftItemsTexts, Arrays.asList(expectedLeftItemsText));
        softAssert.assertAll();
    }

    @Step("Different Page title should be '{0}'")
    public void assertOpenDifferentElementsPage(String title) {
        softAssert.assertEquals(diffElemPage.getTitle(), title);
        softAssert.assertAll();
    }

    @Step("Water and Wind checkboxes should be selected")
    public void assertSelectedCheckboxes() {
        softAssert.assertTrue(diffElemPage.getWaterCheckBox().isSelected());
        softAssert.assertTrue(diffElemPage.getWindCheckBox().isSelected());
        softAssert.assertAll();
    }

    @Step("Radio Selen should be selected")
    public void assertSelectedRadio() {
        softAssert.assertTrue(diffElemPage.getSelenRadio().isSelected());
        softAssert.assertAll();
    }

    @Step("Yellow should be selected in dropdown")
    public void assertSelectedYellowInDropdown() {
        softAssert.assertTrue(diffElemPage.selectYellow().isSelected());
        softAssert.assertAll();
    }

    @Step("For Water and Wind checkboxes should be an individual log row with value corresponded to the status ")
    public void assertCorrespondedLogForCheckbox() {
        softAssert.assertEquals(diffElemPage.getWaterCheckBox().isSelected(), diffElemPage.getWaterLog().contains("Water: condition changed to true"));
        softAssert.assertEquals(diffElemPage.getWindCheckBox().isSelected(), diffElemPage.getWindLog().contains("Wind: condition changed to true"));
        softAssert.assertAll();
    }

    @Step("For radio Selen should be an individual log row with value corresponded to the status ")
    public void assertCorrespondedLogForRadioBtn() {
        softAssert.assertEquals(diffElemPage.getSelenRadio().isSelected(), diffElemPage.getRadioSelenLog().contains("metal: value changed to Selen"));
        softAssert.assertAll();
    }

    @Step("For selected Yellow in dropdown there should be an individual log row with value corresponded to the status ")
    public void assertCorrespondedLogForDropdown() {
        softAssert.assertEquals(diffElemPage.selectYellow().isSelected(), diffElemPage.getDropdownYellowLog().contains("Colors: value changed to Yellow"));
        softAssert.assertAll();
    }

}
