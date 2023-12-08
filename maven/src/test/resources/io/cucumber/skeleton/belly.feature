Feature: Belly

  Scenario: a few cukes
    Given I have cukes 
    | Count | Where |
    | 42    | Belly |
    When I wait 
    | Amount | Measure |
    | 1      | hour    |
    Then my belly should growl
