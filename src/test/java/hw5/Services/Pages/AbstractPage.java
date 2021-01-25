package hw5.Services.Pages;

import hw5.Services.Pages.Components.HeaderMenu;
//import hw5.Services.Pages.Components.LeftSideMenu;
import hw5.Services.Utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {

    public WebDriver driver;
    public WaitActions wait;
    public String url;
    private HeaderMenu headerMenu;

    public AbstractPage(WebDriver driver, WaitActions wait, String url) {
        this.driver = driver;
        this.wait = new WaitActions(driver);
        this.url = url;
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver,wait);
    }

    public void open() {
        driver.get(url);
    }

    public void waitFor(WebElement By){
        wait.waitUntilCondition(By);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public HeaderMenu getHeaderMenu(){
        return headerMenu;
    }


}
