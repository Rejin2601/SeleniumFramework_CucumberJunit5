@loginFeature
Feature: Login functionality

  @tc1
  Scenario: Login
    Given I am on the login page
    When I login with "rejinvincent113@gmail.com" and "Test123"

    @tc2 @test
  Scenario: Login with validation
    Given I am on the login page
    When I login with "rejinvincent113@gmail.com" and "Test123"
    Then I validate logged in user text as "Logged in as TestUser"

  @tc3 @FailedTC
  Scenario: Negative Scenario for Login validation
    Given I am on the login page
    When I login with "rejinvincent113@gmail.com" and "Test123"
    Then I validate logged in user text as "TestUser"

  @tc4 @test
  Scenario: Negative Scenario for Login
    Given I am on the login page
    When I login with "rejinvincent@gmail.com" and "Test123"
    Then I validate login error message as "Your email or password is incorrect!"

  @tc5 @test
  Scenario: Negative Scenario for Login
    Given I am on the login page
    When I login with "rejinvincent113@gmail.com" and "Test12"
    Then I validate login error message as "Your email or password is incorrect!"

  @tc6
  Scenario: Negative Scenario for Login
    Given I am on the login page
    When I login with "rejinvincent11@gmail.com" and "Test12"
    Then I validate login error message as "Your email or password is incorrect!"

  @tc7 @FailedTC
  Scenario: Negative Scenario for Login
    Given I am on the login page
    When I login with "rejinvincent113@gmail.com" and "Test12"
    Then I validate login error message as "Your email or password is incorrect"