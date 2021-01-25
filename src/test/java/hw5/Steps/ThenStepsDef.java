package hw5.Steps;

import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ThenStepsDef extends AbstractBaseStepDef {
    @Then("username should be {string} on the Home Page")
    public void userNameShouldBeOnTheHomePage(String expectedUserName) {
        softAssert.assertEquals(homePage.getUserName(), expectedUserName);
        softAssert.assertAll();
    }

    @Then("title of the Home Page page should be {string}")
    public void titleOfPageShouldBe(String expectedUserName) {
        softAssert.assertEquals(homePage.getTitle(), expectedUserName);
        softAssert.assertAll();
    }

    @Then("Different Elements Page should be opened")
    public void differentElementsPageShouldBeOpened(String title) {
        softAssert.assertEquals(diffElemPage.getTitle(), title);
        softAssert.assertAll();
    }

    @Then("title of Different Elements Page should be {string}")
    public void titleOfDifferentElementsPageShouldBeDifferentElementsPage(String expectedUserName) {
        softAssert.assertEquals(diffElemPage.getTitle(), expectedUserName);
        softAssert.assertAll();
    }

    @Then("individual log row should correspond to the status of WIND checkbox")
    public void individualLogRowShouldCorrespondToTheStatusOfWINDCheckbox() {
        softAssert.assertEquals(diffElemPage.getWindCheckBox().isSelected(), diffElemPage.getWindLog().contains("Wind: condition changed to true"));
        softAssert.assertAll();
    }

    @Then("individual log row should correspond to the status of WATER checkbox")
    public void individualLogRowShouldCorrespondToTheStatusOfWATERCheckbox() {
        softAssert.assertEquals(diffElemPage.getWaterCheckBox().isSelected(), diffElemPage.getWaterLog().contains("Water: condition changed to true"));
        softAssert.assertAll();
    }

    @Then("individual log row should correspond to the status of SELEN radio")
    public void individualLogRowShouldCorrespondToTheStatusOfSELENRadio() {
        softAssert.assertEquals(diffElemPage.getSelenRadio().isSelected(), diffElemPage.getRadioSelenLog().contains("metal: value changed to Selen"));
        softAssert.assertAll();
    }

    @Then("individual log row should correspond to the status of dropdown YELLOW option")
    public void individualLogRowShouldCorrespondToTheStatusOfDropdownYELLOWOption() {
        softAssert.assertEquals(diffElemPage.selectYellow().isSelected(), diffElemPage.getDropdownYellowLog().contains("Colors: value changed to Yellow"));
        softAssert.assertAll();
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String expTitle) {
        softAssert.assertEquals(driver.getTitle(), expTitle);
        softAssert.assertAll();
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int number) {
        softAssert.assertEquals(userTablePage.getDropdownsAsWebElements().size(), number);
        softAssert.assertAll();
    }

    @Then("{int} User names should be displayed on Users Table on User Table Page")
    public void userNamesShouldBeDisplayedOnUsersTableOnUserTablePage(int number) {
        softAssert.assertEquals(userTablePage.getUserNamesAsWebElement().size(), number);
        softAssert.assertAll();
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int number) {
        softAssert.assertEquals(userTablePage.getDescriptionsTextsAsWebElement().size(), number);
        softAssert.assertAll();
    }


    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int number) {
        softAssert.assertEquals(userTablePage.getCheckboxesAsWebElements().size(), number);
        softAssert.assertAll();
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(List<List<String>> expectedValues) {
        List<List<String>> data = expectedValues.subList(1, expectedValues.size());
        for (int i = 0; i < data.size(); i++) {
            List<String> row = data.get(i);
            softAssert.assertEquals(userTablePage.getNumberColumnAsWebElements().get(i).getText(), row.get(0));
            softAssert.assertEquals(userTablePage.getUserNamesAsWebElement().get(i).getText(), row.get(1));
            softAssert.assertEquals(userTablePage.getDescriptionsTextsAsWebElement().get(i).getText().replaceAll("\n"," "), row.get(2));
            softAssert.assertAll();
        }
    }

    @Then("droplist should contain values in column Type for user Roman:")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(List<String> expectedValues) {
        List<String> data = expectedValues.subList(1, expectedValues.size());
        int rowIndex = userTablePage.clickOnDropdownInTableByName("Roman");

        List<String> actualValues = userTablePage.getValuesOfDropdownByIndexOfRow(rowIndex);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < data.size(); i++) {
            softAssert.assertEquals(actualValues.get(i), data.get(i));
        }
        softAssert.assertAll();
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int expectedNumber, String expectedText) {
        List<String> actualText = userTablePage.getLogText();
        softAssert.assertEquals(actualText.size(),1);
        softAssert.assertTrue(actualText.contains(expectedText), "Invalid text in log!");
        softAssert.assertAll();
    }
}
