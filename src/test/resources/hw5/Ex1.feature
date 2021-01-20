Feature: Home and Different Elements pages test
  In order to ensure some elements on Home and Different Elements pages
  As a user
  I want to search them by locators

  Scenario: Exercise 1
    Given I open JDI GitHub site
    When I login as user 'Roman' with password 'Jdi1234'
    Then title of the Home Page page should be 'Home Page'
    And username should be 'ROMAN IOVLEV' on the Home Page
    When I click on 'SERVICE' button in Header
    And I click on 'DIFFERENT_ELEMENTS' button in Service dropdown
    Then title of Different Elements Page should be 'Different Elements'
    When I select checkbox WATER on the Different Elements page
    And I select checkbox WIND on the Different Elements page
    And I select radio SELEN on the Different Elements page
    And I select option YELLOW in dropdown on the Different Elements page
    Then individual log row should correspond to the status of WIND checkbox
    And individual log row should correspond to the status of WATER checkbox
    And individual log row should correspond to the status of SELEN radio
    And individual log row should correspond to the status of dropdown YELLOW option







