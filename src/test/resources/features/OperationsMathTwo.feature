Feature: Operations Two
  Background: Preconditions general
    Given The user generate two random values

  @ticketRegression
  Scenario: Exercise Three
    When The user cubes both values
    Then The user display both powers in console

  @ticketSmoke
  Scenario: Four
    When The user make root square of both values
    Then The user display both roots in console