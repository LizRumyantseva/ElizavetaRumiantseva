package hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw6.forms.MetalsAndColorsForm;
import hw6.forms.ResultForm;

public class MetalsAndColorsPage extends WebPage {
    @Css(".form")
    public MetalsAndColorsForm metalsAndColorsForm;

    @Css(".info-panel-body info-panel-body-result")
    public ResultForm resultForm;
}
