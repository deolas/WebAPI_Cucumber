Feature: User should be able to Register.

  @register_api @api
  Scenario: Verify user registration through API
    Given application is up and reachable
    When Register user with name as "fego vmos"
    Then verify the response code is 201
    And verify response time is within configured value
		And verify the user is created successfully
