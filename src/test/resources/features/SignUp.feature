Feature: Sign Up with valid and invalid credentials

  @SignUp @OCN_01
  Scenario: OCN_01 : Successful Sign Up with valid credentials
    Given the user is on the Sign Up page
    When the user enters a valid email address
    And the user enters a valid password
    And the user enters a valid confirm password
    And the user submits the Sign Up form
    Then the user should be redirected to the dashboard

  @SignUp @OCN_02
  Scenario: OCN_02 : Failed Sign Up with an already registered email
    Given the user is on the Sign Up page
    When the user enters an already registered email address
    And the user enters a valid password
    And the user enters a valid confirm password
    And the user submits the Sign Up form
    Then an error message should be displayed

  @SignUp @OCN_03,04
  Scenario Outline:<TestcaseID>: Sign Up with blank email and  password combinations
    Given the user is on the Sign Up page
    When the user enters email "<email>"
    And the user enters password "<password>"
    And the user re-enters the password as "<confirm_password>" in the confirm password field
    Then the Sign Up button should be disabled
    Then for "<TestcaseID>", "<expected_message>" should be displayed
    Examples:
    | TestcaseID | email                        | password      | confirm_password  | expected_message                                                                                                                               |
    |   OCN_03   | ocntestuser@sample.com       |               | NetW0rk@197.0     |  Password must contain atelast one lowercase letter, uppercase letter, number and special character and be a minimum of 8 characters in length |
    |   OCN_04   | ocntestuser@sample.com       | NetW0rk@197.0 |                   |  Passwords do not match                                                                                                                        |

  @SignUp @OCN_05,06
  Scenario Outline: Failed Sign Up with invalid email and password combinations
    Given the user is on the Sign Up page
    When the user enters email "<email>"
    And the user enters password "<password>"
    And the user re-enters the password as "<confirm_password>" in the confirm password field
    Then the Sign Up button should be disabled
    Then for "<TestcaseID>", "<expected_message>" should be displayed
    Examples:
      | TestcaseID | email                        | password      | confirm_password  | expected_message                                                                                                                               |
      |   OCN_05   | ocntestuser@sample.com       | Net23         |     Net23         |  Password must contain atelast one lowercase letter, uppercase letter, number and special character and be a minimum of 8 characters in length |
      |   OCN_06   | ocntestuser@sample.com       | NetW0rk@197.0 |    Net23          |  Passwords do not match                                                                                                                        |

