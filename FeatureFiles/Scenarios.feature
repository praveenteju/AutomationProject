Feature: Yahoo Scenarios

  @Sanity @Regression
  Scenario Outline: - Create Yahoo Account
    Given I launch the yahoo application "<TestCase ID>"
    When I clik on create account
    And I can see create account Page
    When I enter all the fields
    And Click on Submit
    Then account is created

    Examples: 
      | TestCase ID |
      | TC001       |
      | TC002       |
      | TC003       |
      | TC004       |
      | TC005       |
      | TC006       |
      | TC007       |
      
       @Sanity @Regression
  Scenario Outline: - Create Yahoo Account
    Given I launch the yahoo application "<TestCase ID>"
    When I clik on create account
    And I can see create account Page
    When I enter all the fields
    And Click on Cancel
    Then account is created

    Examples: 
      | TestCase ID |
      | TC010       |
      | TC011       |
      | TC012       |
      | TC004       |
      | TC005       |
      | TC006       |
      | TC007       |
