Feature:  Login

  As a  registerd user
  I want to login to Amazon.co.uk
  So that I can access the website

  @enjoy
  Scenario: user login with valid credentials
    Given user in sign in page
    When user enter valid username
    And user enter valid password
    And  user enter signin button
    Then user should logged in successfully


  @sanity
  Scenario: user logged with invalid credentials
    Given user in sign in page
    When user enter valid username
    And user enter invalid password
    And  user enter signin button
    Then user should  not logged  successfully

  @forgotpassword
  Scenario: user logged with invalid credentials
    Given user in sign in page
    When user enter valid username
    And user click on forgot password
    Then user should  navigate to reset password

