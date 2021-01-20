package hw5.Services.Pages;

import hw5.Services.Pages.Components.Table;
import hw5.Services.Utils.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends AbstractPage {
    private Table table;

    @FindBy(css = ".panel-body-list > li")
    private List<WebElement> logs;

    //private RightSideBar rightSideBar;

    private static final String URL_Home = "https://jdi-testing.github.io/jdi-light/user-table.html";

    public UserTablePage(WebDriver driver, WaitActions wait) {
        super(driver, wait, URL_Home);
        this.driver = driver;
        table = new Table(driver);
        PageFactory.initElements(driver, this);
    }

    //    public int getDropdownsNumber(){
//         return dropdowns.size();
//    }
    public List<WebElement> getDropdownsAsWebElements() {
        List<WebElement> dropdownsInColumn = table.getTableColumn(2);
        return dropdownsInColumn.stream()
                .map(webElement -> webElement.findElement(By.xpath("./select"))).collect(Collectors.toList());
    }

    public List<WebElement> getUserNamesAsWebElement() {
        List<WebElement> userNamesInColumn = table.getTableColumn(3);
        return userNamesInColumn.stream()
                .map(webElement -> webElement.findElement(By.xpath("./a"))).collect(Collectors.toList());
    }


    public List<WebElement> getDescriptionsTextsAsWebElement() {
        List<WebElement> descrTexts = table.getTableColumn(4);
        return descrTexts.stream()
                .map(webElement -> webElement.findElement(By.xpath(".//span"))).collect(Collectors.toList());
    }

    public List<WebElement> getCheckboxesAsWebElements() {
        List<WebElement> checkboxesInColumn = table.getTableColumn(4);
        return checkboxesInColumn.stream()
                .map(webElement -> webElement.findElement(By.xpath(".//input"))).collect(Collectors.toList());
    }

    public List<WebElement> getNumberColumnAsWebElements() {
        return table.getTableColumn(1);
    }

//    public List<String> selectDropdownForUser(int index) {
//        List<WebElement> dropdownInRow = table.getTableColumn(2).get(index).findElements(By.xpath(".//option"));
//        return dropdownInRow.stream().map(WebElement::getText).collect(Collectors.toList());
//    }

    public List<String> getValuesOfDropdownByIndexOfRow(int index) {
        List<WebElement> dropdownInRow = table.getTableColumn(2).get(index).findElements(By.xpath(".//option"));
        return dropdownInRow.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int clickOnDropdownInTableByName(String name) {
        int index;
        for (index = 0; index < getUserNameAsText().size(); index++) {
            if (getUserNameAsText().get(index).equalsIgnoreCase(name)) {
                getDropdownsAsWebElements().get(index).click();
                break;
            }
        }
        return index;
    }

    public void clickOnCheckboxInTableByName(String expectedName) {
        for (int index = 0; index < getUserNameAsText().size(); index++) {
            if (getUserNameAsText().get(index).equalsIgnoreCase(expectedName))
                getCheckboxesAsWebElements().get(index).click();
        }
    }

    private List<String> getUserNameAsText() {
        return getUserNamesAsWebElement().stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getLogText() {
        List<String> logText = new ArrayList<>();
        for (WebElement log : logs) {
            logText.add(log.getText().substring(9));
        }
        return logText;
    }

}
