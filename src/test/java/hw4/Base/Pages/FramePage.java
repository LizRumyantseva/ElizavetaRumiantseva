package hw4.Base.Pages;

import hw4.Base.DriverUtils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends AbstractPage {

    private WebDriver driver;
    private static final String URL_Home = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(id = "button-frame")
    private WebElement iFrameBtn;


    public FramePage(WebDriver driver, WaitActions wait) {
        super(driver, wait, URL_Home);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getIFrameBtn() {
        return iFrameBtn;
    }
}
