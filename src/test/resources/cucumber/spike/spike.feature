Feature: Spike 
  In order write features that require a web UI
  As a developer
  I want to have a suitable web driver instance selected based on the environment

  Scenario: Developing on local machine uses FirefoxDriver
    Given I am running Cucumber on my local machine
    When I run browser based tests
    Then they should run with FirefoxDriver

  Scenario: Running on CI machine uses Selenium Grid
    Given I am running Cucumber on my CI machine
    When I run browser based tests
    Then they should run with RemoteDriver