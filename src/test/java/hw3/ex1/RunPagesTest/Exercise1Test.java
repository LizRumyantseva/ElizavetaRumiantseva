package hw3.ex1.RunPagesTest;

import hw3.Base.RunPages.BaseTest;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseTest {

    @Test
    public void exercise1Test() {

        //1. Open test site by URL
        testSteps1.openMainPage();

        //2. Assert Browser title
        testSteps1.assertBrowseTitle();

        //3. Perform login
        testSteps1.performLogin(username, password);

        //4. Assert Username is loggined
        testSteps1.assertUsernameIsLoggined();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        testSteps1.assert4ItemsHeaderSectionWithTexts();

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        testSteps1.assert4ImagesIndexPage();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        testSteps1.assert4TextsIndexPage();

        //8. Assert that there is the iframe with “Frame Button” exist
        testSteps1.assertIFrameExists();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(homePage.getIframe());
        testSteps1.assertFrameBtnExists();

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        testSteps1.LeftSectionWithTexts();

        testSteps1.assertAll();
    }
}
