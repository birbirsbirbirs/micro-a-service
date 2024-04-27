Feature: sample

  Scenario: test A service
    Given url 'http://localhost:8080'
    When method get
    Then status 200