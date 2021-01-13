package hw5.Steps;

import io.cucumber.java.en.When;

public class ActionStepsDef extends AbstractBaseStepDef{
    @When("^I login as user '([^\"]+)' with password '([^\"]+)' on the Home Page$")
    public void iLoginAsUserWithPasswordOnTheHomePage(String username, String password) {
        homePage.login(username, password);
    }
}
