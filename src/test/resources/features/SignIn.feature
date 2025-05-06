  Feature: Sign In with valid and invalid credentials

  @SignIn @OCN_07
  Scenario: OCN_07 :Successful Sign In with valid credentials
    Given the user is on the Sign In page
    When the user enters an already registered email address
    And the user enters a valid password
    And the user submits the Sign In form
    Then the user should be redirected to the dashboard

    @SignIn @OCN_08
    Scenario Outline:<TestcaseID>: Sign In with blank email and  password combinations
      Given the user is on the Sign In page
      When the user enters email "<email>"
      And the user enters password "<password>"
      Then the Sign In button should be disabled
      Then for "<TestcaseID>", "<expected_message>" should be displayed
      Examples:
        | TestcaseID | email                        | password      |  expected_message                                                                                                                               |
        |   OCN_08   | ocntestuser@sample.com       |               |  Password must contain atelast one lowercase letter, uppercase letter, number and special character and be a minimum of 8 characters in length  |


    @SignIn @OCN_09,10
    Scenario Outline: Failed Sign In with invalid email and password combinations
      Given the user is on the Sign In page
      When the user enters email "<email>"
      And the user enters password "<password>"
      And the user submits the Sign In form
      Then for "<TestcaseID>", "<expected_message>" alert should be displayed
      Examples:
        | TestcaseID | email                        | password      | expected_message              |
        |   OCN_09   | ocntestuser@sample.com       | NetW0rk@15    |  Incorrect E-Mail or Password |
        |   OCN_10   | ocnqauser@sample.com         | NetW0rk@15    |  User not found               |


    @SignOut
    Scenario: OCN_11: Successful Sign Out
      Given the user is signed in
      Then the user clicks "Sign Out" button
      Then the user should be redirected to the Sign In page

