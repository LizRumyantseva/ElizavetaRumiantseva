package hw5.Services.Pages;

import hw5.Services.Utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class AbstractPage {

    public WebDriver driver;
    public WaitActions wait;
    public String url;

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
