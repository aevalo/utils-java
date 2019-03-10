Feature: Do or do not. There is no try.
  Trying either gets you there or not.

  Scenario Outline: Try dividing number ten.
    Given divisor is "<divisor>"
    When I ask the value of division
    Then I should be told "<answer>"

  Examples:
    | divisor   | answer |
    | 2         | 5      |
    | 5         | 2      |
    | 10        | 1      |
    | 1         | 10     |
    | 0         | None   |
