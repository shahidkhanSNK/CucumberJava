# We can add comment by starting the comment with Hash symbol


Feature: feature to test login functionality

@smoketest
  Scenario: Check login is successful with valid credentials
    
    Given user is on login page
    When user enters valid userrname and password
    And clicks on login button
    Then user is navigated to dashboard

