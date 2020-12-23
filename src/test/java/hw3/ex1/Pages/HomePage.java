package hw3.ex1.Pages;

import hw3.Base.DriverUtils.WaitActions;
import hw3.Base.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {
    private WebDriver driver;


    public static final String URL_Home = "https://jdi-testing.github.io/jdi-light/index.html";

    //    WaitActions waitActions;

    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement loginField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id='epam-logo']") //id
    private WebElement epamLogo;
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    List<WebElement> elementsHeader;
    @FindBy(css = ".benefit-icon span") // .icons-benefit
    List<WebElement> elementsIndex;
    @FindBy(css = ".benefit-txt")
    List<WebElement> elementsIndexTexts;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(xpath = "//ul[@class='sidebar-menu']") //id
    private List<WebElement> elementsLeft;


    public HomePage(WebDriver driver, WaitActions wait) {
        super(driver, wait, URL_Home);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String usrname, String pwd) {
        userIcon.click();
        //wait
        loginField.sendKeys(usrname);
        password.sendKeys(pwd);
        loginButton.click();

    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserName() {
       return username.getText();
    }

    public void waitForEpamLogo(){
        super.waitFor(epamLogo);
    }

    public List<String> getHeaderItemsText() {
       return elementsHeader.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getIndexItems() {
        return elementsIndex;
    }

    public List<String> getIndexItemsText() {
        return elementsIndexTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public WebElement getIframe() {
        return iframe;
    }

    public List<WebElement> getLeftItems() {
        return elementsLeft;
    }


}
