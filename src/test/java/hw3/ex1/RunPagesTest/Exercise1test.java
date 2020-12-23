package hw3.ex1.RunPagesTest;

import hw3.ex1.Pages.ExpectedTextsUnderImages;
import hw3.Base.DriverUtils.DriverManager;
import hw3.Base.DriverUtils.WaitActions;
import hw3.ex1.Pages.FramePage;
import hw3.ex1.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1test {
    private static HomePage homePage;
    private static FramePage framePage;

    private static WebDriver driver;
    private WaitActions wait;

    private String username = "Roman";
    private String password = "Jdi1234";


    @BeforeMethod
    public void setUp() {
        driver = new DriverManager().setupDriver();
        wait = new WaitActions(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void exercise1Test() {

        SoftAssert softAssert = new SoftAssert();


        homePage = new HomePage(driver, wait);
        framePage = new FramePage(driver, wait);

        //1. Open test site by URL
        homePage.open();
        homePage.waitForEpamLogo();

        //2. Assert Browser title
        softAssert.assertEquals(homePage.getTitle(), "Home Page");

        //3. Perform login
        homePage.login(username, password);

        //4. Assert Username is loggined
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(homePage.getHeaderItemsText(), Arrays.asList("HOME\n"
                + "CONTACT FORM\n"
                + "SERVICE\n"
                + "METALS & COLORS"));

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = homePage.getIndexItems();
        softAssert.assertEquals(homePage.getIndexItems().size(), 4);
        for (WebElement element : images) {
            softAssert.assertTrue(element.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> imagesTexts = homePage.getIndexItemsText();
        softAssert.assertEquals(imagesTexts.size(), 4);
        int index = 0;
        for (ExpectedTextsUnderImages expectedText : ExpectedTextsUnderImages.values()) {
            String actualText = imagesTexts.get(index);
            softAssert.assertEquals(actualText, expectedText.getText());
            index++;
        }

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.getIframe().isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(homePage.getIframe());
        softAssert.assertTrue(framePage.getIFrameBtn().isDisplayed());

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
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

        softAssert.assertAll();

    }
}
