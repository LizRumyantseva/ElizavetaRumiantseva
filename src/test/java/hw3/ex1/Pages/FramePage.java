package hw3.ex1.Pages;

import hw3.Base.DriverUtils.WaitActions;
import hw3.Base.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends AbstractPage {

    private WebDriver driver;
    public static final String URL_Home = "https://jdi-testing.github.io/jdi-light/index.html";

//    @FindBy(css = "iframe#frame")
//    private WebElement iframe;
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
