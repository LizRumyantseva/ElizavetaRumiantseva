package hw3.Base.Pages;

import hw3.Base.DriverUtils.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.function.Function;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {

    private WebDriver driver;
    private WaitActions wait;
    private String url;

    public AbstractPage(WebDriver driver, WaitActions wait, String url) {
        this.driver = driver;
        this.wait = new WaitActions(driver);
        this.url = url;
        PageFactory.initElements(driver, wait);
    }

    public void open() {
        driver.get(url);

    }
    public void waitFor(WebElement By){
        wait.waitUntilCondition(By);
    }

}
