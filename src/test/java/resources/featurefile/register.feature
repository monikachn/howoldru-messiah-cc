@regression
Feature:Register

  Scenario Outline: As a User I fill the name and dateOf birth then a welcome message with Name and Age displayed successfully
    Given I am on the HomePage
    When  I enter Name "<name>"
    And   I enter Birthday "<birthdate>"
    And   I clickOn the Submit button
    Then  verify the welcome message displayed "<name>" "<birthdate>"
    Examples:
      | name | birthdate  |
      | Jenny Morgan  | 15/02/2003 |
      | Steve Smith  | 10/10/2005 |

  Scenario: Age cannot be over 122 years
    Given I am on the HomePage
    When  I enter Name "Jenny Morgan"
    And   I enter Birthday "10/08/1900"
    And   I clickOn the Submit button
    Then  verify the error message "you are too old to use it"

  @smoke
  Scenario: Date of birth must be in past
    Given I am on the HomePage
    When  I enter Name "Jenny Morgan"
    And   I enter Birthday a future date
    And   I clickOn the Submit button
    Then  verify the error message "your birthday must be in the past"

  Scenario: Name must not be blank
    Given I am on the HomePage
    When  I enter Name ""
    And   I enter Birthday "10/08/2022"
    And   I clickOn the Submit button
    Then  verify the error "incorrect symbols"

  Scenario: Date of birth must be supplied
    Given I am on the HomePage
    When  I enter Name "Jenny Morgan"
    And   I clickOn the Submit button
    Then  verify the error message "wrong date"