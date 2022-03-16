Feature: feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters valid <userrname> and <password>
    And clicks on login button
    Then user is navigated to dashboard

    Examples: 
      | userrname                    | password             |
      | admin@grthealthonline.com    | @Grthealthadmin2021# |
      | shahid@troontechnologies.com |               123123 |
