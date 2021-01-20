package hw5.Services.Pages.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Table {
    private WebDriver driver;

    @FindBy(id = "user-table")
    private WebElement table;

    public Table(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getTableColumn(int index) {
        return table.findElements(By.xpath(String.format(".//tr//td[%d]", index)));
    }

}
