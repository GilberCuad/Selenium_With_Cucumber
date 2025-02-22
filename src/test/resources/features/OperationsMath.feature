Feature: Operations One
  Background: Preconditions general
    Given The user generate two random values

    @ticketRegression
    Scenario: Exercise One
      When The user adds both values
      Then The user display sum in console

      @ticketSmoke
      Scenario: Exercise Two
        When The user multiplies two values
        Then The user display product in console