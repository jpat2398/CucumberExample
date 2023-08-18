Feature: New Application

  Background:
    Given a user is on the homepage
    When a user clicks on the login button
    And a user enters user and password credentials
    And a user clicks on the sign in button
    And a user clicks on the loan application button

  Scenario: Input Fields
    When a user fills out the loan application form
      | fullname     | Jeron Patterson  |
      | age          | 25               |
      | addressline1 | 1 york street    |
      | addressline2 | christmas        |
      | addressline3 | christmashire    |
      | addressline4 | england          |
      | postcode     | ch15ht           |
      | email        | anon1@domain.com |
      | loanamount   | 1000             |
    And the user clicks submit
    Then the user has submitted the form