Feature: Landing page feature
  In order to see the derp bear examples
  as a user
  I want to be able to access them on one page


  Scenario: Landing page derp bear examples
    When I visit Derp-Bear
    Then I should see a list of available examples

  Scenario: Pick a derp bear example
    Given I visit Derp-Bear
    When I pick a basic example
    Then I should see be on the basic example page