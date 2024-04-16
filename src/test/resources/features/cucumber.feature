Feature: test

  @severity=critical
  Scenario: test
    Given Test facade
    Given Rest Step
    Given I store SomeObject as "object_alias"
    Given I store String as "object_alias"
    When I extract object "object_alias" as SomeObject
    Then I can still extract "object_alias" as String

  @severity=critical
  Scenario: test
    Given Test facade
    Given Rest Step
    Given I store SomeObject as "object_alias"
    Given I store String as "object_alias"
    When I extract object "object_alias" as SomeObject
    Then I can still extract "object_alias" as String

  @severity=critical
  Scenario: test
    Given Test facade
    Given Rest Step
    Given I store SomeObject as "object_alias"
    Given I store String as "object_alias"
    When I extract object "object_alias" as SomeObject
    Then I can still extract "object_alias" as String