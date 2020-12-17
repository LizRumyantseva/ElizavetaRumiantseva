package hw2.ex2;

import hw2.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class Exercise2Test extends TestBase {


    @Test
    public void ex2Test() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert Browser title
        String browserTitle = driver.getTitle();
        softAssert.assertEquals(browserTitle, "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        WebElement loginField = waitForElementLocatedBy(driver, By.id("name"));
        loginField.sendKeys("Roman");

        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        WebElement userName = waitForElementLocatedBy(driver, By.id("user-name"));

        //4. Assert User name in the left-top side of screen that user is loggined
        String userNameString = userName.getText();
        //String userName = driver.findElement(By.id("user-name")).getText();
        softAssert.assertEquals(userNameString, "ROMAN IOVLEV");

        softAssert.assertAll();

        //5. Open through the header menu Service -> Different Elements Page
        WebElement service = driver.findElement(By.linkText("Service"));
        service.click();
        WebElement differentElements = driver.findElement(By.linkText("Different elements"));
        differentElements.click();
        softAssert.assertEquals(driver.getTitle(), "Different Elements");
        softAssert.assertAll();


        //6. Select checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        WebElement checkboxWater = checkboxes.get(0);
        checkboxWater.click();
        WebElement checkboxWind = checkboxes.get(2);
        checkboxWind.click();
        softAssert.assertTrue(checkboxWater.isSelected());
        softAssert.assertTrue(checkboxWind.isSelected());

        //7. Select radio
        List<WebElement> radios = driver.findElements(By.xpath("//input[@type = 'radio']"));
        WebElement radioSelen = radios.get(3);
        radioSelen.click();
        boolean radioStatus = radioSelen.isSelected();
        softAssert.assertTrue(radioStatus);

        //8. Select in dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class = 'uui-form-element']"));
        dropDown.click();
        List<WebElement> dropdownOptions = dropDown.findElements(By.xpath("//*[@class = 'uui-form-element']/option"));//???
        Select select = new Select(dropDown);
        select.selectByVisibleText("Yellow");
        WebElement dropdownYellow = dropdownOptions.get(3);
        softAssert.assertTrue(dropdownYellow.isSelected());

        //9.1 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        softAssert.assertEquals(checkboxWater.isSelected(), getListsLogs().get(3).contains("Water: condition changed to true"));
        softAssert.assertEquals(checkboxWind.isSelected(), getListsLogs().get(2).contains("Wind: condition changed to true"));

        //9.2. Assert that for radio button there is a log row and value is corresponded to the status of radio button
        softAssert.assertEquals(radioStatus, getListsLogs().get(1).contains("metal: value changed to Selen"));

        //9.3. Assert that for dropdown there is a log row and value is corresponded to the selected value
        softAssert.assertEquals(dropdownYellow.isSelected(), getListsLogs().get(0).contains("Colors: value changed to Yellow"));


        softAssert.assertAll();

    }


    private List<String> getListsLogs() {
        List<WebElement> logsList = driver.findElements(By.xpath("//ul[@class = 'panel-body-list logs']/li"));

        return logsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
