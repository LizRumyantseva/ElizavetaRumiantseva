package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.entities.MetalsAndColorsData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static hw6.JdiSite.*;
import static hw6.entities.JdiUser.ROMAN;
import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiTest {


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        PageFactory.initElements(JdiSite.class);
        open();
        login(ROMAN);
        String actualUserName = jdiHomePage.getUserName();
        assertEquals(actualUserName, ROMAN.getUserName(),
                format("Expected user: %s, but found %s", ROMAN, actualUserName));
    }

    @Test(dataProviderClass = TestDataFromJson.class,
            dataProvider = "TestData")
     public void metalsAndColorsFormTest(MetalsAndColorsData expectedData) {
        headerMenu.select("METALS & COLORS");
        assertTrue(metalsAndColorsPage.isOpened());
        submitMetalsAndColorsFormFilledWithData(expectedData);

        List<String> actualElements = metalsAndColorsPage.resultForm.getListOfActualPageElements();
        List<String> expectedElements = expectedData.getListOfPageElements();

        assertEquals(expectedElements, actualElements,
                format("Expected color: %s, but found %s", expectedElements.toString(), actualElements.toString()));

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

}
