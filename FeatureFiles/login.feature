Feature: User login

  Scenario: Successful Login
    Given the user is on login page of bearberry
    When user enters the valid data(username: "yp9650568@gmail.com", Password: "Yogi@2198")
    And click on login button
    Then user should see  my account page
