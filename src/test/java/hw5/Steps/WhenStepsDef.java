package hw5.Steps;

import hw5.Services.Pages.Components.Items.items.HeaderMenuItems;
import hw5.Services.Pages.Components.Items.items.ServiceOptions;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WhenStepsDef extends AbstractBaseStepDef {
    @When("I login as user {string} with password {string}")
    public void iLoginAsUserWithPasswordOnTheHomePage(String username, String password) {
        homePage.login(username, password);
    }

    @When("^I click on '(HOME|CONTACT_FORM|SERVICE|METALS_AND_COLORS)' button in Header$")
    public void iClickOnServiceButtonInHeader(HeaderMenuItems option) {
        homePage.getHeaderMenu().headerMenuItemClick(option);
    }


    @When("I select checkbox WIND on the Different Elements page")
    public void iSelectCheckboxWINDOnTheDifferentElementsPage() {
        WebElement windCheckbox = diffElemPage.getWindCheckBox();
        windCheckbox.click();
    }

    @When("I select checkbox WATER on the Different Elements page")
    public void iSelectCheckboxWATEROnTheDifferentElementsPage() {
        WebElement waterCheckbox = diffElemPage.getWaterCheckBox();
        waterCheckbox.click();
    }


    @When("I select radio SELEN on the Different Elements page")
    public void iSelectRadioSELENOnTheDifferentElementsPage() {
        WebElement radioSelen = diffElemPage.getSelenRadio();
        radioSelen.click();
    }

    @When("I select option YELLOW in dropdown on the Different Elements page")
    public void iSelectOptionYELLOWInDropdownOnTheDifferentElementsPage() {
        WebElement dropdown = diffElemPage.getDropdown();
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yellow");
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickOnUserTableButtonInServiceDropdown(String serviceOption) {
        homePage.getHeaderMenu().serviceOptionClick(ServiceOptions.valueOf(serviceOption));
    }

    @When("I select vip checkbox for {string}")
    public void iSelectVipCheckboxForSergeyIvan(String expectedName) {
        userTablePage.clickOnCheckboxInTableByName(expectedName);
    }
}
