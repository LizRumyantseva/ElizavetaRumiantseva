package hw2.ex1;

import hw2.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Exercise1Test extends TestBase {

    @Test
    public void exercise1Test() {
        SoftAssert softAssert=new SoftAssert();

        //2. Assert Browser title
        String browserTitle = driver.getTitle();
        softAssert.assertEquals(browserTitle, "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        WebElement loginField = waitForElementLocatedBy(driver, By.id("name"));
        loginField.sendKeys("Roman");

        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        WebElement userName = waitForElementLocatedBy(driver, By.id("user-name"));

        //4. Assert Username is loggined
        String userNameString = userName.getText();
        softAssert.assertEquals(userNameString, "ROMAN IOVLEV");


        //5.  Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homeButton = driver.findElement(By.linkText("HOME"));
        WebElement contactFormButton = driver.findElement(By.linkText("CONTACT FORM"));
        WebElement serviceButton = driver.findElement(By.linkText("SERVICE"));
        WebElement metalAndColorsButton = driver.findElement(By.linkText("METALS & COLORS"));

        softAssert.assertTrue(homeButton.isDisplayed());
        softAssert.assertTrue(contactFormButton.isDisplayed());
        softAssert.assertTrue(serviceButton.isDisplayed());
        softAssert.assertTrue(metalAndColorsButton.isDisplayed());

        softAssert.assertEquals(homeButton.getText(), "HOME");
        softAssert.assertEquals(contactFormButton.getText(), "CONTACT FORM");
        softAssert.assertEquals(serviceButton.getText(), "SERVICE");
        softAssert.assertEquals(metalAndColorsButton.getText(), "METALS & COLORS");


        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span")); ///
        for (WebElement element : images) {
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(images.size(), 4);


        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));///???
        int index = 0;
        for (ExpectedTextsUnderImages expectedText : ExpectedTextsUnderImages.values()) {
            String actualText = texts.get(index).getText();
            softAssert.assertEquals(actualText, expectedText.getText());
            index++;
        }

        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.id("frame"));
        softAssert.assertTrue(driver.findElement(By.id("frame")).isEnabled());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        String mainPage = driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        WebElement iFrameButton = driver.findElement(By.id("button-frame"));
        softAssert.assertTrue(iFrameButton.isDisplayed());

        //10. Switch to original window back
        driver.switchTo().window(mainPage);
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        //driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement leftItems = driver.findElement(By.xpath("//ul[@class='sidebar-menu']"));//??? how can I get 5 elements?
        String expectedLeftItemsText = ("Home\n"
                + "Contact form\n"
                + "Service\n"
                + "Metals & Colors\n"
                + "Elements packs");
        softAssert.assertTrue(leftItems.isDisplayed());
        softAssert.assertEquals(leftItems.getText(), expectedLeftItemsText);

        softAssert.assertAll();

    }

}



