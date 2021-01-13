package hw4.Base.Pages;

import hw4.Base.DriverUtils.WaitActions;
import hw4.Base.Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DifferentElementsPage extends AbstractPage {
    private WebDriver driver;

    private static final String URL_Home = "https://jdi-testing.github.io/jdi-light/different-elements.html";

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//input[@type = 'radio']")
    private List<WebElement> radios;

    @FindBy(xpath = "//select[@class = 'uui-form-element']")
    private WebElement dropdown;

    @FindBy(xpath = "//*[@class = 'uui-form-element']/option")
    private List<WebElement> dropdownOptions;

    @FindBy(xpath = "//ul[@class = 'panel-body-list logs']/li")
    private List<WebElement> listsLogs;


    public DifferentElementsPage(WebDriver driver, WaitActions wait) {
        super(driver, wait, URL_Home);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getWaterCheckBox() {
        return checkboxes.get(0);

    }

    public WebElement getWindCheckBox() {
        return checkboxes.get(2);
    }

    public WebElement getSelenRadio() {
        return radios.get(3);
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public List<WebElement> getDropdownOptions() {
        return dropdownOptions;
    }

    public WebElement selectYellow(){
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yellow");
        WebElement dropdownYellow = dropdownOptions.get(3);
        return dropdownYellow;
    }

    public List<String> getListsLogs() {
        return listsLogs.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getWaterLog(){
        return getListsLogs().get(3);
    }

    public String getWindLog(){
        return getListsLogs().get(2);
    }

    public String getRadioSelenLog(){
        return getListsLogs().get(1);
    }

    public String getDropdownYellowLog(){
        return getListsLogs().get(0);
    }
}
