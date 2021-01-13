Feature: Exercise1
  In order to ensure some elements on Home and Different Elements pages
  As a user
  I want to search them by locators

  Scenario: Home and Different Elements pages test
    Given I am on Home Page
    Then title of the Home Page page should be 'Home Page'
    When I login as user 'Roman Iovlev' with password 'Jdi1234' on the Home Page
    Then username should be 'Roman Iovlev' on the Home Page





