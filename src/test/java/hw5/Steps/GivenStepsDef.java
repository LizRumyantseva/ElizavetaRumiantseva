package hw5.Steps;

import io.cucumber.java.en.Given;

public class GivenStepsDef extends AbstractBaseStepDef {

    @Given("I open JDI GitHub site")
    public void iAmOnHomePage() {
        homePage.open();
        homePage.waitForEpamLogo();
    }


}
