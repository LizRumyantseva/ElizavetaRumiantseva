package hw6.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw6.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {
    @Css("#elements-block p")
    private WebList checklistElements;

    @JDropdown(root = "#colors",
            list = "li",
            expand = ".caret")
    private Dropdown dropdownColors;

    @JDropdown(root = "#metals",
            list = "li",
            expand = ".caret")
    private Dropdown dropdownMetals;

    @Css("#odds-selector p")
    private WebList oddRadio;

    @Css("#even-selector p")
    private WebList evenRadio;

    @XPath("//div[@id = 'vegetables']")
    private UIElement dropdownVegetables;

    @JDropdown(root = "div[id = vegetables]",
            //value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown vegetableOptions;

    @Css("#submit-button")
    private Button submitButton;

    private void selectElements(MetalsAndColorsData data) {
        for (String element : data.getElements()) {
            checklistElements.select(element);
        }
    }

    private void selectSummaryOddRadio(MetalsAndColorsData data) {
        oddRadio.select(String.valueOf(data.getSummaryOdd()));
    }

    private void selectSummaryEvenRadio(MetalsAndColorsData data) {
        evenRadio.select(String.valueOf(data.getSummaryEven()));
    }

    private void selectDropdownColors(MetalsAndColorsData data) {
        dropdownColors.select(data.getColor());
    }

    private void selectDropdownMetals(MetalsAndColorsData data) {
        dropdownMetals.select(data.getMetals());
    }

    private void clickOnSubmitButton() {
        submitButton.click();
    }

    private void selectVegetables(MetalsAndColorsData data) {
        dropdownVegetables.click();
        vegetableOptions.select("Vegetables"); // unselect

        if (data.getVegetables().length != 0) {
            for (String veg : data.getVegetables()) {
                vegetableOptions.select(veg);
            }
        }
    }

    public void submit(MetalsAndColorsData data) {
        selectDropdownColors(data);
        selectDropdownMetals(data);
        selectElements(data);
        selectSummaryEvenRadio(data);
        selectSummaryOddRadio(data);
        selectVegetables(data);
        clickOnSubmitButton();
    }

}
