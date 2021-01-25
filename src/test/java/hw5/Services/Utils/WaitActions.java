package hw5.Services.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitActions {
    private WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 5);
    }

    public void waitUntilCondition(WebElement element){
        //return webDriverWait.ignoring(NoSuchElementException.class).until(p);
         webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
