package hw4.ex1;

import hw4.Base.DriverUtils.AllureListener;
import hw4.Base.RunPages.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class Exercise1TestWithFailure extends BaseTest {

    @Feature("Testing EPAM site (jdi-testing.github.io)")
    @Story("Home Page interface testing")
    @Test(description = "Exercise 1 test with failure")
    public void exercise1Test() {

        //1. Open test site by URL
        actionStep.openMainPage();

        //2. Assert Browser title
        assertionStep.assertBrowseTitle("Home Page");

        //3. Perform login
        actionStep.performLogin(username, password);

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLoggined("Liza Rumiantseva");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.assert4ItemsHeaderSectionWithTexts("HOME\n"
                + "CONTACT FORM\n"
                + "SERVICE\n"
                + "METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assert4ImagesIndexPage();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.assert4TextsIndexPage();

        //8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.assertIFrameExists();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToIFrame();
        assertionStep.assertFrameBtnExists();

        //10. Switch to original window back
        actionStep.switchToHomePage();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.LeftSectionWithTexts("Home\n"
                + "Contact form\n"
                + "Service\n"
                + "Metals & Colors111\n"
                + "Elements packs");

        assertionStep.assertAll();
    }
}
