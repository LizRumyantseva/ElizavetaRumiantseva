package hw3.ex2.RunPagesTest;


import hw3.Base.RunPages.BaseTest;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    @Test
    public void exercise2Test() {

        //1. Open test site by URL
        testSteps2.openMainPage();

        //2. Assert Browser title
        testSteps2.assertBrowseTitle();

        //3. Perform login
        testSteps2.performLogin(username, password);

        //4. Assert Username is loggined
        testSteps2.assertUsernameIsLoggined();

        testSteps2.assertAll();

        //5. Open through the header menu Service -> Different Elements Page
        testSteps2.assertOpenDifferentElementsPage();

        //6. Select checkboxes
        testSteps2.assertSelectedCheckboxes();

        //7. Select radio
        testSteps2.assertSelectedRadio();

        //8. Select in dropdown
        testSteps2.assertSelectedInDropdown();

        //9.1 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        testSteps2.assertCorrespondedLogForCheckbox();

        //9.2.  that for radio button there is a log row and value is corresponded to the status of radio button
        testSteps2.assertCorrespondedLogForRadioBtn();

        //9.3. Assert that for dropdown there is a log row and value is corresponded to the selected value
        testSteps2.assertCorrespondedLogForDropdown();
    }
}
