package hw5.Services.Pages.Components;

import hw5.Services.Pages.Components.Items.items.HeaderMenuItems;
import hw5.Services.Pages.Components.Items.items.ServiceOptions;
import hw5.Services.Utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    private WebDriver driver;
    private WaitActions wait;

    @FindBy(xpath = "//ul[@class= 'uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> itemsOnHeaderMenu;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    private List<WebElement> optionsInService;

    public HeaderMenu(WebDriver driver, WaitActions wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    public void headerMenuItemClick(HeaderMenuItems menuItem) {
        for (WebElement headerMenuItem : itemsOnHeaderMenu) {
            String item = menuItem.getItemName().toUpperCase();
            if (item.equals(headerMenuItem.getText().toUpperCase())) {
                headerMenuItem.click();
                break;
            }
        }

    }

    public void serviceOptionClick(ServiceOptions serviceOption) {
        for (WebElement serviceItem : optionsInService) {
            String item = serviceOption.getOptionTitle().toUpperCase();
            if (item.equals(serviceItem.getText().toUpperCase())) {
                serviceItem.click();
                break;
            }
        }
    }

}
