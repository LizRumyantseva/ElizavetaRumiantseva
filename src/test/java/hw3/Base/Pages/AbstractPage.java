package hw3.Base.Pages;

import hw3.Base.DriverUtils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class AbstractPage {

    private WebDriver driver;
    private WaitActions wait;
    private String url;

    public AbstractPage(WebDriver driver, WaitActions wait, String url) {
        this.driver = driver;
        this.wait = new WaitActions(driver);
        this.url = url;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(url);
    }

    public void waitFor(WebElement By){
        wait.waitUntilCondition(By);
    }

}
