package hw4.ex2;


import hw4.Base.RunPages.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    @Feature("Testing EPAM site (jdi-testing.github.io)")
    @Story("Different Elements Page interface testing")
    @Test(description = "Exercise 2 test")
    public void exercise2Test() {

        //1. Open test site by URL
        actionStep.openMainPage();

        //2. Assert Browser title
        assertionStep.assertBrowseTitle("Home Page");

        //3. Perform login
        actionStep.performLogin(username, password);

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLoggined("ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.clickOnServiceAndDifferentElements();
        assertionStep.assertOpenDifferentElementsPage("Different Elements");

        //6. Select checkboxes
        actionStep.clickOnCheckboxes();
        assertionStep.assertSelectedCheckboxes();

        //7. Select radio
        actionStep.clickOnRadioSelen();
        assertionStep.assertSelectedRadio();

        //8. Select in dropdown
        actionStep.clickOnDropdown();
        assertionStep.assertSelectedYellowInDropdown();

        //9.1 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertionStep.assertCorrespondedLogForCheckbox();

        //9.2.  that for radio button there is a log row and value is corresponded to the status of radio button
        assertionStep.assertCorrespondedLogForRadioBtn();

        //9.3. Assert that for dropdown there is a log row and value is corresponded to the selected value
        assertionStep.assertCorrespondedLogForDropdown();
    }
}
