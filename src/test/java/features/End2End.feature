Feature: Automated End2End Test
  Description: The purpose of this feature is to test End 2 End integration.

  Scenario Outline: Customer check the transaction status
    Given the user in the home page
    When user click on customer login  
    And choose name as "<name>" 
    And click on login button
    And click on deposit button in the top of the screen
    And enter amount as "<depositamount>" 
    And click on deposit button in the bottom of the screen
    And click on withdraw button in the top of the screen
    And enter amount as "<withdrawamout>"
    And click on withdraw button in the bottom of the screen
    And click on transaction button 
    Then user can view the transaction type

    Examples:
      | name            | depositamount|withdrawamout|
      | Albus Dumbledore|  1000        |  400        |