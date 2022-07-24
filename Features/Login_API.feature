Feature: User should be able to Login.

  @login_api @api
  Scenario: Verify user Login through API
    Given application is up and reachable
    When Login with username as "test-f35fe6@test.mailgenius.com" and password as "Qwerty"
    Then verify the response code is 200
    And verify response time is within configured value
    And verify the user is created successfully
