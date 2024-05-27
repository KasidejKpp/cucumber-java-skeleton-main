Feature: Google

  Scenario: Search "Google" by Google
    Given Open Google.com
    When Search with "Google"
    Then The page title should start with "Google"
    Then Search box contain "Google"

  Scenario Outline: Search set <input> by Google
    Given Open Google.com
    When Search with "<input>"
    Then The page title should start with "<expect>"

    Examples:
      | input | expect |
      | Google | Google |
      |    QA | QA |