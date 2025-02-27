Feature: Login on Saucedemo

  Background:
    Given The user browse the page "https://www.saucedemo.com/"

  @loginWithIncorrectCredentials
  Scenario: Login with incorrect credentials
    When The user write the username "locked_out_user" and write the password "secret_sauce"
    And The user click on login button
    Then The user verifies error message contains text "Epic sadface: Sorry, this user has been locked out."

  @scenarioOutlineLoginIncorrect
  Scenario Outline: Login with incorrect credentials
    When The user write the username <username> and write the password <password>
    And The user click on login button
    Then The user verifies error message contains text <messagError>

    Examples:
      | username          | password       | messagError                                           |
      | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out." |

  @verifiesUI
  Scenario:  Verifies the page UI
    Then Verifies the page login UI
