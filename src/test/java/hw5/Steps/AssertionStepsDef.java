package hw5.Steps;

import io.cucumber.java.en.Then;


public class AssertionStepsDef extends AbstractBaseStepDef {
    @Then("^username should be '([^\"]+)' on the Home Page$")
    public void userNameShouldBeOnTheHomePage(String expectedUserName) {
        softAssert.assertEquals(homePage.getUserName(), expectedUserName);
    }

    @Then("^title of the Home Page page should be '([^\"]+)'$")
    public void titleOfPageShouldBe(String expectedUserName) {
        softAssert.assertEquals(homePage.getTitle(), expectedUserName);
    }

}
