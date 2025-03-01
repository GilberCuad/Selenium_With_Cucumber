Feature: Login on Saucedemo

  Background:
    Given The user browse the page "https://www.saucedemo.com/"


  @scenarioOutlineLoginIncorrect
  Scenario Outline: Login with incorrect credentials
    When The user write the username <username> and write the password <password>
    And The user click on login button
    Then The user verifies error message contains text <errorMessage>

    Examples:
      | username          | password       | errorMessage                                                                |
      | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out."                       |
      | "userError"       | "as43sd#"      | "Epic sadface: Username and password do not match any user in this service" |


  @verifiesUI
  Scenario:  Verifies the page UI
    Then Verifies the page login UI
