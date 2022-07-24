Feature: Login to application through UI

  @regression11
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://fego.vmos-demo.com/"
    And Click on Login link
    And User enters Email as "test-f35fe6@test.mailgenius.com" and Password as "Qwerty19"
    And Click on Login
    Then Page Title should be "Fego"
    Then Username should be "fego vmos"
    And close browser
