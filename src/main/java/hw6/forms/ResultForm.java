package hw6.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import hw6.enums.ResultData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultForm {

    @XPath("//div[@class ='info-panel-body info-panel-body-result']//li")
    public WebList results;


    private String getValueFromResultSectionFor(ResultData resultData) {
        for (UIElement lineInResultPanel : results) {
            if (lineInResultPanel.text().contains(resultData.getValue())) {
                return lineInResultPanel.text().split(":")[1].trim();
            }
        }
        return "";
    }

    private String[] getValuesFromResultSectionFor(ResultData resultData) {
        for (UIElement lineInResultPanel : results) {
            if (lineInResultPanel.text().contains(resultData.getValue())) {
                String elementsAsString = lineInResultPanel.text().split(":")[1].trim();
                return elementsAsString.split("\\s*(,)\\s*");
            }
        }
        return new String[0];
    }

    public List<String> getListOfActualPageElements() {
        List<String> result = new ArrayList<>();
        result.add(getValueFromResultSectionFor(ResultData.COLOR));
        result.add(getValueFromResultSectionFor(ResultData.METAL));
        result.add(getValueFromResultSectionFor(ResultData.SUMMARY));
        result.add(Arrays.toString(getValuesFromResultSectionFor(ResultData.VEGETABLES)));
        result.add(Arrays.toString(getValuesFromResultSectionFor(ResultData.ELEMENTS)));

        return result;
    }
}
