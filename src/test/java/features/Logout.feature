@logoutFeature
Feature: Login functionality


  @tc8 @test
  Scenario: Logout
    Given I am on the login page
    When I login with "rejinvincent113@gmail.com" and "Test123"
    Then I validate logged in user text as "Logged in as TestUser"
    Then I click logout from login page