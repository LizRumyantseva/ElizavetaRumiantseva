Feature: Home and User Table pages test
  In order to ensure some elements on Home and User table pages
  As a user
  I want to search them by locators

  Background:
    Given I open JDI GitHub site
    Then title of the Home Page page should be 'Home Page'
    When I login as user 'Roman' with password 'Jdi1234'
    Then username should be 'ROMAN IOVLEV' on the Home Page
    When I click on 'SERVICE' button in Header
    And I click on 'USER_TABLE' button in Service dropdown

  Scenario: Exercise 2
    When I click on 'SERVICE' button in Header
    And I click on 'USER_TABLE' button in Service dropdown
    Then 'User Table' page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 User names should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description             |
    And droplist should contain values in column Type for user Roman:
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |


  Scenario: Exercise 3
    When I select vip checkbox for 'Sergey Ivan'
    Then 1 log row has "Vip: condition changed to true" text in log section

