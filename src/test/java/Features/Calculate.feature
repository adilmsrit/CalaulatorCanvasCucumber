Feature: Clear, Addition and Subtraction.

  Scenario: Validate function of CE button.
    Given User launches chrome browser
    When User opens "https://www.online-calculator.com/full-screen-calculator/" URL
    And Click on CE
    Then The result should be cleared

  Scenario Outline: Successful validate Addition for all possible scenarios.
    Given User launches chrome browser
    When User opens "https://www.online-calculator.com/full-screen-calculator/" URL
    And User Adds 2 numbers "<Number1>" and "<Number2>"
    And Click on equal
    Then Result should be "5"
    And Close Browser
    Examples:
      | Number1 | Number2 | Result |
      | 2       | 3       | 5      |
      | 0       | 0       | 0      |
      | 500     | 0       | 500    |
      | 0       | 300000  | 300000 |
      | 2.2     | 3.2     | 5.4    |
      | 20000   | 30000   | 50000  |


  Scenario Outline: Successful validate Subtraction for all possible scenarios.
    Given User launches chrome browser
    When User opens "https://www.online-calculator.com/full-screen-calculator/" URL
    And User Subtracts 2 numbers "<Number1>" and "<Number2>"
    And Click on equal
    Then Result should be "<Result>"
    And Close Browser
    Examples:
      | Number1 | Number2 | Result  |
      | 2       | 3       | -1      |
      | 20      | 3       | 17      |
      | 0       | 0       | 0       |
      | 500     | 0       | 500     |
      | 0       | 300000  | -300000 |
      | 2.2     | 3.2     | -1.0    |
      | 20000   | 30000   | -10000  |

