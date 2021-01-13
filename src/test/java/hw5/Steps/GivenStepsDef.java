package hw5.Steps;

import hw5.Steps.AbstractBaseStepDef;
import io.cucumber.java.en.Given;

public class GivenStepsDef extends AbstractBaseStepDef {

    @Given("I am on Home Page")
    public void iAmOnHomePage() {
        homePage.open();
    }


}
