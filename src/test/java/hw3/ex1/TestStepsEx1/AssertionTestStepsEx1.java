package hw3.ex1.TestStepsEx1;

import hw3.Base.DriverUtils.WaitActions;
import hw3.Base.RunPages.BaseAssertionTestSteps;
import hw3.ex1.Pages.ExpectedTextsUnderImages;
import hw3.ex1.Pages.FramePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssertionTestStepsEx1 extends BaseAssertionTestSteps {
    private FramePage framePage;

    public AssertionTestStepsEx1(WebDriver driver, SoftAssert softAssert, WaitActions wait) {
        super(driver, softAssert, wait);
        framePage = new FramePage(driver,wait);
    }


    public void assert4ItemsHeaderSectionWithTexts(){
                softAssert.assertEquals(homePage.getHeaderItemsText(), Arrays.asList("HOME\n"
                + "CONTACT FORM\n"
                + "SERVICE\n"
                + "METALS & COLORS"));
    }

    public void assert4ImagesIndexPage() {
        List<WebElement> images = homePage.getIndexItems();
        softAssert.assertEquals(homePage.getIndexItems().size(), 4);
        for (WebElement element : images) {
            softAssert.assertTrue(element.isDisplayed());
        }
    }

    public void assert4TextsIndexPage() {
        List<String> imagesTexts = homePage.getIndexItemsText();
        softAssert.assertEquals(imagesTexts.size(), 4);
        List<String> expectedTexts = Stream.of(ExpectedTextsUnderImages.values())
                .map(ExpectedTextsUnderImages::getText)
                .collect(Collectors.toList());

        softAssert.assertEquals(imagesTexts, expectedTexts);
    }

    public void assertIFrameExists(){
    softAssert.assertTrue(homePage.getIframe().isDisplayed());
    }

    public void assertFrameBtnExists() {
        softAssert.assertTrue(framePage.getIFrameBtn().isDisplayed());
    }

    public void LeftSectionWithTexts(){
    List<WebElement> leftItems = homePage.getLeftItems();
        for (WebElement element : leftItems) {
        softAssert.assertTrue(element.isDisplayed());
    }
    List<String> leftItemsTexts = leftItems.stream().map(WebElement::getText).collect(Collectors.toList());
    String expectedLeftItemsText = ("Home\n"
            + "Contact form\n"
            + "Service\n"
            + "Metals & Colors\n"
            + "Elements packs");
        softAssert.assertEquals(leftItemsTexts, Arrays.asList(expectedLeftItemsText));
    }

}
