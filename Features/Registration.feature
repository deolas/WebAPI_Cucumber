Feature: Registration

  @regression11
  Scenario: Successful Registration with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://fego.vmos-demo.com/"
    And Click on Login link
    And Click on Create Account tab
    And User enters customer info
    And Click on Create Account Button
    Then Page Title should be "Fego"
    Then Username should be "fego user"
    And close browser
