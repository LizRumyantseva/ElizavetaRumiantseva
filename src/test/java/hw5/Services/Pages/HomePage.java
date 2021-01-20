package hw5.Services.Pages;


import hw5.Services.Utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {
    private WebDriver driver;

    private static final String URL_Home = "https://jdi-testing.github.io/jdi-light/index.html";

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
    @FindBy(id="epam-logo")
    private WebElement epamLogo;
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    List<WebElement> elementsHeader;
    @FindBy(css = ".benefit-icon span")
    List<WebElement> elementsIndex;
    @FindBy(css = ".benefit-txt")
    List<WebElement> elementsIndexTexts;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(xpath = "//ul[@class='sidebar-menu']")
    private List<WebElement> elementsLeft;
    @FindBy(linkText = "Service")
    private WebElement service;
    @FindBy(linkText = "Different elements")
    private WebElement diffElems;
    @FindBy(xpath = "//a[text()='User Table ']")
    private WebElement userTable;


    public HomePage(WebDriver driver, WaitActions wait) {
        super(driver, wait, URL_Home);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String usrname, String pwd) {
        userIcon.click();
        loginField.sendKeys(usrname);
        password.sendKeys(pwd);
        loginButton.click();
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

    public WebElement getServiceItem() {
        return service;
    }

    public WebElement getDiffElemsItem() {
        return diffElems;
    }

    public void switchToIFrame() {
        driver.switchTo().frame(iframe);
    }

    public void switchToHomePage() {
        driver.switchTo().defaultContent();
    }

    public WebElement getUserTableItem() {
        return userTable;
    }


}
