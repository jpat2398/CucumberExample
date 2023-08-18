@authentication
  Feature: Authentication

    Scenario Outline: Login with user details
      Given a user is on the homepage
      When a user clicks on the loan application button
      And a user enters "<user>" and "<password>" credentials
      And a user clicks on the sign in button
      Then a <user> should be logged in
      Examples:
        | user  | password |
        | admin | password |

    Scenario Outline: Logout
      Given a user is on the homepage
      When a user clicks on the login button
      And a user enters "<user>" and "<password>" credentials
      And a user clicks on the sign in button
      And a <user> should be logged in
      And a user clicks on the login button
      Then a log out message is displayed
      Examples:
        | user  | password |
        | admin | password |